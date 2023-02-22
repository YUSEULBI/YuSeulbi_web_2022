package Day15.Ex9_MVC패턴;

import java.util.ArrayList;
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
			else if ( ch == 3 ) { update( ); 	}
			else if ( ch == 4 ) { delete(); }
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
		System.out.println("-------------------------");
		System.out.printf("%2s \t %10s \t %10s \n" , "no" , "mid" , "mpw");
		
		// Controller list함수를 실행하면 DAO의 list함수실행시켜서 DB리스트 받아서 view에 반환
		ArrayList<MemberDTO> result = Controller.getInstance().list(); 
		
		// 반환받은 DB리스트  반복문 돌리기 // 받은거 출력만하기!!!!!!!!!!!!!
		for ( int i = 0  ; i < result.size() ; i++ ) { // 0번 인덱스부터 마지막 인덱스까지 반복
			System.out.printf("%2d \t %10s \t %10s \n" , result.get(i).getMno() , result.get(i).getMid(),result.get(i).getMpw());
		}
	}
	
	public void update(  ) {
		System.out.println("------------------------");
		System.out.println("회원번호 : "); int mno = scanner.nextInt();
		System.out.println("새비밀번호 : "); String mpw = scanner.next();
		boolean result = Controller.getInstance().update(mno, mpw);
		if ( result ) { System.out.println("[알림] 수정 성공 ");	}
		else { System.out.println("[알림] 수정 실패 - 관리자에게 문의 ");	}
	}//update end
	
	public void delete() {
		System.out.println("------------------------");
		System.out.println("삭제할 회원번호 : "); int mno = scanner.nextInt();
		boolean result = Controller.getInstance().delete(mno);
		if ( result ) { System.out.println("[회원삭제 성공]");	}
		else { System.out.println("[회원삭제 실패] - 관리자에게 문의");	}
	}
}
