package 과제.과제11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	
	//싱글톤
	private static View view = new View();
	private View() {	}
	public static View getInstance() {
		return view;
	}
	
	//스캐너
	private Scanner scanner = new Scanner(System.in);
	
	// index
	public void index() {
		System.out.println("1.관리자 2.사용자");
		try {
			int ch = scanner.nextInt();
			if ( ch == 1 ) { admin();	}
			else if ( ch == 2 ) { customer_page();	}
		}
		catch (InputMismatchException e) {
			System.out.println("다시입력하세요 [예외사유] : "+ e);
		}
	}
	// 사용자페이지 --------------------------------------------------------------//
	
	void customer_page() {
		
		while ( true ) {
			ArrayList<ProductDto> result = Controller.getInstance().임시재고;
			System.out.println("-----------------------------------------------------");
			System.out.printf(
					"%2s \t %8s \t %8s \t %2s \n" , "번호","제품명","가격","상태");
			for ( ProductDto p : result ) {
				String state = null;
				if ( p.getPstock() < 1 ) { state = "재고부족";	}
				else { state = "판매중"; }
				System.out.printf(
					"%2d \t %8s \t %8d \t %2s \n" ,
						p.getPno(),p.getPname(),p.getPprice(),state);
				}
			System.out.println("-----------------------------------------------------");
			System.out.println("0:결제 / -1:결제취소 / 장바구니추가[제품번호입력]: ");
			System.out.println("장바구니 담긴 제품수 : " + Controller.getInstance().cartCount());
			
			int ch = scanner.nextInt();
			if ( ch == 0 ) { pay(); }//장바구니에 있는 모든 제품을 결제..
			else if ( ch == -1 ) { cancel();	} // 장바구니 결제전 취소
			else { addCartList( ch ); }//장바구니 담기

		}
		
	}
	
	void pay() {
		System.out.println("-----------------------------------------------------");
		//결제 예정 리스트
		cartPrint();
		System.out.println("-----------------------------------------------------");
		System.out.println("0 : 결제");
		int ch = scanner.nextInt();
		if ( ch == 0 ){ 
		int total = Controller.getInstance().pay();
			System.out.println("-----------------------------------------------------");
			System.out.println("★총 결제금액 : " + total +"원");
			System.out.println("-----------------------------------------------------");
			System.out.println("[알림] 장바구니를 비웠습니다.");
		}
	}
	
	void cartPrint() {
		ArrayList<ProductDto> result =  Controller.getInstance().list();
		ArrayList<Integer> cartList = Controller.getInstance().cartList;
		
			System.out.println("제품명\t수량\t결제금액");
			for ( ProductDto p : result ) {
				System.out.print(p.getPname()+"\t");
				int sum = 0;
				int count = 0;
				for ( int i = 0 ; i < cartList.size(); i++ ) {
				 if ( cartList.get(i) == p.getPno() ) {
					 sum += p.getPprice();
					 count++;
				}
				System.out.print(count+"\t");
				System.out.println(sum+"원");
			}
		}
	}
	
	void cancel() {
		Controller.getInstance().cancel(); System.out.println("[알림] 장바구니를 비웠습니다.");
	}
	
	void addCartList( int ch ) {
		int result2 = Controller.getInstance().addCartList(ch);
		if ( result2 == 1 ) { System.out.println("[알림] 장바구니에 추가");	}
		else if ( result2 == 2 ) { System.out.println("[알림] 재고가 없습니다.");	}
		else if ( result2 == 3 ) { System.out.println("[알림] 존재하지않는 제품번호 입니다.");	}
		else if ( result2 == 4 ) { System.out.println("[알림] 장바구니담기 실패 -관리자문의");	}
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	// 관리자페이지 --------------------------------------------------------------//
	void admin() {
		while(true) {
			System.out.println("1.제품등록 2.제품출력 3.제품수정 4.제품재고변경 5.제품삭제");
			try {
				int ch = scanner.nextInt();
				if ( ch == 1 ) { pRegist(); }
				else if ( ch == 2 ) { pPrint();	}
				else if ( ch == 3 ) { upDate_page(  );	}
				else if ( ch == 4 ) { upDate_pstock();	}
				else if ( ch == 5 ) { delete();	}
			}
			catch (InputMismatchException e) {
				System.out.println("다시입력하세요 [예외사유] : "+ e);
			}
		}
	}
	
	// 제품등록
	void pRegist( ) {
		System.out.println("제품명 : "); 	String pname = scanner.next();
		System.out.println("제품가격 : "); int pprice = scanner.nextInt();
		System.out.println("재고수량 : "); int pstock = scanner.nextInt();
		boolean result = Controller.getInstance().pRegist(pname, pprice, pstock);
		if ( result ) { System.out.println("[알림] 제품등록 성공");	}
		else { System.out.println("[알림] 제품등록 실패");	}
		
	}
	
	//제품출력
	void pPrint() {
		ArrayList<ProductDto> result = Controller.getInstance().list();
		System.out.println("-----------------------------------------------------");
		System.out.printf(
				"%2s \t %10s \t %10s \t %10s \n" , "pno","pname","pprice","pstock");
		
		for ( ProductDto p : result ) {
		//for ( int i = 0 ; i < result.size() ; i++ ) {
			System.out.printf(
				"%2d \t %10s \t %10d \t %10d \n" ,p.getPno(),p.getPname(),p.getPprice(),p.getPstock());
				// "%2d \t %10s \t %10d \t %10d \n" , result.get(i).getPno(),result.get(i).getPname(),result.get(i).getPprice(),result.get(i).getPstock() );
					
		}
	}
	
	//제품수정
	// 5. 제품수정 [ 인수 : pno , pname , pprice / 반환 : 성공실패 ]
	void upDate_page(  ) {
		System.out.println("수정할 필드선택 : 1.제품명 2.제품금액");
		try {
		int ch = scanner.nextInt();
		if ( ch == 1 ) { upDate_pname();	}
		else if ( ch == 2 ) { upDate_pprice();	}
		
		}catch (InputMismatchException e) {
			System.out.println("다시입력하세요 [예외사유] : "+ e);
		}
		
	}
	
	void upDate_pname() {
		System.out.println("제품번호 : "); int pno = scanner.nextInt();
		System.out.println("제품이름 : "); String pname = scanner.next();
		boolean result = Controller.getInstance().upDate_pname(pno, pname);
		if ( result ) { System.out.println("[알림] 제품이름 수정성공");	}
		else { System.out.println("[알림] 제품이름 수정실패");	}
	}
	
	void upDate_pprice() {
		
		System.out.println("제품이름 : "); String pname = scanner.next();
		System.out.println("제품가격 : "); int pprice = scanner.nextInt();
		boolean result = Controller.getInstance().upDate_pprice(pname, pprice);
		if ( result ) { System.out.println("[알림] 제품가격 수정성공");	}
		else { System.out.println("[알림] 제품가격 수정실패");	}
	}
	
	void upDate_pstock() {
		
		System.out.println("제품번호 : "); int pno = scanner.nextInt();
		System.out.println("변경할 재고수량 : "); int pstock = scanner.nextInt();
		boolean result = Controller.getInstance().upDate_pstock(pno, pstock);
		if ( result ) { System.out.println("[알림] 제품재고 수정성공");	}
		else { System.out.println("[알림] 제품재고 수정실패");	}
	}
	
	void delete() {
		System.out.println("삭제할 제품번호 : ");
		int pno = scanner.nextInt();
		boolean result = Controller.getInstance().delete(pno);
		if ( result ) { System.out.println("[알림] 제품삭제 성공");	}
		else { System.out.println("[알림] 제품삭제 실패");	}
	}
	
	
	
	
	
}// class end

