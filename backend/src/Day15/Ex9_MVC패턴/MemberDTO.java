package Day15.Ex9_MVC패턴;

public class MemberDTO { // 설계도
	
	// 1. 필드 [ DB 필드와 일치화 ]
	private int mno;
	private String mid;
	private String mpw;
	
	
	
	// 2. 생성자 [ 무조건 : 빈생성자 , 풀생성자 만들기 ]
	public MemberDTO() {	}
	
	public MemberDTO(int mno, String mid, String mpw) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}
	
	public MemberDTO(String mid, String mpw) {
		super();
		this.mid = mid;
		this.mpw = mpw;
	}

	
	// 3. 메소드 [ 무조건 get set , toString() ]
	@Override
	public String toString() {
		return "BoardDTO [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
	
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	
	
	
	
	
	
}
