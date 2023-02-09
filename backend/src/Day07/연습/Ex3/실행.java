package Day07.연습.Ex3;

import java.util.Scanner;

public class 실행 { ////////////// 객체 + 배열

	public static void main(String[] args) { // main s
		
		// 배열만들기
		Member[] memberList = new Member[3];
	
		Scanner scanner = new Scanner(System.in);
		
		while ( true ) {
			
			//콘솔에 출력
			for ( int i = 0 ; i < memberList.length ; i++ ) {
				if ( memberList[0] == null ) { break; }
				if ( memberList[i] != null ) {
					if ( i+1 != memberList.length ) {
						memberList[i] = memberList[i+1];
					}
					System.out.println(i+"\t"+ memberList[i].name + "\t" + memberList[i].phone);
				}
				
			}
			
			
			System.out.println("1.회원등록 2. 회원삭제");
			int no = scanner.nextInt();
			
			if ( no == 1 ) {
				// 입력받아서 객체생성 객체에담기
				System.out.println("이름 : ");
				String inputname = scanner.next();
				System.out.println("전화번호 : ");
				String inputphone = scanner.next();
				
				// 객체를 Member 필드에 담기
				Member member = new Member();
				member.name = inputname;
				member.phone = inputphone;
				
				// 배열에 담기 , 배열 콘솔에출력
				for ( int i = 0 ; i < memberList.length ; i++ ) { 
					memberList[i] = member;
					break;
				}
				
			} else if ( no == 2 ) { // 삭제
				
				System.out.println("삭제할 인덱스 : ");
				int index = scanner.nextInt();
				memberList[index] = null;
				
				
			} else { }
		
		}
		
	} // main e
	
}
