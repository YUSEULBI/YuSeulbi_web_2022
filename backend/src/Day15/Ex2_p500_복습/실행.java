package Day15.Ex2_p500_복습;

public class 실행 {
	
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		
		//주소값 정수반환 , 주소가 다름
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// 주소값이 다르기 때문에 false -> hashCode 오버라이드해서 내부입력값만 비교하도록 바꾸기
		// s1,s2 객체와 상관없이 s1,s2의 필드 no와 name 리터럴문자열 객체만 비교함.
		// 리터럴문자열은 객체를 공유하기 때문에 주소가 같음
		// name.hashCode는 내부데이터가 같으면 주소값을 공유하기 때문에 true
		System.out.println(s1.hashCode() == s2.hashCode());
		
		// s1과 s2는 객체가 다르기 때문에 주소값도 다름 false
		// 오버라이드해서 객체 내부 데이터만 비교하기
		System.out.println(s1.equals(s2));
	}
	

	
}
