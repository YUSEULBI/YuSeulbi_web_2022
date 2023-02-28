package Day20.model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	// 1. JDBC 인터페이스 3개
	public Connection con; 
	public PreparedStatement ps;
	public ResultSet rs;
	
	public Dao() {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/boardDb" ,
					"root" ,
					"1234"
					);
		}catch (Exception e) {
			System.out.println( e );
		}
	}
	
}
