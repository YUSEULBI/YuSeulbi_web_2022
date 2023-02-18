package 과제.과제9.상속1;

public class 주방가전 {
	
	String 할일;
	
	public 주방가전() { 	}
		
	public 주방가전(String 할일) {
		super();
		this.할일 = 할일;
	}


	public void 전원키기() {
		System.out.println("- 전원을 킵니다.");
		System.out.println();
	}
	
	public void 전원끄기() {
		System.out.println("- 전원을 끕니다.");
	}
}
