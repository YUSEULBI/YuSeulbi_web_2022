package 팀플2.model;

public class 수강내역Dao {
	
	private static 수강내역Dao dao = new 수강내역Dao();
	private 수강내역Dao() { 	}
	public static 수강내역Dao getInstance() {
		return dao;
	}
	
	
	
}
