package 과제.과제9.상속3;

public class Controller {
	
	private static Controller controller = new Controller();
	private Controller() { 	}
	public static Controller getInstance() {
		return controller;
	}
	
	private int i = 0;

	
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	
	

}
