package Day07.Ex3;

import java.util.Scanner;

public class 실행 {
	
	public static void main(String[] args) { // main s
		
		
		Scanner scanner = new Scanner(System.in);
		
		
		// * 객체활용 ///////////////////////////
		
		
		System.out.println("아이디 : ");
		String id = scanner.next();
		System.out.println("비밀번호 : ");
		String password = scanner.next();
		
		
		// 1. 번거로움 [ 객체활용X ]
		String[] 배열 = new String[3]; 	// *String 객체 3개를 저장할 수 있는 배열
		// 객체 1개당 String 문자열 1개 저장하는 객체
		배열[0] = id + "," + password; // 합친 문자열 배열에 대입
		
		System.out.println( 배열[0].split(",")[0]); // ,표로 쪼갠 배열에서 0번째인덱스 데이터 호출
		
		
		//---------------------------------------------------
		
		
		// 2. 회원 클래스 만들어서 회원객체 만들자 [ 객체활용 ]
		Member[] 배열2 = new Member[3];	// Member객체 3개를 저장할 수 있는 배열
		// Member 문자열 2개[id,password] 저장할 수 있는 클래스/객체
		
		Member m1 = new Member();
		m1.id = id; // 입력받은 아이디를 객체내필드인 id에 대입
		m1.password = password; // 입력받은 패스워드를 객체내필드인 password에 대입
		배열2[0] = m1;	// 배열2에 m1 객체 대입
		
		System.out.println(배열2[0].id); //m1을 담은 배열2의 0번째객체의 id
		
	} // main e

}
