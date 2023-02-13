package Day09.ex10_게시판.model;



import java.util.Date;



/*

클래스 model 만들기
 	1. 필드 선정
 	2. 모든 필드는 private
 	3. 생성자 [ 1.빈생성자 2.풀생성자 ]
	4. 메소드 [ 1. toString 2. getter setter ] 

*/

public class Board { // Board 여러개 만들어서 리스트에 담기 때문에 싱글톤 쓰면안됨.

	// 1. 필드 ////////////////////////////////////////////////////////
	private String title;
	private String content;
	private String writer;
	private String password;
	private Date date; //java.util
	private int view;
	// ArrayList<reply> list = new
	
	
	// 2. 생성자 ////////////////////////////////////////////////////////
	
	// 빈생성자
	public Board() {
		super();
	}

	// 풀생성자
	public Board(String title, String content, String writer, String password, Date date, int view) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.date = date;
		this.view = view;
	}


	
	
	// 3. 메소드 ////////////////////////////////////////////////////////
	
	// 주소값 대신 필드값 알려줌. -> 수정함. 주소값 대신 내가 정의한 형식 반환 , 내가 원하는대로 출력
	@Override
	public String toString() {
		return title +"\t"+writer+"\t"+view+"\t"+date;
	}
	
	// getter setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	
	
	
	
	
	
	
}

