package Day08.Ex2_p220;

public class Korean {
	
	// 1. 필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	// 2. 생성자
	
	//빈생성자 ctrl spacebar 자동생성
	public Korean() {}
	
	//매개변수 있는 생성자
	public Korean( String name ,  String ssn ) {
		//this.내부필드명 = 매개변수명
		this.name = name;
		this.ssn = ssn;
	}

	
	
	// 3. 메소드
	// 오버라이드 상속받은 클래스 리모델링 - toString - 필드 데이터 확인목적
	@Override
	public String toString() {
		return "Korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
}


/*


	window - preference

*/