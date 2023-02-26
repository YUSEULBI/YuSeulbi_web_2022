package 연습.연습1.Controller;

import java.util.ArrayList;

import 연습.연습1.model.강사스케줄출력dto;
import 연습.연습1.model.수강내역Dao;
import 연습.연습1.model.스케줄Dao;
import 연습.연습1.model.스케줄출력Dto;
import 연습.연습1.model.예약내역Dto;

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
		return 수강내역Dao.getInstance().예약처리(logsession, sc );
	}
	
	//예약내역
	public ArrayList<예약내역Dto> 예약내역( ) {
		int logsession = 회원Controller.getInstance().getlogsession();
		return 수강내역Dao.getInstance().예약내역(logsession);
	}
	
	//강사스케줄출력
	public ArrayList<강사스케줄출력dto> 강사스케줄출력(){
		int logsession = 회원Controller.getInstance().getlogsession();
		return 스케줄Dao.getInstance().강사스케줄출력(logsession);
	}
}
