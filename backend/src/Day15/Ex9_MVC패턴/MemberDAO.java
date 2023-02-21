package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class MemberDAO { // M?
	
	//DB연동 -> 싱글톤
	
	// 싱글톤 : Dao 싱글톤 사용하는 이유 : 프로그램내 DB연동 1번만 해서 하나의 연동객체 사용 하려고.
		// 1. 내부에 객체 만들기
	private static MemberDAO dao = new MemberDAO(); 
		// 2. 생성자는 private -> 외부에서 new 사용금지
	
		// 3. 외부에서 내부객체 사용할 수 있게 내부객체 반환 메소드 [ getInstance ]
	public static MemberDAO getInstance() { 	return dao; 	}
	
	
	// 1. 필드
	private Connection conn; 		// 1. 연결된 DB구현객체 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQL 조작 [ + 매개변수 가능 ] 인터페이스
	private Resultset rs;			// 3. 실행된 SQL 결과 확인 인터페이스
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동될 수 있게 하려고 ]
	private MemberDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15","root","1234");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 3. SQL 처리 메소드
	// 1. 회원가입 메소드 // 인수:DTO 반환:true false
	public boolean signUp( MemberDTO dto ) {
		
			// 1. sql작성
			String sql = "insert into member(mid,mpw) values( ? , ? );";
		try {
			// 2. 연동DB에 sQL 대입 [ ps -> 매개변수 조작 ]
			ps = conn.prepareStatement(sql);
			
			// ps의 매개변수에대한 조작
				// SQL첫번째?
			ps.setString(1, dto.getMid());
				// SQL두번째?
			ps.setString(2, dto.getMpw());
			// ps의 실행
			ps.executeUpdate();
			
			return true; // 문제없이 실행되면 저장 성공
		}catch (Exception e) {
			System.out.println( "DB오류"+e );
			return false; // try 저장 실패시 실패 반환
		}
	}
	///////////////////////////////////////////////////////////////
	
	// 2. 모든 회원 출력 [ 인수 : X /  반환 : 여러명[ArrayList] 회원[Member] ]
	public ArrayList<MemberDTO> list() {
		return null;
	}
	
	
	
	
}
