package 과제.과제9.상속2;

public class 키보드 extends PC주변기기 {
	private String 구동원리; //기계식,멤브레인,광축 등등
	
	public 키보드() {	}

	public 키보드(String 제품명, int 제품가격, String 연결방식 , String 구동원리) {
		super(제품명, 제품가격, 연결방식);
		this.구동원리 = 구동원리;
	}

	@Override
	void regist() {
		if ( 구동원리 == null ) { System.out.println("입력이 잘못되었습니다."); }
		else { super.regist(); }
	}

	public String get구동원리() {
		return 구동원리;
	}

	public void set구동원리(String 구동원리) {
		this.구동원리 = 구동원리;
	}
	
	
	
	
}
