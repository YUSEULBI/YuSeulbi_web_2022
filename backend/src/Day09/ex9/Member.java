package Day09.ex9;

public class Member {
	
	// 1. 자신 클래스 참조타입으로 객체 생성
	// Member mem = new Member();
	
	// 2. private 잠구기 
	// private Member mem = new Member(); // 외부 클래스에서 접근 못함
	
	// 5. static // 객체 없이 호출하기 위해
	private static Member mem = new Member();
	
	// 3. 생성자도 private 막는다.
	private Member() {	} // 외부에서 Member 객체 생성 불가.
	
	// 4. 인스턴스 함수, 외부에서는 객체가 있어야 꺼낼 수 있음.
	// Member 객체 mem을 반환해주는 함수
	// public Member getInstance() { 
	public static Member getInstance() { // static객체는 static함수로 사용가능
		// mem이 private 잠겨있어서 반환못함. mem 객체 instance추가 ( 5번 )
		return mem;
	}
	

	
}


/*

	싱글톤 : 프로그램내 하나의 객체를 가지는 클래스 패턴
	
		-1. 클래스 내부에 객체 만들기
		-2. 생성자 private
		-3. 내부객체 반환해주는 함수 : getInstance()
		-4. 함수 호출시 객체가 필요한데 외부에서 객체 생성 금지해놓음
		 	-> static 
		 	--> 정적멤버는 인스턴스멤버를 사용할 수 없다. 
		 	-> mem을 static으로 바꿔줘야함
		 	
		 	
	// 클래스내에서 미리 객체를 생성하고 
	// 외부에서 객체 호출 못하게 생성한 객체를 private
	// 외부 클래스에서 객체 생성 못하게 생성자 private
	// 외부 클래스에서 함수로 호출하게 만들기
	 	// 1. 클래스타입의 getInstance함수 ( 클래스객체 반환 )
		// mem클래스객체가 private라 반환할 수 없음 -> static
		// static 정적멤버를 사용하려면 함수도 정적멤버여야함. 함수도 static
		
		
*/