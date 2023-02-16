package 과제.과제8;

public class 로션 extends 화장품 {

	// 1. 필드
	String 피부타입;
	
	// 2. 생성자
	//빈생성자
	public 로션() { 		}

		
	
	//풀생성자
	public 로션(String 제품명, int 가격 , String 피부타입) {
			super();
			this.피부타입 = 피부타입;
		}



	
	
	// 3. 메소드
	@Override
	public String toString() {
		return "로션 [피부타입=" + 피부타입 + "]";
	}



	public String get피부타입() {
		return 피부타입;
	}



	public void set피부타입(String 피부타입) {
		this.피부타입 = 피부타입;
	}
	
	
	
}
