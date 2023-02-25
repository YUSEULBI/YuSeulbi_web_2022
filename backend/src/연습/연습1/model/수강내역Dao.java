package 연습.연습1.model;

import java.sql.PreparedStatement;

public class 수강내역Dao {
	
	private static 수강내역Dao dao = new 수강내역Dao();
	private 수강내역Dao() { 	}
	public static 수강내역Dao getInstance() {
		return dao;
	}
	
	public boolean 예약처리( int logsession  , int sc ) {
		
		String sql = "insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( ? , ? );";
		try {
			// 작성된 sql문을 미리 컴파일, 실행할 준비를 해서 prepared Statement 객체 반환
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			// 길어서 ps변수에 저장
			PreparedStatement ps = DbDAO.getInstance().getPs();
			ps.setInt(1, logsession);
			ps.setInt(2, sc);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("[예약처리 예외발생] "+ e);
			return false;
		}
		
	}
	
}
