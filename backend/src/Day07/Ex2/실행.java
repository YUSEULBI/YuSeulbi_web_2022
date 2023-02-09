// 클래스는 두가지 사용목적 : 2. 실행 ( main 함수 )

package Day07.Ex2;

public class 실행 {
	
	public static void main(String[] args) { //
		
		// 1. 클래스 이용한 객체 생성
		Car myCar = new Car(); // new를 쓸 때마다 새로운 객체메모리 생성 , 주소다름
		// 클래스명 변수명 = new 생성자명();
		
		// 2. 객체의 필드 호출 [ .접근연산자 ]
		System.out.println("모델명 : " + myCar.model);
		System.out.println("시동여부 : " + myCar.start);
		System.out.println("현재속도 : " + myCar.speed);
		
		
		// 3. 
		Car yourCar = new Car(); // new를 쓸 때마다 새로운 객체메모리 생성 , 주소다름
		yourCar.model = "현대자동차";
		
		System.out.println( " 모델명 : " + myCar.model);
		System.out.println( " 모델명 : " + yourCar.model);
		
	}

}
