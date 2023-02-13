package Day09.Ex6_p245;

public class 실행 {

	public static void main(String[] args) { // main s
		
		// 1. 인스턴스멤버 호출
			// 객체 생성 해야 -> 인스턴스멤버 호출 가능하다.
			Calculator mycal = new Calculator();
			System.out.println(mycal.no);
			mycal.no = 10;
			System.out.println(mycal.getNo());
		
		// 2. 정적멤버 호출 ( 객체생성X , 메모리 조심 )
			System.out.println( Calculator.pi );
			double result1 = 10*10*Calculator.pi;
			Calculator.plus(10, 5);
			Calculator.minus(10, 5);
			
			System.out.println( Calculator.info );
			
			
			
			
			
			
	} // main e
	
}
