package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dto.ClientDto;

//해당 클래스를 서버소켓[종착점]으로 만들기
@ServerEndpoint("/chatting/{mid}") // 경로상에 URL :/경로/{매개변수1}/{매개변수2}

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
		접속명단.add( new ClientDto(session, mid) );
		System.out.println( 접속명단.toString());
	}
	
	@OnClose	// 클라이언트소켓이 접속이 끊겼을 때 ( 나갔을때 F5 )
	public void onClose( Session session ) {
		접속명단.remove(session); // F5 누르면 클라이언트소켓이 사라지기때문에 접속명단에서 삭제
		System.out.println("클라이언트 웹소켓이 나갔습니다.");
	}
	
	//클라이언트 소켓이 메시지를 보냈을때 [ 서버가 메시지 받기 ]
	@OnMessage			// Session [누가:클라이언트소켓객체] , String [내용물]
	public void onMessage( Session session , String msg ) throws Exception {
		System.out.println("클라이언트 웹소켓이 메시지를 보냈다. [서버가 메시지를 받았다.]");
		System.out.println("msg : "+msg);
		// ** 서버가 클라이언트 소켓에게 메시지를 보내기
		// 현재 서버소켓과 연결된 클라이언트소켓 모두에게 서버가 받은 내용물 전달
		for( Session s : 접속명단 ) {
			s.getBasicRemote().sendText(msg); // 접속한 모든 사람에게 JS onmessage에게 보냄
		}
		
	}
}
