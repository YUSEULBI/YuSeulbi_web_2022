package Day13.ex4_p365;

public class 실행 {
	
	public static void main(String[] args) {
	
		// 구현객체만들기
		InterfaceCImpl impl = new InterfaceCImpl();
		
		// 인터페이스 변수에 구현객체 대입
		InterfaceA ia = impl;
		ia.methodA();
		// ia.methodB(); InterfaceC 자식 안됨 옆사람 B안됨
		// ia.methodC();
		
		
		// 
		InterfaceB ib = impl;
		//ib.methodA(); 	// 옆사람 A 안됨
		ib.methodB(); 		// 본인 됨
		// ib.methodC(); 	// 자식 안됨
		
		//
		InterfaceC ic = impl;
		ic.methodA(); // 부모 가능
		ic.methodB(); // 부모 가능
		ic.methodC(); // 본인 가능
		
	}
	
	


}
