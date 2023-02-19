package 과제.과제9.상속3;

public class 악기 {
	
	void 결과( int i , int j ) {
		System.out.println();
		System.out.println("------ 결과 안내 ------");
		System.out.println("생각하신 악기는...");
		String 대분류 = null; 
		if ( i == 1 ) {	대분류 = "현악기"; }
		else if ( i == 2 ) { 대분류 = "관악기"; }
		else if ( i == 3 ) { 대분류 = "타악기"; }
		System.out.println("대분류 : "+대분류);
		
	}
		
	
	
}
