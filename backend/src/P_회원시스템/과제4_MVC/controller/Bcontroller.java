package P_회원시스템.과제4_MVC.controller;

import java.util.ArrayList;

import P_회원시스템.과제4_MVC.model.Board;

public class Bcontroller {
	

	
	
	
	// 리스트 생성
	ArrayList<Board> boardList = new ArrayList<>(); 
	
	// BoarderList에 Board 인스턴스 추가해주는 함수 // 글추가
	public int addBoardList ( String title , String writer , String content ) {
		
		// 매개변수 board클래스 인스턴스 멤버에 담기
		Board board = new Board(title, writer, content);
		boardList.add(board);
		
		return 0;
	}
	
}
