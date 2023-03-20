package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/board/reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 2.
		ArrayList<ReplyDto> result = BoardDao.getInstance().getReplyList(bno);
		
		// 3.
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}

	// 댓글작성
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// 1.
		request.setCharacterEncoding("UTF-8");
		int mno = 
		MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		System.out.println("mno : "+mno);
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("bno : "+bno);
		String rcontent = request.getParameter("rcontent");
		System.out.println("rcontent : "+rcontent);
		
		ReplyDto dto = new ReplyDto(rcontent, mno, bno);
		int type = Integer.parseInt(request.getParameter("type"));
		if ( type == 1 ) { // 상위댓글
			
			System.out.println("dto : "+dto);
			
		}else if ( type == 2 ) { // 하위댓글
			// rindex를 dto에 추가
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			dto.setRindex(rindex);
			System.out.println("dto : "+dto);
		}
		
		
		// 2.
		
		
		// 3.
		boolean result = BoardDao.getInstance().rwrite(dto);
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
