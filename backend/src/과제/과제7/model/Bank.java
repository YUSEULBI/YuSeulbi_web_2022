package 과제.과제7.model;

import java.util.Random;

public class Bank {
	
	// 1. 필드
	
	protected String accountNum;
	protected String password;
	protected String holder;
	protected int leftMoney;
		
		
	// 2. 생성자
		
		//빈생성자
		public Bank() {		}

		//풀생성자
		public Bank(String accountNum, String password, String holder, int leftMoney) {
			super();
			this.accountNum = accountNum;
			this.password = password;
			this.holder = holder;
			this.leftMoney = leftMoney;
		}

		
		
		//생성자 / 매개변수( 계좌주 , 비밀번호 ) 예금액0 , 계좌번호 자동생성
		public Bank( String password, String holder ) {
			super();
			this.password = password;
			this.holder = holder;
			this.leftMoney = 0;
		}
		
		
			
	// 3. 메소드
		
	
}
