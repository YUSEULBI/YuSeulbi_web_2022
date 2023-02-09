package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_회원시스템_컬렉션프레임워크 { // class start
	
	public static void main(String[] args) { // main s
		
		Scanner scanner = new Scanner(System.in);
		
		// 배열 대신 컬렉션 프레임워크
		ArrayList<Member> memberList = new ArrayList<>(); // 가변길이 !!!
		// 리스트  <제네릭>
		// ArrayList : 리스트 선언 사용되는 클래스
		// <자료형=클래스/타입> : 리스트 안에 들어갈 항목의 자료형=클래스
		
		
		while ( true ) {
			
			// 배열명.length : 배열내 길이 		[ 고정길이 ]
			// 리스트명.size() : 리스트내 요소 개수 [ 가변길이 ]
			System.out.println("번호\t회원명\t전화번호");
			for ( int i = 0 ; i < memberList.size(); i++ ) { // 데이터가 없으면 0 [ 가변 ] / 배열은 정해놓은 배열길이만큼 돈다. / ArrayList 메모리 효율성이 좋음 
				System.out.println(i + "\t" + memberList.get(i).name + "\t" + memberList.get(i).phone );
			}
				
			
			//배열은 forEach [X] / 컬렉션프레임워크는 forEach[o]
			/*
			 * memberList.forEach( ( o ) -> { System.out.println( o ); } );
			 */ // js (인수) => {실행문} : 익명화살표함수 / java (인수)->{실행문;}
			
			
			System.out.println("1.회원등록 2.회원삭제 : ");
			int ch = scanner.nextInt();
			if ( ch == 1 ) {
				System.out.println("회원명 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				
				Member member = new Member();
				// 객체생성
				member.name = name;
				member.phone = phone;
				memberList.add(member); // 리스트에 객체 추가 // js : push()
							
			}else if ( ch == 2 ) {
			
				System.out.println("삭제할번호/인덱스 : ");
				int no = scanner.nextInt();
				memberList.remove(no);
				
				
			}else {}
		}
		
	} // main end

} //class end
