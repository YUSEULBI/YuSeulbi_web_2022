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
 * Servlet implementation class Board
 */
@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청시 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		// 매개변수 요청 [ AJAX data 속성에서 보내준 매개변수 이름 ]
		String content = request.getParameter("content");
			System.out.println("content : " + content);
		String writer =  request.getParameter("writer");
			System.out.println("writer : " + writer);
			
		// 객체화 [ int 필드기본값 0 , 객체필드 기본값 null ]
		BoardDto boardDto = new BoardDto(0, content, writer, null);
			System.out.println("dto : "+boardDto);
		// 4.Dao 호출해서 결과 저장
		boolean result = BoardDao.getInstace().onwrite(boardDto);
			System.out.println("onwrite result : " + result); 
		// 5. dao결과 true / false response
		// 한글없어서 인코딩안하고 truefalse는 잭슨 쓸 필요는 없어서 그대로 response ( 'true' vs '{true}' )
		response.getWriter().print(result);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BoardDto> list = BoardDao.getInstace().onRead();
		System.out.println( "dao List : " + list); // dao 반환값 확인
		
		// json 문자형식으로 변환
		ObjectMapper objectMapper = new ObjectMapper(); // 1. Jackson 라이브러리에서 제공하는 클래스
		
		String jsonList = objectMapper.writeValueAsString(list); // 2. dao로 부터 받은 list객체를 변환
		System.out.println(jsonList); // 형변환 확인
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonList);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
