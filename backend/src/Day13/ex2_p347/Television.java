package Day13.ex2_p347;

public class Television implements RemoteControl {
	// 텔리비젼클래스가 인터페이스의 추상메소드를 구현할거야!! - 구현객체
	// 오버라이딩 필수!!!!!!!!!!
		// 구현한다고 했기 때문에 인터페이스 추상메소드 꼭 구현해야함
	
	// 필드
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
	}
	
	@Override
	public void setVolume(int volume) { // 요청한 소음이 최대소음보다 크면
		if ( volume > RemoteControl.MAX_VOLUME ) { // 현재소음에 최대소음을 대입
			this.volume = RemoteControl.MAX_VOLUME;
			System.out.println("최대소음보다 커질수없습니다. 최대소음 고정");
		} else if ( volume < RemoteControl.MIN_VOLUME ) { // 요청소음이 최소소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME; // 현재소음에 최소소음 대입
			System.out.println("최소소음보다 작을수없습니다. 최소소음 고정");
		} else { this.volume = volume;	}
		System.out.println("현재 TV 볼륨 : " + this.volume ); // 현재 소음 출력
		
	}
	
	
}
