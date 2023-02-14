package 과제.과제4_싱글톤.model;

import java.util.ArrayList;
// DTO 이동객체..!!! 로직X 정보공개X
//M : 데이터 저장할 때 사용되는 데이터 모델링
	// - 회원[객체] 여러명 만들어서 하나의 리스트에 저장
	// 회원객체가 여러개 필요해서 ---> 인스턴스멤버
	// 접근제한자 - 필드 : private 외부 직접접근 방지 -> getter , setter

	//인스턴스멤버 		: 객체필요	-> 스택영역
	// 정적멤버	static	: 객체X 	-> 메소드영역

public class Member {
	
	
	// 1. 필드 /////////////////////////////////////
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	// 한명의 회원[객체]가 여러개의 board객체를 가질 수 있다.
	private ArrayList<Board> boardlist;

	
	
	
	
	
	// 2. 생성자 /////////////////////////////////////
	//빈생성자
	public Member() {	}
	//풀생성자
	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardlist) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardlist = boardlist;
	}
	



	// 3. 메소드 // 1. .toString 2. getter , setter
	
	//toString
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", boardlist=" + boardlist
				+ "]";
	}
	
	
	// getter setter
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Board> getBoardlist() {
		return boardlist;
	}
	public void setBoardlist(ArrayList<Board> boardlist) {
		this.boardlist = boardlist;
	}
	
	
	
	

}
