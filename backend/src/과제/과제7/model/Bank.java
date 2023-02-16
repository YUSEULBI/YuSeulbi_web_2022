package 과제.과제7.model;


import java.util.Random;

public class Bank extends BankService {
	
	
	// 1. 필드
	protected String accountNum; 	// 계좌번호
	protected String password;		// 비밀번호
	protected String holder; 		// 계좌주
	protected int leftMoney;		// 잔액
		
		
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

				
	// 3. 메소드
		public String getAccountNum() {
			return accountNum;
		}

		public void setAccountNum(String accountNum) {
			this.accountNum = accountNum;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getHolder() {
			return holder;
		}

		public void setHolder(String holder) {
			this.holder = holder;
		}

		public int getLeftMoney() {
			return leftMoney;
		}

		public void setLeftMoney(int leftMoney) {
			this.leftMoney = leftMoney;
		}

		

		
		
		
		
		
		
		
		
}
