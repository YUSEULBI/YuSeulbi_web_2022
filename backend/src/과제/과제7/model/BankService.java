package 과제.과제7.model;

import java.util.ArrayList;

import 과제.과제7.controller.Bcontroller;

public class BankService {

	//계좌생성함수
	public void newAccount (  ) {
		//강제형변환
		Bank account = (Bank)this;
		//유효성검사 생략
		
		// 계좌DB에 추가
		Bcontroller.getInstance().getAccountDB().add(account);
		//System.out.println("총 계좌 개수 : "+Bcontroller.getInstance().getAccountDB().size());
	}
	
	// 생성된 마지막 계좌정보 안내 함수
		public void newAccountInfo(  ) {
			ArrayList<Bank> DB = Bcontroller.getInstance().getAccountDB(); 
			int no = DB.size();
			Bank account = DB.get(no-1);			
			System.out.println("------------- 계좌 생성 완료  -----------");
			System.out.println("계좌주 : " + account.getHolder());
			System.out.println("계좌번호 : " + account.getAccountNum());
		}
}
