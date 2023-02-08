package Day06;

public class Ex2_문자열 { // class s

	public static void main(String[] args) { // main s
		
		// 1. 자바 문자열을 사용하는 방법
				// 1. 배열 - 모든언어의 사용법 
		char[] 문자열1 = new char[] { '안','녕' }; // c언어 사용법 / char는 "안녕"안됨
				// 2. 클래스 [ 객체 ] 참조타입 힙에 메모리 저장
		String 문자열2 = new String( "안녕" );
				// 3. 문자리터럴 " " - 자동으로 힙에 메모리 저장 / 
		String 문자열3 = "안녕";
		
		//[p.156]
		
		
		String strVar1 = "홍길동"; // 주소같음
		String strVar2 = "홍길동"; // 주소같음
		
		// 주소비교
		if ( strVar1 == strVar2 ) {
			// 만약에 두 변수가 가지고 있는 주소가 같으면
			System.out.println("참조[주소]같음");
		} else {
			System.out.println("참조[주소]다름");
		}
		
		if ( strVar1.equals(strVar2)) {
			// 만약에 두 변수가 가지고 있는 주소의 데이터가 같으면
			System.out.println("참조[주소] 내부 값도 같음");
		}
		
		String strVar3 = new String("홍길동"); // 주소다름
		String strVar4 = new String("홍길동"); // 주소다름
		if (strVar3 == strVar4 ) {
			System.out.println("참조[주소]같음");
		} else {
			System.out.println("참조[주소]다름");
		}
		
		if ( strVar3.equals(strVar4)) {
			System.out.println("참조[주소] 내부 같음 ");
		}
		
		
		// p.157 null 과 "" 빈값의 차이 / Optional 나중에 설명
		String hobby = ""; // "" vs null
		if ( hobby.equals("")) {
			System.out.println(" \"\"의 객체");
			
		}
		String hobby2 = null;
		// if ( hobby2.equals(null) ) { System.out.println("null의객체데이터확인"); 	} 불가능
		if ( hobby2 == (null) ) { System.out.println("null 주소 확인 "); 	}
		
		// 문자열관련 api함수
		// [p158] 1. charAt(인덱스)
		String ssn = "9506241230123"; // 인덱스 0~부터 시작
		char sex = ssn.charAt(6); // ssn의 6번째 성별가져옴 
		System.out.println(sex);
		if ( sex == '1' || sex == '3' ) {System.out.println("남자");}
		else { System.out.println("여자"); }
		
		// [ p.159] 2. 문자열 길이 
		// 길이:13 , 인덱스: 0~12
		int length = ssn.length();
		if ( length == 13 ) {
			System.out.println("주민등록번호 자릿수 맞음");
		} else {
			System.out.println("주민등록번호 자릿수 다름");
		}
		
		// [ p.160 ] 3. replace("기존문자" , "새로운문자" ) //치환된 문자열 반환
		String oldstr = "자바 문자열 불변입니다. 자바 문자열은 String 입니다.";
		String newstr = oldstr.replace("자바","JAVA" ); // 변경된 문자열 반환 -> 꼭 변수 저장
		System.out.println(oldstr);
		System.out.println(newstr);
				
		
		
		
	} // main e
	
} // class e



/*
  ' ' : 문자 		char	기본타입
  " " : 문자열 	String	참조타입
  
 자바 문자열을 사용하는 방법
 	1. 배열 , 클래스 , 문자리터럴
 	2. 클래스
 			-new 연산자 [ 객체 메모리 생성 ==못씀 ]
 			String 문자열3 = new String("안녕")
 			String 문자열4 = new String("안녕")
 			문자열3과 문자열4는 주소가 다름
 			문자열3 == 문자열4		[ X ]
 			문자열3.equals(문자열4) [ o ]
 			
 			new 연산자 [ 객체 메모리 생성 ]
 			
 	2. 문자리터럴
 			- 문자리터럴이 동일한 경우 객체 공유 [ 주소 같다 == 사용가능 ]
 			String 문자열3 = "안녕";
 			String 문자열4 = "안녕";
 				문자열3 == 문자열4 		[ 가능 ]
 				문자열3.equals(문자열4) [ 가능 ]
 
 	== 스택영역의 주소 비교
 	.equals 힙영역의 데이터 비교 // 객체 비교 함수
 	
 	
 	자바 문자열의 함수들
 		.charAt(인덱스); 						: 인덱스 위치의 문자1개 추출
 		.length();							: 문자열의 길이
 		.replace("기존문자" , "새로운문자");		: 기존문자를 새로운문자로 치환(교체)
 		
 			.subString(인덱스); 				: 0 ~ 인덱스 자르기
 			.subString( 시작인덱스 , e덱스 );	: 시작인덱스부터 e인덱스까지 자르기
 			.split("자를 기준");					: 기준문자 기준으로 자르기
 			
 		.indexOf("찾을문자");					: 찾을문자의 인덱스 번호 반환
 		.contains("찾을문자");					: 찾을문자가 존재하면 true / 없으면 false
 
*/