package Day19.Ex4_p611;

public class User2Thread extends Thread {

	private Calculator calculator; // 필드
	public User2Thread() { // 생성자
		setName("User2Thread");
	}
	
	// setter
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
	
}
