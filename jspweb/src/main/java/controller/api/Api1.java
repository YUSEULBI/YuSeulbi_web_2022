
package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api1
 */
@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Api1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 공공데이터 포털에서 신청한 데이터 가져오기 [ 안산시 전기차 충전소 현황 ]
			// URL클래스 java.net
			// .openStream() 스트림 사용가능 : 해당 객체의 연결된 url 스트림 제공 함수 [ 반환 : InputStream ] 한글깨짐
		//URL url = new URL("URL주소");
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=Iqz2hhoDi1svJ0zCQoU1Ol%2F%2Bq6uALaVVHNlDUHV9UF%2F7XsZwh82IOjzCL77bBoSdnftYuB9kq38EGPG9xOeamg%3D%3D");
		
		
		// 2. 해당 URL 의 데이터 [ 스트림(바이트) ] 읽어오기 위한 스트림 객체 생성
		//InputStream inputStream = url.openStream(); // 한글깨짐
		//InputStreamReader reader = new InputStreamReader( url.openStream() , "UTF-8" );  // 한글안깨지게
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream() , "UTF-8")); // 한번에 스트링[문자열]으로 가져옴
			//
			//byte[] array1 = new byte[100000];
			//char[] array2 = new char[100000];
		
		// 3. 스트림으로부터 바이트 읽어오기
		//inputStream.read( array1 ); 		// 바이트 배열로 읽어오기
		//reader.read( array2 );				// 문자 배열로 읽어오기
		String result = bf.readLine();		// 모든 바이트 읽은 후 문자열String 반환
		
		System.out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
