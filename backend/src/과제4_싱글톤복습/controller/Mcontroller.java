package 과제4_싱글톤복습.controller;

public class Mcontroller {
	//싱글톤
	// 객체를 미리 하나 만들기 , 정적메소드로만 mc가 호출되게끔 private
	private static Mcontroller mc = new Mcontroller();
	//객체 추가생성 못하게 막기
	private Mcontroller() { 	}
	// 외부에서 Mc를 쓸려면 객체를 생성해야하는데 객체를 못만드니까 정적메소드로 객체없이 호출하게 만들기
	public static Mcontroller getInstance () {
		return mc;
	}
	
	
	// 1. 회원가입 처리
	// 인수: id , pw , confirmpw , name , phone	반환: 0성공 1패스워드실패
	public int signup () {
	 return 1;
	}

	// 2. 로그인 처리
	// 인수 : id , pw				반환: i회원번호 -1비밀번호틀림 -2아이디틀림
	public int login() {
		return -2;
	}

	// 3. 아이디찾기 처리
	// 인수 : name , phone			반환 : 찾은아이디 혹은 null

	// 4. 비밀번호찾기 처리
	// 인수 : id , phone				반환 : 찾은비밀번호 혹은 null
	
}
