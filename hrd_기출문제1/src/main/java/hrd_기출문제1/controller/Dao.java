package hrd_기출문제1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Dao {
	
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	
	
	public static Connection getConnection() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/xe",  "root", "1234" );
		return con;
	}
	
	// 
	public Dao() {
		try {
			con = getConnection();
		} catch (Exception e) { System.out.println(e); 	}
	}
	
	
	// 1. 마지막 회원번호+1 가져오기
	public int getCustno() {
		String sql = "select max(custno)+1 from member_tbl_02";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if ( rs.next() ) {	return rs.getInt(1); 	}
			
		} catch (Exception e) { System.out.println(e); 	}
		return 0;
	}
	
	// 2. 회원등록
	public boolean join( MemberDto dto  ) {
		String sql ="insert into member_tbl_02(custname , phone , address , joindate , grade , city) values(?, ?, ?, ?, ?, ?);";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getCustname());
			ps.setString(2, dto.getPhone());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getJoindate());
			ps.setString(5, dto.getGrade());
			ps.setInt(6, dto.getCity());
			ps.executeUpdate(); return true;
		} catch (Exception e) { 	System.out.println(e);		}
		return false;
	}
	
	// 3. 모든회원조회
	public ArrayList<MemberDto> getMemberList(){
		ArrayList<MemberDto> memberlist = new ArrayList<>();
		String sql = "select custno , custname , phone , address , joindate , if ( grade = 'A' , 'VIP' , if ( grade = 'B' , '일반' , '직원' )  )  as g ,  city  from member_tbl_02;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while ( rs.next() ) {
				memberlist.add(new MemberDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getInt(7)) ); 
				
			}
		} catch (Exception e) { System.out.println(e); 	}
		System.out.println(memberlist);
		return memberlist;
	}
	
	// 4. 회원1명의 정보 조회
	public MemberDto getMember( int custno ) {
		String sql = "select * from member_tbl_02 where custno="+custno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if ( rs.next() ) { 
				return new MemberDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), 
						rs.getString(6), rs.getInt(7));
			}
		} catch (Exception e) { System.out.println(e); 	}
		return null;
	}
	
	// 5. 회원1명 정보업데이트
	public boolean updateMember( MemberDto dto , int custno ) {
		String sql = "update member_tbl_02 set "
				+ "custno = ? , custname = ? , phone = ? , address = ? , joindate = ? , "
				+ "grade = ? , city = ? where custno= ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setInt(7, dto.getCity());
			ps.setInt(8, custno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
	
	// 6. 매출페이지 조회
	public ArrayList<MemberDto> view() {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select member.custno , member.custname ,   "
				+ " if ( member.grade = 'A' , 'VIP' , if ( member.grade = 'B' , '일반' , '직원' )  )  as 고객등급 , "
				+ " sum(money.price*money.amount) as 매출 "
				+ " from member_tbl_02 member join money_tbl_02 money on member.custno = money.custno  group by member.custno;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), null, null, null, rs.getString(3), 0);
				dto.setPrice(rs.getInt(4));		
				list.add(dto );
			}
		} catch (Exception e) { System.out.println(e); 	}
		return list;
	}
}

