package Day19.Ex1_p596;

import java.awt.Toolkit;

public class 실행 {

	// p.596
		// main메소드() : 메인 thread 싱글스레드
	public static void main(String[] args) {
		
		// ------------단일 싱글 스레드 ------------------------------------------------------
		// * 소리 코드가 실행되고 출력 코드 실행
		// 1. 소리 코드
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for ( int i = 0 ; i<5 ; i++ ) {
			toolkit.beep(); // 비프음 소리내기 , 비프음소리내기전에 반복문이 끝내서 1번만 소리남.
			try {
				Thread.sleep(500); // 스레드 0.5초 대기상태
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// 2. 출력 코드
		for ( int i = 0 ; i < 5 ; i++ ) {
			System.out.println("띵"); // 비프음이 끝나고 띵이 콘솔에 출력된다.
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// -----------------------------------------------------------------------------
		// ========== 멀티 스레드 =========================================================
		
		//Thread thread = new Thread( new Runnable() {} );
			// 익명 [이름이없는] 구현 객체
		
		// 1. 스레드 객체 생성
		Thread thread = new Thread (  new Runnable() {
			
			// 2. run 메소드를 구현
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for ( int i = 0 ; i < 5 ; i++ ) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					}catch (Exception e) {
						// TODO: handle exception
					} // catch end
				}// for end
				
			} // run end
		}); // 생성자 end 
		thread.start(); // 3. run 메소드 실행

		// 2. 출력코드
		for ( int i = 0 ; i < 5 ; i++ ) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		// ---------------------------------------------------------------------------------------
		// 멀티스레드 구현 2
		System.out.println("------3. 멀티스레드 시작 -----------");
		//  1. 소리출력 (멀티스레드 )
		Thread thread2 = new Sound();
		thread2.start();
		
		// 2. 출력코드
				for ( int i = 0 ; i < 5 ; i++ ) {
					System.out.println("띵");
					try {
						Thread.sleep(500);
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
		
		// ---------------------------------------------------------------------------------------
		// 멀티스레드 구현 3 --- 인터페이스
		System.out.println("------4. 멀티스레드 시작 -----------");
			// 구현객체를 만들어서
		Runnable runnable = new Sound2();
		
			// 스레드에 전달
		Thread thread3 = new Thread(runnable);
		
		thread3.start();
		
		// 2. 출력코드
		for ( int i = 0 ; i < 5 ; i++ ) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
				
				
	} // main end	
	
}
