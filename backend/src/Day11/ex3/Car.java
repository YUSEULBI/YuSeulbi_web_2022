package Day11.ex3;

public class Car {
	public int speed;
	
	public void speedUp() {
		speed++;
	}
	
	
	// final메소드 : 오버라이딩 불가능
	public final void stop() {
		System.out.println("차 멈춤");
		speed = 0;
	}
}
