package Day04;

import java.util.Scanner; // Scanner import

public class Ex2_예금 { // 클래스 시작
	
	public static void main(String[] args) { // 메인 시작
		
		// Scanner 클래스
		Scanner scanner = new Scanner(System.in);
		
		// 전역변수 [ 누적 ] * 예금액,계좌번호,비밀번호는 계속 보관해야 함.
		int balance = 0; String account = "123-12345"; short password = 1234;
		
		while( true ) { // 무한루프 시작 [ 종료조건 : 4 입력 ]
			
			System.out.println("-----------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료 : ");
			System.out.println("-----------------------");
			System.out.print(">> 선택 : ");
			int ch = scanner.nextInt();
			//---------------------------------------------------------
			if ( ch == 1 ) {
				System.out.print(">>> 예금할 계좌번호 : ");
				String inaccount = scanner.next();
				if ( account.equals(inaccount) ) { // 만약에 계좌번호와 입력받은 계좌번호값이 같으면
					
					System.out.print(">>>예금할 금액 : ");
					balance += scanner.nextInt();
					System.out.println(" >>> 예금후 금액 : " + balance );
					
				}else {
					System.out.println(">>>없는 계좌번호 입니다. ");
				}
							
			}
			//---------------------------------------------------------
			else if ( ch == 2 ) { // 2번 출금 ///////////////////////////
				System.out.print(">>>출금할 계좌번호 : ");
				String inaccount = scanner.next();
				
				//계좌번호 확인/////////////
				if ( account.equals(inaccount) ) {
					System.out.print(">>>계좌 비밀번호 : ");
					short inpassword = scanner.nextShort();
					
					//비밀번호 확인////////////////
					if ( password == inpassword ) { 
						
						System.out.print(" >>>출금할 금액 : ");
						
						// 출금요청액을 int형 변수pay에 저장
						int pay = scanner.nextInt();
						
						// 잔액비교 - [요청출금액 < 잔액] -> 출금 //////////////////
						if ( balance > pay ) {
							balance -= pay;
							System.out.println(" >>> 출금후 금액 : " + balance );
							
						} else { // [요청출금액 > 잔액] -> X
							System.out.println(">>>잔액부족 : " + balance);
						} // 잔액비교 end ////////////////////////////////
						
					
					//비밀번호틀림////////////
					}else {
						System.out.println("해당 계좌 비밀번호가 틀렸습니다.");
					} // 비밀번호확인 end ////////////////////////////////
					
				//계좌번호틀림///////////////
				} else {
					System.out.println(">>>없는계좌번호입니다.");
				} // 계좌번호 확인 end //////////////////////////////
				
			} // 2번 출금 end ///////////////////////////////////////
			// 3번 ///////////////////////////////////////////////
			else if ( ch == 3 ) {
				System.out.println(">>>예금 잔액 : " + balance );
				
			} // 3번 end /////////////////////////////////////////// 
			// 4번  ///////////////////////////////////////////////
			else if ( ch == 4 ) { System.out.println(">>>종료"); break; }
			else { System.out.println( " >>> 알수없는 번호입니다. [ 다시입력 하세요 ]"); }
			
			
		} // 무한루프 끝
		
	} // 메인 끝
	
} // 클래스 끝


/*
  1. if 중첩
  
  2. 비교연산자 , equals
   
  	자료형[char] == 
  
  	클래스[String]
  	클래스.equals
  	
  	 : 객체A.equals(객체B)
  	 
  	"안녕".equals("안녕")
  	 
 */
