package Day13.ex5_p376;

public class Car {
	// 타입을 인터페이스로 선언 [ 해당 인터페이스를 구현한 클래스들의 구현객체를 여러개 대입 ]
	Tire tire1 = new HankookTire();
	Tire tire2 = new HankookTire();
	void run() {
		tire1.roll();
		tire2.roll();
	}
}
