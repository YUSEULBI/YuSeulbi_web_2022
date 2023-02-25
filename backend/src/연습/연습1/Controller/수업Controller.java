package 연습.연습1.Controller;

import java.util.ArrayList;

import 연습.연습1.model.수강내역Dao;
import 연습.연습1.model.스케줄Dao;
import 연습.연습1.model.스케줄출력Dto;

public class 수업Controller {
	
	//싱글톤
	private static 수업Controller controller = new 수업Controller();
	private 수업Controller() {	}
	public static 수업Controller getInstance() {
		return controller;
	}
	
	//전체스케줄목록
	public ArrayList<스케줄출력Dto> 전체수업목록() {
		return 스케줄Dao.getInstance().전체스케줄목록();
		
	}
	
	//예약처리
	public boolean 예약처리( int sc ) {
		int logsession = 회원Controller.getInstance().getlogsession();
		return 수강내역Dao.getInstance().예약처리(sc, logsession );
	}
}
