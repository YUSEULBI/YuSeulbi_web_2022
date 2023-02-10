package Day08.Ex5;

public class Ex6_회원시스템_함수 { // class s

	// main함수 : 메인스레드(코드흐름읽어주는역할) 가지고 있는 함수
	public static void main(String[] args) { // main s
		// static (정적변수 상수 만들때) . 실행되면 메인함수부터 실행됨
		
		//[ 다른 클래스 메소드 호출 방법 ]
		//1. 객체 생성 // 다른 클래스 함수 호출을 위한 빈생성자 객체
		Front front = new Front();
		
		//2. 객체를 통한 다른 클래스의 함수호출
		front.index();
		
		
		
		
		
		
		
		
	} // main end
	
	// 1. 함수선언 [ 인수X 반환X ]
	// // static : JVM 시작될 때 먼저초기할당 ( 힙X스택X -> Method Area ) 모든곳에서 호출가능 , 전역변수만들때 사용 , 메모리 효율이 떨어짐
	// static void menu() { } 메모리효율안좋음
	
	
} // class end
