package Day20.controller;

import Day20.model.Dao.MemberDao;
import Day20.model.Dto.MemberDto;

public class MController {

	private static MController dao = new MController();
	private MController() {
		// TODO Auto-generated constructor stub
	}
	public static MController getInstance() {
		return dao;
	}
	
	// 로그인세션
	private int loginsession = 0; // 로그인된 회원번호
	public int getLoginsession() {
		return loginsession;
	}
	public void setLoginsession(int loginsession) { // setter
		this.loginsession = loginsession;
	}
	
	
	//회원가입처리 [ 아이디 중복 체크 ]
	public int signup( String mid , String mpw , String mname , String mphone ) {
		// 1. 유효성검사 [ 글자수 , 중복체크 등등 ]
			// 1. 아이디 중복체크
		if ( MemberDao.getInstance().idCheck(mid)) {
			return 2; // 중복된 아이디
		}
		
		// 2. 객체화
		MemberDto dto = new MemberDto(0, mid, mpw, mname, mphone);
		
		// 3. 회원가입 DB처리 후 DB결과를 반환
		return MemberDao.getInstance().signup(dto);
		
	}
	
	
	
	// 2. 
	public boolean login( String mid , String mpw ) {
		// 1. 유효성검사 
		
		// 2.
		int result = MemberDao.getInstance().login(mid, mpw);
		if ( result == 0 ) { return false;	}
		else {
			// 3. 로그인증거 [ 로그인 정보저장소 세션 ]
			loginsession = result; // 반환된 회원번호 저장
			return true;	}
		
	}
	
}


