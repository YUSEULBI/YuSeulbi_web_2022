package Day15.Ex3_p504;

public class Smartphone {
	
	private String company;
	private String os;
	
	
	public Smartphone(String company, String os) {
		super();
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() { // 또는 override에서 object의 toString눌러서 불러도됨.
		// TODO Auto-generated method stub
		return company+","+os;
	}
	
	
	
}
