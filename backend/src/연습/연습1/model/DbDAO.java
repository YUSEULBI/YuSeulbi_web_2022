package 연습.연습1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDAO {
	
	// 싱글톤
	private static DbDAO dao = new DbDAO(); 
	public static DbDAO getInstance() { return dao; }
	
	// 1.필드
	private Connection conn; // DB구현객체
	private PreparedStatement ps; // SQL조작 (매개변수사용)
	private ResultSet rs; // SQL결과조작
    
	// 2. 생성자
	private DbDAO() {
	
		try { 
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/console" , "root" , "1234");
			System.out.println("[연동성공]");
			
		}catch (Exception e) {
			System.out.println( "[연동실패] : " + e );
		}
	}

	@Override
	public String toString() {
		return "DbDAO [conn=" + conn + ", ps=" + ps + ", rs=" + rs + "]";
	}


	
	


	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	
	
}
