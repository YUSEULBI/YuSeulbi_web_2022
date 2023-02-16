package 과제.과제7.view;


import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제7.controller.Bcontroller;
import 과제.과제7.model.Bank;
import 과제.과제7.model.Kookmin;
import 과제.과제7.model.Sinhan;
import 과제.과제7.model.Uri;




public class Front {
	
		// 싱글톤
		private static Front front = new Front();
		private Front() {		}
		public static Front getInstance() {
			return front;
		}
		
		// 스캐너
		private Scanner scanner = new Scanner(System.in);
			
		
		// 인덱스		
		public void index() {
			while ( true ) {
				System.out.println("------------- 계좌 관리 ---------------");
				System.out.println("은행명\t계좌번호\t\t예금액");
				ArrayList<Bank> AccountDB =Bcontroller.getInstance().getAccountDB();
				
				for ( Bank b : AccountDB ) {
					// 객체타입 instanceOf로 찾아서 타입별로 은행명출력하는 함수
					String bankName = Bcontroller.getInstance().bankName(b);
					System.out.println(bankName+"\t"+b.getAccountNum()+"\t"+b.getLeftMoney()+"원");
				}
								
				System.out.println("메뉴 > 1.계좌생성 2.예금 : ");
				
				int ch = scanner.nextInt();
				if ( ch == 1 ) { newAccount_page();	}
				else if ( ch == 2 ) { deposit_page();	}
				else { System.out.println("번호를 잘못 누르셨습니다.");	}
			}
		}
		

		
		// 1. 계좌생성 페이지
		public void newAccount_page() {
			System.out.println("------------- 계좌 생성 ---------------");
			System.out.println("메뉴 > 1.신한은행 2.국민은행 3.우리은행 : ");
			
			int bNum = scanner.nextInt();
			
			if ( bNum == 1 ) { newSinhan();	}
			else if ( bNum == 2 ) {	newKookmin();	}
			else if ( bNum == 3 ) {	newUri();	}
			else { System.out.println("번호를 잘못 누르셨습니다."); }
					
		}
		
		// 2. 예금 페이지
		public void deposit_page() {
			System.out.println("----------- 계좌 입금 -----------------");
			System.out.println("예금할 계좌번호 : \n예)03-12-34"); String acNum = scanner.next();
			System.out.println("예금액 숫자만입력 : "); int money = scanner.nextInt();
			//예금함수
			Bcontroller.getInstance().deposit(acNum, money);
		}
		
		// 3 .신한은행 계좌생성 페이지
		void newSinhan() {
			System.out.println("------------- 계좌 정보 입력  -----------");
			System.out.println("계좌주 : "); 		String holder = scanner.next();
			System.out.println("계좌비밀번호 : "); 	String password = scanner.next();
			// accountNum = 난수생성();
			String accountNum =  Bcontroller.getInstance().randomAccountNum();
			// leftMoney는 0;
			Sinhan sinhan = new Sinhan(accountNum, password, holder, 0);
			//sinhan 본인을 newAccount함수 매개변수로 집어넣음
			sinhan.newAccount();
			
			//계좌생성완료 페이지 오버라이드 함수
			sinhan.newAccountInfo();
			
		}
		// 4 .국민은행 계좌생성 페이지
		void newKookmin() {
			System.out.println("------------- 계좌 정보 입력  -----------");
			System.out.println("계좌주 : "); 		String holder = scanner.next();
			System.out.println("계좌비밀번호 : "); 	String password = scanner.next();
			// accountNum = 난수생성();
			String accountNum =  Bcontroller.getInstance().randomAccountNum();
			// leftMoney는 0;
			Kookmin kookmin = new Kookmin(accountNum, password, holder, 0);
			//kookmin 본인을 newAccount함수 매개변수로 집어넣음
			kookmin.newAccount();
			
			
			//계좌생성완료 페이지 오버라이드 함수
			kookmin.newAccountInfo();
		}
		
		// 5 .우리은행 계좌생성 페이지
		void newUri() {
			System.out.println("------------- 계좌 정보 입력  -----------");
			System.out.println("계좌주 : "); 		String holder = scanner.next();
			System.out.println("계좌비밀번호 : "); 	String password = scanner.next();
			// accountNum = 난수생성();
			String accountNum =  Bcontroller.getInstance().randomAccountNum();
			// leftMoney는 0;
			Uri uri = new Uri(accountNum, password, holder, 0);
			//uri 본인을 newAccount함수 매개변수로 집어넣음
			uri.newAccount();
			
			//계좌생성완료 페이지 오버라이드 함수
			uri.newAccountInfo();
	
		}
		
		
		
		
}
