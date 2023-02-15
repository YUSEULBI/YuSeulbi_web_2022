package 과제.과제7.model;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
	ArrayList<Bank> accountDB = new ArrayList<>();
	
	// 1. 필드
	protected String bankNum;
	protected String accountNum;
	protected String password;
	protected String holder;
	protected int leftMoney;
		
		
	// 2. 생성자
		
		//빈생성자
		public Bank() {		}

		//풀생성자
		public Bank(String bankNum, String accountNum, String password, String holder, int leftMoney) {
			super();
			this.bankNum = bankNum;
			this.accountNum = accountNum;
			this.password = password;
			this.holder = holder;
			this.leftMoney = leftMoney;
		}
		
		//매개변수4개
		public Bank( String accountNum, String password, String holder, int leftMoney) {
				super();
				this.accountNum = accountNum;
				this.password = password;
				this.holder = holder;
				this.leftMoney = leftMoney;
		}

		
		
		
			
	// 3. 메소드
		public boolean newAccount ( String password , String holder ) {
			
			
			// accountNum
			Random random = new Random();
			int result = random.nextInt(98)+1;
			int result2 = random.nextInt(98)+1;
			String resultString = Integer.toString(result);
			String resultString2 = Integer.toString(result2);
			if ( result < 10 ) { resultString = "0" + resultString;	}
			if ( result2 < 10 ) { resultString2 = "0" + resultString2;	}
			String accountNo = bankNum +"-"+ resultString +"-"+ resultString2;
			
			// leftMoney
			int leftMoney = 0;
			
			Bank bank = new Bank(accountNo, password, holder, leftMoney);
			accountDB.add(bank);
			return true;
		}
		
		
		

		@Override
		public String toString() {
			return "Bank [bankNum=" + bankNum + ", accountNum=" + accountNum + ", password=" + password + ", holder="
					+ holder + ", leftMoney=" + leftMoney + "]";
		}

		public ArrayList<Bank> getAccountDB() {
			return accountDB;
		}

		public void setAccountDB(ArrayList<Bank> accountDB) {
			this.accountDB = accountDB;
		}
		
		
		
		
		
}
