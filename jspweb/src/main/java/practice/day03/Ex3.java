package practice.day03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3
 */
@WebServlet("/Ex3") // <-- 해당 클래스 [ 자원 ] URL 정의 , localhost:8080/프로젝트명(jspweb)/서블릿명(Ex3)
public class Ex3 extends HttpServlet { // <-- HttpServlet 클래스에게 상속 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 1. GET 메소드
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST메소드 에서 통신 받았습니다.");
	}
	

	// 2. POST 메소드
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET메소드 에서 통신 받았습니다.");
	}

	// 3. PUT 메소드
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PUT메소드 에서 통신 받았습니다.");
	}

	// 4. DELETE 메소드
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DELETE메소드 에서 통신 받았습니다.");
	}

}
