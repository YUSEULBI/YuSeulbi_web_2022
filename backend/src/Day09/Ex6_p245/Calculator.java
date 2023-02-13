package Day09.Ex6_p245;

import P_회원시스템.과제4_MVC.start;

public class Calculator {
	
	// 1. 필드
		// 1.인스턴스멤버
		int no;
		
		// 2.정적멤버
		static double pi = 3.14159;
		
	// 2. 생성자
		// static 생성자 없음
	
	// 3. 메소드
		// 1. 인스턴스멤버
		int getNo() {
			return no;
		}
		
		// 2. 정적멤버
		static int plus( int x , int y ) {
			return x + y ;
		}
		static int minus( int x , int y ) {
			return x - y;
		}
		
		
		
		static String info;
		// 정적블록 : p.248
		static { // 복잡한 초기화를 해야할 때 사용
			info = pi + "파이입니다.";
		}
		// static String info = pi + "파이입니다."; 간단하면 이렇게 하면됨.
		
	
}


/*

	정적멤버 : 
		1. static 키워드
		2. JVM 메소드 영역 저장
		3. 객체 없이 사용 가능
		4. 사용방법
			클래스명.정적멤버
		5. 프로그램 시작시 생성 , 프로그램 종료시 초기화
			- 모든 클래스에서 공통이 사용되는 메모리 사용시 효율 좋음
			- 잠시 사용하는 메모리의 경우 정적멤버는 효율 떨어짐
		6. 정적멤버는 인스턴스멤버 사용할 수 없다. (인스턴스 생성전이라서)
		

*/