package Day15.Ex5_p516;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Properties;

public class System클래스 {
	

	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// p.517
		// 반복문 돌리기 전 나노초를 재고
		// 반복문을 돌린 후에 나노초를 재서
		// 돌린후시간 - 돌리기전시간 = 반복문을 돌리는데 소요된 시간
		
		long time1 = System.nanoTime(); // 현재시간을 나노초로 표현
		System.out.println( time1 ); //나노초가 출력됨.
		
		int sum = 0;
		for ( int i = 1 ; i<=1000000 ; i++ ) { //CPU마다 걸리는 시간 다름
			sum += i;		//i를 sum에 누적더하기 누적합계
			
		}
		long time2 = System.nanoTime();	//현재시간 나노초로 표현
		System.out.println( (time2-time1) + "나노초가 소요 되었습니다.");
		
		// p.518 Properties는 경로찾을 때  , 비트 , 자바버전 등등~~
		System.out.println("-----------------------------------");
		System.out.println("key   :         value ");
		Properties props = System.getProperties(); // 모든 시스템 속성 호출
		
		//-------------------------------------------------------------
		for( Object obj : props.keySet() ) { //시스템 속성들의 키를 반복문 돌림
			//System.out.println((String)obj); //java Properties에 저장된key출력
			System.out.println((String)obj + "						"+ // 해당 키를 문자열 반환
								System.getProperty((String)obj));		// 해당 키를 이용한 시스템 속성 정보 출력
		}
		
		
		// p.520
		//인코딩 : 문자 코드를 전산기기 안에서 0, 1로 저장하는 방식.
		
		
		String data = "자바"; // 문자열 저장 조작
		
		// 해당 문자열을 바이트로 변환 *********************
		// 이클립스 설정을 UTP-8로 해놓음. 한글 1글자가 3바이트 - > 자바 6바이트
		// 인코딩타입 : UTF-8 [한글3바이트]
		// String data = "자바" 를 UTF-8버전으로 인코딩 = data.getBytes();
		byte[] arr1 = data.getBytes(); //****************  
		
		System.out.println(arr1); // 배열의 주소값
		
		// 배열내 데이터 출력 Arrrays.toString(배열명)
		//[-20, -98, -112, -21, -80, -108]
		System.out.println(Arrays.toString(arr1)); // 자>> [-20, -98, -112,///// 바>> -21, -80, -108] 
		
		
		// 문자열 -> 바이트열 getBytes()
		// String data = "자바"를 EUC-KR버전으로 인코딩 = data.getBytes("EUC-KR");
		byte[] arr2 = data.getBytes("EUC-KR"); //예외처리 던지기함. // 인코딩타입 : EUC-KR [한글2바이트]  자>>[-64, -38,///바>> -71, -39]
		System.out.println(Arrays.toString(arr2));
		
		// 바이트열 -> 문자열 new String(배열명)  *********************
		String str1 = new String( arr1 ); //*******************
		System.out.println( str1 );
		
		//
		String str2 = new String ( arr2 , "EUC-KR");
		System.out.println(str2);
	}
	
}

/*

	밀리초 -> 								1/1,000
		마이크로초 -> 						1/1,000,000
			나노초 -> 						1/1,000,000,000 // 10억분의 1초
				피코초 -> 					1/1,000,000,000,000
					펨토초 -> 				1/1,000,000,000,000,000
						아토초 -> 			1/1,000,000,000,000,000,000
							젭토초 ->		1/1,000,000,000,000,000,000,000 
								욕토초		1/1,000,000,000,000,000,000,000,000
	

*/