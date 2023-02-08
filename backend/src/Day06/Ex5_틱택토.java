package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 { // class s
	
	public static void main(String[] args) { // main s
		/*	
		 	게임 끝내는 법 3가지
			break game;
			return; main 함수종료
			
			if ( 결과 == true ) { break; }
			결과 = true;
		*/
		///승리판단 나 두고 컴퓨터 둘때마다 승리판단해야함!!!! 지금은 패스~
		
		// *입력객체
		Scanner scanner = new Scanner(System.in);
		
		
		
		// 1. 배열선언 : 자료형타입[ ] 배열명 = { 데이터1 , 데이터2 , 데이터3 };
		// * 게임판 9칸 문자열 선언
		String[] 게임판 = { 
				
				"[ ]" , "[ ]" , "[ ]" , 
				"[ ]" , "[ ]" , "[ ]" ,
				"[ ]" , "[ ]" , "[ ]" 		};
		
		
		// * 전역변수 - 승리판단 결과 저장
		boolean 결과 = false; // false 결과판단 없다.
		
		// 3. 알두기 
		game : while (true) { // while start
			
			//---------게임판출력-------------------------
			// 2. 배열호출
			for ( int i = 0 ; i < 게임판.length ; i++ ) {
				System.out.print( 게임판[i] );
				
				// 인덱스 기준 2 ,5 ,8일 때 줄바꿈
				if ( i%3 == 2 ) {
					System.out.println(); }
			}
			
			//---------------------------------------
			
			//---------------3. 플레이어 알두기--------------
			
			while ( true ) { // 플레이어가 정상적으로 알 둘때까지 [ 정상 알둘때까지 ] 반복 , 정상알두면 break
				System.out.println("위치 0~8 선택 : ");
				int 위치 = scanner.nextInt();
			
				// 	유효성검사 1. 0~8 사이 2. 알이 이미 있는 위치있으면 --> 다시입력
				if ( 위치 < 0 || 위치 > 8 ) { 
					System.err.println("[알림]허용범위내 입력해주세요."); continue; }
				
				if ( !게임판[위치].equals("[ ]")) { //2. 공백이 아니면! 다시입력
					System.err.println("[알림]이미 알이 존재하는 위치입니다."); continue; } 
				
				게임판[위치] = "[O]";
				
				break;
				
			} // while end
			
			// 결과가 존재하면 게임종료
			//if ( 결과 == true ) { break; }
			// 승리판단 여기 복붙하면 무승부 잘 돌아감 /////////////////////////////////
			
			// ------------------4.컴퓨터 알두기-----------------
			
			while ( true ) { // 무한루프 / [종료조건 : 정상적인 난수 생성될 때 break ]
				Random random = new Random(); // 난수 관련된 메소드 제공
				int 위치 = random.nextInt(9); // 0~8
				if ( !게임판[위치].equals("[ ]")) { continue; }
				게임판[위치] = "[X]"; break;
			} // while end
			
			//-----------------5.승리자판단 [ 1.사람승리 2.컴터승리 3.무승부 ]-------------------
			
			// 승리자
			
			// 0 1 2
			// 3 4 5
			// 6 7 8
			// 사람승리 "[O]"
			// 가로승리  0 1 2 , 3 4 5 , 6 7 8
			// 세로승리  0 3 6 , 1 4 7 , 2 5 8
			// 대각선승리 0 4 8 , 2 4 6
			
			//게임판[0] == "[O]" && 게임판[1] == "[O]" && 게임판[3] == "[O]"
			//게임판[3] == "[O]" && 게임판[4] == "[O]" && 게임판[5] == "[O]"
			//게임판[6] == "[O]" && 게임판[7] == "[O]" && 게임판[8] == "[O]"
			
			for ( int i = 0 ; i <=6 ; i+=3 ) {
				if ( !게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+1]) && 게임판[i].equals(게임판[i+2])  ) {
					System.out.println("승리자 : " + 게임판[i]);
					break game;
					// return; main 함수종료
					// 결과 = true;
				}
			}
			//게임판[0] == "[O]" && 게임판[3] == "[O]" && 게임판[6] == "[O]"
			//게임판[1] == "[O]" && 게임판[4] == "[O]" && 게임판[7] == "[O]"
			//게임판[2] == "[O]" && 게임판[5] == "[O]" && 게임판[8] == "[O]"
			for ( int i = 0 ; i <= 2 ; i++ ) {
				if ( !게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6]) ) {
					System.out.println("승리자 : " + 게임판[i]);
					break game;
				}
			}
			
			if ( ( !게임판[0].equals("[ ]") && 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8]) ) || 
					( !게임판[2].equals("[ ]") && 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6]) ) ) {
				System.out.println("승리자 : " + 게임판[4]);
				break;
			}
			
			
			// 무승부 : 알이 9개
			int 빈자리수 = 0;
			for ( int i = 0 ; i<게임판.length ; i++ ) {
				if ( 게임판[i].equals("[ ]") ) 빈자리수++;
			}
			if ( 빈자리수 == 0 ) { 
				결과 = true;
				System.out.println("무승부"); break;
			}
			
		} // while end // 게임끝
		
		
		
		
	} // main e

} // class e
