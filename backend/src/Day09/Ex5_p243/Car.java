package Day09.Ex5_p243;

public class Car {
	
	// 인스턴스 멤버
	// 1. 필드
	String model;
	int speed;
	
	// 2. 생성자
	Car ( String model ){ // model : 매개변수 
		// 매개변수는 다른 사람이 알아볼 수 있게 쓰기( 관례적으로 필드명과 동일하게 씀 )
		this.model = model; // this.model : 인스턴스멤버필드
	}
	// 3. 메소드
	void setSpeed ( int speed ) {
		this.speed = speed;
		// 인스턴스멤버필드 = 매개변수
	}
	
	void run() {
		this.setSpeed(100);
		System.out.println( this.model + "가 달립니다. (시속 : " + this.speed+"km/h");
	}
}


/*


	객체 내부 멤버 호출시 this
		* 다른 변수/메소드/생성자와 이름이 동일할 때 사용
	 	1. 내부 필드 호출 this.필드명
	 	2. 내부 함수 호출 this.함수명()
	 	3. 내부 생성자 호출 this( )


*/