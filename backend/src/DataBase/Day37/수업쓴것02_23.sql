/*

	SQL
		DDL
        DML
        DCL
        
        DDL
			create
				create database DB명
                create table 테이블명( 필드명1 타입 제약조건 );
            drop
				drop database DB명;
                drop database if exists DB명; -- 존재하면 삭제
                drop table 테이블명
                drop table if exists 테이블명;
		DML
        DCL

	-타입 [ DBMS 회사마다 다름 ]
		정수형 
			tinyint
            smallint
            int
            bigint
		문자형
			char(길이) : 고정길이
            varchar(길이) : 가변길이
		대용량 [ 긴글 , 첨부파일 ]
			text			:긴글
            longtext		:더 긴글
            
		실수형
			float
            double
		날짜형
			date
            time
            datetime
            
            
        
    -제약조건 
    
*/
drop database market;
-- DB생성
drop database if exists market;

create database market;
use market;
drop table if exists member;
create table member(
	-- 필드 선언
		-- 필드명은 테이블앞글자_필드명
	mid char(8) not null primary key , 
		-- char (길이) : 길이만큼 문자 저장 [ 최대 길이 글자 ]
        -- 제약조건 : not null [ 만일 공백이면 저장실패 ] 
        -- primary key : (기본키)식별키 [필드내 중복불가능 , 공백불가능]
			-- 주민등록번호 , 학번 , 회원번호 , 사번 , 제품번호 등
        
	mname varchar(10) not null ,
		-- varchar(길이) : 가변길이 [ 데이터의 길이가 일정하지 않을 때 ]
		-- 가변길이 : 저장된 데이터 만큼 메모리 할당
			-- varchar(8) 에서 'ABC'만 저장시 5칸 메모리 자동제거
        -- 고정길이 : 선언된 길이 만큼 메모리 할당
			-- char(8) 에서 'ABC' 저장시 8칸 메모리 고정 [ 3칸:ABC , 5칸:빈공간 ]
	
    mnumber int not null,
		-- int : 정수 +-20억 정도 저장가능 [ 공백 불가능 ]
	maddr char(2) not null , -- 최대 2글자 저장 [ 공백 불가능 ]
    
    mphone1 char(3) , -- 국번 ,최대 3글자 저장 [ 공백 가능 ]
    
    mphone2 char(8) , -- 전화번호, 최대 8글자 저장 [ 공백 가능 ]
    
    mheight smallint ,
		-- smallint +-3만정도 저장가능
    mdebut date
		-- date : 날짜
	      
);

select * from member;

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');
-----------------------------------------------------------------
drop table if exists buy;
create table buy(
	
	bnum int auto_increment primary key , -- auto_increment -자동생성 / primary key 공백,중복불가
    mid char(8) ,
    bpname char(6) not null , -- null 이면 등록이 안됨
    bgname char(4) ,
    bprice int not null ,
    bamout smallint not null ,
    foreign key( mid ) references member(mid) -- 관계 mid / member테이블 mid랑 연결
);

select * from buy;

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

select * from buy;

-- ER다이어그램 [ 테이블 간 관계 확인 ]
	-- 메뉴 -> Database -> reverse enginner - 로그인 - 마켓선택 - 다음다음 다이어그램 나옴~

-- 1. select : 검색
-- 1. select 필드명1,필드명2 from 테이블명
select mid from member;
select mid,mname from member;
-- 2. select * from 테이블명
	-- *와일드카드 : 모든것 의미 = 모든 필드 뜻
select * from member;

-- 3. select 필드명 as '별칭' from 테이블명
select mid as '회원아이디' from member;
select mid '회원아이디' from member; -- as생략가능

