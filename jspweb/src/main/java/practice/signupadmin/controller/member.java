package practice.signupadmin.controller;

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

import practice.signupadmin.dao.MemberDao;
import practice.signupadmin.dto.MemberDto;

/**
 * Servlet implementation class member
 */
@WebServlet("/pppmember")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public member() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDto> list = MemberDao.getInstance().getMemberList();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = mapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonList);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get에서 통신받았습니다.");
		String uploadpath = request.getSession().getServletContext().getRealPath("/practice/signupadmin/mimg");
		System.out.println(uploadpath);
		
		MultipartRequest multi = new MultipartRequest(
					request ,		// 1.요청방식
					uploadpath ,	// 2.첨부파일 가져와서 저장할 서버내 폴더
					1024*1024*10 ,	// 3.첨부파일 허용 범위 용량 [ 바이트 단위 ]
					"UTF-8" ,		// 4.첨부파일 한글 인코딩
					new DefaultFileRenamePolicy()	//5. 동일한 첨부파일명이 있으면 뒤에 숫자 붙여서 식별
				);
		
		String mid = multi.getParameter("mid");
		String mpwd = multi.getParameter("mpwd");
		String memail = multi.getParameter("memail");
		String mimg = multi.getFilesystemName("mimg");
		
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		System.out.println(dto);
		
		boolean result = MemberDao.getInstance().signup(dto);
		response.getWriter().print(result);
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
