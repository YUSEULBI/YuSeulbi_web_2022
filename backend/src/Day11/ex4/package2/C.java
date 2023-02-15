package Day11.ex4.package2;

import Day11.ex4.package1.A;

public class C {
	
		public void method() {
				
				// 다른 패키지 클래스 protected 객체 생성 불가능
				A a = new A(); 		// X
				a.field = "value"; 	// X
				a.method();			// X
			}
	
}
