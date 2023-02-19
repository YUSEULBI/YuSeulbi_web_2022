package 과제.과제9.상속2;

public class 프린터 extends PC주변기기 {
	private String 인쇄방식; //레이저,잉크젯,열전사 등등..
	
	public 프린터() {	}

	public 프린터(String 제품명, int 제품가격, String 연결방식 , String 인쇄방식) {
		super(제품명, 제품가격, 연결방식);
		this.인쇄방식 = 인쇄방식;
	}

	@Override
	void regist() {
		if ( 인쇄방식 == null ) { System.out.println("입력이 잘못되었습니다."); }
		else { super.regist(); }
	}

	public String get인쇄방식() {
		return 인쇄방식;
	}

	public void set인쇄방식(String 인쇄방식) {
		this.인쇄방식 = 인쇄방식;
	}
	
	
}
