package Day15.Ex7_p524;

import java.util.ArrayList;

public class 포장클래스 {
	
	public static void main(String[] args) {
		
		// 1. 특정 API[컬렉션]는 객체만 지원
		//ArrayList<int> list = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		// 2. 자료형에 대한 메소드 제공
		//int a = 10;		System.out.println( a ); 			[x]
		Integer b = 10; System.out.println( b.toString() ); //[o] // 다양한 기능을 쓸 수 있음.
		
		
		// p.526
		Integer obj = 100; //박싱 : 기본자료형을 객체화
		System.out.println(obj.intValue());
		
		
		//언박싱
		int value = obj;	// 언박싱 : 객체 --> 기본자료형
		System.out.println( value );
		
		// 연산시 자동 언박싱 후 연산 ( 알아서 Integer -> int )
		int result = obj + 10; System.out.println( result );
		
	}
	
}


/*
	
	1. 특정 API[컬렉션]는 객체만 지원
	2. 자료형에 대한 메소드 제공
	




 */
