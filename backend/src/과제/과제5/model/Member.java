package 과제.과제5.model;

public class Member {

	// 관계 필드 [ 식별용 = PK ]
		private int mno; // 회원번호 = 식별자 필드 PK
		// 일반 필드
		private String id;
		private String pw;
		private String phone;
	
	// 생성자
		//빈생성자
		public Member() { 		}
		
		//풀생성자
		public Member(int mno, String id, String pw, String phone) {
			super();
			this.mno = mno;
			this.id = id;
			this.pw = pw;
			this.phone = phone;
		}

		
		
	// 메소드
	@Override
		public String toString() {
			return "Member [mno=" + mno + ", id=" + id + ", pw=" + pw + ", phone=" + phone + "]";
		}

	
		
	// getter setter
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
		
		
		
}
