package Day08.Ex2_p220;

public class 실행 {
		
	public static void main(String[] args) {
		
		// 1. 객체생성 [ 빈생성자 ]
		Korean k1 = new Korean();
		// 객체정보출력 : 객체명.toString(); [내부클래스에 오버라이드해야함]
		System.out.println(k1.toString()); // 객체안의 toString에 접근 
		
		// 객체 필드 호출 [ 객체명.필드명 ] 
		// [ . 접근연산자 : 주소로 힙영역에 있는 필드나 함수에 접근 ]
		// 변수는 스택영역에 있기 때문에 .을 찍어서 주소로 접근할 필요없음
		System.out.println( k1.nation );
		System.out.println( k1.name );
		System.out.println( k1.ssn );
		
		// 2. 생성자 - 객체초기화역할 기본값 빨리 만들기 , 여러 객체 빠르게 만들기
		Korean k2 = new Korean("박자바", "011225-1234567");
		System.out.println(k2.toString());
		
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
		
	}
	
}
