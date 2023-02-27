package Day19.Ex4_p611;

public class Calculator { // 계산기
	
	private int memory; // 필드 
	
	// getter setter
	
	public int getMemory() { return memory; } // getter
	
	public synchronized void setMemory( int memory ) { // setter
		this.memory = memory;
		try {
			Thread.sleep(2000); // 해당 메소드 걸리는 시간 추가 ( 코드가 많이 들어가서 시간이 오래걸린다는 가정 )
			
		}catch (Exception e) { 		}
		
		System.out.println( Thread.currentThread().getName() + ":" + this.memory );
	}
	
}
