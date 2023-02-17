package Day13.ex2_p347;

public class Audio implements RemoteControl {
	//필드
	private int volume;

	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다");
		
	}
	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다");
		
	}
	@Override
	public void setVolume(int volume) {
		if ( volume > RemoteControl.MAX_VOLUME ) { // 현재소음에 최대소음을 대입
			this.volume = RemoteControl.MAX_VOLUME;
			System.out.println("최대소음보다 커질수없습니다. 최대소음 고정");
		} else if ( volume < RemoteControl.MIN_VOLUME ) { // 요청소음이 최소소음보다 작으면
			this.volume = RemoteControl.MIN_VOLUME; // 현재소음에 최소소음 대입
			System.out.println("최소소음보다 작을수없습니다. 최소소음 고정");
		} else { this.volume = volume;	}
		System.out.println("현재 오디오 볼륨 : " + this.volume ); // 현재 소음 출력
		
	}
	
	//필드
	private int memoryVolume; // 추가 필드 선언
		//음소거 하기전 기존 볼륨 저장
	
	
	// 디폴트 메소드 ( 상속과 동일함 ) 인스턴스모델링 extends / 상수모델링 implement
	// 오버라이드 디폴트메소드는 defult 안씀
	@Override
	public void setMute(boolean mute) {
		if ( mute ) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리 합니다.");
			setVolume(RemoteControl.MIN_VOLUME);
			
		}else {
			System.out.println("무음 해제 합니다.");
			//기존 소음 가져오기
			setVolume(this.memoryVolume);
		}
		//RemoteControl.super.setMute(mute);
	}
	
	
	
	
	
	
}
