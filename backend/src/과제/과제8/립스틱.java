package 과제.과제8;

public class 립스틱 extends 화장품 {

	// 1. 필드
		String 칼라;
		String 제형;
	
	// 2. 생성자
	//빈생성자
	public 립스틱() { 		}

		
	
	//풀생성자
	public 립스틱(String 제품명, int 가격 , String 칼라, String 제형) {
			super();
			this.칼라 = 칼라;
			this.제형 = 제형;
		}



	
	
	// 3. 메소드	
	@Override
	public String toString() {
		return "립스틱 [칼라=" + 칼라 + ", 제형=" + 제형 + "]";
	}
	
	

	@Override
	void 등록(화장품 제품) {
		super.등록(제품);
	}



	// getter setter
	public String get칼라() {
		return 칼라;
	}



	public void set칼라(String 칼라) {
		this.칼라 = 칼라;
	}



	public String get제형() {
		return 제형;
	}



	public void set제형(String 제형) {
		this.제형 = 제형;
	}
	
	
	
}
