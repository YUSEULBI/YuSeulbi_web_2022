package Day11.ex1;

public class Smartphone extends Phone {
			//자식클래스	extends 부모클래스 {
			//부모클래스의 멤버들을 자식클래스가 사용할 수 있다.
	// 1.필드
	public boolean wifi;
	
	
	// 2.생성자
	public Smartphone() { 	
		
	}
	
	public Smartphone( String model , String color ) {
		super( model , color );		// 부모클래스에 기본생성자가 부모클래스 멤버 호출가능
		System.out.println("자식클래스 생성자실행");
		this.model = model;
		this.color = color;
	}
	
	// 3. 메소드
	public void setWifi ( boolean wifi ) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}

	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
	
}
