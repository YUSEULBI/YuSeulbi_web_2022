package Day13.ex1;
// 인터페이스는 목적은 같지만 기능이 다르다.!!!
public class 실행 {

	public static void main(String[] args) {
		
		// 1. 인터페이스 사용하는 구현객체
		
			// 1. 인터페이스는 타입 이므로 변수처럼 사용 가능
		 	
			// 2. 참조하지 않고있는 변수는 null 대입
		RemoteControl control = null;
		
		// 3. 해당 인터페이스를 implements 선언한 객체의 주소 대입
		RemoteControl control2 = new Television();
		 	
		// 4. 해당 인터페이스를 implements 선언하지않는 객체의 주소 대입X
		//RemoteControl control3 = new Audio();
		
		
		 // 2
		RemoteControl rc; // 1. 인터페이스 변수 선언 // 스택영역 변수선언
		rc = new Television(); //힙 영역 객체 선언 . 주소 반환
								//반환된 주소는 rc 스택영역의 변수 대입
			// =
			RemoteControl rc2 = new Television();
		
		// 3
		rc.turnOn();
		new Television().turnOn(); // 똑같은 기능 , 스택에 저장을 안해서 1회성이다. 단기사용에 유용
		
		// 4 리모콘 교체
		rc = new Audio();
		rc.turnOn();
		
		
	}
}
