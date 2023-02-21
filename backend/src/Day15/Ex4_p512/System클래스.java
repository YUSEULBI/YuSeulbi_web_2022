package Day15.Ex4_p512;

public class System클래스 {
	
	public static void main(String[] args) {
		
		System.out.println("출력"); // 콘솔 출력
		System.err.println("에러"); // 콘솔에 에러 출력 // 속도차이가 있어서 err가 먼저 출력나오는경우가 있음 안쓰는게...
		
		int value = 100; // int 100 대입 가능 정수니까~
		//int value2 = "100"; // int에 문자 "100"은 대입 불가능 문자니까~
			// 문자열 --> 기본타입으로 변환
		int value3 = Integer.parseInt("100"); // "100" -> 100변환
		
		try { // 예외(오류)가 발생할 것 같은 코드를 try 안에 넣음 [ 경험적인 짐작이 필요 ]
			int value4 = Integer.parseInt("1oo"); // "1oo"는 문자임 int로 못바꿈
		}
		catch (Exception e) { // try{} 에서 예외(오류)가 발생했을때 catch{}실행
			System.err.println("에러내용");
			System.err.println(e.getMessage());
		}
		
		
		
		
		// p514 예제
		
		int speed = 0 ;
		int keyCode = 0;
		
		while (true) {
			
			if ( keyCode != 13 && keyCode != 10 ) { // 엔터[]가 아니고
				if ( keyCode == 49 ) { // 숫자1 코드 = 49
					speed++;
				}else if ( keyCode == 50 ) { // 숫자2코드 = 50
					speed--;
				}else if ( keyCode == 51 ) { // 숫자3코드 = 51
					//break; // while문 탈출
					
					//프로그램종료
					System.exit(0); // 0:정상종료 / 1 or -1 : 비정상종료 / 관례적으로 통함
				}
				System.out.println("현재 속도 : "+speed);
				System.out.println("1.증속 2.감속 3.중지");
			}
			
			
			try {
				keyCode = System.in.read(); //입력받기 코드로 반환됨 [*예외처리필수]
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
		}// while end
		
		
		
	}
	
}
