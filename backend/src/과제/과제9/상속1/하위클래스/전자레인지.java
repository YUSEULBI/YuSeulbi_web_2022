package 과제.과제9.상속1.하위클래스;

import 과제.과제9.상속1.주방가전;

public class 전자레인지 extends 주방가전 {
	
	
	//생성자	
	public 전자레인지() {
		super();
	}

	public 전자레인지(String 할일) {
		super(할일);
	}

	@Override
	public void 전원키기() {
		super.전원키기();

		System.out.println("- 전자레인지에 음식을 데웠습니다.");
		System.out.println();
	}
	
	
}
