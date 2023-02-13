package P_회원시스템.싱글톤복습;

public class Front {
	
	// 
	String name;
	
	void test() {};
	// 싱글톤 만들때 클래스 내에서 미리 객체 생성하고 생성자막고 함수로 반환할때 static을 아직 안쓰면 정의만 되었지 안만들어진 상태
	// 클래스객체만들때 static 추가하면 클래스 객체명이 스택영역에 있다가 메소드영역으로 가서 항상 사용할 수 있다.
	private static Front front = new Front();
	
	// 생성자 막기
	private Front() { 	}
	
	// 함수가 스택영역에 있어서 사라지기 때문에 메소드영역으로 옮기는것?
	// 함수가 생성전이었는데 static을 선언해서 메소드영역에 저장
	// static을 쓰면 객체없이 바로 쓸 수 있음.
	public static Front getInstance() {
		return front;
	}
	
	
	
}
