package Day02;

public class Ex3_연산자 {  // c s
	
	public static void main(String[] args) { // main s
		
		// 1. 부호/증감연산자 [ p.78 ]
		
		int x = +10;
		int y = -10;
		
		System.out.println(" x : " + x);
		System.out.println(" y : " + y);
		
		System.out.println(" x++ : " + (x++)); // 후위증가 ;기준으로 바뀜
		System.out.println(" x : " + x); // 11
		System.out.println("++x : " + (++x));
		
		System.out.println( "y-- : " + (y--) ); //-10
		System.out.println(" y : " + y ); 		//-11
		System.out.println(" --y : " + (--y) ); //-12
		
		
		// 2. 산술연산자 [ p.81]
		System.out.println(" x+y : " + (x+y) ); // 12 + -12 
		System.out.println(" x-y : " + (x-y) ); // 12 - -12 = 24
		System.out.println(" x*y : " + (x*y) ); // -144
		
		System.out.println(" 5/3 : " + (5/3) ); // 소수점 안나오고 int 정수형으로
		// ( int / int ) -> 소수점 없이 몫만 나옴
		
		System.out.println(" 5%3 :" + (5%3) ); // 나머지
		
		
		// 3. 비교연산자 [ p89]
		System.out.println(" x==y : "+ (x==y) ); // + 12 == -12 false
		System.out.println(" x!=y : "+ (x!=y) ); // + 12 != -12 true 
		System.out.println(" x > y : "+ (x > y) ); // +12 > -12 true
		System.out.println(" x >= y : "+ (x >= y) ); // +12 >= -12 true
		System.out.println(" x < y : "+ (x < y) ); // +12 < -12 false
		System.out.println(" x <= y : "+ (x <= y) ); // +12 <= -12 false
		
		System.out.println("str1.equals(str2) : " + ( "유재석".equals("유재석") ) );
		System.out.println(" ! str1.equals(str2) : " + ( !"유재석".equals("유재석") ) );
		
		
		// 4. 논리연산자 [ p.91 ]
		System.out.println(" x > 3 && x < 20 " + (x > 3 && x < 20));
		System.out.println(" x > 5 && x < 10 " + (x > 5 && x < 10)); // true && flase -> false
		System.out.println(" x <= 0 || x>=20 " + (x <= 0 || x>=20)); // false || false
		System.out.println(" x <= 0 || x>=10 " + (x <= 0 || x>=10)); // false || true -> true
		System.out.println(" !(x == y) " + (!(x == y)) ); // 부정연산자
		
		// 5. 대입연산자 [p.102]
		int z = 30;
		z += x;	// 30 += 12  [1] 30+12 = 42연산 후에   [2] z에 42를 대입
		System.out.println(" z+=x : " + z);
		z -= x;
		z *= x;
		z /= x;
		z %= x;
		
		
		// 6. 삼항연산자 [p.103]	조건 ? 참 : 거짓
		String 결과 = (x >= 20)  ?  "합격" : "불합격"; System.out.println(결과);
		
		// 7. 연결연산자
		System.out.println( "문자열A"+"문자열B");
		String 연결문자1 = "유재석"+"10"; // 문자열 + 문자열 = 문자열 "유재석10"
		String 연결문자2 = "유재석"+10; // 문자열 + 숫자열 = 문자열 "유재석10"
		
		String 연결문자3 = "유재석"+10+20; System.out.println(연결문자3); 
		//문자열+숫자열+숫자열 = 문자열 , 연산이 안됨
		
		String 연결문자31 = "유재석"+(10+20); System.out.println(연결문자31);
		//문자열과 합해지전에 숫자열 먼저 계산
		
		
		
		
		
		
	}
	
} // c e
