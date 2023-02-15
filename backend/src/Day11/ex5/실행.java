package Day11.ex5;

public class 실행 {
	
	public static void main(String[] args) {
		// 자식객체
		Child child = new Child();
			child.name = "유재석";
			child.job = "방송인";
		
		// 자식객체 -> 부모객체 타입변환
		Parent parent = child;
		
		Object object = child; // 해당객체 타입 모를경우 ( 자동타입변환 )
		Child child3 = (Child) object; // 캐스팅
		
		//
		parent.method();
		parent.mathod2(); // 부모 멤버인데 -> 자식이 오버라이딩 한 메소드 사용 ,오버라이딩은 살아있음.
		// parent.method3 자식멤버 못씀
		
		System.out.println(parent.name);
		// System.out.println(parent.job); 상속을주더라도 부모는 자식의 필드는 못씀
		
		
		
		
		// ----------------------강제변환
		
		// 캐스팅 , 부모객체를 자식객체로 강제 타입변환
		// 부모 , 자식 모든 필드,메소드 사용가능
		Child child2 = (Child) parent;
		child2.method();
		child2.mathod2();
		child2.mathod3();
		System.out.println(child2.name);
		System.out.println(child2.job);
		
		
	
	}
	
}
