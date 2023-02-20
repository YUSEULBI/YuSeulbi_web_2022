package 과제.과제10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DB과제1_복습 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		try {
			while ( true ) {
				
				System.out.println("1.DB연결 2.SQL구문 작성 3.매개변수 입력");
				int ch = scanner.nextInt();
				if ( ch == 1 ) {	
					
				}
				else if ( ch == 2 ) {	}
				else if ( ch == 3 ) {	}
				
			}//while end
		}
		catch (InputMismatchException e) {
			System.out.println("다시 입력해주세요.[입력형식오류]");
		}
		
	}//main end
	
}//class end

