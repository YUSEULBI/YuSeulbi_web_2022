package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ChatDto;

/**
 * Servlet implementation class ProductChat
 */
@WebServlet("/product/chat")
public class ProductChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductChat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		int chatmno = Integer.parseInt(request.getParameter("chatmno"));
		
		ArrayList<ChatDto> list = ProductDao.getInstance().getChatList(pno, mno , chatmno);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ncontent = request.getParameter("ncontent");
		int pno = Integer.parseInt(request.getParameter("pno"));
		int frommno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		int tomno = Integer.parseInt(request.getParameter("tomno"));
		
		ChatDto chatDto = new ChatDto(ncontent, pno, frommno, tomno);
		System.out.println("chatDto : "+chatDto);
		
		boolean result = ProductDao.getInstance().setChat(chatDto);
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
