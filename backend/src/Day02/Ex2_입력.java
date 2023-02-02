package Day02;

import java.util.Scanner; // Scanner클래스 사용 위한 Scanner클래스 import

public class Ex2_입력 { // c s
	
	public static void main(String[] args) {
		// 1. [p70] 입력
			// scan + 자동완성
			// 객체 생성 : 클래스명 객체명 = new 생성자명( 인수 );
			// 입력 객체 : Scanner 객체명영문소문자 = new Scanner( System.in );
				// { } 안에서 1번만 선언
		
		
		
		// scanner 객체에 저장 -> 변수 = next 변수에 저장 -> syso 콘솔에 변수 출력
		// 입력값을 객체에 저장하고 > 객체에 저장된 값을 변수에 저장하고 -> 변수에 저장된 값을 콘솔 출력
		// 입력값을 새로 입력하면 객체는 새로운 입력값으로 덮어씌워져 기존 입력값이 사라진다.
		
		// 1.입력객체 
		Scanner scanner = new Scanner( System.in ); // 입력받은 값을 객체에 저장
		// 2. 입력메소드 -> 변수에 저장 [ 자료형 맞추기 ]
			String 문자열1 = scanner.next(); // 1. 문자열[띄어쓰기 불가능] 입력받는 함수
			System.out.println("문자열1 : " + 문자열1);
			scanner.nextLine(); // ★★★해결방안
			String 문자열2 = scanner.nextLine(); // 2. 문자열[띄어쓰기 가능] 입력받기 함수
			System.out.println("문자열2 : " + 문자열2); 
			// ★★★문제점: nextline은 앞에 next와 하나로 취급됨. 입력 안받고 넘어가짐.
			// ★★★해결방안 : 앞에 .nextLine() 작성
			
			boolean 논리 = scanner.nextBoolean();  // 논리 입력받기
			System.out.println( "논리 : " + 논리);
			
			char 문자 = scanner.next().charAt(0); // 한글자 입력받기 함수 .charAt(인덱스) 인덱스=0이면 한글자
			System.out.println("문자 : "+ 문자);
			
			//정수형
			byte 바이트 = scanner.nextByte(); // 정수형 입력받기
			System.out.println( "바이트 : " +바이트);
			short 쇼트 = scanner.nextShort(); // 정수형 입력받기
			System.out.println( "쇼트 : " +쇼트);
			int 인트 = scanner.nextInt(); 	// 정수형으로 입력받기
			System.out.println( "인트 : " +인트);
			long 롱 = scanner.nextLong(); // 정수형 입력받기
			System.out.println( "롱 : " +롱);
			
			//실수형
			float 플롯 = scanner.nextFloat(); // 실수형 입력받기
			System.out.println("플롯 : " + 플롯 );
			double 더블 = scanner.nextDouble();
			System.out.println("더블 : " + 더블 );
			
			
			
			// 기본자료형 비교 [ 비교 연산자 가능 == ]
			int 비밀번호 = 1234;
				System.out.println( 비밀번호 == 1234 ); // true
				
			// 문자열 비교 [String 객체] 비교 
				// [ 객체는 비교 연산자 불가능 --> 객체를비교할땐 --> 문자열A.equals("문자열B") ]
			String 아이디 = "qwe"; // String 객체 연산자 불가능
				System.out.println( 아이디.equals("qwe") ); // false

	}
	
} // c e


/*
 			import		JRE System Library
System		X			jave.lang은 패키지명 import 안함
String		x			jave.lang은 패키지명 import 안함
Scanner		import java.util.Scanner;	***자동입력으로 클래스를 import 시켜야함

						java.base 는 외우는게 좋음
						
						
						

	스트림 stream
	
	모니터[출력  <-------바이트---------
								본체 [cpu : java명령어]
	키보드[입력] -------바이트--------->

*/

