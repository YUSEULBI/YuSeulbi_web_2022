package Day15.Ex2_p500;

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
		//객체비교가 아니라 필드내 문자열 데이터만 비교 
		int hashCode = no + name.hashCode();//입력값String객체의 해시코드 ( s1,s2의 객체랑 별개 )
		return hashCode;
	}
	
	
	

}
