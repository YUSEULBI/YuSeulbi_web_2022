package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
	
	private static BoardDao boardDao = new BoardDao();
	
	public static BoardDao getInstace() {
		return boardDao;
	}
	
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	private BoardDao() { 	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
					);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// 1. 등록
	public boolean onwrite( BoardDto dto ) {
		String sql ="insert into ex3( bcontent , bwriter ) values( ? , ? ); ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			ps.executeUpdate(); return true;
		}catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	// 2. 모든 방문록 출력 R
	public ArrayList<BoardDto> onRead ( ){
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from ex3;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				BoardDto boardDto = new BoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(boardDto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}return list;
	}
	
	// 3.
	public boolean onupdate( String newContent , int bno ) {
		String sql = "update ex3 set bcontent = ? where bno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newContent);
			ps.setInt(2, bno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
				
	}
	
	// 4.
	public boolean ondelete( int i ) {
		String sql = "delete from ex3 where bno = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
}
