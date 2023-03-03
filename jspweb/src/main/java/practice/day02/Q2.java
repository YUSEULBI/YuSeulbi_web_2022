package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class q2
 */
@WebServlet("/Q2")
public class Q2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet실행");
		ArrayList<Dto2> list = Dao2.getInstance().getData();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonList = objectMapper.writeValueAsString(list);
		
		System.out.println(list);
		System.out.println(jsonList);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String q1 = request.getParameter("q1");
		String q2 = request.getParameter("q2");
		double q3 = Double.parseDouble(request.getParameter("q3"));
		int q4 = Integer.parseInt(request.getParameter("q4"));
		String q5 = request.getParameter("q5");
		String q6 = request.getParameter("q6");
		boolean q7 = Boolean.parseBoolean(request.getParameter("q7"));
		String q8 = request.getParameter("q8");
		String q9 = request.getParameter("q9");
		
		Dto2 dto2 = new Dto2(q1, q2, q3, q4, q5, q6, q7, q8, q9);
		
		boolean result = Dao2.getInstance().setData(dto2);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
