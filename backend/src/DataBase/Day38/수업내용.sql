/*

	메모리
		주기억장치		:	RAM	휘발성	전기O저장O	- 현재 실행중인 명령어 저장
			- JVM , 게임중 , 
		보조기억장치	:	ROM	비휘발성 	전기X저장O 	- 모든 명령어 저장
			- DB , 파일처리 , C드라이브 , CD , USB , 게임전체 등
    데이터베이스 : 표 만들기
		1. 데이터[자료] 베이스[모임] -> 표 -> 관계형[열/행] 데이터베이스
        2. [ 워드 , 엑셀 , 한글 ] 마우스 표 제작 vs [ 데이터베이스 ] 대화식[명령어] 표 제작
        3. SQL 질의어
	표만들기
		1. 무엇을 저장할지 생각
			ex) 회원번호 ,아이디 , 비밀번호 , 이름 , 게시판번호 , 게시물제목 , 내용 , 작성일 , 작성자
		2. 회원1명이 회원가입 ( 글을 쓴게 아님 )
        3. 회원1명 더 회원가입
        
        5. 정규화 ( 이상현상(중복)제거 )
			테이블내 대표되는 필드 선정 [ PK 참조당함 / FK는 PK를 씀 ] 
				1. 중복이 없어야함 
				2. 절대적인 식별용 데이터가 존재해야함 [ 공백null X ] null도 중복임
				3. 메모리 효율성 선택 [ 용량이 적은거 ] 
			현 테이블의 PK필드가 다른 테이블에서 사용되면 [FK] 외래키
				FK는 
				1. 중복 가능 ( 1사람이 게시물 여러개 작성 ) 
				2. PK필드에 존재하는 데이터만 작성 가능 ( 무결성이 깨지지않도록 무결성 유지 ) ex) 글을 안쓴 회원은 삭제가능 , 글을 쓴 회원을 삭제하면 삭제한회원의 글이 남아있으면 무결성이 깨짐
				
			회원테이블( 회원번호 int primary key );
			게시물테이블( 회원번호_fk int , foreign key (회원번호_fk) references 회원 ( 회원번호_pk ) ;
        
			유지보수가 좋다!!!!!!!!!
            
            pk와 fk 관계 외 테이블간 중복 필드 없어야한다.
            
            
        
*/



-- 1. DB 생성 / 선택
drop database if exists 관계테이블연습;

create database 관계테이블연습;
drop table if exists 회원;
use 관계테이블연습;
create table 회원(
	회원번호 int primary key,
    아이디 varchar(20),
    비밀번호 varchar(10)
    
);

drop table if exists 제품;
create table 제품 (
	제품번호 int primary key,
    제품이름 varchar(20),
    제품가격 int
);

drop table if exists 구매내역;
create table 구매내역 (
	구매번호 int primary key ,
    구매일자 datetime ,
	회원번호_fk int , 
    제품번호_fk int ,
    foreign key ( 회원번호_fk ) references 회원( 회원번호 ) ,
    foreign key ( 제품번호_fk ) references 제품( 제품번호 )
);

-- 예제1 : 매머드커피 홈페이지 DB설계
	-- 제품 , 카테고리 , 주문
    
drop database if exists  매머드커피;
drop database if exists  mamoth;
create database mamoth;
use mamoth;
-- 제품명 , 제품설명 , 카테고리 , 가격 
-- 주문번호 , 주문한 제품 , 주문일시 , 주문상태
-- 콜드브루라떼 , 부드러운~~ , 콜드브루 , 3000 , 주문번호1 , 주문한제품-콜드브루라떼 , 02/24 , 주문들어옴
-- 콜드브루라떼 , 부드러운~~ , 콜드브루 , 3000 , 주문번호2 , 주문한제품-콜드브루라떼 , 02/24 , 주문들어옴
-- 달고나콜드브루라떼 , 부드러운~~ , 콜드브루 , 4500 , 주문번호3 , 주문한제품-달고나브루라떼 , 02/25 , 주문들어옴



drop table if exists 카테고리; -- 대분류 부터 만들어야함!! , PK먼저 만들어야함!!
drop table if exists category;
create table category( -- 제품을 등록하지 않아도 카테고리는 존재해야함 ---------------대분류
	cNum int auto_increment primary key ,
	cName varchar(20) not null unique
);

drop table if exists 제품;
drop table if exists product; -- 제품등록테이블
create table product( -- 제품등록할 때 카테고리는 항상 먼저 존재 ---------------중분류
	pNum int auto_increment primary key , -- 제품번호
	pName varchar(20) not null unique ,
    pContent text not null ,
    pPrice smallint not null ,
    cNum int ,
    foreign key ( cNum ) references category(cNum) on delete cascade on update cascade
);


drop table if exists 주문; 
drop table if exists orderT; -- ---------------소분류
create table orderT(
	oNum int auto_increment primary key  ,
    oDate datetime default now(),
    oState tinyint default 1 ,
    pNum int ,		-- 제품번호
    foreign key ( pNum ) references product( pNum ) on delete set null on update set null
);


-- 카테고리 

	insert into category(cName) values( '콜드브루'); -- pk -> 1 
    insert into category(cName) values( '커피'); 	-- pk -> 2
    select * from category;
    
-- 제품 -- fk 도 넣어야함
	insert into product(  pName , pContent , pPrice , cNum ) values ( '콜드브루라떼' , '맛있는' , 3000 , 1 ); -- pno 1
    insert into product(  pName , pContent , pPrice , cNum ) values ( '오곡콜드브루' , '맛있는' , 4500 , 1 ); -- pno 2
    insert into product(  pName , pContent , pPrice , cNum ) values ( '꿀커피' , '맛있는' , 2000 , 2 ); -- pno 3
    
-- order
	insert into orderT( pNum ) values (1 );
    insert into orderT( pNum ) values (2 );
    insert into orderT( pNum ) values (3 );
    insert into orderT( pNum ) values (2 );
    select * from orderT;
	
	select * from category , product , orderT; -- 중복이 발생해서 join 해야함 다음에 배움
    
    delete from category where cName ='커피';
    select * from product;
    select * from orderT;
    select * from category;
