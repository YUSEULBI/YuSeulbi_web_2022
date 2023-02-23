package Day17;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력_복습 {
	
	
	public static void main(String[] args) {
		Ex3_달력_복습 ex3_달력_복습 = new Ex3_달력_복습();
		ex3_달력_복습.run();
	}
	Scanner scanner = new Scanner(System.in);
	void run() {
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR); 		// 현재 년도
		int month = cal.get(Calendar.MONTH)+1;	// 현재 월
		
		
		
		while(true) {
			System.out.printf("=================== %d 년 %d 월 ===================\n" ,
						year , month );
			
			
			
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			
			//1.현재월 - 1일의 요일 
			cal.set(year, month-1 , 1); // 현재 연도,월의 첫째날로 날짜바꿈 
			int sweek = cal.get(Calendar.DAY_OF_WEEK); // 첫째날의 요일의숫자 -> 목요일이면 4
			
			//2.현재월 - 마지막의 요일
			int eday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //설정한 현재날짜의 맥시멈일 마지막일
			
			// 해당 월 1일 전까지 공백으로 채우기
			for ( int i = 1 ; i < sweek ; i++ ) {
				System.out.print("\t");
			}
			
			for ( int i = 1 ; i <= eday ; i++ ) {
				System.out.printf("%2d\t",i); // 일수 출력 i~마지막일까지
				// sweek는 현재날짜cal의 요일
				// sweek는 1일부터 시작함.
				// sweek가 7일이 되면 줄바꿈
				// 그러기 위해서 i가 증가할때마다 sweek도 증가해야함.
				// i도 일수 sweek도 일수임.
				if ( sweek % 7 == 0 ) { System.out.println();	}
				sweek++;
			}
			System.out.println("\n===================================================");
			System.out.print("1.이전달 2.다음달 3.검색");
			int ch = scanner.nextInt();
			if ( ch == 1 ) {}
			else if ( ch == 2 ) {}
			else if ( ch == 3 ) {}
		}
	}
}
