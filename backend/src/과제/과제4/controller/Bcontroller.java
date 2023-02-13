package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;
import 과제.과제4.model.Member;

public class Bcontroller { // 처리제어담당
	
	// 1.필드
	ArrayList<Board> boardList = new ArrayList<>();
	
	
	// 2.생성자
		//빈생성자
		public Bcontroller() {	}
	
	// 3.메소드
		
		// 입력값을 보드리스트DB에 저장하는 함수 ///////////////
		// 인수: title , content , 회원인덱스 / 반환 없음.
		public void writeSave( String title , String content , String id ) {
			
			// Board클래스 객체 생성 ( 제목 , 작성자 , 내용 )
			Board board = new Board(title, id, content); 
			
			// BoardList에 저장
			boardList.add(board);
						
			
		};
		
		// 글목록에 필요한 데이터 반환시켜주는 함수 ///////////////
		//보드리스트 반환 함수
		public ArrayList<Board> listNum( ){ 
			return boardList;
		}
		
		
		// 선택한 인덱스 글 삭제 해주는 함수   ///////////////
		// 인수 : 삭제할글인덱스 , 현재로그인id
		public int deleteBoard( int dNum , String id ) {
			// 글의 작성자와 , 현재 로그인한 작성자가 같으면 삭제
			if ( boardList.get(dNum).writer == id ) {
				boardList.remove(dNum);
				return 0; // 삭제성공
			}
			
			return 1; // 삭제실패
		}
		
		
		
		// 선택한 글 작성자와 로그인아이디 같은지 판단해주는 함수   ///////////////
			// 인수 : 선택한글인덱스 , 현재로그인id
			public int checkId( int dNum , String id ) {
				// 글의 작성자와 , 현재 로그인한 작성자가 같으면 삭제
				if ( boardList.get(dNum).writer == id ) {
					return 0; // 아이디가 같음
				}
				return 1; // 아이디가 다름
			}
			
			
	
		// 글 수정함수 (인수 : 선택한 글 인덱스 , 수정내용 )
			public void reWrite( int linum , String 수정내용) {
				
				boardList.get(linum).content = 수정내용;
				//
				
			}
		
			
		// 조회수 올리기 함수 ////////////////////
		 public void viewUp( int linum ) {
			 boardList.get(linum).view += 1;
			
		}
			
}
