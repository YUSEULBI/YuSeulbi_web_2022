package 과제.과제7.controller;

import java.util.ArrayList;
import java.util.Random;

import 과제.과제7.model.Bank;
import 과제.과제7.model.Kookmin;
import 과제.과제7.model.Sinhan;
import 과제.과제7.model.Uri;

public class Bcontroller {

	//싱글톤
	private static Bcontroller bcontroller = new Bcontroller();
	private Bcontroller() { 	}
	public static Bcontroller getInstance () {
		return bcontroller;
	}
	
	
	//DB
	private ArrayList<Bank> AccountDB = new ArrayList<>();
	public ArrayList<Bank> getAccountDB (){
		return AccountDB;
	}
	
	
	// 난수생성
	public String randomAccountNum() {
		
		Random random = new Random();
		int result = random.nextInt(98)+1;
		int result2 = random.nextInt(98)+1;
		String resultString = Integer.toString(result);
		String resultString2 = Integer.toString(result2);
		if ( result < 10 ) { resultString = "0" + resultString;	}
		if ( result2 < 10 ) { resultString2 = "0" + resultString2;	}
		String accountNo = "-"+ resultString +"-"+ resultString2;
		return accountNo;
		
	}
	
	//은행명 반환 함수
	public String bankName( Bank b ) {
		if (b instanceof Sinhan) { return "신한"; }
		if (b instanceof Kookmin) { return "국민"; }
		if (b instanceof Uri) { return "우리"; }
		return "은행명오류";
	}
	
	//예금 함수
	public void deposit( String acNum , int Money ) {
		for ( Bank b : AccountDB ) {
			// 입력한 계좌번호랑 계좌DB에 같은 계좌번호를 갖고있는 객체가 있으면
			if ( b.getAccountNum().equals(acNum) ) {
				b.setLeftMoney(b.getLeftMoney()+Money);
				return;
			}
		}
		System.out.println("계좌번호를 올바르게 입력해주세요.");
	}
	
}
