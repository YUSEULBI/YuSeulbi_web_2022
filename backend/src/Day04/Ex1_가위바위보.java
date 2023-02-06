package Day04; // 패키지

import java.util.Random;
import java.util.Scanner; // 해당 클래스를 사용하기 위한 패키지로 부터 클래스 가져오기

public class Ex1_가위바위보 { // 클래스 시작
	
	public static void main(String[] args) { // 메인 시작
		
		// 3. 입력객체
		// 클래스 위에 import 꼭 필요 -> Scanner 자동완성해야함.
		Scanner scanner = new Scanner(System.in);
		
		// 9. [전역변수] / 변수의 사용범위 : '지역변수' 특징 { } 밖으로 못나감
		int pwin = 0;	int cwin = 0;	int play = 0;
			// * while 안에서 선언된 변수는 반복문 돌때마다 초기화됨. 누적안됨
		
		while(true) { // 1. 무한루프 [ 종료조건 : 3번 입력 ]
			// 2. 출력 : syso ctrl spacebar
			// System은 java.lang -> import 안해도됨 기본임
			System.out.print(" 1. 가위(0) 바위(1) 보(2) 종료(3)");
			
			// 4. 입력 : Scanner 클래스 -> scanner 객체 필요 !!
			// scanner.nextInt(); // 입력받은 데이터를 scanner로 가져와서 int형으로 변환
			
			// 5. 저장 : [변수]에 저장
			// 입력받은 데이터를 scanner로 가져와서 byte형으로 변환해 변수에 저장
			byte player = scanner.nextByte();
			System.out.println("player 낸수 : " + player);
			
			// 6. 제어문[흐름제어] : 경우의수 , 흐름변화를 위해 필요시 사용
			// [경우의수] -> 정상입력 ( 0~2 ) , 종료 (3) -> 2가지 경우 -> if문
			if ( player == 3 ) {
				System.out.println("-- 종료 , 플레이수 : " + play);
				
				// 10 . 최종승리
				if ( pwin > cwin ) {System.out.println("player 최종승리 " + pwin);}
				else if ( pwin < cwin ) {System.out.println("com 최종승리 " + cwin);}
				else { System.out.println(" 최종 무승부 ");}
				
				break; // 반복문 탈출
			}
			
			// 0 , 1 , 2 , 3 외에 수를 입력하는 경우 막는 건 추후에 배움
			
			// 7. 난수 생성 [ 1. Math클래스 2.Random클래스 ]
			Random random = new Random();
			int com = random.nextInt(3); // 0~2 사이의 int형 난수 생성
			System.out.println(" >> com 낸수 : " + com);
			
			// 8. 승리자 판단
			// [경우의수]
			// [ player 이기는 수 ]
			// p: 0 , c : 2
			// p: 1 , c : 0
			// p: 2 , c : 1
			
			// [ com 이기는 수 ]
			// p: 0 , c : 1
			// p: 1 , c : 2
			// p: 2 , c : 0
			
			// [ 비기는 수 ]
			// p: 0 , c : 0
			// p: 1 , c : 1
			// p: 2 , c : 2
			if ( 
					( player == 0 && com == 2 ) || 
					( player == 1 && com == 0 ) || 
					( player == 2 && com == 1 ) ) {
				System.out.println(" >>>> player winner "); pwin++;
				
			} else if ( player == com ) {
				System.out.println(" >>>> draw "); 
				
			} else { System.out.println(" >>>> com winner "); cwin++; }
			
			play++;
			
		} // while문 end 
		
	} // 메인 끝

} // 클래스 끝


/*
	1 . 승리자판단
	2 . 지역변수 특징
	3 . Scanner 클래스 , Random 클래스
 */
