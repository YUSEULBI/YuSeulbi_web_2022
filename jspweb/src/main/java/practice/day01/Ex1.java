package practice.day01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

/**
 * Servlet implementation class Indextest
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글인코딩
		response.setCharacterEncoding("UTF-8");
		// 실행해서 데이터 호출
		ArrayList<String> result = Dao.getInstance().getData();
		// 확인
		System.out.println("확인 : " + result);
		// JS로 보내기
		response.getWriter().print(result);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String data = request.getParameter("data"); // ajax( data : { "매개변수명" : 데이터  } )
		System.out.println(" JS POST방식으로 받은 데이터 : " + data );
		
		// 1. DB연동 후 요청된 데이터를 DAO에게 전달 후 결과를 result에 저장
		boolean result =
		Dao.getInstance().setData(data);
		
		response.getWriter().print(" POST 메소드 방식으로 잘받았습니다." + result);
				
	}

}
