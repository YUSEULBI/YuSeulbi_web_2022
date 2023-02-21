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
		// obj.getNo를 써야하는데 Student타입만 사용가능함.
		// obj는 Object타입으로 받았으므로 부모인 Object는 자식인 Student의 메소드 getNo를 모름
		// 그래서 타입변환해야함
		if ( obj instanceof Student ) {
			Student target = (Student)obj;
			if ( no == target.getNo() && name.equals(target.getName()) ) {
				return true;
			}
			
		}
		return false;
			
		
	}
	

}
