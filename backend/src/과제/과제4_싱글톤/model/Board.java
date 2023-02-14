package 과제.과제4_싱글톤.model;

public class Board {
	// 'Member'가 글을 씀 , 글을 '여러개' 씀
	// 하나의 회원이 하나의 게시글을 씀
	// model
	// 일 대 다
	// 1. 게시글 1개의 작성자(회원)은 1명이다	[object]
	// 2. 1명의 회원은 여러개의 글을 작성할 수 있다. [ArrayList]
	// DTO 이동객체..!!!
	// Board 주인은 1명...?
	
	// 1.필드 // 제목 , 내용 , 조회수
	private String title;
	private String content;
	private int view;
	
	// 하나의 게시물[객체]가 하나의 멤버객체를 가질 수 있다.
	private Member member; // 1명의 회원  , 게시물1개의 주인은 회원1명
	
	// 2. 생성자 /////////////////////////////////////
	
	// 빈생성자
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
