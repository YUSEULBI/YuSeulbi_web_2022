package P_회원시스템.과제4_MVC.model;

public class Member {
	
	// 1. 필드
	public String id;
	public String pw;
	public String name;
	public String phone;
	
	// 2. 생성자
		//빈생성자
		public Member() { 	}

		//풀생성자
		public Member(String id, String pw, String name, String phone) {
			super();
			this.id = id;
			this.pw = pw;
			this.name = name;
			this.phone = phone;
		}
		
	
	// 3. 메소드

}
