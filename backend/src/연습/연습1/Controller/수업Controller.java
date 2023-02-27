package 연습.연습1.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import 연습.연습1.model.강사스케줄출력dto;
import 연습.연습1.model.수강내역Dao;
import 연습.연습1.model.스케줄Dao;
import 연습.연습1.model.스케줄Dto;
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
	
	//수업등록
	public boolean 수업등록 (  LocalDateTime time , int 금액 , int 회원번호 ) {
	
		스케줄Dto dto = new 스케줄Dto(0, time, 금액, 회원번호);
		return 스케줄Dao.getInstance().수업등록(dto);
		
	}
	
	// 수강취소
	public boolean 수강취소( int 수강내역번호 ) {
		int logsession = 회원Controller.getInstance().getlogsession();
		return 수강내역Dao.getInstance().수강취소(수강내역번호, logsession);
	}
	
	// 수업수정
	public boolean 수업수정( int 스케줄번호 , LocalDateTime time , int 금액 , int 강사번호 ) {
		스케줄Dto dto = new 스케줄Dto(스케줄번호, time, 금액, 강사번호);
		return 스케줄Dao.getInstance().수업수정(dto);
		
	}
}
