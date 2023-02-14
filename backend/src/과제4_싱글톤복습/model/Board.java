package 과제4_싱글톤복습.model;

public class Board {
	
	// 1. 필드
	private String title;
	private String content;
	private int view;
	private Member member;
	
	// 2. 생성자
	//빈생성자
	public Board() {	}
	// 풀생성자

	public Board(String title, String content, int view, Member member) {
		super();
		this.title = title;
		this.content = content;
		this.view = view;
		this.member = member;
	}
	
	// 3. 메소드
	
}
