package Day07;

import java.util.Scanner;

public class Ex1_회원시스템_배열 { // class start
	
	public static void main(String[] args) { // main start
		
		//입력객체
		Scanner scanner = new Scanner(System.in);
		
		// 문자열 [String] 3개를 저장할 수 있는 배열 선언 [ 기본값 : null ]
		// 기본값 초기화 { null , null , null }
		String[] memberList = new String[3];  // 고정길이 3개
		
		//반복문
		while ( true ) { // 무한루프 [ 종료조건 : 없음 ]
			
			// 회원배열내 회원데이터 출력
			System.out.println("번호\t회원명\t전화번호");
			for ( int i = 0 ; i < memberList.length ; i++ ) {
				if ( memberList[i] != null) {
					
					String[] member = memberList[i].split(","); // { "유재석" , "010-1234-5678" }
					System.out.println(memberList[i]);
					System.out.println(i+"\t"+member[0] +"\t"+member[1]);
				}
			}
			
			//회원등록
			System.out.println("1.회원등록 2.회원삭제 : ");
			int ch = scanner.nextInt(); // 입력값 저장변수
			
			//1번 회원등록
			if ( ch == 1 ) {
				System.out.print("회원명 : ");
				String name = scanner.next();
				
				System.out.print("전화번호 : ");
				String phone = scanner.next();
				
				// 배열의 빈공간[null] 을 찾아서 memberList배열에 대입
				for( int i = 0 ; i < memberList.length ; i++) {
					if ( memberList[i] == null ) { // if start
						memberList[i] = name+","+phone; // 이름과 전화번호를 하나의 문자열로 합침
						System.out.println(i+"번 회원이 등록되었습니다. 정보 : " + memberList[i] );
						
						break; // 저장이되면 반복문종료( 종료안하면 배열의 모든 null에 저장시킴 )
					} // if end
				} // for end
				
				
			//2번 회원삭제
			}else if ( ch == 2 ){
				
				System.out.println(" 삭제할 번호[인덱스] :  ");
				int no = scanner.nextInt();
				memberList[no] = null;
				
				//빈자리 [ null ] 채우기 [ 삭제된 인덱스 뒤로 한칸씩 당기기 ]
				for ( int i = no ; i < memberList.length ; i++ ) { // 삭제된 자리부터
					if ( i+1 == memberList.length ) { // 마지막 인덱스 이면
						memberList[i]=null; break;} // 마지막인덱스는 i+1 안되기 때문에 null넣고 break
					memberList[i] = memberList [ i + 1 ]; // 앞자리로 땡기기
					if ( memberList[i+1] == null ) break; // 다음 인덱스가 null이면 땡길필요가없어서 break;
				}
				
			// 1,2번 외 입력값
			}else {
				
				
			}
			
			
		} // while end
		
	} // main end

} // class end
