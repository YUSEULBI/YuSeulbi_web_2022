package 연습.연습1.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class 수강내역Dao {
	
	private static 수강내역Dao dao = new 수강내역Dao();
	private 수강내역Dao() { 	}
	public static 수강내역Dao getInstance() {
		return dao;
	}
	
	ArrayList<예약내역Dto> 예약내역리스트 = new ArrayList<>();
	
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
	
	public ArrayList<예약내역Dto> 예약내역( int logsession ) {
		예약내역리스트 = new ArrayList<>();
		
		//스케줄번호/ 수강일시 / 강사 / 금액
		String sql ="select 스케줄번호_pk , 수강일시 , 이름 , 금액 from 회원,스케줄,수강내역 \r\n"
				+ "			where 스케줄.회원번호_fk = 회원.회원번호_pk and 회원.회원번호_pk = ? and 회원.회원번호_pk = 수강내역.회원번호_fk   and 스케줄.스케줄번호_pk = 수강내역.스케줄번호_fk order by 수강일시;";
		try {
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			PreparedStatement ps = DbDAO.getInstance().getPs();
			ps.setInt(1, logsession);
			DbDAO.getInstance().setRs(ps.executeQuery());
			ResultSet rs = DbDAO.getInstance().getRs();
			while ( rs.next() ) {
				LocalDateTime time = ( LocalDateTime ) rs.getObject(2);
				예약내역Dto dto = new 예약내역Dto(rs.getInt(1), time, rs.getString(3), rs.getInt(4));
				예약내역리스트.add(dto);
			} return 예약내역리스트;
			
		}catch (Exception e) {
			System.out.println("[ 예약내역 예외발생 ] : " + e);
			return null;
		}
		
	}
	
}
