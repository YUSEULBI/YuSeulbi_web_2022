package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MassageDto;

//해당 클래스를 서버소켓[종착점]으로 만들기
@ServerEndpoint("/chatting/{mid}")
// @ServerEndpoint("/chatting/{mid}/{roompk}")

// 매개변수 받을때
	// 주의* 매개변수 여러개이면 경로에 순서 잘맞추기

// >>>   /경로/{매개변수1}/{매개변수2} 	==> @PathParam("매개변수1") String mid
		/* 
		 >>>[회원아이디 qweqwe 라는 가정]
		 	/jspweb/chatting/qweqwe
		 	/jspweb/chatting/{mid}
			@PathParam("mid") String mid
			매개변수 = qweqwe
		*/
// >>>   /경로?cno=1 			==> request.getParameter("cno")

public class Chatting {
	
	// *-* 접속한 클라이언트 명단 [목록] ( 클라이언트소켓 여러개)
	public static ArrayList<ClientDto> 접속명단 = new ArrayList<>();
	
	
	// 클라이언트 소켓이 접속했을 때의 실행되는 메소드/함수
	@OnOpen			// Session [ 접속한 클라이언트소켓 객체 ] 
	// 서버 엔드포인트의 url매개변수 가져오기 [ @PathParam ] 경로상의변수 가져오기
	public void onOpen( Session session , @PathParam("mid") String mid ) {
		System.out.println("클라이언트의 웹소켓이 들어왔다.");
		System.out.println(session);
		// 접속한 클라이언트 소켓들을 보관해야함
		ClientDto clientDto = new ClientDto(session, mid);
		접속명단.add( clientDto );
		System.out.println( 접속명단.toString());
	}
	
	@OnClose	// 클라이언트소켓이 접속이 끊겼을 때 ( 나갔을때 F5 )
	public void onClose( Session session ) {
		
		// F5 누르면 클라이언트소켓이 사라지기때문에 접속명단에서 삭제
		
		// 접속이 끊긴 세션의 dto 찾아서 제외
		for ( ClientDto dto : 접속명단 ) {
			// 접속끊긴 세션찾기 -> 찾은session이 들어있는 dto제외
			// == 주소비교
			if ( dto.getSession() == session ) { 접속명단.remove(dto); }
		} 
		System.out.println("클라이언트 웹소켓이 나갔습니다.");
	}
	
	//클라이언트 소켓이 메시지를 보냈을때 [ 서버가 메시지 받기 ]
	@OnMessage			// Session [누가:클라이언트소켓객체] , String [내용물]
	public void onMessage( Session session , String msg ) throws Exception {
		// 메시지 구성
		MassageDto massageDto = new MassageDto(session, msg);
			System.out.println("massageDto : " +massageDto);
		// 메시지 받는 프로그램 : JSON
		ObjectMapper mapper = new ObjectMapper();
		String jsonMessageDto = mapper.writeValueAsString( massageDto );
			System.out.println("jsonMessageDto : " +jsonMessageDto);
		System.out.println("클라이언트 웹소켓이 메시지를 보냈다. [서버가 메시지를 받았다.]");
		System.out.println("msg : "+msg);
		// ** 서버가 클라이언트 소켓에게 메시지를 보내기
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for( ClientDto dto : 접속명단 ) {
			// 각 dto안의 세션을 각각 꺼내서 메시지 보내기
						// json형식[모양]의 타입은 문자열로 전송됨
							// String a = "10"; 숫자형식 , 타입은 문자열
			dto.getSession().getBasicRemote().sendText( jsonMessageDto ); // 접속한 모든 사람에게 JS onmessage에게 보냄
		}
		
	}
}
