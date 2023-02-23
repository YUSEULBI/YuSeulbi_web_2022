package Day17;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Ex2_p532 {
	
	public static void main(String[] args) {
		
			// 1. Date , SimpleDateFormat
				// java.util 의 Date : Date 객체명 = new Date();
				//현재 시스템[컴퓨터]의 날짜 
			Date now = new Date();
			System.out.println( now ); // 객체명만 써도 toString
			
			
			
				// SimpleDateFormat 객체명 = new SimpleDateFormat( 패턴 ) ;
				// 객체명,format ( 날짜객체 ) : 해당날짜객체 가 패턴 형식으로 변환
				/*
				 * 패턴
				 * 		y: 연도	yy		yyy			yyyy
				 * 		M: 월	M->2	MM-> 02 	MMM: 2월
				 * 		d: 일
				 * 		H: 시
				 * 		m: 분
				 * 		s: 초	
				 */
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("y MMM dd H:m:ss"); //소 대 소 대:소:소문자
			System.out.println( sdf.format(now) );
			
			// 2. Calender 클래스
			// Calender.getInstance 
			Calendar cal = Calendar.getInstance(); // () 안에 timeZone넣어주면 다른 나라시간대나옴~
			System.out.println( cal );
			
			System.out.println( "현재 년도 : " + cal.get(Calendar.YEAR) );
			System.out.println( "현재 년도 : " + cal.get( 1 ) );
			
			// 연결연산자 땜에 문자열이 먼저 더해지면 문자열이 되어서 ()쳐서 MONTH먼저 계산
			System.out.println( "현재 월 : " + ( (cal.get(Calendar.MONTH) ) +1 ) ); // 1월: 0 / 2월: 1 ~
			System.out.println( "현재 일/년 : "+cal.get(Calendar.DAY_OF_YEAR)); // 2023년 54일째
			System.out.println( "현재 일/월 : "+cal.get(Calendar.DAY_OF_MONTH));
			System.out.println( "현재 일/주 : "+cal.get(Calendar.DAY_OF_WEEK));
			
			// 주 : 일요일:1 ~ 토요일:7
			int week = cal.get( Calendar.DAY_OF_WEEK );
			if ( week == Calendar.MONDAY ) { System.out.println("월");	}
			if ( week == 3 ) { System.out.println("화");	}
			if ( week == Calendar.WEDNESDAY  ) { System.out.println("수");	}
			if ( week == Calendar.THURSDAY ) { System.out.println("목");	}
			if ( week == 6 ) { System.out.println("금");	}
			if ( week == Calendar.SATURDAY ) { System.out.println("토");	}
			if ( week == 1 ) { System.out.println("일");	}
			
			
			// 오전:0 / 오후:1 
			System.out.println("현재 오전/오후 : " + cal.get(Calendar.AM_PM));
			int ampm = cal.get(Calendar.AM_PM);
			if ( ampm == 0 ) { System.out.println("오전");	}
			else { System.out.println("오후");	}
			
			//시
			System.out.println( "현재 시 : " + cal.get(Calendar.HOUR ));
			//System.out.println( cal.get( 10 )); // 동일
			
			//분
			System.out.println( "현재 분 : " + cal.get(Calendar.MINUTE));
			//초
			System.out.println( "현재 초 : " + cal.get(Calendar.SECOND));
			
			
			// 3. 자바기준 - 각국의 표준시 코드 ID // 인터넷에 검색하는게 빠름
			for ( String timeId : TimeZone.getAvailableIDs() ) {
				System.out.println( timeId );
				
				
			// 4. LocalDateTime
			LocalDateTime dateTime = LocalDateTime.now();
				System.out.println(dateTime);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd a HH:mm:ss");
				System.out.println(  dtf.format(dateTime));
				
				System.out.println("1년 후 : " + dateTime.plusYears(1));
				System.out.println("2개월 전 : " + dateTime.minusMonths(2));
				System.out.println("7일후 : "+ dateTime.plusDays(7));
			
			// 5.
			LocalDateTime 시작일 = LocalDateTime.of(2021, 1 , 1 , 0 , 0 , 0 );
			LocalDateTime 종료일 = LocalDateTime.of(2021, 12 , 31 , 0, 0 , 0);
			
			// 종료일이 -> 시작일 이후 날짜인지
			System.out.println("" +시작일.isBefore(종료일)); // true
			System.out.println("종료일 이 시작일 이전 : " + 시작일.isAfter(종료일)); // false
			System.out.println("종료일과 시작일 같은지 : " + 시작일.isEqual(종료일)); //false
			
			// 같은연도이면 0나옴
			System.out.println("연도 차 : " + (시작일.until(종료일, ChronoUnit.YEARS))); //0
			// 
			System.out.println("월 차 : " + (시작일.until(종료일, ChronoUnit.MONTHS))); // 11
			System.out.println("일수 차 : " + (시작일.until(종료일, ChronoUnit.DAYS))); // 364
			System.out.println("시 차 : " + (시작일.until(종료일, ChronoUnit.HOURS))); 
			System.out.println("분 차 : " + (시작일.until(종료일, ChronoUnit.MINUTES)));
			System.out.println("초 차 : " + (시작일.until(종료일, ChronoUnit.SECONDS)));
			
			// 피씨방 노래방 요금시작시간 시간대별 요금계산 (주차장..) 오호 분당 천원..!
			
			
			
			// DecimalFormat
			double num = 1234567.89;
			
			DecimalFormat df;
			
			// * 천단위 쉼표 만들기
			df = new DecimalFormat("#,####");
			System.out.println(df.format(num));
			
			// * 무조건 소수 첫째 자리 표기 [ 없으면 0 ]
				// 0 : 숫자가 없는 자리면 0 채움
			 	// # : 만일 숫자가 없는 자리면 공백
			df = new DecimalFormat("#,###.0");
			
			System.out.println(df.format(123456.7));
			System.out.println(df.format(123456));
			
			
			// * 금액의 천단위 쉼표 : #,##0 / #은생략 0은 없어도 0표시
			df = new DecimalFormat("#,##0원");
			System.out.println(df.format(123456));
			System.out.println(df.format(1));
			
			
			// SimpleDateFormat( 패턴 )
			
			Date date = new Date();
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println( dateFormat.format(date));
			
			dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			System.out.println(dateFormat.format(date));
			
			dateFormat = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
			System.out.println(dateFormat.format(date));
			
			dateFormat = new SimpleDateFormat("오늘은 E요일");
			System.out.println(dateFormat.format(date));
			
			dateFormat = new SimpleDateFormat("[연] 오늘은 D번째 날");
			System.out.println(dateFormat.format(date)); // 23년 54번째 날
			
			dateFormat = new SimpleDateFormat("[월] 오늘은 d번째 날");
			System.out.println(dateFormat.format(date)); // 2월의 23번째 날
			
			
		}
		
	}
	
}
;