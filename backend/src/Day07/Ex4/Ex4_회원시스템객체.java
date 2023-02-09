package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템객체 { // class s

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Member[] memberList = new Member[3]; // Member객체 3개를 저장할 수 있는 배열
								//Member객체는 String 2개 저장할 수 있는 클래스
		
		while( true ) { // 무한루프
			
			// *출력
			System.out.println("번호\t회원명\t전화번호");
			for ( int  i = 0 ; i < memberList.length ; i++ ) {
				if ( memberList[i] != null ) {
					System.out.println(i+"\t"+memberList[i].name+"\t"+memberList[i].phone);
				}
			}
			
			System.out.println(" 1.회원등록 2.회원삭제 ");
			int ch = scanner.nextInt();
			if ( ch == 1 ) {
				System.out.println("회원명 : ");
				String inputname = scanner.next();
				
				System.out.println("전화번호 : ");
				String inputphone = scanner.next();
				
				for ( int i = 0 ; i < memberList.length ; i++) {
					if ( memberList[i] == null ) {
						// [x] name +","+ phone;
						// [o] 객체 만들기
						Member member = new Member(); // 1. Member클래스를 가져와서 member객체생성
						member.name = inputname; 	// 2. Member클래스(member)의 필드 name 에 inputname 대입
						member.phone = inputphone;  // 2. Member클래스(member)의 필드 phone 에 inputphone 대입
						memberList[i] = member; 	// 3. Member클래스로 만든 객체member를 Member배열에 넣기
						break;
					}
				}
				
				
				
			}else if ( ch == 2 ) {
				
			}else {
				
			}
			
		}// while end
		
	}// main end
	
} //
