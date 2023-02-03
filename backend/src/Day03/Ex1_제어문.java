package Day03;

import java.util.Random;

public class Ex1_제어문 {
	
	public static void main(String[] args) {
		
		// if형태
			// 1. if( 조건식 ) 실행문;
			// 2. if( 조건식 ) { 실행문; 실행문; }
			// 3. if( 조건식 ){
			//			true
			//		} else {
			//			false
			//		}
			/*
			 * 4. if( 조건식 ){
			 * 			true1
			 * 		} else if ( 조건식2 ){
			 * 			true2
			 * 		} else if ( 조건식3 ){
			 * 			true3
			 * 		} else {  false 	}
			 */
		
		// 1. [p.111]
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score < 90) 
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다."); // if영향에 벗어나서 실행됨
		
		
		// 2. [p.113]
		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다");
			System.out.println("등급은 A입니다.");
			
		} else {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		// 3. [p.114]
		
		//true값 1개 - 속도가 빠름
		if( score >= 90 ) {
			System.out.println( " 점수가 100~90입니다. ");
			System.out.println( " 등급은 A등급 입니다. ");
		} else if ( score >= 80 ) {
			System.out.println( " 점수가 80~89입니다. ");
			System.out.println( " 등급은 B등급 입니다. ");
		} else if ( score >= 70 ) {
			System.out.println( " 점수가 70~79입니다. ");
			System.out.println( " 등급은 C등급 입니다. ");
		} else {
			System.out.println( " 점수가 70미만입니다. ");
			System.out.println( " 등급은 D등급 입니다. ");
		}
		
		//true값 여러개
		if( score >= 90 ) {
			System.out.println( " 점수가 100~90입니다. ");
			System.out.println( " 등급은 A등급 입니다. ");
		} if ( score >= 80 ) {
			System.out.println( " 점수가 80~89입니다. ");
			System.out.println( " 등급은 B등급 입니다. ");
		} if ( score >= 70 ) {
			System.out.println( " 점수가 70~79입니다. ");
			System.out.println( " 등급은 C등급 입니다. ");
		} if ( score < 70 ) {
			System.out.println( " 점수가 70미만입니다. ");
			System.out.println( " 등급은 D등급 입니다. ");
		}
		
		// * [ p.116 ]
		
		int num = (int)(Math.random()*6)+1;  // 정수로 강제 형 변환
		// Math.random()				0~0.9999 실수
		// (Math.random()*6)			0~5.9999 실수
		// (Math.random()*6)+1  		1~6.9999 실수
		// (int)(Math.random()*6)+1; 	1~6 정수 [ 강제 형변환 ]
		
		// Math : 수학 관련 메소드 제공하는 클래스
		// Random : 난수 관련 메소드를 제공하는 클래스
		
		// Random :  
		Random random = new Random();
		// int가 표현가능한 범위 내
		System.out.println( "random.nextInt() : " + random.nextInt() );
		// 0~2까지 [3가지]
		System.out.println( "random.nextInt(3) : " + random.nextInt(3) ); 
		// 0~5까지 [6가지]
		System.out.println( "random.nextInt(6) : " + random.nextInt(6) );
		// 1~6까지 [6가지]
		System.out.println( "random.nextInt(6)+1 : " + random.nextInt(6)+1 );
		
		// 문자난수 만들기 유니코드 임시비밀번호에 이용
		// 소문자 [97 : a] ~ [122 : z]
		System.out.println( random.nextInt(26)+97 ); // 97~122 숫자
		char c1 = (char)(random.nextInt(26)+97); // char 로 강제 형변환 
		System.out.println( c1 );
		
		
		if (num==1) {
			System.out.println("1번이 나왔습니다.");
		} else if (num==2) {
			System.out.println("2번이 나왔습니다.");
		} else if (num==3) {
			System.out.println("3번이 나왔습니다.");
		} else if (num==4) {
			System.out.println("4번이 나왔습니다.");
		} else if (num==5) {
			System.out.println("5번이 나왔습니다.");
		} else {
			System.out.println("6번이 나왔습니다.");
		}
		
		
		// if 중첩
		/* 
		 	if( 조건식 ) {
		 		if (조건식) {
		 		} else {
		 		}
		 	}else{
		 	}
		 	
		*/
		
		// [p.117]
		int score2 = (int)(Math.random()*20) + 81 ; // 81~ 100
		System.out.println( " 점수 : " + score2);
		
		String grade;
		
		if ( score2 >= 90 ) {
			
		
			if ( score >= 95 ) {
			grade = " A+ ";
			} else { grade = "A"; }
			
			// else { if(조건식)
		} else { if (score>=85) {grade = "B+"; } else { grade="B";} }
		
		System.out.println("학점 : " + grade);
		
	}
	
}
