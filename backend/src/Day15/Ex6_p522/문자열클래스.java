package Day15.Ex6_p522;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열클래스 {
	
	public static void main(String[] args) {
		
		// p. 522
		
		// String vs StringBuilder();
		String data = "ABC"; 
			System.out.println(data.hashCode()); // 64578
		//새로운 참조할당
		data += "DEF"; // 변경된게 아니라 "ABCDEF" 객체를 새로 만든것 [효율성떨어짐] // 1923910755
			System.out.println(data.hashCode());
		
		String data2 = new StringBuilder()
				.append("DEF") 		// 문자열 끝에 추가
				.insert(0, "ABC")	// 해당 인덱스 위치에 추가
				.delete(3, 4)		// 해당 인덱스 삭제
				.toString();		// 완성된 문자열을 리턴
		
		System.out.println(data2);
		
		StringBuilder data3 = new StringBuilder();
			System.out.println(data3.hashCode()); // 주소값일치
			data3.append("ABC");
			System.out.println(data3.hashCode()); // 주소값일치
			data3.append("DEF");
			System.out.println(data3.hashCode()); // 주소값일치
		
		System.out.println( data3 );
		
		
		// p.524
		
		String data4 = "홍길동&이수홍-박연수";
		String[] arr = data4.split("&|-"); // split은 String배열로 반환 / & 이거나 - 이면 split
		
		//배열 데이터를 출력
		System.out.println( Arrays.toString(arr));
		
		String data5 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data5,"/");
		
		System.out.println( "조각수 : "+st.countTokens() );
		
		for ( int i = 1 ; i <= 3 ; i++ ) {
			System.out.println(st.nextToken());
		}
		
		
		
	} // main end
	
	
}
