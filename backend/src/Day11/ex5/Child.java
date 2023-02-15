package Day11.ex5;

public class Child extends Parent {
	
	public String job;
	
	@Override
	public void mathod2() {
		System.out.println("자식이 부모메소드2 재정의");
	
	}
	
	public void mathod3() {
		System.out.println("자식메소드3");
	
	}
	
	
}
