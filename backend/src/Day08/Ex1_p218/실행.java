package Day08.Ex1_p218; 

public class 실행 { // 클래스 사용목적 :  main함수 가지고있음 , 실행목적
	
	public static void main(String[] args) { // 스레드를 돌리는 목적
		//////////////외부..//////////////////////
		// 1. car 클래스 이용한 객체 생성
		// 클래스명 변수명 = new 생성자명();
		
		// 기본생성자 , 설계클래스에
		Car car = new Car();
		System.out.println( car.toString() );
		car.model = "그랜저"; car.color="노랑";
		
		// 2개의 인수 생성자
				Car car3 = new Car("그랜저", "파랑");
		System.out.println( car3.toString() );
		
		// 3개의 인수 생성자
		Car car2 = new Car("그랜져", "검정", 250);
		System.out.println( car2.toString() );
		
		
		
		
	}

}
