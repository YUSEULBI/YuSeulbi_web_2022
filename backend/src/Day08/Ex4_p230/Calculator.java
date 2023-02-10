package Day08.Ex4_p230;

public class Calculator { 
	
	// [ 멤버 ]
	// 1. 필드
	// 2. 생성자
	
	
	// 3. 메소드
		
		// 1. 반환X 인수X 
		void powerOn() {
			System.out.println("전원을 켭니다.");
		}
		
		// 2. 반환X 인수X
		void powerOff() {
			System.out.println("전원을 끕니다.");
		}
		
		// 3. 인수 x , y / 반환 int // 예 x=3 y=5  return =8 
		int plus ( int x , int y ) {
			int result = x+y;
			return result;
		}
		
		// 4. 인수 : x , y / 반환 double / 예 x=3 , y=5  return = 0.6
		/*
		 * double divide( double x , double y ) { }
		 * 외부클래스에서 인수 int로 넣어도 -> double이 더 크기 때문에 자동형변환 
		 */
		double divide( int x , int y ) {
			double result = (double)x/(double)y;
			return result;
		}
		
		// 5. 인수 : x , y / 반환X
		void multiply ( double x , double y ){
			double result = (double)x * (double)y;
			System.out.println( result );
		}
		
		// 6. 인수X / 반환O
		String info( ) {
			 return "이젠 계산기";
		}
		
		/////
		//내부함수호출///////////////////////////
		void 함수호출 () {
			
			powerOn();
		
		}
		
}

/*

	함수 = 메소드
	
	[js 함수 선언] 
	function 함수명( 인수명 ) {
	
	}
	
	[ JAVA 함수 선언 ]
	리턴타입 넣어야함.
	리턴타입 함수명 ( 인수1 , 인수2 ) {
	
	}
	
	[ js 호출 ]
	함수명 ( 인수1 , 인수2 );
	
	
	[JAVA 내부 함수 호출 ]
	함수명 ( 인수1 , 인수2 );
	
	[JAVA 외부 함수 호출 ] - 객체가 필요함
	객체명.함수명( 인수1 , 인수2 )
	
	/////////////////////////////////
	1. 인수X 반환X
	void 함수명 ( ) { }
	
	2. 인수O 반환X
	void 함수명 ( 인수1 , 인수2 ) {	}
	
	3. 인수X 반환O
	리턴타입 함수명( ) { return 값; }
	
	4. 인수O 반환O
	리턴타입 함수명 ( 인수1 , 인수2 ) { return 값; }
	 

*/