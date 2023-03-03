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
		// 1
		//ArrayList<Object> list = Dao.getInstance().getData();
		ArrayList<Dto> list = Dao.getInstance().getData2();
		
			// * JAVA객체와 JS객체는 체계/형태가 다르다. [ 호환 불가 ]
			// 해결 : JAVA객체를 JS객체로 바꾸자 [ Object -> json ]
			// json : 자바스크립트 객체
			// 1.라이브러리 jackson -databind , annotations , core ]
			// 2. ObjectMapper 객체 생성 [ jackson 라이브러리 
		ObjectMapper objectMapper = new ObjectMapper();
		// objectMapper.writeValueAsString(자바객체); --> 자바객체 --> JSON문자열반환
		String jsonArray = objectMapper.writeValueAsString(list);
		// 자바객체가 json형식으로 문자열 변환 // [ {} , {} ]
		
		//System.out.println(list);
		//System.out.println(jsonArray); // 자바객체가 json형식으로 문자열 변환 // [ {} , {} ]
			
		// 2. 요청으로 받은 결과를 jS에게 전달
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); // 전송[전달]타입을 json 형식
		response.getWriter().print(jsonArray); // 변환된json형식 문자열 전달
		
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
		//boolean result = Dao.getInstance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		// 3. 변수10개를 ---> DTO 1개 생성 
		Dto dto = new Dto(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		// 3-4 DAO메소드에게 DTO 1개 전달
		boolean result = Dao.getInstance().setData2(dto);
				
		// *response : JS에게  응답 보내는 객체
		// 4. 응답시 데이터 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 5. DAO 결과를 JS에게 전달하기
		response.getWriter().print(result);
	}

}
