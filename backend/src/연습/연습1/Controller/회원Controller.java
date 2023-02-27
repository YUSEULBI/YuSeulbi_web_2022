package 연습.연습1.Controller;

import java.util.ArrayList;

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
	
	public int 로그인 ( String 아이디 , String 비번 ) {
		회원Dto dto = 회원Dao.getInstance().로그인(아이디, 비번);
		if ( dto == null ) {return -1;} //로그인실패 
		else if ( dto.get회원번호_pk() > 0 ) { 
			logsession = dto.get회원번호_pk(); System.out.println( "logsesion : " + logsession);
			if ( dto.get등급() == 2 ) { return 2;	} // 강사
			if ( dto.get등급() == 3 ) { return 3;	} //관리자 --> 회원페이지에서 로그인 시도했기 때문에 안됨.
			return 1;	} // 일반회원
		return -1; // 로그인실패 
	}
	
	// 3. 관리자 로그인 [ 인수 비밀번호 / 반환 : 성공실패 ]
	public boolean 관리자로그인( String 비번 ) {
		
		회원Dto dto = 회원Dao.getInstance().관리자로그인(비번);
		if ( dto == null ) { return false;	}
		logsession = dto.get회원번호_pk();
		return true;
	}
	
	// 4. 강사,회원조회
	public ArrayList<회원Dto> 회원조회( int 등급  ){
		return 회원Dao.getInstance().회원조회(등급);
	}
	
}
