package 과제.과제7.model;

import java.util.Random;

public class Kookmin extends Bank {

	// 1.필드
	private final String bankNum = "03";
	// 2. 생성자
	public Kookmin( String password, String holder ) {
		super();
		final String bankNum = "03";
		Random random = new Random();
		int result = random.nextInt(98)+1;
		int result2 = random.nextInt(98)+1;
		String resultString = Integer.toString(result);
		String resultString2 = Integer.toString(result2);
		if ( result < 10 ) { resultString = "0" + resultString;	}
		if ( result < 10 ) { resultString2 = "0" + resultString2;	}
				
		this.accountNum = kookmin +"-"+ resultString +"-"+ resultString2;
		this.password = password;
		this.holder = holder;
		this.leftMoney = 0;
	}
	
	// 3. 메소드
	
	
	
}
