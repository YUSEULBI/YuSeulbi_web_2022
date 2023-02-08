package Day06;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex3_문자열2 {
	
	public static void main(String[] args) throws Exception { // throws 던지기
		
		while ( true ) { // 무한반복
			
		
		// 1. 문자열 입력
		// 스택						힙
		Scanner scanner = new Scanner(System.in); 	// 1. 입력객체
		//System.out.print("문자열 입력해주세요 : ");		 
		String input = scanner.nextLine()+"\n";			// 2. 입력객체가 제공하는 메소드 , 입력받은 문자열을 변수에 저장
		// next 띄어쓰기 안됨 / nextLine - 띄어쓰기됨 엔터안됨
		//System.out.println(input);					
		
		// 주기억장치 -> 보조기억장치 파일처리(log기록) 파일처리는 싱글게임 가능..!!!!!!! 웹개발은 DB써야한다ㅏㅏㅏㅏ
		// 2. 문자열 파일에 저장 [ 자바외 키보드/파일/네트워크 등등 통신할 때 무조건 바이트단위 ]
			// .FileOutputStream 파일 쓰기 클래스 FileOutputStream
			// FileOutputStream( "파일경로") : 파일 새로 쓰기
			// FileOutputStream( "파일경로" , true ) : 파일 이어쓰기
			// .write( 바이트배열 ) :
		// 문자열.getBytes() : 해당 문자열을 바이트배열 반환
		FileOutputStream fout = new FileOutputStream("c:/java/test.txt" , true);
		fout.write( input.getBytes() );
		
		}
	}
	
}
