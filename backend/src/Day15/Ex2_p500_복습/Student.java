package Day15.Ex2_p500_복습;

public class Student {
	private int no;
	private String name;
	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		int hashCode = no+name.hashCode(); // int + String입력값의 해쉬코드 int
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		// if ( this.no == obj.getNo ) { } 
		// obj.getNo를 써야하는데 getNo는 Student객체(타입)에 있음.
		// 인수로 받은 obj는 Object타입으로 받았으므로 부모인 Object는 자식인 Student의 메소드 getNo를 모름
		// 그래서 타입변환해야함 Object -> Student
		if ( obj instanceof Student ) { // obj는 이전에 Student타입이었나용? true이면 아래 실행문 실행~
			Student target = (Student)obj; // obj를 타입변환해서 target변수명에 담음
			if ( no == target.getNo() && name.equals(target.getName()) ) {
				// s1.equals(s2)에서 s1은 Student본인 , s2는 인수로 받은 obj->'target'
				// s1의 String문자열 no가 target의 String문자열 no와 주소값이 같고
				// s1의 String문자열 name이 target의 String문자열 name과 주소같이 같으면
				// true반환
				
				// 여기서 s1의 no와 s2의 no 문자열이 같을 수 있는 이유는
				// no에 입력되는 값은 문자리터럴 이기 때문이다.
				// 문자 리터럴은 값이 동일하면 객체를 공유한다.
				// 하나의 객체에서 값을 호출하기 때문에 주소가 같다.
				// s1과 s2는 서로 다른 객체이지만 그 안에 String타입의 필드가 같은 내용을 담는다면
				// 서로 다른 s1 s2의 no 값은 동일한 객체를 공유한다.
				return true;
			}
		}
		return false;
			
		
	}
	

}
