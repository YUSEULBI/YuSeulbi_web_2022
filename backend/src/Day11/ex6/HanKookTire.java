package Day11.ex6;

public class HanKookTire extends Tire { // 하위클래스
			// 하위클래스 extends 부모클래스 : 상속
	@Override // 오버라이드 : 부모클래스의 메소드를 재정의/리모델링
	public void roll() {
		System.out.println("한국타이어가 굴러갑니다.");
	}
	
	@Override
	public void stop() {
	 System.out.println("한국타이어가 멈춥니다.");
	}
}
