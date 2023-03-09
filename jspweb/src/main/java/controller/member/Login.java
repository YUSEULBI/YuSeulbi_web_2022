package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX에게 데이터 요청
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		// 2. DAO 호출해서 요청데이터를 보내서 결과 얻기
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		// 로그인 성공하면
		if ( result == true ) {
			// 로그인 세션 만들기
				// request.getSession() : 서버[톰캣] 내 세션 객체 호출
				// .setAttribute( "key" , 데이터 );	// 서버[톰캣] 내 세션객체에 속성[데이터] 추가
			
			// 세션에 login이라는 이름으로 로그인성공한 데이터(mid)를  저장
			request.getSession().setAttribute("login", mid); 
		}
		
		// 3. DAO에게 받은 결과를 AJAX에게 전달
		response.getWriter().print(result);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
