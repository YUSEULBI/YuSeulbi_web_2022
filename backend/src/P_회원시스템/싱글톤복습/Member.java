package P_회원시스템.싱글톤복습;

public class Member {
	
	// 아직 생성전이었던 객체를 메소드에 저장 : static
	// 공유메모리 , 외부클래스에서 객체생성없이 바로 호출가능.
	// 객체에 바로 접근하지 못하도록 private
	private static Member member = new Member();
	
	private Member() { 	}
	
	// 다른 패키지에서도 접근하도록 public
	// 생성전이었던 함수를 메소드에 저장.->외부에서 객체를 생성하지않아도 호출가능.
	// 객체생성을 막고 , 클래스를 외부에서 사용가능하게 함.
	public static Member getInstance() {
		return member;
	}
	
	void test () {
		
	}
	
	// new Member 는 힙영역
	// Member member객체명은 메소드영역?
	// Member getInstance함수는 메소드영역?
	// member객체에 접근못하게 막는 이유는..?
	
}
