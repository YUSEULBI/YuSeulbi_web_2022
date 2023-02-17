package 과제.과제9;

import java.util.Scanner;

public class Front {

	//싱글톤
	private static Front front = new Front();
	private Front() {	}
	public static Front getInstance () {
		return front;
	}
	
	Scanner scanner = new Scanner(System.in);
	이동 move = new 사람();
	
	public void index() {
		while (true) {
			System.out.println("--------------------");
			System.out.println(">>>이동방법을 선택하세요");
			System.out.println("1.걷기 2.이동수단");
			int ch = scanner.nextInt();
			if ( ch == 1 ) {  동쪽서쪽이동();	}
			else if ( ch == 2 ) { 이동수단선택();	};
		}
	}
	
	public int 방향선택() {
		System.out.println(">>>이동방향을 선택하세요");
		System.out.println("1.동쪽이동 2.서쪽이동");
		int ch = scanner.nextInt();
		return ch;
	}
	
	public void 동쪽서쪽이동() {
		int ch = 방향선택();
		if ( ch == 1 ) { move.동쪽이동(); 	}
		else if ( ch == 2 ) { move.서쪽이동();	}
	}
	
		
	void 이동수단선택() {
		while (true) {
			System.out.println("---- 이동수단을 골라보자 ----");
			System.out.println("1. 비행기");
			System.out.println("2. 자동차");
			System.out.println("3. 자전거");
			System.out.println("선택 : ");
			
			int ch = scanner.nextInt();
			if ( ch == 1 ) { 비행기이동();	}
			else if ( ch == 2 ) { 자동차이동();	}
			else if ( ch == 3 ) { 자전거이동();	}
			
		}
	}
	
	void 비행기이동() {
		move = new 비행기();
		동쪽서쪽이동();
	}
	
	void 자동차이동() {
		move = new 자동차();
		동쪽서쪽이동();
	}
	
	void 자전거이동() {
		move = new 자전거();
		동쪽서쪽이동();
	}
	
}
