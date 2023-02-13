package Day09.ex10_게시판.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.ex10_게시판.controller.Bcontroller;
import Day09.ex10_게시판.model.Board;

public class Front {

	// 싱글톤 객체 [ 1. 프로그램내 하나의 객체 - 공유 메모리 ]
	// Front클래스 객체 생성
	// 생성한 Front클래스 접근금지 -> 객체 필드값 변경불가 , 공유가능(메소드영역 저장)
	private static Front front = new Front();
	// 생성자 접근금지 -> 객체 생성 불가
	private Front() {}
	// 접근가능 , 공유가능 함수 만들기 
	public static Front getInstance() {
		return front;
	}
	
	// 필드 : 입력 객체
	private Scanner scanner = new Scanner(System.in); // 인스턴스 멤버
	
	// 2. index 함수
	public void index() {
		while ( true ) {
			print_page();
			System.out.println("메뉴선택>>  1.쓰기 2.상세 : ");
			int ch = scanner.nextInt(); //지역변수
			if ( ch == 1 ) { write_page();	}
			else if ( ch == 2 ) { view_page(); }
		}
		
	} // index end ////////////////////////////////////////
	
	
	
	// 3. 쓰기 페이지 함수
	private void write_page() { // 보호 // 인스턴스멤버
		// 입력받기
		System.out.println("---------- 글쓰기페이지 -----------");
		System.out.println(" 제목 : ");
		String title = scanner.next();
		System.out.println(" 내용 : ");
		String content = scanner.next();
		System.out.println(" 작성자 : ");
		String writer = scanner.next();
		System.out.println(" 비밀번호 : ");
		String password = scanner.next();
		Date date = new Date(); // 현재 날짜 구해줌 // 사용하는 클래스마다 import해줘야함.
		System.out.println( date );
		int view = 0 ;
		
		// write 함수에 인수전달 후 결과를 result에 저장
		boolean result =
		// Bcontroller 함수 가져와서 인수 전달
		Bcontroller.getInstance().write(title, content, writer, password, date, view);
		
		// result 결과에 따른 안내
		if ( result ) {
			System.out.println("[알림]글쓰기 성공");
		}else {
			System.out.println("[알림]글쓰기 실패");
		} // if end
		
	} // write end ////////////////////////////////////////
	
	
	
	// 4. 출력 페이지 함수
	private void print_page() {
		System.out.println("----------- 글목록 -----------");
		
		ArrayList<Board> result = Bcontroller.getInstance().print();
		System.out.println("번호\t제목\t작성자\t조회수\t작성일");
		// 반환된 리스트객체 처음부터 마지막까지 반복처리
		for ( int i = 0 ; i < result.size() ; i++ ) {
			// 출력 반복
			System.out.println( i +"\t"+ result.get(i).toString());
		}
	} // print end ////////////////////////////////////////
	
	// 5. 상세페이지 함수
	private void  view_page() {
		System.out.println("게시물번호 : ");
		// 2. 입력받은 게시물번호의 게시물정보를 컨트롤에게 요청 [ bno 넘겨주고 ]
		int bno = scanner.nextInt();
		Board result = Bcontroller.getInstance().view(bno);
		System.out.println("------------ 게시물상세 "+bno+" ------------");
		System.out.println( " 제목 : " + result.getTitle()  );
		System.out.println( " 작성일 : " + result.getDate());
		System.out.println( " 조회수 : " + result.getView()+"\t"+ " 작성자 : " + result.getWriter());
		System.out.println( " 내용 : " + result.getContent());
		System.out.println(">> 1. 뒤로가기 2. 삭제 3. 수정 : ");
		int ch = scanner.nextInt();
		if (  ch  == 1 ) { return;	}
		else if (  ch == 2 ) {	}
		else if ( ch == 3 ) {	}
		
	}
	
	

	
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