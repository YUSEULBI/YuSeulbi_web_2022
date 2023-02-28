package Day20.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day09.ex10_게시판.controller.Bcontroller;
import Day20.controller.BController;
import Day20.controller.MController;
import Day20.model.Dto.BoardDto;
import Day20.model.Dto.CategoryDto;

public class BoardView {
	
	private static BoardView dao = new BoardView();
	private BoardView() {
		// TODO Auto-generated constructor stub
	}
	public static BoardView getInstance() {
		return dao;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	
	// 1. 게시물 모든 게시물
	public void index() {
		while ( true ) {
			System.out.println("================ 로그인 ================");
			// 최신 게시물 3개 출력
			boardPrintRecent();
			
			// 모든 갤러리 출력
			categoryPrint();
			
			System.out.print("-1: 로그아웃 , 0:갤러리추가 , 이동할 갤러리 번호 선택 : ");
			int ch = scanner.nextInt();
			if ( ch == -1 ) { 
				MController.getInstance().setLoginsession(0); //로그인세션초기화
				System.out.println("[로그아웃] 안녕히 가세요!");
				break;
			}
			else if ( ch == 0 ) { categoryAdd();	}
			else if ( ch > 0 ) { boardPrint( ch );	}
			
			
		}
		
		
	}
	
	// 2. 카테고리 추가
	public void categoryAdd() {
		System.out.println("================ 갤러리 추가 ================");
		scanner.nextLine();
		System.out.println(" 추가할 갤러리 이름 : "); String cname = scanner.nextLine();
		
		boolean result = BController.getInstance().categoryAdd( cname );
		if ( result ) { System.out.println("[등록성공] 갤러리 추가 되었습니다.");	}
		else { System.out.println("[등록실패] 관리자문의");	}
	}
	
	
	// 3. 모든 카테고리 호출 [ 갤러리1개 = dto / 갤러리여러개 = dto 여러개 = 배열혹은 리스트 호출 ]
	public void categoryPrint() {
		// 1. 모든 카테고리 요청 후 리스트에 담기
		ArrayList<CategoryDto> clist = BController.getInstance().categoryPrint();
		
		// 2. 출력 ( 향상된 for문 써도 됨)
		/*
		 * for ( int i = 0 ; i < clist.size() ; i++ ) { System.out.println(
		 * clist.get(i).getCno() + " - " + clist.get(i).getCname() ); }
		 */
		
		// 2. 출력 향상된 for문
		int count = 0;
		for ( CategoryDto dto : clist ) {
			System.out.print(dto.getCno()+" - "+ dto.getCname()+"\t");
			count++; // 반복횟수 저장
			if ( count % 4 == 0 ) {System.out.println();} //4개씩 출력시 줄바꿈
		}
		System.out.println();
		
		
	}
	
	// 4. 게시물쓰기 페이지
	public void boardAdd( int cno ) {
		System.out.println("================ 게시물 쓰기 ================");
		System.out.print("제목 : "); String btitle = scanner.next();
		System.out.print("내용 : "); String bcontent = scanner.next();
		boolean result = BController.getInstance().boardAdd(btitle, bcontent , cno );
		if ( result ) { System.out.println("[글등록성공]");	}
		else { System.out.println("[글등록실패]");	}
				
	}
	
	// 5. 모든 게시물 최근 3개
	public void boardPrintRecent() {
		System.out.println("================ 최신 게시물 ================");
		ArrayList<BoardDto> blist = BController.getInstance().boardPrintRecent();
		System.out.printf("%s\t%s\t%s\t%s\t%s\t%10s\n","번호","제목","작성자","조회수","갤러리","작성일");
		for ( BoardDto d : blist ) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",
					d.getBno(),d.getBtitle(),d.getMid(),d.getBview(),d.getCname(),d.getBdate());
		}
		System.out.println();
	}
	
	// 6. 선택한 갤러리 모든 게시물
	public void boardPrint( int cno ) {
		System.out.println("================ 선택한 갤러리 ================");
		ArrayList<BoardDto> blist = BController.getInstance().boardPrint(cno);
		System.out.printf("%s\t%s\t%s\t%s\t%s\n","번호","제목","작성자","조회수","작성일");
		for ( BoardDto d : blist ) {
			System.out.printf("%d\t%s\t%s\t%s\t%s\n",
					d.getBno(),d.getBtitle(),d.getMid(),d.getBview(),d.getBdate());
		}
		System.out.println();
		
		while(true) {
			System.out.println("갤러리메뉴 : 1.뒤로가기 2.게시물쓰기 3.게시물보기 : ");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { break;	}
			else if ( ch == 2 ) { boardAdd( cno );	}
			else if ( ch == 3 ) {	}
			
		}
	}
	
	
	
}
