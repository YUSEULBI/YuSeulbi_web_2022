package 과제.과제7.model;

import java.util.Random;

public class Sinhan extends Bank {
	// 1.필드
	final String bankCode = "03";
	// 2. 생성자
	public Sinhan() { 	}
	public Sinhan( String accountNo , String password, String holder, int leftMoney ) {
		super(accountNo, password, holder, leftMoney);
		
	}
	
	
	
	// 3. 메소드
	@Override
	public boolean newAccount(String password, String holder) {
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
		
		Sinhan sinhan = new Sinhan(accountNo, password, holder, leftMoney);
		accountDB.add(sinhan);
		return true;
	}
}
