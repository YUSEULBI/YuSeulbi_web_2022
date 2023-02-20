package Day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_p468 {
	
	public static void main(String[] args) {
		
		// 1. Class.forName("패키지명.클래스") 해당클래스가 있는지 찾아줌
			//일반예외 : 컴파일전에 예외 확인
		try {
			Class.forName("java.lang.String"); // 클래스 여부 찾기 --> 실행결과 아무일 없음 , 클래스가 존재함
		}
		catch( ClassNotFoundException e ) {
			e.printStackTrace(); // 예외정보출력
		}
		//
		System.out.println();
		
		try {
			Class.forName("java.lang.String2");
			System.out.println("java.lang.String2 클래스 존재안함");
		}
		catch( ClassNotFoundException e ){
			e.printStackTrace();
			System.out.println("클래스가없음: "+e);
		}
		
		//2. 다중catch
			// 배열 : 타입[] 배열명 = { 데이터 , 데이터 , 데이터 } 
		String[] array = {"100" , "1oo"};
			// 배열 for : 인덱스는 0부터 , 길이는 1부터
		for ( int i = 0 ; i <= array.length ; i++ ) { //length는 2
			try {
				int value = Integer.parseInt( array[i]); 
				//Integer.parseInt( 문자열 ) - > 정수형으로 바꿔줌
				//예외발생 : "100" ->가능 // "1oo" 문자라서 숫자로 못바꿈 불가능/
				System.out.println("array["+i+"] "+value);
			
			}
			catch(NumberFormatException e ) {
				System.out.println("숫자로 변환할수 없음 : " + e);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스초과 : "+e);
			}
			catch ( Exception e ) { // 자식클래스보다 위에두면 슈퍼클래스 Exception 가 예외처리 다 가져감 -> 오류발생
				// exception 예외클래스중에서 최상클래스임. 가장 아래에 작성해야 오류없음.
				System.out.println("예외발생 : " + e);
			}
				
		}
		
		
		// 3. InputMismatchException /////////////////////////////////
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				int cn = scanner.nextInt();
			}
			catch( InputMismatchException e ) { // exception 도 가능 (다중처리에는 주의)
				System.out.println("잘못된 입력 입니다.");
			}
		}
		
		
		
		
		
		
	}
	
}
