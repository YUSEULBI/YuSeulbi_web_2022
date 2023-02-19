package 과제.과제9.상속3;


import java.util.Scanner;

public class Front {
	
	private static Front front = new Front();
	private Front() { 	}
	public static Front getInstance() {
		return front;
	}
	
	현악기 현악기 = new 현악기();
	관악기 관악기 = new 관악기();
	타악기 타악기 = new 타악기();
	
	Scanner scanner = new Scanner(System.in);
	public void index() {
		
		while (true) {
			System.out.println("-------악기분류찾기-------");
			System.out.println("-악기 하나를 생각해주세요.");
			System.out.println("-생각하신 악기의 연주방법은?");
			System.out.println("1.줄을사용 2.입으로불어서 3.두들겨서");
			int ch = scanner.nextInt();
			Controller.getInstance().setI(ch);
			if ( ch == 1 ) {	현악기(); }
			else if ( ch == 2 ) {	관악기();}
			else if ( ch == 3 ) {	타악기();}
			else { System.out.println("잘못입력하셨습니다.");	}
		}
		
	} // index end
	
	///현악기////////////////
	
	void 현악기() {
		System.out.println(">>생각하신 악기는 현악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
		System.out.println("줄 사용방식을 묻습니다.");
		System.out.println("1.활을 씁니까? 2.줄을뜯습니까? 3.줄을때립니까?");
		int ch = scanner.nextInt();
		
		int i = Controller.getInstance().getI();

		if ( ch == 1 ) { 찰현악기(); 현악기.결과(i, ch);  }
		else if ( ch == 2 ) { 발현악기(); 현악기.결과(i, ch); 	}
		else if ( ch == 3 ) { 타현악기(); 현악기.결과(i, ch);	}
	}
	
	void 찰현악기() {
		System.out.println(">>생각하신 악기는 찰현악기입니다~!");
	}
	
	void 발현악기 () {
		System.out.println(">>생각하신 악기는 발현악기입니다~!");
	}
	
	void 타현악기 () {
		System.out.println(">>생각하신 악기는 타현악기입니다~!");
	}
	
	/////관악기////////////////
	
	void 관악기() {
		System.out.println(">>생각하신 악기는 관악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
		System.out.println("마우스피스 유무를 묻습니다.");
		System.out.println("1.있다. 2.없다.");
		int ch = scanner.nextInt();
		
		int i = Controller.getInstance().getI();
		if ( ch == 1 ) { 금관악기(); 관악기.결과(i, ch);	}
		else if ( ch == 2 ) { 목관악기(); 관악기.결과(i, ch);	}
		
	}
	
	void 목관악기 () {
		System.out.println(">>생각하신 악기는 목관악기입니다~!");
	}
	
	void 금관악기 () {
		System.out.println(">>생각하신 악기는 금관악기입니다~!");
	}
	
	////타악기////////////////
	
	void 타악기() {
		System.out.println(">>생각하신 악기는 타악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
		System.out.println("자세한 연주방식을 묻습니다.");
		System.out.println("1.악기에 씌워진 막을 때린다.");
		System.out.println("2.악기의 소리나는 부분을 직접때린다.");
		int ch = scanner.nextInt();
		
		int i = Controller.getInstance().getI();
		if ( ch == 1 ) { 막명악기(); 타악기.결과(i, ch);	}
		else if ( ch == 2 ) { 체명악기(); 타악기.결과(i, ch);	}
		
	}
	
	void 막명악기 () {
		System.out.println(">>생각하신 악기는 막명악기입니다~!");
	}
	
	void 체명악기 () {
		System.out.println(">>생각하신 악기는 체명악기입니다~!");
	}
}
