drop database if exists work;
create database work;
use work;

drop table if exists department;
create table department(
	deptno int primary key , -- 부서 코드
	dname varchar(20) ,
    eno int
);

drop table if exists employee;
create table employee(
	eno int auto_increment primary key,
	ename varchar(50),
    erank varchar(10), -- 사원 대리 부장 과장 대표
    etype varchar(20), -- 일용직 정규직 임원
	deptno int ,
    edate date,
    epic longtext ,
    dedate date default null ,
    dereason longtext ,
    foreign key ( deptno ) references department( deptno ) on delete set null
);
alter table department add foreign key( eno ) references employee( eno ) on delete set null;


insert into department(deptno , dname) values( 1 , '인사팀');
insert into department(deptno , dname) values( 2 , '영업팀');
insert into department(deptno , dname) values( 3 , '개발팀');
select * from department;

select * from employee;
delete from employee where eno = 1;

select * from department;
select e.eno , e.ename , e.erank , e.etype , d.dname , edate , epic , d.dname , dedate , dereason  from employee e , department d where e.deptno = d.deptno and e.eno = d.eno ;
select e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , e.dedate , e.dereason from employee,department where e.deptno = d.deptno;
select e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , e.dedate , e.dereason  from employee e , department d where d.deptno = e.deptno ;
select e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , e.dedate , e.dereason  from employee e , department d where d.deptno = e.deptno ;


insert into employee(ename , erank , etype , deptno , edate , epic ) values('고길동','사원','정규직', 1, '2023-03-05' ,'profile21.png' );
insert into employee(ename , erank , etype , deptno , edate , epic ) values('상길동','부장','정규직', 1, '2023-03-05' ,'profile21.png' );
update department set eno = 4 where deptno = 1;

update employee set ename = '김길동' , erank = '대리' , etype = '임원' , deptno = 3 , epic = 'profile21.png' , dedate = null , dereason = null where eno = 1;
select 
	e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , 
    if( e.eno in( select e.eno from  employee e , department d  where e.eno = d.eno ) , d.dname , '' ) as rname ,
    e.dedate , e.dereason
from 
	employee e ,department d
where 
	e.deptno = d.deptno;


select 
	e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , 
    if( e.eno in( select e.eno from  employee e , department d  where e.eno = d.eno ) , d.dname , '' ) as rname ,
    e.dedate , e.dereason
from 
	employee e ,department d
where 
	e.deptno = d.deptno and e.dedate IS NULL;


select 
	e.eno , e.ename , e.erank , e.etype , d.dname , e.edate , e.epic , 
    if( e.eno in( select e.eno from  employee e , department d  where e.eno = d.eno ) , d.dname , '' ) as rname ,
    e.dedate , e.dereason
from 
	employee e ,department d
where 
	e.deptno = d.deptno and ename like '%호%' ;
    
    

select * from employee;  
/*

deptno int primary key , -- 부서 코드
	dname varchar(20) ,
    eno int

*/








