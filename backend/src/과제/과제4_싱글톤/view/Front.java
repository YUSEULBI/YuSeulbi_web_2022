package 과제.과제4_싱글톤.view;

import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Mcontroller;

public class Front {

	// 싱글톤
	private static Front front = new Front();
	private Front() {	}
	public static Front getInstance () {
		return front;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 메인페이지
	public void index() {
		while (true ) { // 무한루프 종료조건 없음
			System.out.println("------------이젠커뮤니티-----------");
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : ");
			int ch = scanner.nextInt();
			if ( ch == 1 ) {	signup_page();	}
			else if ( ch == 2 ) {	login_page();	}
			else if ( ch == 3 ) {	findId_page();	}
			else if ( ch == 4 ) {	signPw_page();	}
		} // while end
		
		
	}
	
	// 2. 회원가입페이지
	public void signup_page() {
		
		System.out.println("아이디 : "); 		String id = scanner.next();
		System.out.println("비밀번호 : "); 		String pw = scanner.next();
		System.out.println("비밀번호확인 : "); 	String confirmpw = scanner.next();
		System.out.println("이름 : "); 		String name = scanner.next();
		System.out.println("전화번호 : "); 		String phone = scanner.next();
		
		// 컨트롤에게 전달 후 받기
		int result =  Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		
		// 결과 제어
		if ( result == 1 ) { System.out.println("[알림]회원가입 실패 . 패스워드가 서로 다릅니다"); }
		else if (  result == 2 ) { System.out.println("[알림]회원가입 성공. 감사합니다."); }
						
	}

	
	// 3. 로그인페이지
	public void login_page() {
		
		System.out.println("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		
		// 컨트롤에게 전달 후 결과받기
		int result = Mcontroller.getInstance().login(id, pw);
		
		if ( result == -1 ) { System.out.println("[알림] 로그인 실패. 패스워드 틀림");	}
		else if ( result == -2 ) { System.out.println("[알림] 로그인 실패. 존재하는 아이디없음");	}
		else { System.out.println("[알림] 로그인 성공. 안녕하세요"); board_page(); }
		// 로그인 성공시 게시물을 볼 수 있도록 board_page함수로 이동[호출]
	}
	
	// 4. 아이디찾기 페이지
	public void findId_page() {
		
		// 1. 입력부
		System.out.println("이름 : "); String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		//
		String result = Mcontroller.getInstance().fineId(name, phone);
		if ( result == null ) { System.out.println("[알림] 아이디 찾기 실패"); 	}
		else { System.out.println("[알림] 회원님의 아이디 : " + result + "입니다");}
	}
	
	// 5. 비밀번호 찾기 페이지
	public void signPw_page() {
		System.out.println("아이디 : ");String id = scanner.next();
		System.out.println("전화번호 : ");String phone = scanner.next();
		
		String result = Mcontroller.getInstance().finePw(id, phone);
		if ( result == null ) {System.out.println("[알림] 비번찾기실패");	}
		else { System.out.println("회원님 비번은 "+ result + "입니다.");	}
	}
	
	// 6. 로그인 성공시 게시물 출력
	public void board_page() {
		
	}
	
	// 7. 게시물 쓰기 페이지
	public void write_page() {
		
	}
	// 8. 게시물 상세 페이지
	public void view_page() {
		
	}
	
	// 8. 게시물 수정 페이지
	public void update_page() {
		
	}
	
	
	
}
