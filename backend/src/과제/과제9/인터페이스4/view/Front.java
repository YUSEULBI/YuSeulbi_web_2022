package 과제.과제9.인터페이스4.view;

import java.util.Scanner;

import 과제.과제9.인터페이스4.비타민필터;
import 과제.과제9.인터페이스4.샤워기;
import 과제.과제9.인터페이스4.수전;
import 과제.과제9.인터페이스4.카본필터;
import 과제.과제9.인터페이스4.필터;
import 과제.과제9.인터페이스4.항균세디먼트필터;

public class Front {
	
	Scanner scanner = new Scanner(System.in);
	
	//샤워기는 필터를 장착안해도 언제든 틀 수 있음.
	수전 수전 = new 샤워기();
	
	public void index() {
		
		System.out.println("-----------------------------");
		System.out.println("          욕실           ");
		System.out.println("-----------------------------");
		while( true ) {
			
			// 필터장착전 / 필터장착후 메뉴문자가 다름
			if ( !(수전 instanceof 항균세디먼트필터)&&!(수전 instanceof 카본필터)&&!(수전 instanceof 비타민필터) )
			{ System.out.println(">> 샤워기틀기[q] / 샤워필터장착[e]"); }
			else { System.out.println(">> 샤워기틀기[q] / 샤워필터교체[e]"); }
			
				//번호 입력값 저장
				String 입력 = scanner.next();
				
				//q입력////////////////////////////////////////////////////////////////////////////
				if ( 입력.equals("Q") || 입력.equals("q")) { 
					수전.수도꼭지를튼다(); //기본샤워기
					
					// 필터를 장착했으면 필터사용횟수차감, 필터소진시 자동교체
					if ( (수전 instanceof 항균세디먼트필터)||(수전 instanceof 카본필터)||(수전 instanceof 비타민필터) ) {
						필터 필터수전 = (필터)수전; // 강제타입변환
						필터 사용된필터수전 = 필터수전.필터누적횟수추가();
						boolean result = 사용된필터수전.필터확인함수(); // 필터소진 true / 남았으면 false
						if (result) {
							System.out.println("-----------------------------");
							System.out.println("-필터를 소진하여 '동일한 필터'로 교체합니다.");
							System.out.println("-----------------------------");
							사용된필터수전.누적횟수초기화();  continue; }	
					}
					
					System.out.println("-----------------------------");
					System.out.println("-샤워기를 10분 사용했습니다.");
					System.out.println("-----------------------------");
				}
				//e입력////////////////////////////////////////////////////////////////////////////
				else if ( 입력.equals("E") || 입력.equals("e")) { 필터장착(); }
				
				//잘못입력////////////////////////////////////////////////////////////////////////////
				else {
					System.out.println("-----------------------------");
					System.out.println("-잘못된 입력입니다.");
					System.out.println("-----------------------------");
					
				}//if end
					
		}// while end
		
	}// index end
	
	
	public void 필터장착() {
		System.out.println("-장착할 필터를 골라주세요");
		System.out.println(">> 1.항균세디먼트필터 2.카본필터 3.비타민필터");
		int no = scanner.nextInt();
		if ( no == 1 ) { 수전 = new 항균세디먼트필터(3); System.out.println("[항균세디먼트 필터가 장착되었습니다.]");	}
		else if ( no == 2 ) { 수전 = new 카본필터(4);  System.out.println("[카본 필터가 장착되었습니다.]");	}
		else if ( no == 3 ) { 수전 = new 비타민필터(5);  System.out.println("[비타민 필터가 장착되었습니다.]");	}
		
		System.out.println("-이제 깨끗한 물을 사용할 수 있습니다.");
		System.out.println("-----------------------------");

	}
	

}
