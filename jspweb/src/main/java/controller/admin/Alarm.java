package controller.admin;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	private static ArrayList<ClientDto> 알림명단 = new ArrayList<>();
	
	@OnOpen // 클라이언트 소켓이 들어왔을 때 [매핑] 연결
	public void 서버입장( Session session , @PathParam("mid") String mid ) throws Exception  { 
		System.out.println( "session :" +session );
		알림명단.add(new ClientDto(session, mid));
	}
	
	@OnClose // 클라이언트 소켓이 나갔을 때 [매핑] 연결
	public void 서버나가기( Session session ) throws Exception  {
		System.out.println( "session :" +session );
		// 클라이언트소켓이 나갔을 때 나간소켓을 알림명단에서 제거
		for ( ClientDto c  : 알림명단) {
			if ( c.getSession() == session ) { 알림명단.remove(c); }
		}
	}
	
	@OnError // 클라이언트 소켓이 에러가 발생했을 때 [매핑] 연결
	public void 서버오류(Session session , Throwable e ) throws Exception  {
		System.out.println( "session :" +session );
	}
	
	
	// OnMessage 매개변수가 필수 
	@OnMessage // 클라이언트 소켓이 메시지를 보냈을 때 [매핑] 연결
	public static void 서버메시지( Session session , String msg  ) throws Exception {  
		System.out.println( "session :" +session );
		// ProductChat.java에서 메시지를 DB에 저장성공하면 서버소켓에게(Alarm) 메시지받는mno와,메시지를 보냄
		
		// ProductChat.java에서 실행되기 위해서 서버메시지 함수를 static으로 변경
		// ProductChat.java에서 Alarm.서버메시지(null, tomno+","+ncontent );
		
		// Strimg msg 가 tomno+","+ncontent 임
		
		// 메시지를 받는 mno
		int tomno = Integer.parseInt( msg.split(",")[0] );
		
		// 메시지 내용
		String tomsg = msg.split(",")[1];
		
		for ( ClientDto c : 알림명단 ) {
			// ClientDto : [Session session] / [String mid]
			// c하나에 세션과 로그인한 아이디 갖고있음.
			// 로그인한 사람의 mno를 구해서 
			int cmno = MemberDao.getInstance().getMember(c.getMid()).getMno();
			//int cmno = MemberDao.getInstance().getMno(c.getMid());
			
			// 로그인한 사람과 메시지받는 사람이 같으면
			if ( cmno == tomno ) { // 받는 회원번호가 알림명단에 존재하면
				// 로그인한 회원중에 해당 메시지를 받는 회원에게 OnMessage (메시지내용) 보내기
				c.getSession().getBasicRemote().sendText( tomsg );
			}
			
		}
	}
	
	
}


/*
 
 	Session session 	: 요청한 클라이언트 소켓의 변수
 	Throwable e 		: 에러 발생시 에러이유 저장된 변수
 	String s			: 요청한 메시지 내용
 
 	서버소켓
 		1. @ServerEndpoint("서버소켓경로/{매개변수명}/{매개변수명}/{매개변수명}")
 		2. @OnOpen		필수 매개변수 : Session session
 		2. @OnClose		필수 매개변수 : Session session
 		2. @OnError		필수 매개변수 : Session session , Throwable e
 		2. @OnMessage	필수 매개변수 : Session session , String s
 		6. @PathParam("경로상의{매개변수명}") String mid
 
 */
