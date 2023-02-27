package Day19.Ex2;

public class A extends Thread { // 잘안씀
	@Override
	public void run() {
		while(true) {
			System.out.println( "[ 2. A 스레드 실행중 ] -- A 메소드 스레드 : " + Thread.currentThread()); // 스레드 이름
			try {
				Thread.sleep(1000); // 스레드 1초간 일시정지
			}catch (Exception e) {		}
			
		}
	}

}
