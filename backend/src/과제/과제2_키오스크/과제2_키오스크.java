package 과제.과제2_키오스크; // 패키지(폴더)명

import java.util.Scanner;

public class 과제2_키오스크 { // 클래스(파일)명

	public static void main(String[] args) { // main start
		
		//입력값 받아서 'scanner' 객체에 저장
		Scanner scanner = new Scanner(System.in);
		
								
		// [재고 전역변수 ] 콜라 10개 , 사이다 8개 , 환타 15개
		byte 콜라 = 10;
		byte 사이다 = 8;
		byte 환타 = 15;
		byte 콜라장바구니 = 0;
		byte 사이다장바구니 = 0;
		byte 환타장바구니 = 0;
		
		//키오스크 메뉴 [ 무한 루프 : 종료없음(24시간 가동) ]
		while ( true ) { // while 시작
			
			//메뉴 안내 , 번호입력 안내
			System.out.print("1. 콜라 2. 사이다 3. 환타 4. 결제 \n");
			System.out.print("번호입력 : ");
			
			// 메뉴선택 값 num 저장
			byte num = scanner.nextByte();
			
			// 1번 콜라 선택시
						if ( num == 1 ) {
							
							// 콜라 재고가 1 이상일 때
							if ( 콜라 > 0 ) {
								
								//콜라재고 1차감
								콜라--;
								콜라장바구니++;
								System.out.println(">>>콜라 재고 : " + 콜라);
								System.out.println(">>>장바구니에 담긴 콜라개수 : " + 콜라장바구니);
							// 콜라 재고가 없을 때  
							} else  {
								System.out.println(">>>콜라 재고가 없습니다.");
							}
							
						// 2번 사이다 선택시
						}else if ( num == 2 ) {
							
							// 사이다 재고가 1 이상일 때
							if ( 사이다 > 0 ) {
								
								//사이다재고 1차감
								사이다--;
								사이다장바구니++;
								System.out.println(">>>사이다 재고 : " + 사이다);
								System.out.println(">>>장바구니에 담긴 사이다개수 : " + 사이다장바구니);
							// 사이다 재고가 없을 때  
							} else  {
								System.out.println(">>>사이다 재고가 없습니다.");
							}
						
						// 3번 환타 선택시
						}else if ( num == 3 ) {
							
							// 환타 재고가 1 이상일 때
							if ( 환타 > 0 ) {
								
								//환타재고 1차감
								환타--;
								환타장바구니++;
								System.out.println(">>>환타 재고 : " + 환타);
								System.out.println(">>>장바구니에 담긴 환타개수 : " + 환타장바구니);
							// 환타 재고가 없을 때  
							} else  {
								System.out.println(">>>환타 재고가 없습니다.");
							}
						
						// 4번 결제 선택시
						}else if ( num == 4 ) {
							
							
							
							//장바구니에 담긴 상품이 있으면
							if ( 콜라장바구니>0 || 사이다장바구니>0 || 환타장바구니>0  ) {
							//현재 장바구니 현황 표시 목록
							System.out.println("-------------------------------------");
							System.out.println("제품명		수량		가격");
							System.out.println("콜라		"	+	콜라장바구니+"		"+ 콜라장바구니*300+"원");
							System.out.println("사이다		"	+	사이다장바구니+"		"+ 사이다장바구니*400+"원" 		);
							System.out.println("환타		"	+	환타장바구니+"		"+ 환타장바구니*500+"원" 		);
							System.out.println("-------------------------------------");
							System.out.println("총 금액"+ (int)(콜라장바구니*300+사이다장바구니*400+환타장바구니*500)+"원");
							System.out.println("-------------------------------------");
							System.out.println("1. 결제 2. 취소");
							System.out.println("메뉴 선택 : ");
							
							} else { System.err.println("장바구니에 담긴 제품이 없습니다."); }
						}else { 
							System.err.println(">>>메뉴번호를 다시입력하세요");
						}
			
		} // while end
		

			
			
		
		
		
	} // main end
	
}
