package Day19.Ex2;

public class B implements Runnable { //코드가 불편하지만 대규모 확장성이 좋음.
	@Override
	public void run() {
		while(true) {
			System.out.println( "[ 4. B 스레드 실행중 ]---- B메소드 스레드 : " + Thread.currentThread()); // 스레드 이름
			try {
				Thread.sleep(1000); // 스레드 1초간 일시정지
			}catch (Exception e) {		}
			
		}
		
	}
}
