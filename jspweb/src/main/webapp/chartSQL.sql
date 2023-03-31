-- 날짜별 충전내역
select * from mpoint;
select sum ( if ( mpamount = '포인트충전' , mpamount , 0 ) ) as 충전된포인트 ,
	 date_format( mpdate , '%Y %m %d') as 충전날짜
from mpoint group by date_format( mpdate , '%Y %m %d') ;
select date_format( now() , '%Y %m %d' );

--------------
select if( mpcomment = '포인트충전' , mpamount , 0 ) as 충전된포인트 from mpoint;
select sum( mpamount ) from mpoint group by mpdate;
select sum ( if( mpcomment = '포인트충전' , mpamount , 0 ) ) as 충전된포인트 from mpoint group by date_format( mpdate , '%Y%m%d' );

select 
sum( if( mpcomment = '포인트충전' , mpamount , 0 ) ) as 충전된포인트총합계 ,
date_format( mpdate , '%Y%m%d' ) as 충전날짜
from mpoint 
group by date_format( mpdate , '%Y%m%d' );

select date_format( mpdate , '%Y %m %d' ) as 날짜 from mpoint;
-- 날짜별 포인트 충전 합계 [최근5개]
select 
    sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,
	date_format( mpdate , '%Y%m%d' ) as 충전날짜
from mpoint
   group by date_format( mpdate , '%Y%m%d' )
   order by 충전날짜 desc 
   limit 5;

-- where은 별칭 못씀 (  where 이후에 별칭이 생겨서 안됨 )
-- 특정 날짜별 포인트 충전 합계 [ 최근 5개 ] between '매개변수' and '매개변수'  받으면 됨.
-- date_format( mpdate , '%Y%m%d' ) >= '20230301' and date_format( mpdate , '%Y%m%d' ) <= '20230331'
select 
    sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,
	date_format( mpdate , '%Y%m%d' ) as 충전날짜
from mpoint
where date_format( mpdate , '%Y%m%d' ) between '20230301' and '20230331'
   group by date_format( mpdate , '%Y%m%d' )
   order by 충전날짜 desc 
   limit 5;
   
   
/* -------- 차트 .js 샘플 SQL--------- */
-- 날짜별 포인트 충전 내역
	-- 1. 
	select * from mpoint; 
	-- 2. 특정 필드만 [ 충전 내역이 포인트충전일 경우에만 ]
    select 
		if( mpcomment ='포인트충전'  , mpamount , 0 ) as 충전된포인트 ,
        date_format( mpdate , '%y%m%d')
    from mpoint;
    
    -- 3. mysql 날짜 형식변경 함수 [  date_format( 날짜 , 형식 ) ]
    select date_format( now() , '%Y %m %d' );
    
    -- 4. 총 포인트 충전 합계
	select 
		sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계
    from mpoint;
    
    -- 5. 날짜별 포인트 충전 합계
	select 
		 sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,
        date_format( mpdate , '%Y%m%d' ) as 충전날짜
    from mpoint
    group by date_format( mpdate , '%Y%m%d' );
    
    -- 6. 날짜별 포인트 충전 합계 [ 최근 5개 ]
    select 
		sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,
        date_format( mpdate , '%Y%m%d' ) as 충전날짜
    from mpoint
    group by date_format( mpdate , '%Y%m%d' )
    order by 충전날짜 desc 
    limit 5;
    
	-- 7. 특정 날짜별 포인트 충전 합계 [ 최근 5개 ] * 별칭으로 where 에서` 사용 불가능
    select 
		sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,
        date_format( mpdate , '%Y%m%d' ) as 충전날짜
    from mpoint
    where 
			date_format( mpdate , '%Y%m%d' ) >= '20230301' and  
			date_format( mpdate , '%Y%m%d' ) <='20230331' 
    group by date_format( mpdate , '%Y%m%d' )
    order by 충전날짜 desc;
	
    
    select 
    sum( if( mpcomment ='포인트충전'  , mpamount , 0 ) ) as 충전된포인트총합계 ,
	date_format( mpdate , '%Y%m%d' ) as 충전날짜
	from mpoint
	where date_format( mpdate , '%Y%m%d' ) between '20230301' and '20230331'
   	group by date_format( mpdate , '%Y%m%d' )
   	order by 충전날짜 desc 
   	
    
    -- 샘플 데이터 
	insert into mpoint( mpcomment , mpamount , mpdate , mno ) values( '포인트 충전' , 10000 , '2023-03-30' , 4 );
	insert into mpoint( mpcomment , mpamount , mpdate , mno ) values( '포인트 충전' , 123456 , '2023-03-29' , 4 );
	insert into mpoint( mpcomment , mpamount , mpdate , mno ) values( '포인트 충전' , 753 , '2023-03-28' , 4 );
	insert into mpoint( mpcomment , mpamount , mpdate , mno ) values( '포인트 충전' , 4227 , '2023-03-27' , 4 );
    insert into mpoint( mpcomment , mpamount , mpdate , mno ) values( '포인트 충전' , 5852 , '2023-03-26' , 4 );