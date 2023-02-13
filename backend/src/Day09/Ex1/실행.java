package Day09.Ex1;

public class 실행 {
	
	public static void main(String[] args) { // main s
		
		// 1. 객체 만들기
		Member member = new Member();
		System.out.println(member.name);
		
		// Member 클래스 안에 로컬변수는 호출 안됨.
		// System.out.println(member.inputName); 
		
		
		// 2. Member클래스 함수호출
		member.setName();
		
	} // main e

}
