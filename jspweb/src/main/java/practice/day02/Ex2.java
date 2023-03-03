package practice.day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. request : JS 요청 객체
		// 1. 요청시 데이터 한글인코딩
		request.setCharacterEncoding("UTF-8");
		
		// System.out.println(request.getParameter( 매개변수명 ) );
		// getParameter 반환값 무조건 String --> 필요에 따라 형변환 필요함. 
		String data1 = request.getParameter("data1"); 
		String data2 = request.getParameter("data2");
		Double data3 = Double.parseDouble(request.getParameter("data3")); //String을 Double로 형변환
		int data4 = Integer.parseInt( request.getParameter("data4") );
		String data5 = request.getParameter("data5");
		String data6 = request.getParameter("data6");
		String data7 = request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean( request.getParameter("data8") );
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		
		// 3. DAO 메소드에 인수 10개 전달
		boolean result = Dao.getInstance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		// *response : JS에게  응답 보내는 객체
		// 4. 응답시 데이터 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 5. DAO 결과를 JS에게 전달하기
		response.getWriter().print(result);
	}

}