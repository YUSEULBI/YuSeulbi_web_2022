package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	// 로그인 / 회원정보 호출
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

	// 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	// 회원정보수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
