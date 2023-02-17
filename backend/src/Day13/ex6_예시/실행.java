package Day13.ex6_예시;

import java.util.Scanner;

public class 실행 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		키보드 key = null; // 스탭영역 변수선언 구현안된 추상화
		
		// 객체사용방법만 추상만 만드는거 인터페이스
		
		while (true) { // 구현객체 선택
			System.out.println("----바탕화면----");
			System.out.println("1.피파온라인  ");
			System.out.println("2.메이플스토리  ");
			
			System.out.println("선택 : ");
			int sh = scanner.nextInt();
			// 입력한 번호의 구현한 클래스 [객체]를 대입
			if ( sh == 1 ) { key = new 피파온라인();	}
			else if ( sh == 2 ) { 
				key = new 메이플스토리();
				
				System.out.println("1.마법사 2.전사 : ");
				int 입력2 = scanner.nextInt();
				if ( 입력2 == 1 ) { key= new 마법사();	} //마법사의 키보드
				else if ( 입력2 == 1 ) { key= new 전사();	} // 전사의 키보드
			}
			
			// 실제로 게임시작 - 게임별로 A키 B키가 다른 기능이 동작
			while(true) {
				System.out.println("게임시작~~~");
				String 입력 = scanner.next();
				if ( 입력.equals("A")) {
					key.A버튼();
				}else if( 입력.equals("B")) {
					key.B버튼();
				}else if ( 입력.equals("X") ) { break;	}
			
				
			}
			
		}
		
	}
	
}

