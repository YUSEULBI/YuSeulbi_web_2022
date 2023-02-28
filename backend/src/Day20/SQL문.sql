-- DB 데이터베이스 [ 여러개의 테이블 저장 공간 ] -- 대소문자 구분안함
drop database if exists boardDb;
create database boardDb;
use boardDb;

-- 2. 테이블
	-- 1.회원
drop table if exists member;
create table member(
	mno int auto_increment primary key ,
    mid varchar(20) not null unique ,
    mpw varchar(20) not null ,
    mname varchar(30) not null , -- not null 실수공백방지
    mphone varchar(13) not null 
    
);

	-- 2. 카테고리
drop table if exists category;
create table category(
	cno	int auto_increment primary key ,
    cname varchar(20) not null
);

	-- 3. 게시물
drop table if exists board;
create table board(
	bno 	int 	auto_increment primary key ,
    btitle	varchar(1000) not null ,
    bcontent longtext not null , 					-- 긴글 텍스트
    bdate	datetime default now() , 				-- insert시 자동 현재 시스템날짜시간 대입
    bview	int default 0 , 						-- 조회수 시작은 0
    mno_fk	int , 									-- 작성자 [fk]
    cno_fk 	int , 									-- 카테고리 [fk]
    foreign key( mno_fk ) references member(mno) on delete set null ,  -- pk 삭제시 fk 보존
    foreign key( cno_fk ) references category(cno) on delete cascade -- pk 삭제시 fk삭제
);

	-- 4. 대댓글
drop table  if exists reply;
create table reply(
	rno int auto_increment primary key,
    rcontent text not null ,
	rdate	datetime default now() ,
    rindex	int ,	-- 부모댓글 [ 0 최상위 , 1~ : 상위 댓글이 있음 --> 대댓글임을 알 수 있음 ]
    mno_fk		int ,	
    bno_fk		int ,
    foreign key( mno_fk ) references member( mno ) on delete set null, -- 탈퇴한 회원입니다.
    foreign key( bno_fk ) references board( bno ) on update cascade -- 게시물이 삭제되면 댓글도 같이 삭제
);


-- 1. 아이디 중복체크 -- 아이디 검색 --> 존재하면 중복 =/ '레코드'가 없으면 존재하지않는 아이디
select * from member where mid = 'qwe'; -- 특정 회원 아이디가 일치하는 회원 검색

-- 2. 회원가입
insert into member ( mid , mpw , mname , mphone ) values( 'qwe', 'qwe', 'qwe', '010-1111-1111');
select * from member;

-- 로그인a
select * from member where mid = 'qwe' and mpw = 'qwe' ; -- 아이디와 비밀번호가 일치한 회원 레코듳 ㅏㅈ기

-- 카테고리 추가
insert into category( cname ) values( '국내야구' );

select * from category;

-- 게시물 등록
insert into board( btitle ,  bcontent , mno_fk , cno_fk  ) values( '제목' , '내용' , 1 , 1 );

-- 최신 게시물 3개 출력
select * from board;
select*from board order by bdate desc; -- 작성일 기준 최신 [ desc 현재부터 / asc 과거부터 ]
select * from board order by bdate desc limit 3; -- 게시물 위에서 3개

	-- mno --> mid / cno --> cname [ join ]
	-- 1. 필요한 여러 테이블 select
		-- 테이블[레코드수] * 테이블[레코드수] * 테이블[레코드수]
    
    select bno , btitle , bcontent , bdate , bview , mid , cname 
		from board,member,category where board.mno_fk = member.mno and board.cname = category.cname;
        select * from board,member,category where board.mno_fk = member.mno and board.cno_fk = category.cno;
        select * from board b , member m , category c where b.mno_fk = m.mno and b.cno_fk = c.cno; -- 별칭 사용하면 코드 줄음
        
        -- 필요한 필드 추출
        select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname 
        from board b , member m , category c 
        where b.mno_fk = m.mno and b.cno_fk = c.cno ;
        
        select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname 
        from board b , member m , category c 
        where b.mno_fk = m.mno and b.cno_fk = c.cno 
        order by b.bate desc limit 3;
        
        select b.bno , b.btitle , b.bcontent , b.bdate , b.bview , m.mid , c.cname 
        from board b , member m , category c 
        where b.mno_fk = m.mno and b.cno_fk = c.cno 
        and b.cno_fk = 1;
        
        
        select bno , btitle , bcontent , bdate , bview , mid , cname from board,member,category where board.mno_fk = member.mno and board.cno_fk = category.cno;

select*from board , member; -- 두줄 나옴
select*from board , member where board.mno_fk = member.mno;

-- 해당 카테고리의 모든 게시물 출력 
select * from board where cno_fk = 1; -- 1번 카테고리의 게시물만 출력


-- 조회
select * from board where bno = 1; -- 1번 게시물 조회 -- 결과는 1개