-- 4. select 필드명 from 테이블명 where 조건
	select * from member where mname = '블랙핑크'; -- 회원명[필드]이 '블랙핑크'인 레코드 검색
    select * from member where mnumber = '4'; -- 멤버수 필드가 4명인 레코드 출력
    select * from member where mheight <= 162; -- 평균키필드가 162 이하이면 레코드 출력
    select * from member where mheight >= 165 and mnumber > 6; -- 키필드가 165이면서 멤버 필드가 6초과
    select * from member where mheight >= 165 or mnumber >6; -- 키필드 165이상 이거나 멤버수 필드가 6초과이면
    select * from member where member.mheight >= 163 and mheight <= 165; -- 163~165
    select * from member where mheight between 163 and 165; -- 
    select * from member where maddr = '경기' or maddr = '전남' or maddr = '경남';
    select * from member where maddr in ( '경기' , '전남' , '경남' ); -- 주소가 경기 혹은 전남 혹은 경남 중 하나이면
    select * from member where mname = '우주소녀'; -- = 같다. [ 모두 동일했을 때   ]
    select * from member where mname like '우%'; -- '우'로 시작하는 문자 찾기
    select * from member where mname like '%대'; -- '대'로 끝나는 문자 찾기
    select * from member where mname like '%녀%'; -- '녀'가 포함된
    select * from member where mname like '우___'; -- '우'로 시작하는 4글자 찾기 [ 우 _ _ _ ]
    select * from member where mname like '_우'; -- 우로 끝나는 두글자
    select * from member where mname like '_우_'; -- 세글자 중 가운데 글자가 '우'인 문자 찾기
    
    -- 자바에서 통계내는 것보다 통계를 내고 자바로 가는것이 나음
    select mname, mnumber , mnumber+1 , mnumber-1 , mnumber*2 , mnumber/2 , mnumber div 2 , mnumber mod 2  from member;
    
	select * from member where mname = '블랙핑크';
    select mname from member;
	select * from member where mname = '블랙핑크';
    select mname from member where mname = '소녀시대';
    select * from member where mnumber <= 4;
    select mname , mnumber*mheight 멤버점수 from member; -- 통계내기 좋음
	
-- 5 select * from 테이블명 order by 정렬기준필드
	-- 다중정렬 : 앞 정렬에서 동일한 데이터가 있을 경우 하위 정렬 
		-- select * from 테이블명 where 조건 order by 정렬기준1 , 정렬기준2
	select * from member order by mdebut asc; -- 오름차순 , 날짜과거순 / 기본값 asc 생략가능
    select * from member order by mdebut desc; -- 내림차순 ( 최신순 / 과거날짜는 작게 침 / 최근날짜가 날짜중에 가장큰 숫자  )
    select * from member order by mheight desc; -- 키가 가장큰 순서부터 / 정렬전에 where을 먼저 써야함
    select * from member where mheight >= 164 order by mheight desc;
    
    -- 키를 내림차순으로 정렬후 , 동일한 키가 있을 경우 동일 키중에서 데뷔날짜 오름차순으로 정렬
    select * from member order by mheight desc , mdebut asc;
		/*  
			다중정렬
			학년 점수 	학년 정렬 -> 점수 정렬 		학년 
            1	50								1 50
            3	20								1 60
            1	60								3 20
               
        */ 
		
    
    -- 6. select * from 테이블명 limit 레코드수 			: 검색 레코드 수 제한	
		-- select * from 테이블명 limit 시작레코드 , 개수
		select * from member limit 3;
        select * from member limit 0, 5;  -- 에이핑크 , 블랙핑크 , 소녀시대~~~~~
        select * from member;
        select * from member order by mheight desc limit 3; -- 키 상위 레코드 3개
        
	-- 7. select distinct 필드명 from 테이블명			: 필드내 데이터 중복 제거
		select maddr from member;
        select distinct maddr from member; -- 중복제거
        
	-- 8. select * from 테이블명 group by 그룹기준필드
		select bamout from buy;
        select sum(bamout) from buy; -- 판매수량 필드 합계
        select avg(bamout) from buy; -- 판매수량 필드 평균
		select max(bamount) from buy; -- 판매수량 필드내 최대값
        select max(bamount) from buy; -- 판매수량 필드내 최소값
        select count( bamout) from buy; -- 판매수량 필드의 레코드수 [ null 미포함 ]
        select count(*) from buy; -- 전체 레코드 수 [ null 포함 ]
        
		-- 1. 회원 아이디[그룹] 별로 판매수량 합계
        select mid 회원아이디 , sum(bamout) as 구매수량총합 from buy group by mid;
		
        -- 2. 회원아이디[그룹] 별로 총매출액[ 가격*수량] 합계
        select mid 회원아이디 , sum(bprice * bamout ) as 총매출액 from buy group by mid;
        -- 3. 회원 아이디[그룹] 별 로 수량 평균
        select mid 회원아이디 , avg( bamout ) as 판매수량평균 from buy group by mid;
        
        -- 4. 회원 수
        select mid 회원아이디 , count( * ) as 결제수 from buy group by mid; -- 레코드 몇개인지
        

