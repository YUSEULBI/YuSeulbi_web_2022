package 과제.과제9.상속2;

import java.util.Scanner;

public class Front {
	
	//싱글톤 // 클래스로드 될때 메소드영역에 생성
	private static Front front = new Front();
	private Front() {	}
	public static Front getInstance() {
		return front;
	}
	
	//스캐너
	Scanner scanner = new Scanner(System.in);
	
	void index() {
		while ( true ) {
			System.out.println("--------- PC주변기기 ---------");
			System.out.println("제품번호\t제품명\t\t제품금액");
			for( PC주변기기 p : Controller.getInstance().getProductDB() ) {
				System.out.println( p.getPno()+"\t"+p.get제품명()+"\t"+p.get제품가격()+"원" );
			}
			System.out.println("---------------------------");
						
			System.out.println(">>1.제품등록 2.상세보기");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { regist();	} // 제품등록
			else if ( ch == 2 ) { view();	} //상세보기
		}
		
		
	}
	
	void regist() {
		System.out.println("-------PC주변기기 제품등록-------");
		System.out.println(">> 1.키보드 2.마우스 3.프린터");
		int ch = scanner.nextInt();
		if ( ch == 1 ) { register_Keyboard(); }
		else if ( ch == 2 ) { register_mouse();	}
		else if ( ch == 3 ) { register_Printer();	}
	}
	
	void view() {
		if ( Controller.getInstance().getProductDB().size() == 0 ) {
			System.out.println("등록된 제품이 없습니다."); return;
		}
		System.out.println(">>제품번호를 입력하세요");
		int no = scanner.nextInt();
		
		PC주변기기 제품 =  Controller.getInstance().getProductDB().get(no-1);
		System.out.println("제품번호 : "+제품.getPno());
		System.out.println("제품명 : "+제품.get제품명());
		System.out.println("제품가격 : "+제품.get제품가격()+"원");
		if ( 제품 instanceof 키보드 ) { 	
			키보드 키보드제품 = (키보드)제품;
			System.out.println("구동원리 : "+키보드제품.get구동원리());
		}
		if ( 제품 instanceof 마우스 ) {		
			마우스 마우스제품 = (마우스)제품;
			System.out.println("구동방식 : " + 마우스제품.get구동방식());
		}
		if ( 제품 instanceof 프린터 ) {		
			프린터 프린터제품 = (프린터)제품;
			System.out.println("인쇄방식 : " + 프린터제품.get인쇄방식());
		}
		System.out.println(">> 1.뒤로가기");
		int ch = scanner.nextInt();
		if ( ch == 1 ) { return;	}
		else { return;	} //다른키 눌러도 처음화면으로
		
	}
	
	void register_Keyboard() {
		System.out.print("제품명 : "); 	String 제품명 = scanner.next();
		System.out.print("제품가격 : "); 	int 제품가격 = scanner.nextInt();
		System.out.print("연결방식 : ");	String 연결방식 = scanner.next();
		System.out.print("키보드구동원리 : ");	String 구동원리 = scanner.next();
		System.out.println();
		키보드 키보드 = new 키보드(제품명, 제품가격, 연결방식, 구동원리);
		키보드.regist();
	}
	
	void register_mouse() {
		System.out.print("제품명 : "); 	String 제품명 = scanner.next();
		System.out.print("제품가격 : "); 	int 제품가격 = scanner.nextInt();
		System.out.print("연결방식 : ");	String 연결방식 = scanner.next();
		System.out.print("마우스구동방식 : ");	String 구동방식 = scanner.next();
		System.out.println();
		마우스 마우스 = new 마우스(제품명, 제품가격, 연결방식, 구동방식);
		마우스.regist();
	}
	
	void register_Printer() {
		System.out.print("제품명 : "); 	String 제품명 = scanner.next();
		System.out.print("제품가격 : "); 	int 제품가격 = scanner.nextInt();
		System.out.print("연결방식 : ");	String 연결방식 = scanner.next();
		System.out.print("인쇄방식 : ");	String 인쇄방식 = scanner.next();
		System.out.println();
		프린터 프린터 = new 프린터(제품명, 제품가격, 연결방식, 인쇄방식);
		프린터.regist();
	}
	
	
}
