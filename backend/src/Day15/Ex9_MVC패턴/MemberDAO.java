package Day15.Ex9_MVC패턴;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private Connection conn; 		// 1. 연결만 블루투스역할만 연결된 DB구현객체 가지고 있는 인터페이스
	private PreparedStatement ps;	// 2. 연결된 SQL 내용수정 실행 [ + 매개변수 가능 ] 인터페이스
	private ResultSet rs;			// 3. 실행된 SQL 결과조작 확인 인터페이스 // java.sql
	
	// 2. 생성자 [ 연동코드 -> 객체 생성시 바로 연동될 수 있게 하려고 ]
	private MemberDAO( ) {
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
			ps.executeUpdate(); // insert 수정해죠
			
			return true; // 문제없이 실행되면 저장 성공
		}catch (Exception e) {
			System.out.println( "DB오류"+e );
			return false; // try 저장 실패시 실패 반환
		}
	}
	///////////////////////////////////////////////////////////////
	
	// 2. 모든 회원 출력 [ 인수 : X /  반환 : 여러명[배열 vs ArrayList] 회원모델[MemberDTO객체] ]
	public ArrayList<MemberDTO> list() {
		
		// 회원여러명 담은 리스트 // MemberDTO만 들어갈 수 있는 리스트
		ArrayList<MemberDTO> list = new ArrayList<>();
		
		// 1. SQL 작성
		String sql = "select * from member;"; //모든회원검색
		
		// 2. 연결된 DB에 작성된 SQL대입 [ 예외처리 ]
		try {
			ps = conn.prepareStatement(sql);
		
		// 3. SQL 조작
			
		// 4. SQL 실행 // SQL결과를 rs에 저장 / rs - 실행된 결과 조작
			 rs = ps.executeQuery(); // 결과 검색된 모든 레코드를 레코드 단위로가져옴
			
		// 5. SQL 결과
			 // 레코드 --자바형태--> 객체DTO // 레코드1개 -> DTO1개 -> 회원1개
			 while( rs .next() ) { // rs.next() : 다음레코드이동 [ 없으면 false ] //마지막레코드까지 무한루프
				 // rs.next() 할때마다 다음레코드로 넘어감. 처음엔 rs.[null]
				 
				 // 레코드 --> 객체화  
				 MemberDTO dto = new MemberDTO(
					//[ rs.get필드타입(DB의필드순서번호) ]
				 	rs.getInt(1), rs.getString(2) , rs.getString(3) ) ;
				 
				 System.out.println("회원마다 : " + dto );
				 
				 // 1개 객체만들때마다 list에 추가 
				 list.add(dto);
			}
			 System.out.println("회원 목록 : " + list.toString());
			 // 함수호출한 Controller에 반환
			 return list;
			 
		}catch (Exception e) {
			System.out.println("DB오류 : " + e); 		}
		
		return null;
		
	}
	
	// 3. 비밀번호수정 [ 인수 : 누구[식별가능한것->mno]의 비밀번호를 무엇(새로운 newpw)으로 바꿈 / 반환 : 성공true 실패false ]
	public boolean  update( int mno , String mpw ) {
		
		// 1. SQL 작성
		String sql = "update member set mpw = ? where mno = ?;";
				
		// 2. 연결DB에 SQL대입
		try {
		ps = conn.prepareStatement(sql);
		
		// 3. SQL 조작
		ps.setString(1, mpw);
		ps.setInt(2, mno);
		
		// 4. SQL 실행
		ps.executeUpdate(); // insert , update , delete -> executeUpdate();	 	결과1개
							// select - > ps.executeQuery();					몇개 찾았어? 결과 여러개
		// 5. SQL 결과
		return true;
		
		}catch (Exception e) {
			System.out.println("DB오류 : " + e);
		}
		return false;
	}
	
	
	// 4. 회원 삭제 [ 인수 : 회원 누구를[mno] 삭제할건지 / 반환 : 성공[true]실패[false]  ] 반환이 2가지면 boolean / 여러가지면 byte나 int 성공[1]실패[2]없는회원[3]
	public boolean delete ( int mno ) {
		// 1.SQL작성
		String sql = "delete from member where mno = ?;";
		
		try {
		// 2.SQL대입 / ps는 인터페이스
			ps = conn.prepareStatement(sql);
		// 3.SQL조작
			ps.setInt(1, mno);
		// 4.실행
			ps.executeUpdate(); // insert , update , delete
		// 5.결과반환
			return true;
			
		}catch (Exception e) {
			System.out.println("DB오류 : " + e);
		}
		return false;
	}
}
