package 과제4_싱글톤복습.model;

public class Board { // Board객체가 여러개 필요함 싱글톤X
	
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
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", view=" + view + ", member=" + member + "]";
	}

	
	
	//getter setter
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

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
}
