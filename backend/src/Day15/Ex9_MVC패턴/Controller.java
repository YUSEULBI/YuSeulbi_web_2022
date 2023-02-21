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
	
	public ArrayList<MemberDTO> list() {
		return null;
	}
}