-- 9. select * from 테이블명 group by 그룹기준필드 having 그룹내 조건
	-- 아이디별 합계 1000이상이면 VIP로..
    select * from buy;
    select mid as 회원아이디 , sum( bprice * bamout ) as 총매출액 from buy group by mid having sum(bprice * bamout ) >= 1000;
	select mid 회원아이디 , sum( bprice * bamout ) as 총매출액 from buy group by mid having sum( bprice * bamout ) >= 1000 ;
	
    select mid 회원아이디 , sum ( bprice * bamout ) as 총매출액 
    from buy
     -- where sum 그룹전에 where
    group by mid
    -- having 그룹이후에
    ;
    
    
    
    
-- 10. 전체
	-- select * from 테이블명 where 조건 group by 그룹 having 그룹조건 order by 정렬 limit 레코드수제한
		
    select * from buy; 
    
    -- 아이폰을 구매한 mid
    select mid , bpname from buy where bpname = '아이폰';
    -- 디지털분류 제품을 구매한 mid 개수
    select bgname, count(bgname) from buy where bgname = '디지털';
    
    
    
-- insert

	-- 1. 특정필드값넣기- insert into 테이블명 ( 필드명1 , 필드명2 ) values( 값1 , 값2 );
	-- 2. 전체필드값넣기- insert into 테이블명 values ( 값1 , 값2 );
    -- 3. 다중 레코드 삽입 : insert into 테이블명 values( 값1 , 값2 ) , ( 값1 , 값2 );
			-- 두번 레코드 추가
	-- 4. 검색된 결과를 삽입 : insert into 테이블명 select
				-- 검색된 필드와 삽입할 테이블내 필드명이 동일할 경우 ( 순서도 동일 )
	-- 5. 마지막으로 추가된 레코드 pk값 확인 : select last_insert_id();
    
    
select * from buy2;
create table buy2( mid char(8) , bpname char(8) );
select * from buy limit 5;
insert into buy2 select mid , bpname from buy limit 5;

create table maddr( mid char(8) , maddr char(2) ); -- 회원아이디 , 주소 테이블
select * from maddr;
select * from member limit 5; -- 0번 레코드부터 5개 검색
insert into maddr select mid , maddr from member limit 5;
select * from maddr;
select last_insert_id();
    
-- update
	-- update 테이블명 set 필드명 = 수정할값 where 조건식
	-- 1. 해당 테이블에서 주소가 서울이면 'seoul'
    select * from member;
    -- update member set maddr = 'seoul' where maddr = '서울' ; -- 오류 [ char(2) : 최대 2글자 ] 
    -- 워크벤치에서 update,delete 기본적으로 사용 불가능
		-- 메뉴 -> edit -> preferences -> 사이드메노 SQL editor 선택 -> 가장 아래 safe updates 체크 해제
    update member set maddr = 'se' where maddr = '서울';
	update member set mnumber = mnumber/3;
    update member set maddr = '안산'; -- 조건[where] 없을경우 전체 변경
    
