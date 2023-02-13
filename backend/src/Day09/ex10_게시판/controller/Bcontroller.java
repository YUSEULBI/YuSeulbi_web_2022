package Day09.ex10_게시판.controller;

import java.util.ArrayList;
import java.util.Date;

import Day09.ex10_게시판.model.Board;

public class Bcontroller {

	private ArrayList<Board> boardDb = new ArrayList<>();
	
	// 1. 싱글톤 객체
	// 클래스 접근금지(필드값변경불가) , 공유가능
	private static Bcontroller bc = new Bcontroller();
	// 생성자 접근금지 ( 객체 생성 불가 )
	private Bcontroller() {};
	public static Bcontroller getInstance() {
		return bc;
	}
	
	// 2. 쓰기 처리 함수
	public boolean write ( String title , String content , String writer , 
			String password , Date date , int view ) {
		
		// 유효성검사 생략
		// 리스트와 같은 객체화로 만들기 - board객체 만들기
		Board board = new Board(title, content, writer, password, date, view);
		// 리스트에 담기
		boardDb.add(board);
		
		return true; // 성공
	}
	
	// 3. 출력페이지 데이터 반환 함수
	public  ArrayList<Board> print() {
		// 유효성검사 생략
		return boardDb;
	}
	
	// 4. 특정 게시물 출력 처리 함수
	public Board view( int bno ) {
		// 조회수 올리기 // 객체명.set필드명 ( 객체명.get필드명()+1 );
		boardDb.get(bno).setView(boardDb.get(bno).getView()+1);
		return boardDb.get(bno);
	}
	
	
}
