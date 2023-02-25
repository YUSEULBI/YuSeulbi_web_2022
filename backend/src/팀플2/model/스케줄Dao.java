package 팀플2.model;

import java.sql.PreparedStatement;

public class 스케줄Dao {
	
	public 스케줄Dto 전체수업목록() {
		String sql = "select * from 스케줄;";
		try {
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			PreparedStatement ps = DbDAO.getInstance().getPs();
			
		}catch (Exception e) {
			System.out.println("[전체수업목록 함수 예외]" + e);
		}
	}
	
}
