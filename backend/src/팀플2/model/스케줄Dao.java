package 팀플2.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class 스케줄Dao {
	
	//싱글톤
	private static 스케줄Dao dao = new 스케줄Dao();
	private 스케줄Dao() { 	}
	public static 스케줄Dao getInstance() {
		return dao;
	}
	
	// 스케줄테이블 여러개 -> 스케줄DTO 여러개 -> ArrayList로 담기
	private ArrayList<스케줄Dto> 스케줄리스트 = new ArrayList<>();
	public ArrayList<스케줄Dto> get스케줄리스트(){
		return 스케줄리스트;
	}
	
	public boolean 전체스케줄목록() {
		//sql문 작성
		String sql = "select * from 스케줄;";
		try {
			// 작성된 sql문을 미리 컴파일, 실행할 준비를해서 Prepared Statement 객체 반환
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			// ps 호출하는 문장이 길어서 ps변수에 다시 담음
			PreparedStatement ps = DbDAO.getInstance().getPs();
			// sql문을 실행한 결과값을 ResultSet rs객체에 반환.
			DbDAO.getInstance().setRs(ps.executeQuery()); 
			// rs 호출문장이 넘 길어서 rs변수에 다시 담음
			ResultSet rs = DbDAO.getInstance().getRs();
			
			while ( rs.next() ) {
				// DB의 datetime타입을 Object타입으로 받아서 LocalDateTime 타입으로 강제형변환
				LocalDateTime time = (LocalDateTime) rs.getObject(2);
				//스케줄테이블 1행씩 dto객체로 생성
				스케줄Dto dto = new 스케줄Dto(rs.getInt(1),time,rs.getInt(3), rs.getInt(4));
				// 스케줄dto 하나씩 스케줄리스트에 추가
				스케줄리스트.add(dto);
			}	 
			System.out.println("[스케줄목록 list에 저장함.]");
			return true;
		}catch (Exception e) {
			System.out.println("[스케줄목록 함수 예외발생]" + e);
			return false;
		}
	}
	
}
