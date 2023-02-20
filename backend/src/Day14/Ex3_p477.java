package Day14;

public class Ex3_p477 { // class s
	
	// 1.	
	public static void findClass() throws Exception { //예외던지기 -> 호출한곳으로 던지기
		Class.forName("java.lang.String2"); //일반예외 실행전 미리 알려줌.
	}
	
	public static void main(String[] args) throws Exception { //메인에서 던지면 자바클래스가 받음
		
		try {
			findClass();
		}
		catch ( Exception e ) {
			
		}
		System.out.println("확인");
		

		
	}
	
	
} // class e


/*

	예외 떠넘기기
		- 메소드 내부에서 예외발생했을때 메소드 호출했던 곳으로 예외를 넘기기
		- throws
		- 메소드 마다 예외처리를 하면 코드가 많아 지저분함 -> 이동후 한곳에서 처리(보통 view(Front)쪽에서 한번에 처리)

*/