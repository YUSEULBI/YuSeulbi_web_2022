package Day19.Ex4_p611;

public class User1Thread extends Thread {
	private Calculator calculator; // 계산기필드
	public User1Thread() {	// 생성자
		setName("User1Thread");
	}
	
	// setter
	public void setCalculator( Calculator calculator ) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(100);
	}
	
}
