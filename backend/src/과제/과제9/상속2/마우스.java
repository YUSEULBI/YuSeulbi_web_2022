package 과제.과제9.상속2;

public class 마우스 extends PC주변기기 {
	private String 구동방식; // 볼마우스 광마우스
	
	public 마우스() {	}

	
	public 마우스(String 제품명, int 제품가격, String 연결방식 , String 구동방식) {
		super(제품명, 제품가격, 연결방식);
		this.구동방식 = 구동방식;
	}


	@Override
	void regist() {
		if ( 구동방식 == null ) { System.out.println("입력이 잘못되었습니다."); }
		else { super.regist(); }
	}


	public String get구동방식() {
		return 구동방식;
	}


	public void set구동방식(String 구동방식) {
		this.구동방식 = 구동방식;
	}
	
	
	
	
	
}
