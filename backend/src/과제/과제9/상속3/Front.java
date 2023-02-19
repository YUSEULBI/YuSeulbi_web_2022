package 과제.과제9.상속3;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {
	
	private static Front front = new Front();
	private Front() { 	}
	public static Front getInstance() {
		return front;
	}
	
	private ArrayList<악기> 악기검색기록 = new ArrayList<>();
	public ArrayList<악기> get악기검색기록(){
		return 악기검색기록;
	}
	
	Scanner scanner = new Scanner(System.in);
	public void index() {
		//오류나서 보류
//		if ( 악기검색기록.size()>0) {
//			System.out.println("-------검색기록-------");
//			System.out.println("악기이름\t대분류\t중분류");
//			
//		}
		
		System.out.println("-------악기분류찾기-------");
		System.out.println("-악기 하나를 생각해주세요.");
		System.out.println("-생각하신 악기의 연주방법은?");
		System.out.println("1.줄을사용 2.입으로불어서 3.두들겨서");
		int ch = scanner.nextInt();
		
		if ( ch == 1 ) { 
			악기 악기 = new 악기("현악기"); 현악기(악기);
		}
		else if ( ch == 2 ) { 	
			악기 악기 = new 악기("관악기"); 관악기(악기);
		}
		else if ( ch == 3 ) { 	
			악기 악기 = new 악기("타악기"); 타악기(악기);
		}
	}
	
	///현악기////////////////
	
	void 현악기( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 현악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
		System.out.println("줄 사용방식을 묻습니다.");
		System.out.println("1.활을 씁니까? 2.줄을뜯습니까? 3.줄을때립니까?");
		int ch = scanner.nextInt();
		
		if ( ch == 1 ) { 찰현악기( 생각한악기 );	}
		else if ( ch == 2 ) { 발현악기( 생각한악기 );	}
		else if ( ch == 3 ) { 타현악기( 생각한악기 );	}
	}
	
	void 찰현악기( 악기 생각한악기 ) {
//		현악기 생각한현악기 = (현악기)생각한악기; // 형변환 콘솔오류나서 보류
//		생각한현악기.set중분류("찰현악기");
		System.out.println(">>생각하신 악기는 찰현악기입니다~!");
//		System.out.println("생각하신 악기이름을 알려주세요");
//		String name = scanner.next();
//		생각한현악기.set악기이름(name);
//		악기검색기록.add(생각한현악기);
	}
	
	void 발현악기 ( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 발현악기입니다~!");
	}
	
	void 타현악기 ( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 타현악기입니다~!");
	}
	
	/////관악기////////////////
	
	void 관악기( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 관악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
		System.out.println("마우스피스 유무를 묻습니다.");
		System.out.println("1.있다. 2.없다.");
		int ch = scanner.nextInt();
		
		if ( ch == 1 ) { 금관악기( 생각한악기 );	}
		else if ( ch == 2 ) { 목관악기( 생각한악기 );	}
		
	}
	
	void 목관악기 ( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 목관악기입니다~!");
	}
	
	void 금관악기 ( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 금관악기입니다~!");
	}
	
	////타악기////////////////
	
	void 타악기( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 타악기 입니다!");
		System.out.println();
		System.out.println("-세부분류로 들어가볼까요?");
		System.out.println("자세한 연주방식을 묻습니다.");
		System.out.println("1.악기에 씌워진 막을 때린다.");
		System.out.println("2.악기의 소리나는 부분을 직접때린다.");
		int ch = scanner.nextInt();
		
		if ( ch == 1 ) { 막명악기( 생각한악기 );	}
		else if ( ch == 2 ) { 목관악기( 생각한악기 );	}
		
	}
	
	void 막명악기 ( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 막명악기입니다~!");
	}
	
	void 체명악기 ( 악기 생각한악기 ) {
		System.out.println(">>생각하신 악기는 체명악기입니다~!");
	}
}
