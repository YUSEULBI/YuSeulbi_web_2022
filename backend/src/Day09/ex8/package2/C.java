package Day09.ex8.package2;

import Day09.ex8.package1.A;

public class C {
	
	// 1. A클래스가 public 일때
	A a; // 가능 : 같은 패키지 아니지만 import해서 가능
	
	// 2. A클래스가 public 아닐때
		// 불가능 : default 같은 패키지만 가능
	
	
	A a1 = new A(true); // public 가능
	//A a2 = new A(1); default 다른 패키지일 경우 불가능
	//A a3 = new A("문자열"); private X
	
	public static void main(String[] args) {
		A a4 = new A(true);
		a4.field1 = 10; // public O
		// a4.field2 = 10; default X
		// a4.field3 = 10; default X
	}
}
