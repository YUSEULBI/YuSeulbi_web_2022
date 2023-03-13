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
	
	// 특정 회원 반환 + 보유포인트
	public MemberDto getMember( String mid ) {
		// 조인한 레코드
		String sql = "select m.mno , m.mid , m.mimg , memail , sum( p.mpamount ) as mpoint"
				+ " from member m , mpoint p"
				+ " where m.mno = p.mno and m.mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if ( rs.next() ) { // 조인한 결과는 찾는 값이 없어도 null값이 포함된 레코드1개 들어옴 --> JS로 null값이 포함된 object로 반환됨
				// 결과필드 :  mno[1] , mid[2] , mimg[3] , memail[4] , mpoint[5]
				MemberDto dto = new MemberDto( // 비밀번호 빼고
						rs.getInt(1), rs.getString(2), 
						null, rs.getString(3), rs.getString(4));
				dto.setMpoint(rs.getInt(5)); // 늦게 만들어서 생성자 없어서 이렇게 추가
				return dto; // 레코드1개
			}
		} catch (Exception e) { 	System.out.println(e); 		}
		return null; // 없다
	}
	
	// 6. 아이디 찾기
	public String findid( String memail ) {
		String sql = "select mid from member where memail = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if ( rs.next() ) {
				return rs.getString(1); // 있으면 아이디 반환
			}
		} catch (Exception e) { System.out.println(e); 	}
		return "false"; // 없으면 false
	}
	
	// 7. 비밀번호 찾기
	
	public String findpwd( String mid , String memail , String updatePwd ) {
		
		String sql = "select mno from member where mid = ? and memail = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, memail);
			rs = ps.executeQuery();
			if ( rs.next() ) { 	 	
				
				sql = "update member set mpwd = ? where mno = ? ";
				ps = con.prepareStatement(sql);
				ps.setString(1, updatePwd);
				ps.setInt(2, rs.getInt(1));
				int result = ps.executeUpdate(); // 업데이트한 레코드 개수 반환
					if ( result == 1 ) { 
						// -- 이메일 테스트 되는 경우
						// new MemberDto().sendEmail(memail, updatePwd); // 임시 비밀번호를 이메일로 보내기
						// return "true";
						
						// 이메일 전송 안되는 경우
						return updatePwd;
					}
			}
			
		} catch (Exception e) {  System.out.println(e); 	}
		return "false";
	}
}




