package 과제.과제4.view; //Front
// * 입출력 JS 담당(if , for 가능) print , Scanner / 저장안됨!!!

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;
import 과제.과제4.model.Board;

public class Front { // Front class s
	
	// 스캐너클래스 객체생성
	Scanner scanner = new Scanner(System.in);
	// Mcontroller 클래스 객체 생성
	Mcontroller mc = new Mcontroller();
	// Bcontroller 클래스 객체 생성
	Bcontroller bc = new Bcontroller();
	// boardList 받기
	ArrayList<Board> result = bc.listNum();
	
	// 1. 메인페이지
	public void index() {
		while ( true ) {
			
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int ch = scanner.nextInt();
			if ( ch == 1 ) { signUp();}
				
			else if ( ch == 2 ) { login();}
				
			else if ( ch == 3 ) {findId();}
				
			else if ( ch == 4 ) {findPassword();}
				
			else { }
			
		}
	}

		
	// 2. 회원가입 페이지
	void signUp() {
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : "); 		String pwd = scanner.next();
		System.out.println("비밀번호확인 : "); 	String confirmpwd = scanner.next();
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		int result = mc.signup( id , pwd , confirmpwd , name , phone  );
		
		if ( result == 1 ) {
			System.out.println("[회원가입 실패]");
		}else if ( result == 0 ) {
			System.out.println("[회원가입 성공]");
		}
		
	}
	
	// 3. 로그인 페이지
	void login() {
		System.out.println("로그인 : ");
		String loginId = scanner.next();
		System.out.println("비밀번호 : ");
		String loginPwd = scanner.next();
		
		int result = mc.login(loginId, loginPwd);
		if ( result >= 0 ) {  
			// result = 0~숫자 -> 로그인성공한 회원 번호
			System.out.println("로그인 성공했습니다. 커뮤니티페이지로 이동합니다.");
			// 로그인 성공화면 출력
			community(result);
		}
		else if ( result == -1 ) { System.out.println("[알림]비밀번호가 다릅니다."); }
		else if ( result == -2 ) { System.out.println("[알림]없는 회원입니다."); }
		else {}
	}
	
	// 4. 아이디 찾기 페이지
	void findId() {
		//입력받음
		System.out.println("이름 : ");
		String findName = scanner.next();
		System.out.println("전화번호 : ");
		String findPhone = scanner.next();
		//입력값을 Mcontroller로 보내기
		String result = mc.findId( findName , findPhone );
		if ( !result.equals("0") && !result.equals("1") ) {
			System.out.println("아이디 찾기 성공! 아이디 : " + result);
		}else if ( result.equals("0")) {
			System.out.println("없는 회원 이름입니다.");
		}else if ( result.equals("1")) {
			System.out.println("전화번호가 일치하지 않습니다.");
		}
		
	}
	
	// 5. 비밀번호 찾기 페이지
	void findPassword() {
		System.out.println("아이디 : ");
		String findId = scanner.next();
		System.out.println("전화번호 : ");
		String findphone = scanner.next();
		String result = mc.findpw(findId,findphone);
		if ( !result.equals("0") && !result.equals("1") ) {
			System.out.println("비밀번호찾기 성공! 비밀번호 : " + result);
		}else if ( result.equals("0") ) {
			System.out.println("존재하지 않는 아이디입니다.");
		}else if ( result.equals("1") ) {
			System.out.println("전화번호가 일치하지 않습니다.");
		}
	}
	
	// 6. 로그인 성공 화면 - 커뮤니티/////////////////////////////////////////
	void community( int i ){
		
		while ( true ) {
			System.out.println("---------- 커뮤니티 ----------");
			System.out.println("번호\t조회수\t작성자\t제목");
			// 글목록출력
				
				for ( int j = 0 ; j < result.size(); j++) {
					if ( result.size() >= 0 ) {
					System.out.println(j+"\t"+result.get(j).view+"\t"+result.get(j).writer+"\t"+result.get(j).title);
					}
				}
			
			
			//메뉴 선택화면 출력
			System.out.println("메뉴> 1.글쓰기 2.글보기 3.로그아웃");
			int no = scanner.nextInt();
			
			// 1.글쓰기
			if ( no == 1 ) {
				write(i);
				
				
				
			// 2.글보기
			}else if ( no == 2 ) {
				if ( result.size() < 1 ) { System.out.println("게시물이 없습니다"); community(i); }
				
				System.out.println("글번호를 입력하시면 상세글페이지로 넘어갑니다.");
				
				// 상세보기,삭제,수정할 글 인덱스 //////////////////
				int linum = scanner.nextInt();
				bc.viewUp( linum );
				postView(linum , i);
				
				
				
				
				
				
			// 3.로그아웃
			}else if ( no == 3 ) {
				// 인덱스 페이지로 돌아가기
				System.out.println("초기화면으로 이동합니다.");
				index();
				
			}
		}
	}; // community 함수 end///////////////////////////////////////////////////////
	
	
	//글쓰기함수
	void write( int i ){
		
		System.out.println("---------- 글쓰기 ----------");
		
		//입력받기
		System.out.println("제목 : ");
		String title = scanner.next();
		System.out.println("내용 : ");
		String content = scanner.next();
		
		//아이디받기
		String id = mc.id(i);
		
		// Bcontroller로 입력값 보내기
		bc.writeSave( title , content , id );
		
		
		//
		community(i);
	}
	
	// 글상세 함수
	// 인덱스 번호를 입력하면 제목,작성자,조회수,내용 보여줌
	void postView(int linum , int i) {
			
			while (true ) {
				System.out.println("---------- 글상세 ----------");
				System.out.println("제목 : " + result.get(linum).title );
				System.out.println("작성자 : " + result.get(linum).writer +"\t"+"조회수 : "+result.get(linum).view);
				System.out.println("내용 : " + result.get(linum).content);
				System.out.println("메뉴> 1.글삭제 2.글수정 3.뒤로가기");
	
				int cnum = scanner.nextInt(); 
				if ( cnum == 1 ) { // 글삭제////////////////////////////////////
									
					//삭제함수 ( 인수 : 삭제할글인덱스 , 현재로그인id ) 
					int result = bc.deleteBoard( linum, mc.id(i) );
					
					if ( result == 0 ) { // 삭제 결과 안내
					System.out.println(">>> 삭제되었습니다."); community(i);
					
					
					} else if ( result == 1 ) { // 삭제 실패 안내
						System.out.println(">>> 작성자만 삭제할 수 있습니다.권한없음");
						
					}
					
					 
				}else if ( cnum == 2 ) { // 글수정 ////////////////////////////////////
					
					
					//수정함수 ( 인수 : 수정할글인덱스 , 현재로그인id ) 
					int result = bc.checkId( linum, mc.id(i) );
					
					if ( result == 0 ) { // 작성자 아이디와 같음
					System.out.println("글 수정내용: ");
					String reContent = scanner.next();
					//글 수정함수 (인수 : 선택한 글 인덱스 , 수정내용 )
					bc.reWrite( linum , reContent );
					
					System.out.println(">>> 글을 수정했습니다."); 
					community(i);
									
					} else if ( result == 1 ) { // 작성자 아이디와 다름
						System.out.println(">>> 작성자만 수정할 수 있습니다.권한없음");
						
					}
					
							
				
				}else if ( cnum == 3 ) { community(i);} // 뒤로가기 ////////////////////////////////////
				
			} // while end
	} // postView end
	
} // Front class end







