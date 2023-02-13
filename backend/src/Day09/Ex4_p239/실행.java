package Day09.Ex4_p239;

public class 실행 {

	public static void main(String[] args) { // main s
		
		Calculator calculator = new Calculator();
		
		// 함수명은 같지만 매개변수가 달라서 식별가능하다~
		double result1 = calculator.areaRectangle(10);
		double result2 = calculator.areaRectangle(10, 20);
		
		System.out.println(result1);
		System.out.println(result2);
		
	} // main end
	
}
