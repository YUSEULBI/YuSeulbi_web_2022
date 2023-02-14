package 과제.과제5.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제5.controller.Mcontroller;
import 과제.과제5.controller.Pcontroller;
import 과제.과제5.model.Member;
import 과제.과제5.model.Memo;
import 과제.과제5.model.Product;

public class Front {

	// 싱글톤
	private static Front front = new Front();

	private Front() {
	}

	public static Front getInstance() {
		return front;
	}

	private Scanner scanner = new Scanner(System.in);

	public void index() {
		while (true) {
			System.out.println("------------ 고잔동 중고거래 ------------");
			System.out.println("메뉴선택 >> 1.회원가입 2.로그인");
			int ch = scanner.nextInt();
			if (ch == 1) {
				signup_page();
			} else if (ch == 2) {
				login_page();
			}

		} // while end
	} // index end

	// 1.회원가입페이지
	public void signup_page() {
		System.out.println("아이디 : ");
		String id = scanner.next();
		System.out.println("비밀번호 : ");
		String pw = scanner.next();
		System.out.println("비밀번호확인 : ");
		String confirmPw = scanner.next();
		System.out.println("전화번호 : ");
		String phone = scanner.next();

		boolean result = Mcontroller.getInstance().signUp(id, pw, confirmPw, phone);
		if (result) {
			System.out.println("[알림]회원가입 성공!");
		} else {
			System.out.println("[알림]비밀번호를 똑같이 입력하세요");
		}

	}

	// 2.로그인페이지
	public void login_page() {
		System.out.println("아이디 : ");
		String id = scanner.next();
		System.out.println("비밀번호 : ");
		String pw = scanner.next();
		boolean result = Mcontroller.getInstance().logIn(id, pw);
		if (result) {
			System.out.println("[알림]로그인성공!");
			community_page();
		} else {
			System.out.println("[알림]로그인실패!");
		}

	}

	// 3. 중고거래페이지 ( 등록된 모든 제품 반환 , 마이페이지 , )
	public void community_page() {

		while (true) {
			System.out.println("------------ 중고거래커뮤니티 ------------");
			System.out.println("제품번호\t제목\t금액\t판매자");
			for (Product p : Pcontroller.getInstance().pPrint()) {
				String writer = null;
				for (Member m : Mcontroller.getInstance().getMemberDB()) {
					if (p.getMno() == m.getMno()) {
						writer = m.getId();
					}
				}
				System.out.println(p.getPno() + "\t" + p.getTitle() + "\t\t" + p.getPrice() + "\t" + writer);
			}

			System.out.println("메뉴선택>> 1.제품등록 2.제품상세보기 3.마이페이지 4.로그아웃");

			int ch = scanner.nextInt();
			if (ch == 1) {
				regist_page();
			} else if (ch == 2) {
				pView_page();
			} else if (ch == 3) {
				myPage();
			} else if (ch == 4) {
				Mcontroller.getInstance().logOut();
				break;
			}
		}

	}

	// 4. 제품등록페이지
	public void regist_page() {
		System.out.println("------------ 제품등록 ------------");
		System.out.println("제목 : ");
		String title = scanner.next();
		System.out.println("내용 : ");
		String content = scanner.next();
		System.out.println("금액 : ");
		String price = scanner.next();
		boolean result = Pcontroller.getInstance().regist(title, content, price);
		if (result) {
			System.out.println("[알림] 제품등록 성공");
		} else {
			System.out.println("[알림] 제품등록 실패");
		}
	}

	// 5. 제품상세보기
	public void pView_page() {
		System.out.println("*제품 번호를 입력 : ");
		int pno = scanner.nextInt();
		Product result = Pcontroller.getInstance().pView(pno);

		String writer = null;
		for (Member m : Mcontroller.getInstance().getMemberDB()) {
			if (m.getMno() == result.getMno()) {
				writer = m.getId();
			}
		}
		System.out.println("------------제품상세보기------------");
		System.out.println("제목 : " + result.getTitle());
		System.out.println("제품번호 : " + result.getPno() + "\t작성자 : " + writer);
		System.out.println("내용 : " + result.getContent());
		System.out.println("금액 : " + result.getPrice());

		System.out.println("메뉴번호>> 1.쪽지보내기 2.뒤로가기");
		int ch = scanner.nextInt();
		if (ch == 1) {
			sendM_page(pno);
		} else if (ch == 2) {
			return;
		}
	}

	// 6. 쪽지보내기페이지
	public void sendM_page(int pno) {
		System.out.println("------------쪽지보내기------------");
		System.out.println("메세지 : ");
		String sendM = scanner.next();
		boolean result = Pcontroller.getInstance().send(pno, sendM);
		if (result) {
			System.out.println("[알림] 쪽지 전송성공");
		} else {
			System.out.println("[알림] 쪽지 전송실패");
		}

	}

	// 7. 마이페이지 ( 내가 등록한제품 , 내가보낸쪽지 , 내가받은쪽지 )
	public void myPage() {
		System.out.println("------------마이페이지------------");
		// 로그인한사람이 등록한 제품 리스트
		//ArrayList<Product> myP =  Mcontroller.getInstance().myProduct();
		// 내가보낸쪽지 리스트
		//ArrayList<Memo> sendM = Mcontroller.getInstance().mySendM();
		// 내가 받은 쪽지 리스트
		//ArrayList<Memo> receiM = Mcontroller.getInstance().myReceiM();
		
		
		
		// 로그인한사람이 등록한 제품 리스트
		System.out.println(">>>내가 등록한 제품");
		for ( Product p : Mcontroller.getInstance().myProduct() ) {
			System.out.println("제품번호 : " + p.getPno() + "제목 : "+p.getTitle() + "금액 : " + p.getPrice());
		}
		
		//
//		for ( Memo m : Mcontroller.getInstance().getMemoDB() ) {
//			if ( m.getFrommno() == Mcontroller.getInstance().getLogSession()) {
//				System.out.println("내가보낸메세지");
//			}
//				
//		}
		
	/*	
		
		 * // 내가 받은 쪽지 리스트 System.out.println(">>>내가 보낸 쪽지"); for ( Memo m :
		 * Mcontroller.getInstance().mySendM() ) { System.out.println("받는사람 : " +
		 * m.getPno() + "보낸메세지 : "+m.getContent()); } // 로그인한사람이 등록한 제품 리스트
		 * System.out.println(">>>내가 받은 쪽지"); for ( Memo m :
		 * Mcontroller.getInstance().myReceiM() ) {
		 * System.out.println("보낸사람 : "+m.getFrommno() + "받은메세지 : " + m.getContent());
		 * 
		 * }
		 */
		System.out.println("메뉴선택>>> 1. 뒤로가기");
		int no = scanner.nextInt();
		if ( no == 1 ) { return;	}
		else {	};
	}

}
