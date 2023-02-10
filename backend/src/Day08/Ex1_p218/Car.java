package Day08.Ex1_p218;


// 클래스선언
	// 1. 첫글자 영문 대문자
	// 2. 띄어쓰기X , 숫자로 시작X
	// 3. 멤버 : 1.필드 2.생성자 3.메소드

public class Car { // 클래스 사용목적 : 설계도 ///////////////내부/////////////////

	// 1. 필드 - 실무에선 private 필드명 ( 외부접근차단 ) 
	String model;
	String color;
	int maxSpeed;
	
	
	// 2. 생성자 - 
		// 필드명에 바로 대입시킬수도 있지만 캡슐화(은닉화)로 필드를 숨겨야해서 생성자사용 
		// 생성자를 사용해서 간접접근하면 필터링(유효성검사) 가능
	
		// 1. 생성자가 1개도 선언이 없을 때 기본생성자 사용가능
		// 2. 생성자 이름은 클래스명과 동일!!!!!! 다르면 메소드[함수] 취급
		// 3. 기본생성자[깡통] , 풀생성자 -> 관례적으로 만들고 시작
		// 4. 오버로딩 : 이름이 동일할 경우 시그니처 ( 매개변수 개수 , 타입 ) 다를경우 구분해서 식별 가능 
		// 5. 오버라이딩 : 부모의 메소드를 재정의 ( 부모의 집을 상속받아서 리모델링 )
	
	//1. 빈 생성자 = 객체 생성시 매개변수 없다.
	Car() { 	} // 빈생성자 ,기본생성자 , 깡통
	
	// 생성자 = 2개의 매개변수를 받는다.
	// 관례적으로 필드명과 매개변수이름을 동일하게 넣기 때문에
	// 내부의 필드는 this를 써서 표시한다.
	Car( String model , String color ){
		// this.내부필드명 = 매개변수
		this.model = model;
		this.color = color;
	}
		
	
	// 2. 생성자 = 3개의 매개변수를 가지는 생성자
	Car( String model , String color , int maxSpeed ){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	
	
	
	// 3. 메소드
	@Override
	public String toString() {
		return "Car [model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
} // class e
