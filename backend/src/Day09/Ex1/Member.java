/*
	
	클래스 사용 용도
	1. 라이브러리 : 다른 클래스로부터 사용되는 클래스
			협업에서 사용되는 디자인 패턴 : MVC , MVC2 ( API개발에 사용 )
	2. 실행클래스 : main 함수 가지고 있는 클래스
	
	- 필드 사용
		객체 내부 : 생성자 , 메소드
		객체 외부 : 객체명.필드명
		
	JVM
	
	메소드영역		vs		스택영역		vs		힙영역
						
	String(클래스)		String name; (변수)
					String name(변수)	=		new String("유재석") - 인스턴스
					
	클래스(필드-메모리X)	지역변수					객체 (인스턴스화 시킨)
	
	
*/

package Day09.Ex1;

public class Member { // class s
	
	
	
	// 클래스 멤버
	
		// 1. 필드
		String name; // 필드 	// 초기값 null
		int num;			// 초기값 0
		double num2; 		// 초기값 0.0
		boolean check; 		// 초기값 false
		String[] array = new String[3]; 	// 초기값 null null null 
		
		// 2. 생성자
		// 3. 메소드
		void setName() {
			String inputName; // 로컬변수
			System.out.println( name );
			// System.out.println( inputName ); 로컬변수는 자동 초기화 안됨.
			
		}
		
	

} // class e
