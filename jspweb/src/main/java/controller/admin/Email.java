package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;

/**
 * Servlet implementation class Email
 */
@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 받을 회원 이메일 요청
		String memail = request.getParameter("memail");
		System.out.println(memail);
		
		// 2. 인증코드 만들기
		String auth = "";
		
		for ( int i = 0 ; i<6 ; i++ ) { // 6자리 난수 생성
			Random random = new Random();
			auth += random.nextInt(10); // 0~9사이의 정수 생성
		};
		System.out.println( "auth : " + auth );
		
		// 3. 인증코드와 받는 사람의 이메일에게 보내기 
		
		// MemberDto dto = new MemberDto(); dto.sendEmail(memail, auth);
		
		// 스택변수없이 힙만들고 함수실행하고 사라짐 , 재호출 안됨
		boolean result =  new MemberDto().sendEmail(memail, auth);
		if ( result ) { 
			response.getWriter().print( auth ); // 성공하면 인증코드 반환
		}else {
			response.getWriter().print( result ); // 실패하면 false 반환
		}
		// 3. 인증코드 보내기
		
		
		
		// 2. smtp
			/*
			  간이 메일 전송 프로토콜
			  simple mail transfer protocol
			  메일 서버 ( 네이버 , 구글 , 카카오  , 다음 ) 에게 우편 전송
			  qweqwe@naver.com -> 네이버에게 보내는거임
			JAVA MAIL 라이브러리 [ java-mail ,
			 
			 */
	}

}
