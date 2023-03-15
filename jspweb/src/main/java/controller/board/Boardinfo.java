package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class Boardinfo
 */
@WebServlet("/board/info")
public class Boardinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Boardinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type"));
		if ( type == 1 ) { // 전체출력
			ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList();
			ObjectMapper mapper = new ObjectMapper();
			String jsonlist = mapper.writeValueAsString(result);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonlist);
			
			
		}else if (type == 2) { // 개별출력
			int bno =  Integer.parseInt(request.getParameter("bno"));
			System.out.println("bno : " + bno);
			// Dao
			// 형변환
			// 응답
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 업로드
		// 1. 업로드할 파일의 저장 위치 [ 경로 ]
			// 클라이언트[유저] ----X----> git[내프로젝트]
			//            ---------> 서버[배포된프로젝트]
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println("uploadpath : " + uploadpath);
			
			// * 업로드 [ 파일이동 : 유저파일 -> 서버폴더내 이동 ]
		//파일복사 [ 입력받은 file 대용량 바이트 복사하기 ]
 		MultipartRequest multi = new MultipartRequest(
				request, 		// 1. 요청방식
				uploadpath,		// 2. 첨부파일 가져와서 저장할 서버내 폴더
				1024*1024 *10 ,	// 3. 첨부파일 허용 범위 용량 [ 바이트단위 ]
				"UTF-8" ,		// 4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy() // 5. 동일한 첨부파일명이 있으면 뒤에 숫자 붙여서 식별
		);
		System.out.println("multi : "+multi);
		
		// form 전송은 form 하위 name명
		// .getParameter 값을 가져옴
 		int cno = Integer.parseInt(multi.getParameter("cno"));	System.out.println("cno : "+cno);
 		String btitle = multi.getParameter("btitle");			System.out.println("btitle : "+btitle);
 		String bcontent = multi.getParameter("bcontent");		System.out.println("bcontent : "+bcontent);
 		
 		// 첨부파일의 파일명만 호출 [ .getFilesystemName ]
 		String bfile = multi.getFilesystemName("bfile");		System.out.println("bfile : "+bfile);
 		
 		// mid 호출
 		String mid = (String)request.getSession().getAttribute("login");
 		System.out.println("mid : "+ mid);
 		
 		// MemberDao에서 mid를 mno로 바꿔서 받기
 		int mno = MemberDao.getInstance().getMno(mid);
 		// 만약에 회원번호가 존재하지 않으면 글쓰기 불가 유효성검사
 		if ( mno < 1 ) { response.getWriter().print(false); }
 		System.out.println("mno : "+ mno);
 		//dto
 		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
 		System.out.println("dto : "+ dto); //BoardDto클래스에 toString 오버라이드하면 dto안의 객체값을 볼수 있음/ 원래는 주소값이 나옴
 		
 		//dao
 		boolean result = BoardDao.getInstance().bwrite(dto);
 		System.out.println("result : "+result);
 		response.getWriter().print(result);
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
