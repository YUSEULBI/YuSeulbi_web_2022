package 과제.과제5.model;

public class Product {
	
	// 관계 필드 = 참조 필드 [ FK ]
	private int mno;	// 등록한 회원의 번호
	// 관계 필드 = 식별용 [ pk ]
	private int pno; 	// 제품번호 
	// 일반 필드 
	private String title; 
	private String content;
	private String price; 
	private boolean state; 	// 제품상태 : 판매중 , 판매완료
	
	//생성자
	//빈생성자
	public Product() { 	}

	//풀생성자
	public Product(int mno, int pno, String title, String content, String price, boolean state) {
		super();
		this.mno = mno;
		this.pno = pno;
		this.title = title;
		this.content = content;
		this.price = price;
		this.state = state;
	}

	// 
	
	
	// 메소드
	@Override
	public String toString() {
		return "Product [mno=" + mno + ", pno=" + pno + ", title=" + title + ", content=" + content + ", price=" + price
				+ ", state=" + state + "]";
	}
	
	// getter setter
	
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	

}
