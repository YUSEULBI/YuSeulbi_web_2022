package Day14.ex1_p466;

public class p466 {
	
	
	// 1. p.466
	
	// 함수 선언
	// 접근제한자 키워드 반환타입 함수명 ( 타입 매개변수 , 타입 매개변수2 ){	return 반환데이터; }
		//접근제한자 : public , private ,  default[클래스에선 생략] , protected
		//키워드[생략가능] : static[정적] , final[외부에서오버라이드불가능]
		//반환타입 : return 할 데이터의 타입
		//함수명 : 카멜표기법
	 	//매개변수 : 타입에 맞춰서 선언
	public static void printLength(String data) {
		try { //*예외 발생할 것 같은 코드를 try{}안에 넣기
			int result = data.length(); // 문자열 길이 : 문자열.length(); 예외발생하면 실행안함/ 예외없으면 실행
			System.out.println("문자 수 : " + result);
		}
		catch ( NullPointerException e ) {
			//* 만약에 try{}안에서 예외가 발생했을때 실행되는 catch{}코드
				// - 만일 try{} 안에서 예외가 발생하지 않으면 catch{} 실행안됨.
				// e : 예외객체명[객체명은 아무거나] 객체안에는 예외정보가 담겨져ㄴㄴ있음.
			System.out.println(e.getMessage());
		}
		finally { // * 예외가 있던말던 실행되는 코드
			System.out.println("마무리 실행");
		}
	}
	
	// main함수 선언 : main스레드가 포함된 함수 -> 스레드 : 코드를 읽어주는 흐름 단위 [ 지금은 단일 스레드 ]
	public static void main(String[] args) { // 메인함수에서 사용가능한것 :  static , 싱글톤 , 객체생성
		
		System.out.println("프로그램시작");
		printLength("ThisIsJava");
		printLength(null);		// NullPonterException : 데이터가 null이라서 length()함수 사용불가.
		System.out.println("프로그램 종료");
		
	}
	
	
	
	/*
	
		에러 : 컴퓨터하드웨어의 고장으로 인해 응용프로그램 실행 오류 발생
		예외 : 에러를 제외한 나머지 예외라는 오류 , 웹은예외처리자동
			* 잘못된 사용[사용자] 또는 잘못된코딩[개발자]으로 인해 발생
			* 잘못된 사용 : 사용자가 비정상적인 행동했을 때 ( 코드엔 문제없음 ) -> 많은경험으로 예상가능
			
				1. 일반 예외 : 컴파일전에 발생할 수 있는 예외 검사 [*스트림(자바와 외부통신)] ex)파일처리했을때 
				2. 실행 예외 : 컴파일후에 발생하는 예외. -> 경험
				
		예외클래스
			Exception 클래스 : 모든 예외를 받을 수 있는 예외중에 최상위 클래스
			
		문법
			try{
				1. 예외가 발생할 것 같은 코드 [	경험	]
			}
			catch( 예외클래스 e ){ // 예외발생해야 실행
				2. try{} 에서 예외가 발생했을때 실행되는 코드 [ 만일 예외 발생했을 때 이후 실행코드 ]
			}
			finally{ // 무조건 실행
				3. 예외가 있던말던 실행되는 코드 [ *생략가능 ]
			}
			
	
	*/
}
