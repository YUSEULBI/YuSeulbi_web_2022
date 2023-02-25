package 팀플2.Controller;

import java.util.ArrayList;

import 팀플2.model.스케줄Dao;
import 팀플2.model.스케줄Dto;

public class 수업Controller {
	
	//싱글톤
	private static 수업Controller controller = new 수업Controller();
	private 수업Controller() {	}
	public static 수업Controller getInstance() {
		return controller;
	}
	
	//전체스케줄목록
	public ArrayList<스케줄Dto> 전체수업목록() {
		boolean result = 스케줄Dao.getInstance().전체스케줄목록();
		if ( result ) { return 스케줄Dao.getInstance().get스케줄리스트();	}
		else { return null;	}
	}
}
