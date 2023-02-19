package 과제.과제9.상속3;

public class 현악기 extends 악기 {
	
	@Override
	void 결과(int i, int j) {
		super.결과(i, j);
		String 중분류 = null; 
		if ( j == 1 ) {	중분류 = "찰현악기"; }
		else if ( j == 2 ) { 중분류 = "발현악기"; }
		else if ( j == 3 ) { 중분류 = "타현악기"; }
		System.out.println("중분류 : "+중분류);
		System.out.println("입니다.");
		System.out.println("--------------------");
		System.out.println();
	}
	
	
}
