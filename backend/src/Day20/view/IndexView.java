package Day20.view;

import java.util.Scanner;

import Day20.controller.MController;
import P_회원시스템.과제4_MVC.controller.Mcontroller;

public class IndexView {

	private static IndexView dao = new IndexView();
	private IndexView() {
		// TODO Auto-generated constructor stub
	}
	public static IndexView getInstance() {
		return dao;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	// 1. 메인페이지
	public void index() {
		while( true ) {
			System.out.println("================ 이젠 갤러리 ================");
			System.out.println("1.로그인 2.회원가입");
			try {
				int ch = scanner.nextInt();
				if ( ch == 1 ) { login();	}
				else if ( ch == 2 ) {	signup(); }
			}catch (Exception e) {
				System.err.println("[알림] 잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	
	// 2. 회원가입
	public void signup() throws Exception { 
		// 만일 해당 메소드에서 예외[오류] 발생하면 해당 메소드를 호출했던 곳으로 오류이동
		
		System.out.println("================ 회원가입 ================");
		System.out.println(" 아이디 : ");		String mid = scanner.next();
		System.out.println(" 비밀번호 : ");	String mpw = scanner.next();
		System.out.println(" 이름 : ");		String mname = scanner.next();
		System.out.println(" 전화번호 : ");	String mphone = scanner.next();
		
		int result =
		MController.getInstance().signup(mid, mpw, mname, mphone);
		if ( result == 1 ) {
			System.err.println("[성공] 회원가입 되었습니다. ");
		}else if ( result == 2 ) {
			System.out.println("[실패] 사용중인 아이디가 있습니다.");
		}else if ( result == 3 ) {
			System.out.println("[실패] 시스템 오류 : 관리자에게 문의");
		}
	}
	
	// 3. 로그인 페이지
	public void login() {
		System.out.println("================ 로그인 ================");
		System.out.println(" 아이디 : ");		String mid = scanner.next();
		System.out.println(" 비밀번호 : ");	String mpw = scanner.next();
		boolean result = MController.getInstance().login( mid , mpw );
		if ( result ) { 
			System.out.println("[로그인성공]");
			// BoardView 게시물 초기화면으로 이동
			BoardView.getInstance().index();
			}
		else { System.out.println("[로그인실패]");	}
		
	}
	
	
	
}
