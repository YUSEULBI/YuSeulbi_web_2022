package 과제.과제5.view;

import java.util.Scanner;

import 과제.과제5.controller.Mcontroller;

public class Front {
	
	// 싱글톤
	private static Front front = new Front();
	private Front() { 	}
	public static Front getInstance () {
		return front;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while ( true ) {
			System.out.println("---------수사네 중고거래---------");
			System.out.println("메뉴선택 >> 1.회원가입 2.로그인");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { signup_page();	}
			else if ( ch == 2 ) { login_page();	}
		
		} // while end
	} // index end
	
	// 1.회원가입페이지
	public void signup_page() {
		System.out.println("아이디 : "); 		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pw = scanner.next();
		System.out.println("비밀번호확인 : ");	String confirmPw = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		boolean result = Mcontroller.getInstance().signUp(id, pw, confirmPw, phone);
		if ( result ) {	System.out.println("[알림]회원가입 성공!");	}
		else { System.out.println("[알림]비밀번호를 똑같이 입력하세요");}
		
	}
	
	// 2.로그인페이지
	public void login_page() {
		System.out.println("아이디 : "); 		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pw = scanner.next();
		boolean result = Mcontroller.getInstance().logIn(id, pw);
		if ( result ) { System.out.println("[알림]로그인성공!"); community_page();	}
		else {	System.out.println("[알림]로그인실패!");	}
		
	}
	// 3. 중고거래페이지 ( 등록된 모든 제품 반환 , 마이페이지 , )
	public void community_page() {
		
		while ( true ) {
			System.out.println("------------중고거래커뮤니티------------");
			System.out.println("메뉴선택>> 1.제품등록 2.제품상세보기 3.마이페이지");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { regist_page();	}
			else if ( ch == 2 ) { pView_page();	}
			else if ( ch == 3 ) { myPage();	}
		}
		
	}
	
	// 4. 제품등록페이지
	public void regist_page() {
		System.out.println("------------제품등록------------");
	}
	
	// 5. 제품상세보기
	public void pView_page() {
		System.out.println("------------제품상세보기------------");
	}	
	
	// 6. 쪽지보내기페이지
	public void sendM_page() {
		System.out.println("------------쪽지보내기------------");
		
	}
	// 7. 마이페이지 ( 내가 등록한제품 , 내가보낸쪽지 , 내가받은쪽지 )
	public void myPage() {
		System.out.println("------------마이페이지------------");
	}

	
	
	
}
