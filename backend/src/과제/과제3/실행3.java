package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행3 { // class start

	public static void main(String[] args) { // main start
		
		// 스캐너 클래스
		Scanner scanner = new Scanner(System.in);
		
		// ArrayList 클래스
		ArrayList<Book> bookList = new ArrayList<>();
		
		ArrayList<Member> memberList = new ArrayList<>();

		
		while ( true ) { // while s
			
			System.out.println("1.로그인 2.회원가입");
			System.out.println("메뉴 번호: ");
			int ch = scanner.nextInt();
			
			// 1. 로그인페이지
			if ( ch == 1 ) {
				System.out.println("--------로그인페이지--------");
				System.out.println(">> 아이디 : ");
				String inputid = scanner.next();
				System.out.println(">> 비밀번호 : ");
				String inputpw = scanner.next();
				
				int count = 0;
				int memberListindex = 0;
				for ( int i = 0 ; i < memberList.size() ; i++ ) {
					
					if ( memberList.get(i).id.equals(inputid) && memberList.get(i).password.equals(inputpw)  ) {
						count++;
						memberListindex = i;
					}
				}
				
				if ( count == 1 ) {
					System.out.println("로그인성공했습니다.");
					////////////////////////////////////////////////////////////////////////////////
					while ( true ) {
						// 도서초기메뉴
						System.out.println("--------------- 이젠 도서관 ---------------");
						System.out.println("번호\t대여여부\t도서장르\t도서명\t대여자아이디");
						for ( int i = 0 ; i < bookList.size() ; i++ ) {
							String 대여여부글자 = "대여가능";
							if ( bookList.get(i).도서대여여부 == false ) {
								대여여부글자 = "대여불가능";
							}
							String 아이디 = " ";
							if ( bookList.get(i).member == null ) {
								아이디 = "대여자없음";
							}else {
								아이디 = bookList.get(i).member.id;
							}
							System.out.println(i+"\t"+대여여부글자+"\t"+bookList.get(i).도서장르+"\t"+bookList.get(i).도서명+"\t"+아이디);
							
						}
						System.out.print(memberList.get(memberListindex).id + "님의 대여목록:");
						for ( int i = 0 ; i < memberList.get(memberListindex).rentList.size(); i++) {
							if ( memberList.get(memberListindex).rentList != null ) {
								System.out.print(memberList.get(memberListindex).rentList.get(i).도서명);
							}
							if ( i+1 < memberList.get(memberListindex).rentList.size() ) { System.out.print(","); }
						}
						System.out.println();
						
						
						
						
						System.out.println(">>> 1.도서대여 2.도서반납 3.도서등록[관리자]");
						int no = scanner.nextInt();
						
						// 1. 도서대여
						if ( no == 1 ) { 
							System.out.println("---------------대여페이지---------------");
							System.out.println(">>>대여할 도서번호 : ");
							int bookNum = scanner.nextInt();
							if ( bookList.get(bookNum).도서대여여부 == true ) {
								bookList.get(bookNum).도서대여여부 = false;
							}else if ( bookList.get(bookNum).도서대여여부 == false ) {
								System.out.println("이미 대여중인 도서입니다. 대여불가");
								
							}
							// 북리스트의 booknum인덱스의 member 에 멤버 대입 
							bookList.get(bookNum).member = memberList.get(memberListindex);
							memberList.get(memberListindex).rentList.add(bookList.get(bookNum));
							//System.out.println(memberList.get(memberListindex).rentList.get(0).도서명);
							
						// 2. 도서반납	
						}else if ( no == 2 ) {
							System.out.println("---------------반납페이지---------------");
							System.out.println(">>>반납할 도서번호 : ");
							int returnBookNo = scanner.nextInt();
							if ( bookList.get(returnBookNo).도서대여여부 == false ) {
								bookList.get(returnBookNo).도서대여여부 = true;
							} else if ( bookList.get(returnBookNo).도서대여여부 == true ) {
								System.out.println("대여중인 도서가 아닙니다.");
							}
							bookList.get(returnBookNo).member = null;
							memberList.get(memberListindex).rentList.remove(bookList.get(returnBookNo));
							
							
						// 3. 도서등록[관리자]
						}else if ( no == 3 ) {
							System.out.println("---------------등록페이지---------------");
							System.out.println("도서명 : ");
							String 도서명 = scanner.next();
							System.out.println("장르 : ");
							String 장르 = scanner.next();
							
							// Book 클래스
							Book book = new Book();
							book.도서명 = 도서명;
							book.도서장르 = 장르;
							book.도서대여여부 = true;
							book.member = null;
	
							bookList.add(book);
							
							
						} else { 
							System.out.println("---------------없는페이지---------------");
						}
					}
					/////////////////////////////////////////////////////////////////////////////////
				}
				if( count == 0 ) {
				System.out.println("로그인실패했습니다.");
				continue;
				}
				
				
			// 2. 회원가입페이지	
			}else if ( ch == 2 ) {
				System.out.println("--------회원가입 페이지--------");
				
				System.out.println(">> 아이디 : ");
				String id = scanner.next();
				System.out.println(">> 비밀번호 : ");
				String password = scanner.next();
				System.out.println(">> 이름 : ");
				String name = scanner.next();
				System.out.println(">> 전화번호 : ");
				String phone = scanner.next();
								
				Member member = new Member();
				member.id = id;
				member.password = password;
				member.name = name;
				member.phone = phone;
				
				memberList.add(member);
				System.out.println("회원가입이 완료되었습니다.");
				continue;
			}else {
				System.out.println("--------없는 페이지--------");
				
			}
			
			
		
		}// while end
	} // main end
	
} // class end
