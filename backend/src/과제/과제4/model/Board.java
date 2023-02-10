package 과제.과제4.model;

public class Board {
	
	// 1. 필드
	public String title;
	public String writer;
	public String content;
	public int view = 0;
	
	// 2. 생성자
	
	//기본생성자
	public Board() { }

	
	
	//풀생성자
	public Board(String title, String writer, String content, int view) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.view = view;
	}
	
	// 제목 작성자 내용만 받는 3개매개변수 생성자
	public Board(String title , String writer , String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		
	}
	
	
	
	
	// 3. 메소드
}
