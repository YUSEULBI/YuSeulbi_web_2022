package Day09.Ex4_p239;

/*
	오버라이딩 : 이미 존재하는 메소드를 재정의[리모델링]
	vs
	오버로딩 : 생성자와 메소드에서 사용
		이름은 같지만 매개변수의 타입 , 개수 , 순서가 다른 메소드를 여러개 선언

*/


public class Calculator {
	
	// 1. 정사각형 넓이 구하는 함수
	double areaRectangle( double width ) {
		
		return width*width;
	}
	
	// 2. 직사각형의 넓이를 구하는 함수
	double areaRectangle( double width , double height ) {
		
		return width*height;
	}
}
