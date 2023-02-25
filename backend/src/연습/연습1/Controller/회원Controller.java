package 연습.연습1.Controller;

import 연습.연습1.model.회원Dao;
import 연습.연습1.model.회원Dto;

public class 회원Controller {
	
	private static 회원Controller controller = new 회원Controller(); 
	private 회원Controller() { 	}
	public static 회원Controller getInstance() {
		return controller;
	}
	
	private int logsession;
	public int getlogsession() {
		return logsession;
	}
	
	public boolean 회원가입( String 아이디 , String 비밀번호 , String 전화번호 , String 이름 , int 등급 ) {
		
		if ( 아이디 != null && 비밀번호 != null && 전화번호 != null && 이름 != null ) {
			회원Dto dto = new 회원Dto(0, 아이디, 비밀번호, 전화번호, 이름, 등급);
			회원Dao.getInstance().회원가입(dto);
			return true;
		} else { return false; }
	}
	
	public boolean 로그인 ( String 아이디 , String 비번 ) {
		int result = 회원Dao.getInstance().로그인(아이디, 비번);
		if ( result == -1 ) {return false;}
		else if ( result > 0 ) { logsession = result; System.out.println( "logsesion : " + logsession); return true;	}
		return false;
	}
	
	
	
}
