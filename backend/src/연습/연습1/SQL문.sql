drop database if exists console;
create database console;
use console;

drop table if exists 회원;
create table 회원(
   회원번호_pk int auto_increment primary key , 
    아이디 varchar(20) ,
    비밀번호 varchar(20) ,
    전화번호 varchar(20) ,
    이름 varchar(20) ,
    등급  int       -- 1:일반회원[회원가입] 2:강사[강사등록화면]
);

drop table if exists 스케줄;
create table 스케줄(
   스케줄번호_pk  int auto_increment primary key,
   수강일시 datetime ,
    금액 int ,
    회원번호_fk int ,
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk )
);

drop table if exists 수강내역;
create table 수강내역(
   수강내역번호 int auto_increment primary key , 
    회원번호_fk int ,   -- 누가 
    스케줄번호_fk int ,   -- 어떤 스케줄~
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk ) ,
    foreign key( 스케줄번호_fk ) references 스케줄( 스케줄번호_pk )
);

-- 1. 회원가입
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'qwe' ,'qwe' ,'010-4444-4444' ,'유재석' , 1 );
select * from 회원;
-- 2. 관리자가 강사 등록 
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'asd' ,'asd' ,'010-5555-5555' ,'강호동' , 2 );
-- 2-1. 관리자 비밀번호 등록
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( '관리자' ,'1234' ,'관리자' ,'관리자' , 3 );
-- 2-2. 관리자 로그인
select * from 회원 where 등급 = 3 and 비밀번호 = 1234;

-- 2. 관리자가 수강 등록 
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-02-24 11:00:00' , 30000 , 2 );
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-03-01 11:00:00' , 30000 , 2 );

select * from 스케줄;
-- 3. 회원이 수강신청 
insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( 5 , 2 );
select * from 수강내역;


-- 로그인
select * from 회원 where 아이디 = 'qwe' and 비밀번호 = 'qwe'; -- 회원번호_pk

--  전체 강사들의 스케줄 
select * from 회원 , 스케줄 where 회원.회원번호_pk = 스케줄.회원번호_fk;
-- 4. 특정 강사의 스케줄만 확인 
select * from 회원 , 스케줄 where 회원.회원번호_pk = 스케줄.회원번호_fk and 스케줄.회원번호_fk = 2; -- 강사 본인것만
select * from 회원;
select * from 스케줄;
select * from 수강내역;


select * from 회원 , 수강내역 where 회원.회원번호_pk = 수강내역.회원번호_fk and 수강내역.회원번호_fk = 1; -- 학생 본인것만

select * from 스케줄;

-- 모든 스케줄 출력
select 스케줄번호_pk,수강일시,금액,이름 from 회원,스케줄 where 스케줄.회원번호_fk = 회원.회원번호_pk;

-- 1번회원의 예약내역
select distinct 수강내역번호 , 수강일시 , 이름 , 금액 from 회원,스케줄,수강내역 
				where 수강내역.회원번호_fk = 1 and 수강내역.스케줄번호_fk = 스케줄.스케줄번호_pk and 스케줄.회원번호_fk = 회원.회원번호_pk;													
select * from 회원;

-- 로그인한 강사의 스케줄
select 이름,스케줄번호_pk,수강일시 from 회원 , 스케줄 where 회원.회원번호_pk = 스케줄.회원번호_fk and 스케줄.회원번호_fk = 2; -- 강사 본인것만

-- 모든 강사 출력
select * from 회원 where 등급 = 2;
-- 모든 회원 출력
select * from 회원 where 등급 = 1;

-- 회원의 수강취소
delete from 수강내역 where 수강내역번호 = 2 and 회원번호_fk = 1;