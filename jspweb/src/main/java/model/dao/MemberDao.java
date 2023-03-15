package model.dao;

import java.sql.Statement;
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
			ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
			ps.setString(1, dto.getMid() );
			ps.setString(2, dto.getMpwd() );
			ps.setString(3, dto.getMimg() );
			ps.setString(4, dto.getMemail() );
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if ( rs.next() ) { 
				int pk = rs.getInt(1);
				setPoint("회원가입축하", 100, pk );
			}
				// 포인트 지급 [ 내용 , 개수 , 방금 회원가입한 회원번호pk ]
				/*
				 	1. insert 이후에 자동으로 생성된 auto key 찾기
				 	con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
				 
				 	2. 생성된 pk 결과 담기
				 	rs = ps.getGeneratedKeys();
				 	
				 	3. 검색된 레코드 결과 에서 pk 호출
				 	rs.next() ---> rs.getInt(1);
				 */
				
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
	
	// 8. 포인트 적립 함수 [ 1.지급내용 / 2.지급개수 / 3.대상 ]
	public boolean setPoint( String content , int point , int mno ) {
		String sql = "insert into mpoint( mpcomment , mpamount , mno ) values( ? , ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println(e); 	}
		return false;
	}
	
	// 9. 회원탈퇴 [ 인수 : mid , mpwd / 반환 : boolean 성공실패 ]
	public boolean delete( String mid , String mpwd ) {
		String sql = "delete from member where mid = ? and mpwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid); ps.setString(2, mpwd);
			int count = ps.executeUpdate(); // 삭제된 레코드 수 반환
			if ( count == 1 ) { return true;	} // 레코드 1개 삭제 성공시
		} catch (Exception e) { System.out.println(e); 		}
		return false;
	}
	
	// 10. 회원수정 [ 인수 : mid , mpwd , newmpwd , memail / 반환 : 성공실패 ]
	public boolean update( String mid , String mpwd , String newmpwd , String memail , String newmimg ) {
		String sql = "update member set mpwd = ? , memail = ? , mimg = ? where mid = ? and mpwd = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newmpwd);
			ps.setString(2, memail);
			ps.setString(3, newmimg);
			ps.setString(4, mid);
			ps.setString(5, mpwd);
			int count = ps.executeUpdate();	// 수정된 레코드 수 반환
			if ( count == 1 ) { return true;	} // 레코드 1개 수정 성공시 true
			
		} catch (Exception e) { System.out.println(e); 		}
		return false;
	}
	
	// 11. 회원id --> 회원mno
	public int getMno( String mid ) {
		String sql = "select mno from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if ( rs.next()) { return rs.getInt(1); }
		} catch (Exception e) { System.out.println(e); 		}
		return 0;
	}
	
	
}




