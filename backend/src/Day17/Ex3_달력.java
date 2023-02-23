package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력 {
	public static void main(String[] args) {
		// static은 메모리 할당됨 . 인스턴트는 메모리 안할당되어있음
		
		// static 멤버는 instance 멤버 호출 X
		
			// 1. [해당멤버 메소드 필드가 static멤버라면 ]run메소드도 정적멤버 하자
			run2(); 	// 객체가 필요없음
			
			//	2. [호출할 해당멤버가 인스턴스멤버일 때 ] 객체 만들어서 메소드 호출 하자
			Ex3_달력 ex3_달력 = new Ex3_달력();
			ex3_달력.run();
		
	}
	
	// 1. 달력함수 [ 일정추가도 할 숭 있음 DB처리 ]
	static void run2() {}
	void run() {
		
		// 1. 현재 날짜
		Calendar cal = Calendar.getInstance();
		// 2. 현재 연도
		int year = cal.get(Calendar.YEAR);
		// 3. 현재 월
		int month = cal.get(Calendar.MONTH)+1;
		// 4. 현재 일
		//int day = cal.get(Calendar.DAY_OF_MONTH);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		
			System.out.printf("=================== %d 년 %d 월 ===================\n" , year , month );
			System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");
			
			// *** 1. 현재 월 의 1일 날짜의 요일 *********************************
			cal.set(year, month-1 , 1 ); // 현재 연도 월의 1일 날짜 형식으로 변경
			int sweek = cal.get(Calendar.DAY_OF_WEEK); // 2023-02-01 요일 ->목이면 4
			
			// *** 2. 현재 월 의 마지막 일 *********************************
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 2023-02월의 일수의 최대수 = 2월마지막일
			
			//*출력
					
			//*해당 월 1일 전까지 공백으로 채우기
			for ( int i = 1 ; i < sweek ; i++ ) {
				System.out.print("\t");
			}
			
			for ( int i = 1 ; i <= eday ; i++) {
				System.out.printf("%2d\t",i);
				
				// 토요일마다 줄바꿈
				if ( sweek % 7 == 0 ) { 	
					System.out.println(); // 토요일마다 줄바꿈
					
				} // 토요일마다 줄바꿈
				sweek++;
			}
			System.out.println("\n===================================================");
			System.out.print("1.이전달 2.다음달 3.검색");
			int ch = scanner.nextInt();
			if ( ch == 1 ) {	
				month--;
				//월이 0이면 월=12 , 연도 1차감
				if ( month < 1 ) { month = 12; year--;	}
			}
			if ( ch == 2 ) {
				month++;
				// 월이 12면 월=1 , 연도 1증가
				if ( month > 12 ) { month = 1 ; year++;	}
			}
			if ( ch == 3 ) {
				System.out.println("연도 : "); int inputY = scanner.nextInt();
				System.out.println("월 : "); int inputM = scanner.nextInt();
				
				//정상입력이면 대입
				if ( inputY >= 1900 && inputY<=9999 && inputM >=1 && inputM <=12 ) {
					year = inputY; month=inputM;
				}//아니면
				else {
					System.out.println("[*]출력할 수 없는 달력입니다.");
				}
			}
			
		}// while end
		
		
	}
	
	
	
	
	
	
	
	
}// class end
