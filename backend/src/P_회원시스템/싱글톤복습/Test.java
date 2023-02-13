package P_회원시스템.싱글톤복습;

public class Test {
	
	// Front front = new Front
	// 자료형 선택 Front가능 = 초기화 불가능
	
	// Front.
	void test () {
		
		// Front front = new Front();
		//front.name
		// 객체를 가져와서 객체의 필드,메소드에 접근했었음.
		
		// 생성하지 못하게 생성자 막기
		// Front front = new Front();
		// 생성불가
		
		Front front = Front.getInstance();
		
		// 라이브러리 클래스에서 만든 객체에 접근할 수 있음
		
		//-------------------------------------
		// Member 클래스에서 생성자 막음 / 객체생성 불가
		//Member member = new Member();
		
		// 함수를 통해서 Member의 test메소드 호출
		Member.getInstance().test();
		
		
	}
	
	
}
