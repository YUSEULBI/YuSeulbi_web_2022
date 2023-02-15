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

		
		
		
			
	// 3. 메소드
		public boolean newAccount ( int bNum , String password , String holder ) {
			
			//bNum
			String bankNo = " ";
			if ( bNum == 1 ) {	bankNo = "03";	}
			else if ( bNum == 2 ) {	bankNo = "04";	}
			else if ( bNum == 3 ) {	bankNo = "05";	}
			
			// accountNum
			Random random = new Random();
			int result = random.nextInt(98)+1;
			int result2 = random.nextInt(98)+1;
			String resultString = Integer.toString(result);
			String resultString2 = Integer.toString(result2);
			if ( result < 10 ) { resultString = "0" + resultString;	}
			if ( result2 < 10 ) { resultString2 = "0" + resultString2;	}
			String accountNo = bankNum +"-"+ resultString +"-"+ resultString2;
			//
			int leftMoney = 0;
			
			Bank bank = new Bank(bankNo, accountNo, password, holder, leftMoney);
			accountDB.add(bank);
			return true;
		}
		
		
		

		@Override
		public String toString() {
			return "Bank [bankNum=" + bankNum + ", accountNum=" + accountNum + ", password=" + password + ", holder="
					+ holder + ", leftMoney=" + leftMoney + "]";
		}
		
		public String getBankNum() {
			return bankNum;
		}

		

		public void setBankNum(String bankNum) {
			this.bankNum = bankNum;
		}

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
