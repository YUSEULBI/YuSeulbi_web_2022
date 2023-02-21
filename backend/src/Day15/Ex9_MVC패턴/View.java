package Day15.Ex9_MVC패턴;

import java.util.Scanner;

import Day15.Ex1_p498.Member;

public class View {
	Scanner scanner = new Scanner(System.in);
	
	//싱글톤
	private static View view = new View();
	private View() { 	}
	public static View getInstance() {
		return view;
	}
	
	// 1. 메인화면
	public void index() {
		while ( true ) {
			System.out.println("1.회원등록[C] 2.회원출력[R] 3.회원수정[U] 4.회원삭제[D]");
			System.out.println("번호입력 : ");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { signup();	}
			else if ( ch == 2 ) { list(); 	}
			else if ( ch == 3 ) { 	}
			else if ( ch == 4 ) { 	}
		}
	}// index end
	
	public void signup() {
		System.out.println("---------등록[C]---------");
		System.out.println("아이디 : ");
		String mid = scanner.next();
		System.out.println("비밀번호 : ");
		String mpw = scanner.next();
		// 2. 입력값 컨트롤에게 전달 후결과 반환
		boolean result = Controller.getInstance().signUp(mid, mpw);
		// 3. 결과에 따른 출력
		if ( result ) { System.out.println("[회원등록성공]");	}
		else { System.out.println("[회원가입실패]");	}
	} // signup end
	
	public void list() {
	
	}
}
