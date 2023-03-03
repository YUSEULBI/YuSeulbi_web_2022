package practice.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao2 {
	
	private static Dao2 dao2 = new Dao2();
	public static Dao2 getInstance() {
		return dao2;
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public Dao2() {
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
	
	public boolean setData( Dto2 dto ) {
		String sql = "insert into q2 values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhone());
			ps.setDouble(3, dto.getHeight());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getRegistDate());
			ps.setString(6, dto.getManwoman());
			ps.setBoolean(7, dto.isPrivacy());
			ps.setString(8, dto.getRegion());
			ps.setString(9, dto.getIntroduce());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			System.out.println("dao2 setData 예외 : "+e);
		}return false;
		
	}
	
	public ArrayList<Dto2> getData( ){
		ArrayList<Dto2> list = new ArrayList<>();
		String sql = "select * from q2;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Dto2 dto2 = new Dto2(
						rs.getString(1), rs.getString(2), rs.getDouble(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6), 
						rs.getBoolean(7), rs.getString(8), rs.getString(9));
				list.add(dto2);		
			}
		}catch (Exception e) {
			System.out.println("dao2 getdata 예외 : "+e);
		}
		System.out.println(list);
		return list;
	}
}
