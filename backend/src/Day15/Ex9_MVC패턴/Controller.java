package Day15.Ex9_MVC패턴;

import java.util.ArrayList;

public class Controller {
	
	
	//싱글톤
	private static  Controller controller = new Controller();
	private Controller() { 	}
	public static Controller getInstance() {
		return controller;
	}
	//
	public boolean signUp( String mid , String mpw ) {
		// 1. 유효성검사 생략
		// 2. 객체화 [ 이유 : 여러개 변수가 이동하면 로직이 길어짐 -> 여러개 변수를 하나의 객체로  ]
		MemberDTO dto = new MemberDTO(mid, mpw);
		// 3. 해당객체 DB저장 [DAO호출] 하고 실행 성공실패 저장
		boolean result = MemberDAO.getInstance().signUp(dto);
		// 4. 실행결과 반환
		return result;
		
		
	}
	
	public ArrayList<MemberDTO> list() { //페이징처리 , 검색
		// 1. 모든 회원을 호출하는 DAO 메소드 호출해서 결과 얻기
		// return MemberDAO.getInstance().list(); // 이게 더 나음 
		ArrayList<MemberDTO> result = 
		MemberDAO.getInstance().list();
		// 반환 // 원래는 view는 JS일것이기 때문에 바로 반환하는게 아니라 JS용객체를 만들어서 반환예정
		return result;
	}
	
	
	public boolean  update( int mno , String mpw ) {
		//반환값을 스택에 저장해서 이용할 일이 없으니까 반환값 바로 리턴
		return MemberDAO.getInstance().update(mno, mpw);
		
	}
	
	//회원삭제
	public boolean delete ( int mno ) {
		return MemberDAO.getInstance().delete(mno);
	}
}
