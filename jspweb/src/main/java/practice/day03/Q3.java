package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Q3
 */
@WebServlet("/Q3")
public class Q3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q3() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get에 받았습니다.");
		ArrayList<ProductDto> list = ProductDao.getInstance().onP_Print();
		System.out.println("dao list : " + list);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArrayList = mapper.writeValueAsString(list);
		System.out.println(jsonArrayList);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArrayList);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		
		ProductDto dto = new ProductDto(0, pname, pprice);
		boolean result = ProductDao.getInstance().onProduct(dto);
		response.getWriter().print(result);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		String newPname = request.getParameter("newPname");
		int newPprice = Integer.parseInt(request.getParameter("newPprice"));
		boolean result =  ProductDao.getInstance().pupdate(pno, newPname, newPprice);
		response.getWriter().print(result);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno")); 
 		boolean result = ProductDao.getInstance().pdelete(pno);
 		response.getWriter().print(result);
		
	}

}
