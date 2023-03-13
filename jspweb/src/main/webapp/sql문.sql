drop database if exists jspweb;
create database jspweb;
use jspweb;

-- 회원테이블
drop table if exists member;
create table member(
	mno			int 			auto_increment primary key,
    mid			varchar(30) not null unique, -- 공백불가 중복불가
    mpwd		varchar(20) not null ,
    mimg		longtext , -- 웹서버에 저장된 사진경로 -- 공백가능
    memail		varchar(100) -- 공백불가 , 중복불가
    
);
-- insert into member( mid , mpwd , mimg , memail ) values ( ? , ? , ? , ? );
select * from member;

select * from member where mid = '테스트' and mpwd = '테스트';
update member set mpwd = 'qwe1234' where mid = 'qwe1234';
--



-- 친추 테이블
drop table if exists friend;
create table friend(
	fno		int auto_increment primary key,
    ffrom	int ,	-- 신청자
    fto		int ,	-- 신청받은 회원
    foreign key ( ffrom ) references member( mno ) on delete set null ,
    foreign key ( fto ) references member( mno ) on delete set null -- 친구가 탈퇴하면 null
);

-- 포인트 테이블
drop table if exists mpoint;
create table mpoint(
	mpno		int  auto_increment primary key,	-- 포인트내역 식별번호
    mpcomment	varchar(1000) not null ,			-- 포인트내역 내용
    mpamount	int default 0,						-- 포인트
    mpdate 		datetime default now(),				-- 포인트내역 날짜
    mno			int ,								-- 포인트 주인
    foreign key ( mno ) references member ( mno ) on delete set null  -- 탈퇴하면 포인트 null
);
-- 아이디에 해당하는 회원정보 호출
select * from member where mid = '테스트';
-- 아이디에 해당하는 회원정보+보유포인트 호출
select * from mpoint where mno = 1;
-- 특정 회원 보유 포인트
select sum(mpamount) from mpoint where mno = 1;
-- 아이디 해당하는 회원의 보유 포인트
select * from member m , mpoint p where m.mno = p.mno;
-- 출력하고 싶은것만 ( 통계 두개 이상 필드 출력시 그룹필수 )
select m.mno , m.mid , m.mimg , memail , sum( p.mpamount ) as mpoint
from member m , mpoint p 
where m.mno = p.mno
group by mno;	-- 집계할 기준 [ ~~별 ] 
