package 과제.과제9.인터페이스3;

import java.util.Scanner;

public class 실행 {
	
			
	 public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		반죽기 반죽기 = null;
		while ( true ) {
			System.out.println("------------------------------");
			System.out.println("-베이킹에 반죽기를 사용합니다.");
			System.out.println("-반죽기에 장착할 반죽날개을 선택하세요");
			System.out.println(">> 1.거품날 2.혼합날 3.반죽날");
			
			int no = scanner.nextInt();
			if ( no == 1 ) {
				System.out.println("-거품날을 장착합니다.");
				반죽기 = new 거품날();
				반죽기.작동();
			}
			else if ( no == 2 ) {
				System.out.println("-혼합날을 장착합니다.");
				반죽기 = new 혼합날();	
				반죽기.작동();
			}
			else if ( no == 3 ) { 
				System.out.println("-반죽날을 장착합니다.");
				반죽기 = new 반죽날();
				반죽기.작동();
			}
		}
	}
}
