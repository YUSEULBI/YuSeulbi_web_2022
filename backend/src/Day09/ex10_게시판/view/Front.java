package Day09.ex10_게시판.view;

import java.util.Scanner;

public class Front {

	// 싱글톤 객체 [ 1. 프로그램내 하나의 객체 - 공유 메모리 ]
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	// 필드 : 입력 객체
	private Scanner scanner = new Scanner(System.in);
	
	// 2. index 함수
	public void index() {
		while ( true ) {
			System.out.println(" 1. 쓰기 : ");
			int ch = scanner.nextInt(); //지역변수
			if ( ch == 1 ) { write_page();	}
		}
		
	} // index end ////////////////////////////////////////
	
	
	
	// 3. 쓰기 페이지 함수
	private void write_page() { // 보호
		System.out.println("---------- 글쓰기페이지 -----------");
	} // write end ////////////////////////////////////////
	
	
	
	// 4. 출력 페이지 함수
	private void print_page() {
		
		
	} // print end ////////////////////////////////////////
	
	
	
	
}




/*

ex10_게시판 패키지
	controller 패키지
		Bcontroller.java
	model 패키지
		Board.java
	view 패키지
		Front.java
	Strat.java

	
	
	1. start[main함수] 클래스가 Front 클래스를 호출
	2. front 클래스 사용자로부터 입출력받기
	3. Bcontroller 클래스에서 Front로부터 전달받은 데이터 처리/로직
	4. Board 클래스에서 게시물의 모델링 


*/