package Day13.ex2_p347;

public interface RemoteControl {

	// 상수 필드 [ 클래스 1.인스턴스멤버(객체) 2. 정적멤버(객체X) ]
	// 인터페이스는 생성자가 없어서 -> new생성자 못씀 ->  객체를 못만듬 -> 인스턴스멤버를 못씀 인스턴스멤버 변수는 못씀 -> static 멤버만 가능
	// 상수 : static final // 상수는 고정값 초기값이 필요함
	
	
	// 인터페이스는 무조건 상수라서 생략!!!!
	public static final int MAX_VOLUME = 10;
	
	int MIN_VOLUME = 0;	//자동으로 public static final 이 붙음
	
	// 추상메소드
		// 리턴타입 , 메소드명 , 매개변수 만 기술
		// 중괄호 선언 안함!!!
		// public abstract 생략가능 -> 생략시 자동으로 선언됨
		// abstract : 추상
		// 해당 클래스들이 ***implements 했을 때 구현클래스가 되었을때 -> ***오버라이딩 필수
	
	// 1.
	public abstract void turnOn();	// {	}없다.
	void turnOff(); // public abstract 생략가능 , 자동선언
	void setVolume( int volume );
	
	
	// 디폴트 메소드
		// 클래스에서 사용하는 메소드 동일 [ ***선언 과 구현 ]
		// 선언부 앞에 default 선언
		// 구현클래스에서 구현을 안해도 됨!!!!!!!!!! [ ***오버라이드 선택 ]
	
		// 2. default 
	default void setMute( boolean mute ) {
		if ( mute ) {
			System.out.println("무음 처리합니다. ");
			setVolume( MIN_VOLUME );
		
		}else {
			System.out.println("무음 해제합니다.");
			
		}
	}
	
	
	// 정적 메소드
		// 구현클래스 없이 바로 실행문에 호출 (싱글톤과 동일한 호출방법)
		// 구현 객체가 필요없다. new없이 가능 . ***implement X
		// static 선언
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
	
	
}
