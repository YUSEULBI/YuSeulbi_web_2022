package Day01;

public class Ex3_자료형 {
	
	public static void main(String[] args) {
		// 1. java 진수 표현
				int var1 = 0b1011; System.out.println("2진수 : " + var1 );
					// 1011 [2진수]  11
					// 8021 -> 11
					
					
				int var2 = 0206; System.out.println("8진수 : " + var2 );
					// 206 -> 134 ( 8진수 -> 10진수 )
					
				
					//2진수 연습
					// 110101  -> 2진수
					// 32+16+0+4+0+1 = 53 ( 2진수 -> 10진수 ) 
					
					// 2진수 -> 8진수 연습
					// 110 101 -> 2진수
					// 421 421 -> 2진수 쪼개기
					// 65 -> 8진수
					
					// 예제의 8진수 -> 2진수 -> 10진수 연습
					// 206 <-- 8진수
					// 010 000 110 <-- 2진수
					// 256+128+64+32+16+8+4+2+0
					// 0+128+0+0+0+0+4+2+0 = 134 <-- 10진수
					
				
				int var3 = 365; System.out.println("10진수 : "   + var3);
					// 365 -> 365
				int var4 = 0xB3; System.out.println("16진수 : " + var4 );
				
		// 2. 42p byte 자료형 [ -128 ~ 127 ]
			byte b1 = -128; System.out.println("byte자료형 : " + b1);
			byte b2 = 127; System.out.println("byte자료형 : " + b2);
			//byte b3 = 128;  // 오류발생 : 범위 벗어난 데이터
			
		// 3. short 자료형 [ +- 3만 2천 정도 ]
			short s1 = 32000; System.out.println("short 자료형 : " + s1 );
			//short s2 = 33000; 	// 오류발생 : 범위 벗어난 데이터
		
		// 4. int 자료형 [ +- 21억 정도 ]
			int i1 = 2000000000; System.out.println("int자료형 : " + i1 );
			// int i2 = 3000000000; 	// 오류발생 : 범위 벗어난 데이터
			
		// 5. [43p] long 자료형 [ +- 21억 이상 ]
			long l1 = 10; System.out.println("long자료형 : " + l1 );
			long l2 = 10000000000L;	// 오류발생 100억
					/* 정수 기본타입 : int 	변수에 저장되기 전 자료형 명시되지않은 데이터 */
					// 데이터 뒤에 L 붙이면 int -> long
					// 10000000000 --> int
					// 10000000000L --> long
		// 6. [43~44p] char 자료형 [ 각국 문자 0 ~ 65535 ]
			char c1 = 'A';  // 문자 ' ' // 문자열 " "
			System.out.println("char자료형 : " + c1 );
			
			char c2 = 65;  // 문자 ' ' // 문자열 " "
			System.out.println("char자료형 : " + c2 );
			
			char c3 = '가'; System.out.println( " 캐릭터자료형 : " + c3);
			char c4 = 44032; System.out.println( " 캐릭터자료형 : " + c4);
			
		// 7. String 클래스 [ 문자 여러개 ( 문자열 ) 저장할 수 있는 클래스 ] 2바이트*문자개수
			String str1 = "안녕하세요"; System.out.println("String클래스 : " + str1 );
			
		// 8. [ 47p ] float , double 자료형 
			float f1 = 0.123456789123456789F; // 데이터 뒤에 F
			System.out.println("float 자료형 : " + f1); // 유효 소수 이하 7자리까지 표현
			
			double d1 = 0.123456789123456789; System.out.println("double자료형 : " + d1); // 유효 소수 이하 15자리까지 표현
			// 소수점 데이터는 자료형 명시전에 모두 double
			
		// 9. [ 48p ] boolean 논리 [ true , false ]
			boolean bool1 = true; 	System.out.println("boolean 자료형 : " + bool1);
			//boolean bool2 = 1; // 오류발생 : true 혹은 false 만 저장 가능
			
			
	}
	
}


/*
 
	-용량 단위
		Bit 	: 0 또는 1 , 2가지수
		Byte 	: 8bit 01010101 2의 8승		: 용량의 최소단위  
		KByte 	: 1024byte
		MByte 	: 1024Kbyte
		GByte 	: 1024Gbyte
		
	- 최상위 bit -> 부호 역할 - +
			[최상위bit] 0101011
			0 : 정수
			1 : 음수
		
 	- 보수 설명 생략
 	
 	- 진수 : 컴퓨터의 표현단위
 		2진수		0 , 1				기계어/이진코드/bit  	0b
 		8진수 	0 ~ 7									0
 		10진수	0 ~ 9				사람
 		16진수 	0 ~ 9 A B C D E F	메모리 주소 체계 		0x
 		
*/

		