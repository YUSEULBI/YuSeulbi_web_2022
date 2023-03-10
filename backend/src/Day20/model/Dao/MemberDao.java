package Day20.model.Dao;

import Day20.model.Dto.MemberDto;

public class MemberDao extends Dao {
	
	//싱글톤
	private static MemberDao dao = new MemberDao();
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}
	public static MemberDao getInstance() {
		return dao;
	}
	
	// 기능 메소드
	
	// 1. 아이디 중복체크 [ 아이디 검색 ]
	public boolean idCheck( String mid ) {
		String sql = "select * from member where mid = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if ( rs.next() ) { return true; } // 검색된 레코드가 있으면 [ 중복 아이디 ] 
			else { return false; }
			// 없으면 중복된 아이디가 아니다
			
		}catch (Exception e) {
			System.out.println(e);
			return true;
		}
		
	}
	
	// 2. 회원가입
	public int signup( MemberDto dto ) {
		String sql ="insert into member ( mid , mpw , mname , mphone ) values( ?, ? , ? , ? );";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getMid());
			ps.setString(2, dto.getMpw());
			ps.setString(3, dto.getMname());
			ps.setString(4, dto.getMphone());
			ps.executeUpdate();
			return 1;
		}catch (Exception e) { 	System.out.println(e);		}
		return 3;
		
		
	}
	
	
	// 3. 로그인 [ 반환 : 로그인 성공한 회원 번호 ]
		// 로그인세션[로그인되어있는동안] : 1. 회원번호 또는 나중에는 loginDto[회원번호 , 포인트 , 등급]를 새로 만들어서 저장
	public int login( String mid , String mpw) {
		String sql = "select * from member where mid = ? and mpw = ? ;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if ( rs.next() ) {
				// 레코드가 존재하면 로그인성공
				return rs.getInt(1); // 검색된 레코드에서 첫번째 필드 반환
			}else {
				// 레코드가 존재하지않으면 로그인실패
				return 0;
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return 0;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
