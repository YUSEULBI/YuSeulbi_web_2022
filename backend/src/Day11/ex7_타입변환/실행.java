package Day11.ex7_타입변환;

import java.util.ArrayList;

public class 실행 {

	public static void main(String[] args) {
		
		byte value = 10; //byte10
			short value2 = value; // byte10 -> short10
				int value3 = value2; // short10 -> int 10
					long value4 = value3; // int10 -> long10
						float value5 = value4; // long10 -> float10
							double calue5 = value5; // float 10 -> double 10
							
		// 강제타입변환 캐스팅( )
		double value7 = 10.11111;
			float value8 = (float)value7; // double 10.11111 -> float 10.11111
				long value9 = (long)value8; // float 10.11111 -> long 10
					int value10 = (int)value9; // long 10 -> int 10
						short value11 = (short)value10; // int 10 -> short 10
							byte value12 = (byte)value11; // short 10 -> byte 10
							
		
		// 3. 매개변수 , 리턴타입
		double result = 함수1(value); // 
		byte result2 = 함수2( (byte)value3 );
		
		
		// 4. 배열 , ArrayList
				double[] 배열 = new double[3];
				배열[0] = 3.3;  배열[1] = 3;
			// 
		
	} // main end
	
	
	
	
	public static int 함수1 ( double 매개변수 ) { // double모든 기본자료형 받음
		return 3;}
			
	public static byte 함수2 ( byte 매개변수 ) { return 3; }	
		
		
	
}
/* 타입종류
1. 기본타입	- 스택저장
	boolean char byte short int long float double
	
2. 참조타입	- 힙 저장 -> 힙주소 스택에 저장
	배열 , 클래스 , 인터페이스 , 스트링 , 

타입 변환
	1. 자동타입 변환
	
	2. 강제타입 변환
*/