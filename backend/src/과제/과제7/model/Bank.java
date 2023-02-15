package 과제.과제7.model;

import java.util.Random;

public class Bank {
	
	// 1. 필드
	protected String bankNum;
	protected String accountNum;
	protected String password;
	protected String holder;
	protected int leftMoney;
		
		
	// 2. 생성자
		
		//빈생성자
		public Bank() {		}

		

		
		
		
			
	// 3. 메소드
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
