package 과제.과제4.model; //DB
// * 데이터 모델링 데이터형태 // 더이상 쓸거없음
public class Member { 
	
	// 1. 필드
	public String id;
	public String pwd;
	public String name;
	public String phone;
	
	// 2. 생성자
	
	//기본생성자
	public Member() {
	
	}
	
	//풀생성자
	public Member(String id, String pwd, String name, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
	}
	
	
	// 3. 메소드
	
}
