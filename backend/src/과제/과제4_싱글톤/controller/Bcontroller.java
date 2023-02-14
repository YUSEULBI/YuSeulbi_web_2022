package 과제.과제4_싱글톤.controller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Board;

public class Bcontroller {
	
	// Board클래스타입 ArrayList 객체 새로 생성 // private 동일클래스 외에 접근 막음.
	private ArrayList<Board> boardDB = new ArrayList<>();
	
	// 1. 글쓰기 처리 // 인수 : 제목,내용 / 반환 : true,false
	public boolean write( String title , String content ) {
		// 1. 유효성검사 [ 로그인했는지 검사 / 로그인 안되어있으면 false ]
		if ( Mcontroller.getInstance().getLogSession() == null ) {
			return false; // 로그인을 안했으므로 false
		}
		// 2. DB저장
			// 1. 객체화 [ 글작성 : 입력받은데이터 2개와 초기값0 , 로그인한객체주소 ]
			Board board = new Board(title, content, 0, Mcontroller.getInstance().getLogSession() );
			// 2. DB에 저장
			boardDB.add(board);
			// 3.  멤버 객체에 내가 쓴글 객체주소 등록
			Mcontroller.getInstance().getLogSession().getBoardlist().add(board);
		
		return true; // 로그인 되어있음
	}
	
	// 2. 글출력
	public ArrayList<Board> getList(){
		// 추후에 검색처리 , 페이징처리 등등 로직이 들어갈 예정
		return boardDB;
	}
	
	// 3. 글상세
	public Board getBoard(int bno) {
		return boardDB.get(bno);  // 인수로 전달받은 인덱스[게시물번호]의 게시물을 반환
	}
	
	// 4. 글삭제
	public boolean delete( int bno ) {
		boardDB.remove(bno);
		return true;
	}
	
	// 5. 글수정
	public boolean update ( int bno , String title , String content ) {
		// set 저장역할
		boardDB.get(bno).setTitle(title); //인수로 전달받은 인덱스 [ 게시물번호 ] 의 게시물 '제목' 수정
		boardDB.get(bno).setContent(content); //인수로 전달받은 인덱스 [ 게시물번호 ] 의 게시물 '내용' 수정
		return true;
	}
}
