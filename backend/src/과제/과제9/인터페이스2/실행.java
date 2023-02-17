package 과제.과제9.인터페이스2;

import java.util.Scanner;

public class 실행 {
	
	public static void main(String[] args) {
		
		타블렛 타블렛 = null;
		Scanner scanner = new Scanner(System.in);
		
		while ( true ) {
			System.out.println(">>타블렛으로 드로잉프로그램에 그림을 그려보자");
			System.out.println(">>제품선택 [1]인튜어스3 [2]인튜어스4 [3]인튜어스6 [4]인튜어스pro");
			System.out.println("구매할 제품번호 입력: ");
			int no = scanner.nextInt();
			if ( no == 1 ) { 타블렛 = new 인튜어스3타블렛(); System.out.println("그림그리기 시작!");	}
			else if ( no == 2 ) { 타블렛 = new 인튜어스4타블렛(); System.out.println("그림그리기 시작!");	}
			else if ( no == 3 ) { 타블렛 = new 인튜어스6타블렛(); System.out.println("그림그리기 시작!");	}
			else if ( no == 4 ) { 타블렛 = new 인튜어스pro타블렛();	System.out.println("그림그리기 시작!"); }
			
			while ( true ) {
				
				System.out.println("1.그리기 2.지우기 3.그만그리기");
				int 입력 = scanner.nextInt();
				if ( 입력 == 1 ) {
					타블렛.드로잉프로그램에그림그리기();
				}else if ( 입력 == 2 ) {
					타블렛.그림지우기();
				}else if ( 입력 == 3 ) { break;	}
				
				 
			}
			
		}
		
		
		
	}
	
	
	
}

