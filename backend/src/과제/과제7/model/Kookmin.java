package 과제.과제7.model;

public class Kookmin extends Bank {
	// 1.필드
	private final String bankCode;
	
	// 2. 생성자
	//빈생성자
	// final 필드때문에 안만들어짐
	public Kookmin(String accountNum, String password, String holder, int leftMoney) {
		super(accountNum, password, holder, leftMoney);
		this.bankCode = "04";
	}

	// 3. 메소드
	@Override
	public void newAccount( ) {
		this.accountNum = "04"+this.accountNum;
		System.out.println("국민은행 계좌 만들어주셔서 감사합니다.");
		super.newAccount();
		
	}

	@Override
	public void newAccountInfo() {
		super.newAccountInfo();
		System.out.println("계좌주 : 국민은행");
	}

	
	
	
}
