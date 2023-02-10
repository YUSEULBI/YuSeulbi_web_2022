package Day08.Ex4_p230;

public class 실행 {
	
	public static void main(String[] args) { 
		
		// powerOn(); 메모리 할당전이라서 안됨
		
		// 1. 외부에서 함수 호출 -> 객체 필수
		Calculator myCalc = new Calculator();
		
		// 2. 객체를 통한 멤버 함수 호출
		myCalc.powerOn();
		
		// 3. 
		int result1 = myCalc.plus(5, 6);
		System.out.println( result1 );
		
		// 4.
		int x = 10;
		int y = 4;
		double result2 = myCalc.divide(x, y);
		System.out.println( result2);
		
		// 5.
		myCalc.powerOff();
		
		// 6.
		System.out.println( myCalc.info() );
	}
	
}
