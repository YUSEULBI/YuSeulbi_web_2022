package Day13.ex1;

public class Television implements RemoteControl  {
	// 클래스 implements 인터페이스명 : 구현하다
		// 인터페이스 안에 추상된 메소드를 해당 클래스가 구현하겠다.
		// 필수작업 : 추상메소드 구현 @Override!!!!
	
	// abstract : 추상
	// 1. 인터페이스 추상메소드를 구현
	@Override
	public void turnOn() {
		System.out.println("TV를켭니다");
		
	}
	
}
