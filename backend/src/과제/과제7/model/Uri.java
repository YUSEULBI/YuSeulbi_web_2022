package 과제.과제7.model;



public class Uri extends Bank {
	// 1.필드
	private final String bankCode;
	
	// 2. 생성자
	//빈생성자
	// final 필드때문에 안만들어짐
	public Uri(String accountNum, String password, String holder, int leftMoney) {
		super(accountNum, password, holder, leftMoney);
		this.bankCode = "05";
	}

	// 3. 메소드
	@Override
	public void newAccount() {
		System.out.println("우리은행 계좌 만들어주셔서 감사합니다.");
		this.accountNum = "05"+this.accountNum;
		super.newAccount();
	}

	@Override
	public void newAccountInfo() {
		super.newAccountInfo();
		System.out.println("계좌주 : 우리은행");
	}
	
	
}
