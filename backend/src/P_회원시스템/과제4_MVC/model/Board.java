package P_회원시스템.과제4_MVC.model;

public class Board {
	
	// 1. 필드
	String title;
	String writer;
	int view = 0;
	String content;
	
	// 2. 생성자
		
		//빈생성자
		public Board() {	}

		//풀생성자
		public Board(String title, String writer, int view, String content) {
			super();
			this.title = title;
			this.writer = writer;
			this.view = view;
			this.content = content;
		}
		
		
		// 인수 3개 생성자 ( 제목 , 작성자 , 내용 )
		public Board(String title, String writer, String content) {
			super();
			this.title = title;
			this.writer = writer;
			this.content = content;
		}
		
		
	
	// 3. 메소드

}
