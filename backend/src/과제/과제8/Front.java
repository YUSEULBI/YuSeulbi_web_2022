package 과제.과제8;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	
	//싱글톤
	private static Front front = new Front();
	private Front() {	}
	public static Front getInstance () {
		return front;
	}
	
	// 스캐너
	Scanner scanner = new Scanner(System.in);
	
	//DB
	ArrayList<화장품> 화장품DB = new ArrayList<>(); 
	
	
	
	// 실행용 함수
	void index() {
		while (true ) {
			System.out.println("-------- 올리브영 관리자페이지 --------");
			//출력할 곳
			System.out.println("메뉴선택>> 1.제품등록 2.상세보기");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { 등록();	}
			else if ( ch == 2 ) { 상세보기페이지();	}
		}
		
	}
	
	// 제품등록 페이지
	void 등록() {
		System.out.println("1.파운데이션 2.립스틱 3.로션");
		int ch = scanner.nextInt();
		if ( ch == 1 ) { 파운데이션등록페이지();	}
		else if ( ch == 2 ) { 립스틱등록페이지();	} 
		else if ( ch == 3 ) { 로션등록페이지();	}
	}
	
	// 상세보기 페이지
	void 상세보기페이지() {
		System.out.println("넘버선택 : ");
		int no = scanner.nextInt();
		화장품 제품 = 화장품DB.get(no);
		if ( 제품 instanceof 파운데이션) {
			((파운데이션)제품).상세보기();
			
		}

		System.out.println("------------제품정보------------");
		
	}
	
	// 1.파운데이션 등록 함수
		void 파운데이션등록페이지() {
			System.out.println("제품명 : "); String 제품명 = scanner.next();
			System.out.println("가격 : ");  int 가격 = scanner.nextInt();
			
			System.out.println("호수 : ");  int 호수 = scanner.nextInt();
			System.out.println("제형 : ");  String 제형 = scanner.next();
			파운데이션 파운데이션 = new 파운데이션(제품명, 가격, 호수, 제형);
			System.out.println(파운데이션.toString());
			파운데이션.등록(파운데이션);
						
		}
		
	// 2.립스틱 등록 함수
		void 립스틱등록페이지() {
			System.out.println("제품명 : ");	String 제품명 = scanner.next();
			System.out.println("가격 : ");	 int 가격 = scanner.nextInt();
			
			System.out.println("칼라 : ");	 String 칼라 = scanner.next();
			System.out.println("제형 : ");	 String 제형 = scanner.next();
			립스틱 립스틱 = new 립스틱(제품명, 가격, 칼라, 제형);
			화장품DB.add(립스틱);
		}
	
	// 3.로션 등록 함수
		void 로션등록페이지() {
			System.out.println("제품명 : ");	String 제품명 = scanner.next();
			System.out.println("가격 : ");	int 가격 = scanner.nextInt();
			
			System.out.println("피부타입 : ");	String 피부타입 = scanner.next();
			로션 로션 = new 로션(제품명, 가격, 피부타입);
			화장품DB.add(로션);
		}
		
	
}