-- delete
	-- delete form 테이블명 where 조건식
		-- * 만일 관계테이블 일 경우 다른 테이블에서 fk필드로 사용된 레코드는 삭제 불가능 [ * 제약조건 ]
        -- ex) 잇지는 buy테이블에서 사용되지 않아서 삭제가능하다.
        -- ex) 블랙핑크는 구매했기 때문에 buy 테이블에 있어서 삭제불가능
    -- 1. 만약에 핑크가 포함된 이름 삭제
    -- delete from member where mname like '%핑크%'; -- 오류 발생~~ [ pk가 포함된 레코드 삭제하면 fk ??? ] [ 관계가 있는 테이블에서 pk필드가 포함된 레코드 삭제 불가능 ]
		delete from member where mname = '잇지'; -- [ 관계가 있는 테이블에서 fk필드가 없을 경우 pk필드 삭제 가능 ]
		
    
-- 타입 확인
drop table if exists texttype;
create table texttype(
	tinyint_col tinyint , 		-- 1바이트 -127~+128
    smallint_col smallint , 	-- 2바이트 +- 3만정도
    int_col int ,				-- 4바이트 +- 21억정도 ************** 대표
    int_col2 int unsigned  ,		-- 4바이트 + 43억정도 저장 [ unsigned : 음수사용 X / 음수용량을 -> 양수로 ]
    bigint_col bigint ,			-- 8바이트 +-21억이상
    char_col char( 10 ) ,		-- char ( 길이  ) 		: 고정길이 1~255
    varchar_col varchar(10),	-- varchar( 길이  )		: 가변길이 1 ~ 16383 ************** 대표 *mysql 5.0이상만 16383
    text_col text,				-- 1~65535 글자
    longtext_col longtext , 	-- 1~42억 정도 글자저장 ************** 대표
		-- 첨부파일의 경로를 저장 , 첨부파일은 서버에 저장
	float_col float ,			-- 소수점 7자리 저장
    double_col double ,			-- 소수점 15자리 저장
    date_col date ,				-- 날짜 저장 [ yyyy - MM - dd ]
    time_col time , 			-- 시간 저장 [ hh : mm : ss ]
    detatime_col datetime 		-- 날짜/시간 저장 [ yyyy-MM-dd hh:mm:ss] ************** 대표
);    
select * from texttype;
drop table texttype;




    
/*
	
    연산자
		1. 산술연산자 : +	-	*	/	div몫  mod나머지
		2. 비교연산자 : >=이상 <=이하 >초과 <미만 =같다 !=같지않다. 
        3. 논리연산자 : and이면서 or이거나 not부정
		4. 기타연산자 : 
				in ( 값1 , 값2 , 값3 ) : 값 1~3 중에 하나라도 존재하면 [ 값1 or 값2 or 값3 ]
				필드명 between 값1 and 값2 : 필드가 값1 부터 값2 사이이면 true [ 필드>=값1 and 필드<=값2 ]
                like 	: 패턴 검색
					% : 모든 문자수 대응		_ : _개수만큼 문자수 대응
		5. null관련 연산자
				필드명 is null			: null 이면 [ = null [x] ]
                필드명 is not null		: null 이 아니면 [ != null [x] ]
		
	집계함수 [ 2개 이상 필드 검색시 -> group 필수 ]
		sum( 필드명 ) : 해당 필드 내 데이터 총합
        avg( 필드명 ) : 해당 필드 내 데이터 평균
        max( 필드명 ) : 해당 필드 내 데이터 최대값
		min( 필드명 ) : 해당 필드 내 데이터 최소값
        count( 필드명 ) : 해당 필드내 데이터 수[null 미포함] 
        count(*) : 레코드 수 [ null 포함 ] -- 레코드수구할때
        
        
*/
    
    







