/*

	DBA[개발자]				 DBMS				컴퓨터
	언어 : 영어,한글(문자)							기계어 : 0,1
    표 만들어줘				
    create table 회원();	---> 기계어로 번역 ----->  메모리 할당	
        
	[SQL 질의어]
    
    1. DDL
		- create
			create database DB명; 	// DB생성
            create table 테이블명( 필드명 타입 제약조건 , 필드명 타입 제약조건 ) 	// 테이블생성
        - drop
			drop database DB명;		// DB삭제
            drop table 테이블명;		// 테이블삭제
        alter
        truncate
    
    2. DML
		- insert
			모든필드에 데이터추가 : insert into 테이블명 values ( 데이터1 , 데이터2 );
            특정필드에 데이터추가 : insert into 테이블명 (필드명1 , 필드명2) values ( 데이터1 , 데이터2 );
        - select
			테이블의 모든 필드 검색 : select * from 테이블명;
            테이블의 특정 필드 검색 : select 필드명 , 필드명 from 테이블명;
            테이블의 조건 검색 : select * from 테이블명 where 조건
        - update
			모든 레코드에 대한 수정 : update 테이블명 set 필드명 = 새로운값 , 필드명2 = 새로운값
            특정 레코드에 대한 수정 : update 테이블명 set 필드명 = 새로운값 where 조건
        - delete
			모든 레코드 삭제 : delete from 테이블명
            특정 레코드 삭제 : delete from 테이블명 where 조건
		
        * 절
			where 절
            
        
    3. DCL
		grant
        revoke
        
    4. TCL
		commit
        rollback
        
	5. 그외
		use DB명; 	// 해당 DB사용
        
        
	-데이터타입
    
		정수형 : TINYINT , SMALLINT , INT , BIGINT
        실수형 : FLOAT , DOUBLE
        문자형 : CHAR(길이) : 고정길이 // VARCHAR(길이)  : 가변길이
        날짜형 : DATE , TIME , DATETIME
        대용량 : TEXT , LONGTEXT , BLOB , LONGBLOB
        

*/

drop database java; -- ctrl enter 해당커서의 명령어 실행
-- db생성
create database java;
-- db사용
use java;

-- 테이블생성
create table member(
	mno int auto_increment primary key ,
		-- auto_increment : 자동번호 부여 [ *무조건 pk(primary key) 같이사용 ]
		-- primary key : 식별용도 [ * 중복X , 공백null 안됨X ]
        mid varchar(20) ,
        mpw varchar(20) ,
        mname varchar(10) ,
        mphone varchar(13) -- 마지막은 , 안함
);


select * from member;

-- 4. 회원가입 1명 [ 'qwe' , 'qwe' , '유재석' , '010-
insert into member( mid , mpw , mname , mphone ) values ( 'qwe' , 'qwe' , '유재석' , '010-4444-4444' );

-- 6. 회원가입 1명 추가 [ 'asd' , 'asd' , '강호동' , '010-5555-5555' ]
insert into member( mid , mpw , mname , mphone ) values( 'asd' , 'asd' , '강호동' , '010-5555-5555' );

-- 표 확인
select * from member;

-- 7. 로그인하기 , 아이디 비번 일치하면 [ 'asd' , 'zxc' ]
select * from member where mid = 'asd' and mpw = 'zxc'; -- 조건 where절 : 필드명 연산자 값 / 레코드가 존재하면 로그인 성공 , 없으면 로그인 실패
			-- 조건 where절 필드명 = 찾을값		: 해당 필드의 값이 찾을 값과 같으면 true
            -- 조건 and 조건 , 조건 or 조건		: 
            -- 검색된 결과[레코드-행]가  존재하면 로그인 성공 없으면 실패

-- 8. 로그인하기 , 아이디와 비밀번호가 일치한지 [ 'qwe' , 'qwe' ]
select * from member where mid = 'qwe' and mpw = 'qwe'; -- 필드명 = 값 and 필드명 = 값


-- 9. 특정 회원의 모든 정보 호출 [ 회원번호 : 3 ]
select * from member where mno = 3; -- 3번 회원의 레코드[행] 확인 -> 없엉

select * from member where mno = 2; -- 2번 회원의 레코드[행] 확인

-- 10. 특정 회원의 비밀번호 변경 [ 2번 회원의 비밀번호 'zxc'로 변경 ]
update member set mpw = 'zxc'; -- 모든 회원의 비밀번호를 'zxc'로 변경
update member set mpw = 'zxc' where mno = 2; -- mno가 2번인 레코드만 비밀번호 zxc로 변경

-- 11. 특정 회원의 탈퇴 ( 레코드 삭제 )
delete from member; -- 모든 회원 탈퇴
delete from member where mno = 2; -- mno가 2인 레코드를 삭제 ( 레코드 =행 = 가로 = 튜플 ) ( 컬럼 = 세로 = 필드 = 속성 )












