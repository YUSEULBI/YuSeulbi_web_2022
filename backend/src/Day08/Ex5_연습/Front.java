package Day08.Ex5_연습;

import java.util.Scanner;

public class Front {
	
	// 1. 필드
	Scanner scanner = new Scanner(System.in);
	// 2. 생성자
	// 3. 메소드
	void index () {
		
		while ( true ) {
			System.out.println("1.회원등록 2.회원삭제");
			int ch = scanner.nextInt();
			//회원등록 
			if ( ch == 1 ) { signUp(); 
			// 회원삭제
			}else if ( ch == 2 ) { delete(); 
				
			}else {}
		}
		
	} // index end
	
	void signUp( ) {
		System.out.println("회원명 : ");
		
		System.out.println("전화번호 : ");
	}
	
	void delete() {
		System.out.println("삭제할 회원 인덱스 : ");
		
	}
}
