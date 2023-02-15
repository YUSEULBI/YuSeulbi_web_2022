package 과제.과제7.view;


import java.util.Scanner;

import 과제.과제7.model.Bank;
import 과제.과제7.model.Sinhan;




public class Front {
	
		// 싱글톤
		private static Front front = new Front();
		private Front() {		}
		public static Front getInstance() {
			return front;
		}
		
		Scanner scanner = new Scanner(System.in);
		
		Sinhan sinhan = new Sinhan();
		
		Bank bank = new Bank();
		
		public void index() {
			while ( true ) {
				System.out.println("------------- 계좌 관리 ---------------");
				System.out.println("은행명\t계좌번호\t예금액");
				
				
				
				
				System.out.println("메뉴 > 1.계좌생성 2.예금");
				int ch = scanner.nextInt();
				if ( ch == 1 ) { newAccount_page();	}
				else if ( ch == 2 ) { deposit_page();	}
			}
		}
		
		// 1. 계좌생성 페이지
		public void newAccount_page() {
			System.out.println("------------- 계좌 생성 ---------------");
			System.out.println("메뉴 > 1.신한은행 2.국민은행 3.우리은행");
			int bNum = scanner.nextInt();
			System.out.println("------------- 계좌 정보 입력  -----------");
			System.out.println("계좌주 : ");
			String holder = scanner.next();
			System.out.println("계좌비밀번호 : ");
			String password = scanner.next();
			
			
		}
		
		// 2. 예금 페이지
		public void deposit_page() {
			
			
		}
		
}
