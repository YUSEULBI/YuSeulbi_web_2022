package Day09.ex9;

public class 실행 {


	

	public static void main(String[] args) {
		
		
		// 1. 생성자가 private 라서 객체 생성 불가능
		
		// 2. 객체없이 메소드 [ static ] 사용
		// 클래스를 가져와서 객체를 생성하는대신 클래스내에 직접 생성된 객체를 가져오기
		
		Member m1 = Member.getInstance();
		Member m2 = Member.getInstance();
		
		
		System.out.println(m1);
		System.out.println(m2);
	}
	
}
