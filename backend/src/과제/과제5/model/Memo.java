package 과제.과제5.model;

public class Memo { // 단방향 : 메모리효율 속도 좀더 좋은데 양뱡향과 크게 차이없음 ( 리스트가없으면 단방향 ) 데이터가많으면 단방향
	
	// 관계필드 = 참조필드 [ fk ] 
	private int frommno; 	// 쪽지를 보낸 회원 번호 
	// 관계필드 = 참조필드 [ fk ] 
	private int pno; 		// 받는사람 + 현재 쪽지의 제품정보
	// 관계필드 = 식별용 [ pk ]
	private int meno;		// 쪽지번호
	// 일반필드 
	private String content; 
	
	//생성자
	//빈생성자
	public Memo() { 	}
	
	//풀생성자
	public Memo(int frommno, int pno, int meno, String content) {
		super();
		this.frommno = frommno;
		this.pno = pno;
		this.meno = meno;
		this.content = content;
	}

	
	
	// 메소드
	@Override
	public String toString() {
		return "Memo [frommno=" + frommno + ", pno=" + pno + ", meno=" + meno + ", content=" + content + "]";
	}
	
	// getter setter
	public int getFrommno() {
		return frommno;
	}

	public void setFrommno(int frommno) {
		this.frommno = frommno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getMeno() {
		return meno;
	}

	public void setMeno(int meno) {
		this.meno = meno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	};
	
	
	
}
