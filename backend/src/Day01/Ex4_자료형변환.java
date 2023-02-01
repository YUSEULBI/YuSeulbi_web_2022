package Day01;

public class Ex4_자료형변환 {
	
	public static void main(String[] args) {//main s
		
		// 1. [ 54.p ]
		byte b1 = 10;		int il = b1 ; 	// byte --> int 가능
		char c1 = '가'; 		int i1 = c1 ; 	// char --> int 가능 , 자동타입변환!
		int i2 = 50; 		long l1 = i2 ; 	// int --> long 가능
		long l2 = 100; 		float f1 = l2 ; // long --> float 가능
		float f2 = 100.5f;	double d1 = f2; // float --> double 가능
		
		// 2. [ p 58]
		int i3 = 10;	byte b2 = (byte)i3; // int -> byte 불가능 , 강제로 타입을 변환시킴->데이터손실이 없도록
		System.out.println(b2);
		
		long l3 = 300; 		int i4 = (int)l3; 		// long -> int 불가능 강제변환해야함
		int i5 = 65;		char c2 = (char)i5;		// int -> char 불가능 강제변환
		double d2 = 3.14;	int i6 = (int)d2;		// double -> int 불가능 강제변환 , 데이터 손실 발생 소수점 잘림
		System.out.println( i6 ); // 데이터 손실 발생 소수점 잘림
		
		// 3. [ p. 58~64 ] 읽어보기
		
		// 4. 문자열 타입 변환 [ p.65 ] !!!!!!
		String str1 = "10";	// 10 vs "10" 다름  int 와 String 임
		int 정수1 = Byte.parseByte(str1);			// String --> byte
		short 쇼트1 = Short.parseShort(str1); 	// String --> short 	
		int 인트1 = Integer.parseInt(str1);		// String --> int
		long 롱1 = Long.parseLong(str1);			// String --> long
		float 플롯1 = Float.parseFloat(str1);		// String --> float
		double 더블1 = Double.parseDouble(str1); // String --> double
			// "10" : 문자열 타입의 숫자10을 --> 10 : 정수형 타입의 숫자10으로 변경 가능
			// "ABC" : 문자열타입의 문자ABC --> X 불가능
		
		String str2 = "안녕"; //
		// int 인트2 = Integer.parseInt(str2); System.out.println(인트2); // 진짜 문자는 숫자로 바꿀 수 없음
		
		// int 인트3 = (Integer)str1;	// String --> 강제 Int 변경 불가능
		
		
		
	}//main e
	
}


/*
	자료형/타입 변환
		-용량크기 순서
		byte[1] < short[2] , char[2] < int[4] < long[8] < float[4] 소수점때문에 float이 더큼 < double[8]
		
		1. 자동 타입 변환
			- 작은 타입 --> 큰 타입 자동
			큰 허용범위 타입 = 작은 허용범위 타입
			
		2. 강제 타입 변환 [ 캐스팅 ]
			- 손실이 있더라도 강제로 변환
			작은허용범위타입 = (새로운타입)변환할데이터
			
	 	3. 연산시 타입 자동타입 변환
	 		- 피연산자중 큰 타입을 결과 반환
			1. 정수
				1. int 보다 작은 byte , shot 연ㅇ산시 무조건 int 결과
					byte + byte -> int
					short + int -> int
					
				2. long 연산시
					int + long -> long
					
			2. 실수
				float + float -> float
				float + double -> double
					
		4. 문자열 타입변환 !!!
			Byte.parse
		
*/