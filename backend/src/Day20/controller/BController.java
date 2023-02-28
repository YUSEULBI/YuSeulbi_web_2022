package Day20.controller;

import java.util.ArrayList;

import Day09.ex10_게시판.controller.Bcontroller;
import Day20.model.Dao.BoardDao;
import Day20.model.Dao.MemberDao;
import Day20.model.Dto.BoardDto;
import Day20.model.Dto.CategoryDto;
import P_회원시스템.과제4_MVC.controller.Mcontroller;

public class BController {

	private static BController bController = new BController();
	private BController() {
		// TODO Auto-generated constructor stub
	}
	public static BController getInstance() {
		return bController;
	}
	
	// 1. 카테고리 추가 처리
	public boolean categoryAdd( String cname ) {
		return BoardDao.getInstance().categoryAdd(cname);
	}
	
	// 2. 모든 카테고리 호출 처리
	public ArrayList<CategoryDto> categoryPrint(){
		return BoardDao.getInstance().categoryPrint();
	}
	
	// 3.
	public boolean boardAdd( String btitle , String bcontent , int cno ) {
		int mno = MController.getInstance().getLoginsession();
		return BoardDao.getInstance().boardAdd(btitle, bcontent, mno, cno);
	}
	
	// 4.
	public ArrayList<BoardDto> boardPrintRecent(){
		return BoardDao.getInstance().boardPrintRecent();
	}
	
	// 5.
	public ArrayList<BoardDto> boardPrint( int cno ){
		return BoardDao.getInstance().boardPrint(cno);
	}
}
