package controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;

/**
 * Servlet implementation class Point
 */
@WebServlet("/point")
public class Point extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Point() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Integer> map = ProductDao.getInstance().getSum();
		System.out.println("서블릿 map : "+map);
		
		ObjectMapper mapper = new ObjectMapper();
		String json =  mapper.writeValueAsString(map);
		System.out.println("서블릿 map->json : "+json);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post실행");
		String mpcomment = request.getParameter("mpcomment");
		int mpamount = Integer.parseInt(request.getParameter("mpamount"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		boolean result = MemberDao.getInstance().setPoint(mpcomment, mpamount, mno);
		response.getWriter().print(result);
	}

}
