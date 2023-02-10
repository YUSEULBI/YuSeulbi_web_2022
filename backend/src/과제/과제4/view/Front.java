package 과제.과제4.view; //Front
// * 입출력 JS 담당(if , for 가능) print , Scanner / 저장안됨!!!

import java.util.Scanner;

import 과제.과제4.controller.Mcontroller;

public class Front {
	
	// 스캐너클래스 객체생성
	Scanner scanner = new Scanner(System.in);
	// Mcontroller 클래스 객체 생성
	Mcontroller mc = new Mcontroller();
	
	// 1. 메인페이지
	public void index() {
		while ( true ) {
			
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { signUp();}
				
			else if ( ch == 2 ) { login();}
				
			else if ( ch == 3 ) {findId();}
				
			else if ( ch == 4 ) {findPassword();}
				
			else { }
			
		}
	}

		
	// 2. 회원가입 페이지
	void signUp() {
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : "); 		String pwd = scanner.next();
		System.out.println("비밀번호확인 : "); 	String confirmpwd = scanner.next();
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		int result = mc.signup( id , pwd , confirmpwd , name , phone  );
		
		if ( result == 1 ) {
			System.out.println("[회원가입 실패]");
		}else if ( result == 0 ) {
			System.out.println("[회원가입 성공]");
		}
		
	}
	
	// 3. 로그인 페이지
	void login() {
		System.out.println("로그인 : ");
		String loginId = scanner.next();
		System.out.println("비밀번호 : ");
		String loginPwd = scanner.next();
		
		int result = mc.login(loginId, loginPwd);
		if ( result >= 0 ) {  
			System.out.println("0~숫자 -> 로그인성공한 회원 번호");
		}
		else if ( result == -1 ) { System.out.println("[알림]비밀번호가 다릅니다."); }
		else if ( result == -2 ) { System.out.println("[알림]없는 회원입니다."); }
		else {}
	}
	
	// 4. 아이디 찾기 페이지
	void findId() {
		//입력받음
		System.out.println("이름 : ");
		String findName = scanner.next();
		System.out.println("전화번호 : ");
		String findPhone = scanner.next();
		//입력값을 Mcontroller로 보내기
		String result = mc.findId( findName , findPhone );
		if ( !result.equals("0") && !result.equals("1") ) {
			System.out.println("아이디 찾기 성공! 아이디 : " + result);
		}else if ( result.equals("0")) {
			System.out.println("없는 회원 이름입니다.");
		}else if ( result.equals("1")) {
			System.out.println("전화번호가 일치하지 않습니다.");
		}
		
	}
	
	// 5. 비밀번호 찾기 페이지
	void findPassword() {
		System.out.println("아이디 : ");
		String findId = scanner.next();
		System.out.println("전화번호 : ");
		String findphone = scanner.next();
		String result = mc.findpw(findId,findphone);
		if ( !result.equals("0") && !result.equals("1") ) {
			System.out.println("비밀번호찾기 성공! 비밀번호 : " + result);
		}else if ( result.equals("0") ) {
			System.out.println("존재하지 않는 아이디입니다.");
		}else if ( result.equals("1") ) {
			System.out.println("전화번호가 일치하지 않습니다.");
		}
	}
	
}
