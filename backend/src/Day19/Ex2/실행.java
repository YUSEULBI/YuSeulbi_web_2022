package Day19.Ex2;

public class 실행 {

	public static void main(String[] args) {
		// 스레드 실행순서는 운영체제가 스케줄링하면서 정함!!!!!!!! 자바가 정할 수 없음. (운영체제와 독립적)
		
		// 1. Thread 자식 클래스로 멀티스레드 구현
		A a  = new A();
		a.start();
		
		// 2. Thread 자식 클래스의 익명(스택이 없다) 객체로 구현
		Thread thread = new Thread( ) {
			@Override
			public void run() {
				while(true) {
					System.out.println( "[ 3. 익명객체 스레드 실행중 ]--- 익명객체 메소드 스레드 : " + Thread.currentThread()); // 스레드 이름
					try {
						Thread.sleep(1000); // 스레드 1초간 일시정지
					}catch (Exception e) {		}
					
				}
			}
			
		};
		thread.start();
		
		// 3. Runnable 인터페이스 구현 객체 구현 //코드가 불편하지만 대규모 확장성이 좋음.
			// 	Runnable은 구현만 함 Start하기 위해서 Thread에게 전달
		Runnable runnable = new B();
		Thread thread2 = new Thread( runnable );
		thread2.start();
		
		// 4. Runnable 인터페이스 익명 객체로 구현
		Thread thread3 = new Thread( new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println( "[ 5. 익명객체2 스레드 실행중 ]----- 익명객체2 메소드 스레드 : " + Thread.currentThread()); // 스레드 이름
					try {
						Thread.sleep(1000); // 스레드 1초간 일시정지
					}catch (Exception e) {		}
					
				}
				
			}
		});
		thread3.start();
		
		
		// 5. main 스레드
		while(true) {
			System.out.println( "[ 1. main 스레드 실행중 ] main메소드 스레드 : " + Thread.currentThread()); // 스레드 이름
			try {
				Thread.sleep(1000); // 스레드 1초간 일시정지
			}catch (Exception e) {		}
			
		}
		
	}// main end
}
