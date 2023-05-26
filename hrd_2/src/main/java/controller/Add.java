package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
@WebServlet("/hrd2/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
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
		System.out.println("post실행");
		request.setCharacterEncoding("UTF-8");
		// 1. 매개 변수 [ form name 동일 ] 요청
		String sno = request.getParameter("sno"); 		System.out.println("sno : "+ sno);
		int ekor = Integer.parseInt(request.getParameter("ekor"));		System.out.println("ekor : "+ ekor);
		int emath = Integer.parseInt(request.getParameter("emath"));	System.out.println("emath : "+ emath);
		int eeng = Integer.parseInt(request.getParameter("eeng"));		System.out.println("eeng : "+ eeng);
		int ehist = Integer.parseInt(request.getParameter("ehist"));	System.out.println("ehist : "+ ehist);
		
		// 2. dto에 담기 
		Dto dto = new Dto(sno, ekor, emath, eeng, ehist);
		
		// 3. dao
		Dao dao = new Dao();
		boolean result =  dao.add(dto);
		if ( result ) { response.sendRedirect("/hrd_2/add.jsp"); }
		else {}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
