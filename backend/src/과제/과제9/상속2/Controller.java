package 과제.과제9.상속2;

import java.util.ArrayList;

public class Controller {
	
	private static Controller controller = new Controller();
	private Controller() {	}
	public static Controller getInstance() {
		return controller;
	}
	
	private ArrayList<PC주변기기> productDB = new ArrayList<>();
	public ArrayList<PC주변기기> getProductDB(){
		return productDB;
	}
	
	

}
