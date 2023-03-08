package model.dao;

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
	
}
