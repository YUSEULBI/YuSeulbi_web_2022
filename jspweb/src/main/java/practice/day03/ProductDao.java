package practice.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	
	private static ProductDao dao = new ProductDao();
	
	public static ProductDao getInstance() {
		return dao;
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	private ProductDao() {	
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
	
	
	public boolean onProduct( ProductDto dto ) {
		String sql = "insert into q3 ( pname , pprice ) values( ? , ? );";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPname());
			ps.setInt(2, dto.getPprice());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	public ArrayList<ProductDto> onP_Print(){
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "select * from q3;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}return list;
	}
	
	public boolean pdelete( int pno ) {
		String sql = "delete from q3 where pno = ? ;";
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
		
	}
	
	public boolean pupdate( int pno , String pname , int pprice ) {
		String sql ="update q3 set pname = ? , pprice = ?  where pno = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pname);
			ps.setInt(2, pprice);
			ps.setInt(3, pno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
}
