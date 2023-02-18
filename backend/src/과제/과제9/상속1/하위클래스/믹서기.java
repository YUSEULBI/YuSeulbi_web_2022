package 과제.과제9.상속1.하위클래스;

import 과제.과제9.상속1.주방가전;

public class 믹서기 extends 주방가전 {
	
	
	//생성자
	public 믹서기() {
		super();
	}

	public 믹서기(String 할일) {
		super(할일);
	}




	@Override
	public void 전원키기() {
		super.전원키기();

		System.out.println("- 과일을 갈았습니다.");
		System.out.println();
	}
	
}
