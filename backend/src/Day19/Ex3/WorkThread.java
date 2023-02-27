package Day19.Ex3;

public class WorkThread extends Thread {
						// 1. 스레드 클래스에게 상속받기
	public boolean work = true; // 필드
	
	public WorkThread( String name ) { // 생성자
		setName(name); //스레드 이름 변경
	}
	
	@Override
	public void run() { // 메소드 : 스레드 클래스에게 상속받은 run메소드 오버라이드
		while(true) {
			if( work ){
				System.out.println(getName()+" : 작업처리 ");
			}else {
				Thread.yield();
			}
		} // while end
	}// run end
	
}
