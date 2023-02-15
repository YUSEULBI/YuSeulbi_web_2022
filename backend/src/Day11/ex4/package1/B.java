package Day11.ex4.package1;

public class B {
	
	
	public void method() {
		
		// 같은 패키지내 클래스 protected 호출가능
		A a = new A();
		a.field = "value";
		a.method();
	}
	
}
