package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {       super();    }

    
    
 // 회원가입
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// 첨부파일 있을 때
 		// - request는 첨부파일에 대한 요청이 불가능 ---> 외부 라이브러리
 		// 프로젝트 build path 에 cos.jar 추가
 		// 프로젝트 WEB-INF  -> lib -> cos.jar 추가
 		
 		// MultipartRequest 클래스 제공
 			// 1. 요청방식 = HTTP request
 			// 2. 저장폴더 : 1. 프로젝트[git폴더] 2. 서버[워크스페이스 경로] // 수업은 서버에 올림
 					// 서버폴더 경로 찾기 :request.getSession().getServletContext().getRealPath("(webapp생략)/폴더명");
 			// 3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
 			// 4. 첨부파일 요청 한글 인코딩
 			// 5. 첨부파일 파일명 중복일경우 뒤에 자동 붙임
 			
 		
 		// 1bit : 0 , 1
 		// 1byte : 0101010101
 		// 8bit -> 1byte
 		// 1kbte 1024byte -> 1kb
 		// 1mbyte 1024byte -> 1mb
 		// 1gbyte 1024byte -> 1gb
 		//1024*1024  10 -: 10mb
 		
 		// 현재 작업중인 프로젝트 경로 [ git ]
 		// String path = "C:\\Users\\504\\git\\YuSeulbi_web_2022\\jspweb\\src\\main\\webapp\\member\\pimg";
 		
 		// 현재 서버의 배포된 프로젝트내 폴더 경로 찾기
 		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
 		System.out.println(uploadpath);
 		
 		// * 업로드 [ 파일이동 : 유저파일 -> 서버폴더내 이동 ]
 		MultipartRequest multi = new MultipartRequest(
 					request, 		// 1. 요청방식
 					uploadpath,		// 2. 첨부파일 가져와서 저장할 서버내 폴더
 					1024*1024 *10 ,	// 3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
 					"UTF-8" ,		// 4. 첨부파일 한글 인코딩
 					new DefaultFileRenamePolicy() // 5. 동일한 첨부파일명이 있으면 뒤에 숫자 붙여서 식별
 				);
 		
 		// 그외 매개변수 요청 [ request --> multi / ****form 하위태그 내 input태그의 name 식별자를 써주기**** ]
 		String mid = multi.getParameter("mid"); // 호출할 input의 name
 		String mpwd = multi.getParameter("mpwd");
 		String memail = multi.getParameter("memail");
 		String mimg = multi.getFilesystemName("mimg");	// 첨부파일된 파일명 호출 [ .getFilesystemName ]
 		
 		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
 			System.out.println("dto : " + dto);
 		
 		boolean result = MemberDao.getInstance().signup(dto);
 		response.getWriter().print(result);
 		
 		// 첨부파일 없을 때 =----------------------------------//
 		/*
 		request.setCharacterEncoding("UTF-8");
 		String mid = request.getParameter("mid");
 		String mpwd = request.getParameter("mpwd");
 		String memail = request.getParameter("memail");
 		String mimg = request.getParameter("mimg");
 		
 		// 2. DTO만들기
 		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
 			System.out.println("dto : "+dto);
 			
 		// 3. dao 호출 응답결과받기
 		boolean result = MemberDao.getInstance().signup(dto);
 		
 		// 4. 결과응답
 		response.getWriter().print(result);;
 		*/
 	}
    
    
	// 회원정보 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 모든 회원 명단 호출
		ArrayList<MemberDto> list = MemberDao.getInstance().getMemberList();
		System.out.println(list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList =  mapper.writeValueAsString(list);
		System.out.println(jsonList);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonList);
		
	}

	

	// 회원정보수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 업로드 코드 구현
					// 1. 업로드 한 파일을 해당 서버 경로로 업로드
				String path = request.getSession().getServletContext().getRealPath("/member/pimg");
				// * 업로드 [ 파일이동 : 유저파일 -> 서버폴더내 이동 ]
		 		MultipartRequest multi = new MultipartRequest(
		 					request, 		// 1. 요청방식
		 					path,		// 2. 첨부파일 가져와서 저장할 서버내 폴더
		 					1024*1024 *10 ,	// 3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
		 					"UTF-8" ,		// 4. 첨부파일 한글 인코딩
		 					new DefaultFileRenamePolicy() // 5. 동일한 첨부파일명이 있으면 뒤에 숫자 붙여서 식별
		 				);
		 		
		 		// 그외 매개변수 요청 [ request --> multi / ****form 하위태그 내 input태그의 name 식별자를 써주기**** ]
		 		String mid = (String)request.getSession().getAttribute("login"); 		System.out.println("mid : " + mid);
		 		String mpwd = multi.getParameter("mpwd"); 								System.out.println("mpwd : " + mpwd);
		 		String newmpwd = multi.getParameter("newmpwd"); 						System.out.println("newmpwd : " + newmpwd);
		 		String memail = multi.getParameter("memail"); 							System.out.println("memail : " + memail);
		 		String newmimg = multi.getFilesystemName("newmimg"); 					System.out.println("newmimg : " + newmimg);
		 		String defaultimg = multi.getParameter("defaultimg");					System.out.println("defaultimg : " + defaultimg);
		 		
		 		// 3. 만약에 첨부파일이 없으면
		 		if ( newmimg == null ) {		
		 			// 기존 이미지 파일 그대로 사용
		 			newmimg = MemberDao.getInstance().getMember(mid).getMimg();
		 		}
		 		if ( defaultimg.equals( "true" )) { // 기본프로필 사용
		 			newmimg = null;
		 		}
		 		
		 		// * 프로필 변경시 기존프로필 실제파일 서버에서 삭제[]
		 		
		 		boolean result = MemberDao.getInstance().update(mid, mpwd, newmpwd, memail, newmimg);
		 		response.getWriter().print(result);
		
//		// 1. 로그인된 회원수정
//		String mid = (String)request.getSession().getAttribute("login"); System.out.println("mid : "+mid);
//		String mpwd = request.getParameter("mpwd"); System.out.println("mpwd : "+mpwd);
//		String newmpwd = request.getParameter("newmpwd"); System.out.println("newmpwd : "+newmpwd);
//		String memail = request.getParameter("memail"); System.out.println("memail : "+memail);
//		// 2.
//		boolean result = MemberDao.getInstance().update(mid ,  mpwd, newmpwd , memail);
//		// 3.
//		response.getWriter().print(result);
	}

	// 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 로그인된 회원탈퇴
			// 1. 로그인된 회원 아이디 가져오기 [ 세션 ( Object ) ]
		String mid = (String)request.getSession().getAttribute("login");
		System.out.println( "mid : "+ mid );
		String mpwd = request.getParameter("mpwd");
		
		
		// 2. Dao에게 결과 요청후 결과받기
		boolean result = MemberDao.getInstance().delete(mid , mpwd);
		System.out.println("result : " + result);
		
		// 3. 결과 ajax에게 보내기
		response.getWriter().print(result);
	}

}












































