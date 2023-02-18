package 과제.과제9.상속1.하위클래스;

import 과제.과제9.상속1.주방가전;

public class 청소기 extends 주방가전 {
		
	
	//생성자
	public 청소기() {
		super();
	}

	public 청소기(String 할일) {
		super(할일);
	}





	@Override
	public void 전원키기() {
		super.전원키기();

		System.out.println("- 청소기로 바닥을 청소했습니다.");
		System.out.println();
	}
	
}
