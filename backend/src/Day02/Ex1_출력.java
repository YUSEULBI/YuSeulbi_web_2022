package Day02; // 현재 클래스가 존재하는 패키지

// ! : 자바는 무조건 class 단위
	// 자바 100% 객체지향
	// 클래스 기반으로 메모리 할당 : 객체
	// 클래스 : 객체 설계도
public class Ex1_출력 { // class s
			
		// * main 함수 : main 스레드 [ 스레드 : 프로세스 내에서 작업을 수행하는 주체 ]
		public static void main(String[] args) { // main 
			// [p.67] syso ctrl spacebar
			System.out.println("");
				// System : 시스템 관련 클래스 [ 관련 메소드 제공 ]
					// out : 출력 vs in : 입력
						// printIn() : [출력] + [줄바꿈처리]
						// print() : 출력만
						// printf() : 형식 출력
			// 2. print()
			System.out.print("print함수");
			System.out.print("print함수"); //줄바꿈안됨
			
			// 3. 
			System.out.println("printIn 함수");
			System.out.println("printIn 함수"); // [출력] + [\n]
			
			// 4. [p69] printf( "형식문자열" , 값 )
			/*
			 * 형식 문자열
			 * 		%d : 정수
			 * 			%자릿수d  	예) %6d - 6칸사용 , 자릿수에 데이터 없으면 공백처리, 오른쪽정렬 
			 * 			%-자릿수d  	예) %-6d - 6칸사용 , 왼쪽부터 출력 , 데이터+공백
			 * 			%0d  		예) %06d - 6칸사용 , 공백을 0으로 채움
			 * ---------------------------------------------------------
			 * 		%f : 실수
			 * 			%소수점자릿수f  예) %.1f %.2f 소수점 최대 16자리
			 * 			
			 * 		%s : 문자열
			 * 	
			 */
			int value = 123; /* int 자료형인 value 변수명 선언 , 123 값 대입 저장*/
			System.out.println("상품의 가격 : " + value + "원");
			System.out.printf("상품의 가격 : %d원\n" , value);
			System.out.printf("상품의 가격 : %6d원\n" , value); // 정렬
			System.out.printf("상품의 가격 : %-6d원\n" , value); // 정렬
			System.out.printf("상품의 가격 : %06d원\n" , value); // 정렬
			
			double area = 3.14159; 
			System.out.println("파이출력 : " + area);
			System.out.printf("파이출력 : %f \n" , area );
			System.out.printf("파이출력 : %.1f \n" , area );
			System.out.printf("파이출력 : %.2f \n" , area );
			System.out.printf("파이출력 : %.3f \n" , area );
			System.out.printf("파이출력 : %.4f \n" , area );
			
			String name = "홍길동";
			String job = "도적";
			System.out.printf("%6d | %-10s | %10s \n" , 1 , name , job);
			
			
		}
		
		
} // class e




/*
  
 	String : 문자열 클래스
 	System : 시스템 클래스
 	
 	제어 / 이스케이프 문자
 			\n : 줄바꿈
 			\t : 들여쓰기
 			\" : " 출력
 			\' : ' 출력
 
*/