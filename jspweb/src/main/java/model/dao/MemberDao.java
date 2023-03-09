package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao dao = new MemberDao();
	private MemberDao() { 	}
	public static MemberDao getInstance() { return dao; }
	
	// 1. 회원가입
	public boolean signup( MemberDto dto ) {
		String sql ="insert into member( mid , mpwd , mimg , memail ) values ( ? , ? , ? , ? );";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpwd() );
			ps.setString(3, dto.getMimg() );
			ps.setString(4, dto.getMemail() );
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}return false;
	}
	
	// 2. 모든회원호출
	public ArrayList<MemberDto> getMemberList( ) {
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select * from member;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				MemberDto dto = new MemberDto(
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("모든회원호출 : " + e);
		}return list;
	}
	
	// 3. 아이디 중복체크
	public boolean idCheck( String mid ) {	//문자열 ' ' vs 정수/실수 안혀
		// String sql = "select * from member where mid = '"+mid+"'";
		String sql = "select * from member where mid = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			// 만약에 검색 결과 레코드가 존재하면 중복 아이디
			if ( rs.next() ) { return true;	}
			
		} catch (Exception e) {
			System.out.println(e);
		}return false; // 없으면 중복 아이디 아님
	}
	
	public boolean login( String mid , String mpwd ) {
		String sql = "select * from member where mid = ? and mpwd = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			rs = ps.executeQuery();
			if ( rs.next() ) { return true;	} // 있으면  true
		} catch (Exception e) {
			System.out.println(e);
		}return false; // 없으면 false
	}
}




