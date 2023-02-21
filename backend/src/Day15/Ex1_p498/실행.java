package Day15.Ex1_p498;

public class 실행 {
	
	public static void main(String[] args) {
		
		Member obj1 = new Member("blue");
			System.out.println(obj1);
		Member obj2 = new Member("blue");
			System.out.println(obj2);	
		Member obj3 = new Member("red");
			System.out.println(obj3);
		System.out.println( obj1.equals(obj2)); // false
		System.out.println( obj1.equals(obj3));	// false
		
		// equals는 주소를 비교
		// 1번과 2번은 같은 값이지만 객체를 따로따로 생성했기 때문에 주소가 달라서 false
		
	}
	
}


/*





*/