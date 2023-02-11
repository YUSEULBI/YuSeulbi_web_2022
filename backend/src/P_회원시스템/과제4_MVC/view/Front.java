package P_회원시스템.과제4_MVC.view;

import java.util.Scanner;

import P_회원시스템.과제4_MVC.controller.Mcontroller;


public class Front { // 클래스 시작 /////////////////////////////////////////////
	
	// 스캐너 클래스 객체생성 / 입력객체
	Scanner scanner = new Scanner(System.in);
	// Mcontroller 객체 생성
	Mcontroller mc = new Mcontroller();
	
	// 1. 필드
	// 2. 생성자
		
	
	// 3. 메소드
	
	public void index () { // index 메소드 start ///////////////////
		
		while ( true ) { // while start ////////////////////////
			
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			System.out.print("이동할 메뉴 번호 : ");
			int ch = scanner.nextInt();
			
			// 1. 회원가입 ----------------------------------------
			if ( ch == 1 ) { signUp(); }
			
			// 2. 로그인 -----------------------------------------
			else if ( ch == 2 ) { logIn();	}
			
			// 3. 아이디찾기 ---------------------------------------
			else if ( ch == 3 )	{	}
			
			// 4. 비밀번호찾기 --------------------------------------
			else if ( ch == 4 ) {	}
			else {	} // if end  -------------------------------
		
		} // while end ////////////////////////
		 
	} // index 메소드 end ////////////////////////////////////////////
	
	
	// 회원가입 메소드 ///////////////////////////////////////////////////////
	void signUp() {
		
		// 정보 입력받기
		System.out.print("아이디 : ");
		String id = scanner.next();
		
		System.out.print("비밀번호 : ");
		String pw = scanner.next();
		
		System.out.print("비밀번호확인 : ");
		String rePw = scanner.next();
		
		System.out.print("이름 : ");
		String name = scanner.next();
		
		System.out.print("전화번호 : ");
		String phone = scanner.next();
		
		// Mcontroller클래스의 함수로 값을 보내서
		int result = mc.signUpSave( id , pw , rePw , name , phone );
		// 유효성 검사후
		// Member 객체 생성(초기값) 후 DB저장
		// result 리턴값 0이면 회원가입성공 , -1이면 비번이 서로 다릅니다.
		if ( result == 0 ) { System.out.println(">>> 회원가입 성공");	}
		else if ( result == -1 ) { System.out.println("비밀번호가 다릅니다.");	} 
		
	}
	
	int logIn() {	
		
		// 아이디 ,비번 입력받은 값을 문자열객체에 저장
		System.out.println("아이디 : ");
		String id = scanner.next();
		System.out.println("비밀번호 : ");
		String pw = scanner.next();
		
		// 입력값을 Mcontroller의 함수로 보내서
		mc.login( id , pw );
		// 유효성 검사 후
		// 로그인성공 안내 , 커뮤니티 페이지로 이동
		
		return 0 ;
	}
	
	
}// 클래스 끝 /////////////////////////////////////////////////////////
