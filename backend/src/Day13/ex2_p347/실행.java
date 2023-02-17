package Day13.ex2_p347;

public class 실행 {
	
	public static void main(String[] args) {
		// 인터페이스는 static 이기 때문에 인터페이스명.상수명을 쓰면 호출가능
		// 정적메소드는 객체생성없이 호출가능
		System.out.println("리모콘 최대 볼륨 : " + RemoteControl.MAX_VOLUME );
		System.out.println("리모콘 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
		
		// 인터페이스 변수 선언
		RemoteControl rc;
		
		// 인터페이스에 텔레비전 구현객체 연결
		rc = new Television();
		
		// 인터페이스 메소드 사용 ( 텔레비전 구현객체 )
		rc.turnOn();

		rc.setVolume(8);
		
		rc.turnOff();
		
		
		// 인터페이스 오디오 구현객체 연결
		rc = new Audio();
		
		// 인터페이스 메소드 사용 ( 오디오 구현객체 )
		rc.turnOn();
		rc.setVolume(15);
		rc.turnOff();
		
		
		// 4. 디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
		// 5. 정적메소드 호출
		// rc필요없음
		RemoteControl.changeBattery();
		
	}
}
