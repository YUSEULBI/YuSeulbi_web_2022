package 과제.과제1_연산자문제;

import java.util.Scanner;

public class 과제1_연산자문제 {
	
	public static void main(String[] args) {
		
		// 1번 문제
		System.out.println("|\\_/|\n|q p|  /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__| ");
		
		Scanner scanner = new Scanner( System.in ); // 입력받은 값을 객체에 저장
		
		// 2번 문제
		String 작성자 = scanner.nextLine();
		scanner.nextLine();
		String 내용 = scanner.nextLine();
		scanner.nextLine();
		String 날짜 = scanner.nextLine();
		
		System.out.println("--------------방문록--------------------\n"
				+ "| 순번  | 작성자  | 	내용 	    | 날짜      |\n"
				+ "| 1    | "+작성자+"  | 	"+내용+"	    | "+날짜+"    |\n"
						+ "----------------------------------------");
		
		// 3번 문제
		int 기본급 = scanner.nextInt();
		int 수당 = scanner.nextInt();
		
		double 실수령액 = 기본급 + 수당 ;
		double 세금 = (기본급*0.1);
		실수령액 = 실수령액 - 세금;
		int 실수령액정수 = (int)실수령액;
		System.out.println( 실수령액정수 );
		
		// 4번 문제
		int 금액 = scanner.nextInt();
		int 십만원개수 = (금액/100000);
		int 십만원빼기 = 금액-(십만원개수*100000);
		int 만원개수 = (십만원빼기/10000);
		int 만원빼기 = 십만원빼기-(만원개수*10000);
		int 천원개수 = (만원빼기/1000);
		int 천원빼기 = 만원빼기-(천원개수*1000);
		int 백원개수 = (천원빼기/100);
		
		System.out.printf("4번. 십만원 %d장\n만원 %d장\n천원 %d장\n백원 %d개\n",십만원개수,만원개수,천원개수,백원개수);
		
		// 5번 문제
		int 정수아무거나 = scanner.nextInt();
		String 정수7배수확인 = 정수아무거나%7 == 0 ? "O" : "X";
		System.out.println("5번. 정수7배수확인 : "+정수7배수확인);
		
		// 6번 문제
		int 정수홀짝 = scanner.nextInt();
		String 홀수확인 = 정수홀짝%2 == 1 ? "O" : "X";
		System.out.println("6번. 홀수확인 : "+홀수확인);
		
		// 7번문제
		int 정수홀짝배수 = scanner.nextInt();
		String 짝수와7배수확인 = (정수홀짝배수%7 == 0) && (정수홀짝배수%2==0) ? "O" : "X";
		System.out.println("7번. 짝수와배수확인 : "+짝수와7배수확인);
		
		// 8번문제
		int 정수홀수배수 = scanner.nextInt();
		String 홀수와7배수확인 = (정수홀수배수%7 == 0) && (정수홀수배수%2 == 1) ? "O" : "X";
		System.out.println("8번. 홀수와7배수확인 : "+홀수와7배수확인);
		
		// 9번문제
		int 더큰수정수원 = scanner.nextInt();
		int 더큰수정수투 = scanner.nextInt();
		int 더큰수판별 = 더큰수정수원 > 더큰수정수투 ? 더큰수정수원 : 더큰수정수투;
		System.out.println("9번. 더큰수판별 : " + 더큰수판별);
		
		// 10번문제
		double 반지름 = scanner.nextDouble();
		double 원주율 = 3.14;
		System.out.println( "10번. 원넓이 : " + 반지름*반지름*원주율 );
		
		// 11번 문제
		double 첫번째실수 = scanner.nextDouble();
		double 두번째실수 = scanner.nextDouble();
		System.out.printf( "11번. 앞실수값/뒷실수값 : %10.6f %% \n" , (첫번째실수/두번째실수)*100 );
		
		// 12번 문제
		double 윗변 = scanner.nextDouble();
		double 밑변 = scanner.nextDouble();
		double 높이 = scanner.nextDouble();
		System.out.println("12번. 사다리꼴 넓이 계산 : "+ ((윗변*밑변)*높이)/2 );
		
		// 13번 문제
		int 키 = scanner.nextInt();
		System.out.printf("13번. 표준체중 계산 :  %3.1f \n" , (키-100)*0.9 );
		
		// 14번 문제
		double 두번째키 = scanner.nextDouble();
		double 몸무게 = scanner.nextDouble();
		System.out.printf("14번. BMI계산 : %2.1f \n " , 몸무게/((두번째키/100)*(두번째키/100)) );
		
		// 15번 문제
		double inch = scanner.nextDouble();
		System.out.println( "15번. " + inch*2.54 +"cm");
		
		// 16번 문제
		double 중간고사 = scanner.nextDouble();
		double 기말고사 = scanner.nextDouble();
		double 수행평가 = scanner.nextDouble();
		System.out.printf("16번. 점수 : %3.2f \n" , (중간고사*0.3)+(기말고사*0.3)+(수행평가*0.4));
		
		// 17번 문제
		// x값 = 8 , y값 = 24
		int x = 10;
		int y = x-- + 5 + --x;
		System.out.printf("17번. x의 값 : %d , y의값 :  %d \n", x, y);
		
		// 18번 문제
		int 나이 = scanner.nextInt();
		String 학생성인중년판별 = 나이 >= 10 && 나이 < 20 ? "학생" : 나이 > 19 && 나이 >= 20 && 나이 < 39 ? "성인" :  나이 >= 40 ? "중년" : "아기";
		System.out.println( "18번. 나이판별 : " + 학생성인중년판별 );
		
		// 19번 문제
		double 국어 = scanner.nextDouble();
		double 영어 = scanner.nextDouble();
		double 수학 = scanner.nextDouble();
		int 총점 = (int)(국어+영어+수학);
		double 평균 = (국어+영어+수학)/3;
		
		System.out.printf("19번. 총점 : %d , 평균 : %3.2f" , 총점 , 평균);
		
		// 20번 문제
		String 아이디 = scanner.nextLine();
	}
		
	
}
