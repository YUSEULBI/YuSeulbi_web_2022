package 과제.과제8;

public class 화장품 extends 화장품서비스 {

	// 1.필드
	String 제품명;
	int 가격;
	
	// 2.생성자
	//빈생성자
	public 화장품() { 	}
	
	//풀생성자
	public 화장품(String 제품명, int 가격) {
		super();
		this.제품명 = 제품명;
		this.가격 = 가격;
	}

	
	
	
	// 3.메소드
	@Override
	public String toString() {
		return "화장품 [제품명=" + 제품명 + ", 가격=" + 가격 + "]";
	}
	
	// getter setter
	public String get제품명() {
		return 제품명;
	}

	public void set제품명(String 제품명) {
		this.제품명 = 제품명;
	}

	public int get가격() {
		return 가격;
	}

	public void set가격(int 가격) {
		this.가격 = 가격;
	}
	
	
}
