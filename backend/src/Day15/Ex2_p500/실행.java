package Day15.Ex2_p500;

public class 실행 {

	public static void main(String[] args) {
		
		// 문자리터럴 ""로 생성된 애는 값이 같으면 객체가 동일함 , 객체공유 , 주소같음
		System.out.println("자바".hashCode());
		System.out.println("자바".hashCode());
		
		System.out.println("자바".hashCode() == "자바".hashCode()); //문자열의 비교가능 , 객체끼리는 false
		
		// new연산자는 데이터가 같아도 객체가 달라서 주소값이 다름.
		Student s1 = new Student(1, "홍길동");
			System.out.println(s1);
		Student s2 = new Student(1, "홍길동");
			System.out.println(s2);
			
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		//hashcode
		System.out.println(s1.hashCode() == s2.hashCode()); //false
		
		//equals
		System.out.println(s1.equals(s2));
	}
}

