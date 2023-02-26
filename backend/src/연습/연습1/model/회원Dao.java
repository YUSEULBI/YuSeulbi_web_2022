package 연습.연습1.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 회원Dao {
	
	private static 회원Dao dao = new 회원Dao();
	private 회원Dao() {
		// TODO Auto-generated constructor stub
	} 
	public static 회원Dao getInstance() {
		return dao;
	}
	
	// 1. 회원가입 [ 인수 : 아이디,비번 / 반환 : 성공실패 ]
	public boolean 회원가입( 회원Dto dto ) {
		String sql = "insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) "
				+ "values( ? , ? ,? , ? , ? );";
		try {
			
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			PreparedStatement ps = DbDAO.getInstance().getPs();
			ps.setString(1, dto.get아이디());
			ps.setString(2, dto.get비밀번호());
			ps.setString(3, dto.get전화번호());
			ps.setString(4, dto.get이름());
			ps.setInt(5, dto.get등급());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("[회원가입SQL문제] : "+ e);
			return false;
		}		
		
	}// signUp end //
	
	// 2. 로그인 [ 인수 : 아이디 , 비번 / 반환 : 회원Dto ]
	public 회원Dto 로그인( String 아이디 , String 비번 ) {
		//select * from 회원 where 아이디 = 'qwe' and 비밀번호 = 'qwe';
		try {
			String sql = "select * from 회원 where 아이디 = ? and 비밀번호 = ?";
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			PreparedStatement ps = DbDAO.getInstance().getPs();
			ps.setString(1, 아이디);
			ps.setString(2, 비번);
			
			DbDAO.getInstance().setRs(ps.executeQuery()); // SQL문을 실행하고 결과를 ResultSet객체로 받음.
			
			ResultSet rs = DbDAO.getInstance().getRs();
			if ( rs.next() ) {
				회원Dto dto = new 회원Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				return dto;
			}else { return null; }
			 
		}catch (Exception e) {
			System.out.println("[로그인 예외 ,맞는 정보가 없습니다.] :" + e);
			return null;
		}
		
	}
	
	// 3. 관리자 로그인 [ 인수 비밀번호 / 반환 : 회원Dto ]
	public 회원Dto 관리자로그인( String 비번 ) {
		회원Dto dto = new 회원Dto();
		String sql = "select * from 회원 where 등급 = 3 and 비밀번호 = ?;";
		try {
			DbDAO.getInstance().setPs(DbDAO.getInstance().getConn().prepareStatement(sql));
			PreparedStatement ps = DbDAO.getInstance().getPs();
			ps.setString(1, 비번);
			DbDAO.getInstance().setRs(ps.executeQuery());
			ResultSet rs = DbDAO.getInstance().getRs();
			if ( rs.next() ) {
				dto = new 회원Dto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				
			}return dto;
		}catch (Exception e) {
			System.out.println("[관리자로그인 예외발생] :" + e);
			return null;
		}
		
	}
	
	
}
