package Day09.Ex3_236p;

public class 실행 {
	
	public static void main(String[] args) {
		

		
		// 1. 필드 초기화 방법 3가지
			// 1. 직접접근 -- 쓰지않기!!!
			Car car = new Car();
			car.gas = 5;
			
			// 2. 생성자 [ 간접접근 ] : 객체만들 때 필수 데이터
			Car yourCar = new Car(5);
			// yourCar = new car(5); 초기화후에는 변경안됨 ( 기존객체 사라지고 새 객체만들어짐) , 변경후는 메소드가 변경
			
			// 3. 메소드 [ 간접접근 ] : 객체생성 후 데이터 넣을 때
			Car myCar = new Car(); // 자동차객체생성
			myCar.setGas(5); // 가스주입 (메소드 호출)
			
			////
			if ( myCar.isLeftGas() ) { // 자동차에 가스가 있으면 (메소드호출)
				System.out.println("출발합니다.");
				myCar.run(); // 달리기 함수 실행
			}
			
			// 달리기함수로 가스를 소진하거나 또는 처음부터 가스가 없으면 안내
			System.out.println("gas를 주입하세요"); 
	}

}

// Getter Setter
