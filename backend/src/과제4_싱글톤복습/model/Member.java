package 과제4_싱글톤복습.model;

import java.util.ArrayList;

public class Member {
	
	// 1. 필드
	private String id;
	private String pw;
	private String name;
	private String phone;
	private ArrayList<Board> boardlist;
	
	// 2. 생성자
	// 빈생성자
	public Member() { 	}
	
	// 풀생성자
	public Member(String id, String pw, String name, String phone, ArrayList<Board> boardlist) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.boardlist = boardlist;
	}


	
	
		
	// 3.메소드
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
