package 연습.연습1.model;

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
	
	// 전체스케줄테이블의 레코드 여러개 -> 스케줄출력DTO 여러개 -> ArrayList로 담기
	private ArrayList<스케줄출력Dto> 전체스케줄리스트 = new ArrayList<>();
	
	
	public boolean 스케줄테이블() {
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
				//스케줄리스트.add(dto);///////////////////////사용하려면 ArrayList만들기
			}	 
			System.out.println("[스케줄목록 list에 저장함.]");
			return true;
		}catch (Exception e) {
			System.out.println("[스케줄목록 함수 예외발생]" + e);
			return false;
		}
	}
	
	public ArrayList<스케줄출력Dto> 전체스케줄목록() {
		전체스케줄리스트 = new ArrayList<>();
		//sql문 작성
		String sql = "select 스케줄번호_pk,수강일시,금액,이름 from 회원,스케줄 where 스케줄.회원번호_fk = 회원.회원번호_pk;";
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
				스케줄출력Dto dto = new 스케줄출력Dto(rs.getInt(1), time, rs.getInt(3), rs.getString(4));
						
				// 스케줄dto 하나씩 스케줄리스트에 추가
				전체스케줄리스트.add(dto);
			}	 
			System.out.println("[전체스케줄 list에 저장함.]");
			return 전체스케줄리스트;
		}catch (Exception e) {
			System.out.println("[전체스케줄목록 함수 예외발생]" + e);
			return null;
		}
	}
	
}
