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

-- 카테고리 테이블 [ 공지사항 , 커뮤니티 , QnA , 노하우 등등 ]
drop table if exists category;
create table category(
	cno int auto_increment primary key ,
    cname varchar(100) 
);

insert into category( cname ) values ('공지사항');
insert into category( cname ) values ('커뮤니티');
insert into category( cname ) values ('QnA');
insert into category( cname ) values ('노하우');
select * from category;

-- 게시물 테이블 [ 번호 , 제목 , 내용 , 첨부파일 , 작성일 , 조회수 , 좋아요수 , 싫어요수 , 작성자 , 카테고리번호 ]
drop table if exists board;
create table board(
	bno int auto_increment primary key ,
    btitle varchar(1000) not null ,
    bcontent longtext not null ,
    bfile longtext ,
    bdate datetime default now() ,
    bview int default 0 ,
    bup int default 0 ,
    bdown int default 0 ,
    mno int ,
    cno int ,
    foreign key ( mno ) references member( mno ) on delete set null ,
    foreign key ( cno ) references category( cno ) on delete cascade
);
-- 생략시 fk에 존재하는 식별키pk는 삭제 불가능

-- 조인 합집합
select bno , btilte , bcontent , bfile , bdate , bview , bup , bdown , m.mid , b.cno   from member m , board b;

-- 1. where 이용 조인 [ * 다른 조건과 가독성 떨어짐 ]
select * from member , board where member.mno = board.mno;
-- 2. 테이블명 별칭
select * from member m , board b where m.mno = b.mno;
-- 3. A테이블 natural join B테이블 / 자연조인 [ 암묵적으로 fk , pk 연결 / pf fk 1개인경우 ]
select * from member m natural join board;
-- 4. A테이블명 join B테이블명 on 교집합필드조건(조인조건) ( where대신 on으로 조인 )
select * from member m join board b on m.mno = b.mno; -- on 키워드 이용해서 교집합 조건 사용하면 다른 where 구분
-- 결론
select board.* , member.mid from member natural join board;
-- 2. 특정 개수만 출력 [페이지 조건] limit 시작인덱스[0] , 개수
select b.* , m.mid from member m natural join board b limit 0 , 3; -- 0부터 3개 / 1페이지
select b.* , m.mid from member m natural join board b limit 3 , 3; -- 0부터 3개 / 2페이지
select b.* , m.mid from member m natural join board b limit 6 , 3; -- 0부터 3개 / 3페이지

-- 검색이 있을때
select b.* , m.mid from member m natural join board b where b.btitle like '%f%' order by b.bdate desc limit 6 , 3;
	-- 자바
	-- "select b.* , m.mid from member m natural join board b where "+key+" like '%"+keyword+"%' order by b.bdate desc limit ? , ?"

select board.* , member.mid , member.mimg  from member natural join board where board.bno = 1;

-- 3. 레코드 수 구하기 count(*)
select count(*)  from member m natural join board b;

-- 검색이 있을 때 레코드수 구하기
select count(*)  from member m natural join board b where b.btitle like '%v%';
	-- 자바에서 사용할경우
-- "select count(*)  from member m natural join board b where "+b.btitle+" like '%"+v+"%'";

-- 검색하기

	-- 카테고리
select * from board where cno = 3;
	-- 제목
select * from board where btitle = '글추가' ;
select * from board where btitle like '%v%' ;
select * from board where btitle like '_asd_' ; -- asd가 2번째 글자에 있는 5글자 제목의 레코드 찾기
	-- % 모든문자대응 [ 문자개수 무시 ] / _  개수만큼 대응 [ 문자개수 중요 ]
/*
	1asd2		like '_asd_' true		like '%asd%' true
    1asd23 		like '_asd_' false		like '%asd%' true
*/
	-- 내용
select * from board where bcontent like '%v%' ;
	-- 작성자
select b.* , m.mid from board b , member m  where b.mno = m.mno and m.mid like '%q%' ;



select * from member;
select * from mpoint;
-- 포인트지급
-- insert into mpoint( mpcomment , mpamount , mno ) values('회원가입축하' , 100 , 1 );

-- 구매적립포인트
-- insert into mpoint( mpcomment , mpamount , mno ) values('구매적립포인트' , 5000 , 1 );
-- 포인트 사용
-- insert into mpoint( mpcomment , mpamount , mno ) values('포인트사용' , -3000 , 1 );

-- 아이디에 해당하는 회원정보 호출
select * from member where mid = '테스트';
-- 아이디에 해당하는 회원정보+보유포인트 호출
select * from mpoint where mno = 1;
-- 특정 회원 보유 포인트
select sum(mpamount) from mpoint where mno = 1;
-- 아이디 해당하는 회원의 보유 포인트
select * from member m , mpoint p where m.mno = p.mno; -- 다른 조건과 헷갈려서 비선호
select * from member m natural join mpoint; -- natural join : 암묵적으로 fk pk 조인

--  4. 출력하고 싶은것만 ( 통계 두개 이상 필드 출력시 그룹필수 )
select m.mno , m.mid , m.mimg , memail , sum( p.mpamount ) as mpoint
from member m , mpoint p 
where m.mno = p.mno
group by mno;	-- 집계할 기준 [ ~~별 ] 

-- 5. 특정 회원 1명의 회원정보 + 보유포인트 
select m.mno , m.mid , m.mimg , memail , sum( p.mpamount ) as mpoint
from member m , mpoint p 
where m.mno = p.mno and m.mid = 'zxczcx';



-- 테이블 설계 주의점 1. 서로다른 테이블간의 중복필드X    2.예외 관계 [ 연결 PK FK ] : 무결성유지
	-- 테이블 당 pk 1개 이상 권장
