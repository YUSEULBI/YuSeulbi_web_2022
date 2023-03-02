package jspweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	private static Dao dao = new Dao();
	public static Dao getInstance() { return dao; 	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private Dao() { 
		try {
			// * [웹서버] : 해당 mySQL 드라이버 [라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver"); //console프로젝트는X --> 웹서버프로젝트는 필요
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234"
					);
			System.out.println("연동성공");
		}catch (Exception e) { 	System.out.println("연동실패"+e); 	}
	}
	
	// 2. SQL 메소드 // 데이터 1개
	public boolean setData( String data ) {
		// 1. SQL 작성
		String sql = "insert into ex1 values(?)";
		// 2. SQL 조작
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate(); // sql실행
			return true;	// 응답
		}catch (Exception e) {
			System.err.println(e);
		}return false;
		
	}
	
	// 데이터들 호출 [ 1개 : String / 여러개 : ArrayList<String> ]
	public ArrayList<String> getData(){
		ArrayList<String> list = new ArrayList();
		String sql = "select * from ex1";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			// 레코드1개 if 여러개 while
			while( rs.next() ) {
				list.add(rs.getString(1)); // 레코드 첫번째 필드
			}
			
			
		}catch (Exception e) { 	System.out.println(e); 	}
		return list;
	}
	
	public boolean setData2( String data ) {
		String sql = "insert q1( e_data2 ) values( ? );" ;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.err.println(e);
		}return false;
	}
	
	public ArrayList<String> getData2 (){
		ArrayList<String> list2 = new ArrayList();
		String sql = "select * from q1;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				 
				 list2.add(rs.getString(1));
				 
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return list2;
	}
}
