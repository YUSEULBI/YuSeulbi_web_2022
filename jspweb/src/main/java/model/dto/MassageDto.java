package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.Chatting;
import model.dao.MemberDao;

public class MassageDto {
	
	//private Session session; 	//메시지 보낸 세션;
	private String frommid; 	//메시지 보낸 회원아이디;
	private String frommimg; 	//메시지 보낸 회원프로필;
	private String msg; 		//메시지 내용;
	private String time; 		//메시지 보낸 날짜시간;
	//private String 방번호pk;
	
	public MassageDto() {
		// TODO Auto-generated constructor stub
	}
	
	// '클라이언트'에게 메시지 전송할때 사용하는 생성자
	public MassageDto(Session session, String msg ) {
		super();
		//this.session = session;
		this.msg = msg;
		
		// 메시지를 보낸 클라이언트 세션을 통해서 회원아이디 얻기
		for ( ClientDto dto : Chatting.접속명단 ) {
			if ( dto.getSession() == session ) {
				this.frommid = dto.getMid();
				// 보낸 사람의 프로필 얻기
				this.frommimg = MemberDao.getInstance().getMember(this.frommid).getMimg();
				// 추후 행동이 필요없어서 모두 힙영역에서 처리 해서 time필드값 저장
				this.time = new SimpleDateFormat("hh:mm:ss").format( new Date() );
			}
		}// end
		
		
		/*
		  Date date = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		  this.time = sdf.format(date);
		 */
		
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "MassageDto [frommid=" + frommid + ", frommimg=" + frommimg + ", msg=" + msg + ", time=" + time + "]";
	}

	public String getFrommid() {
		return frommid;
	}
	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}
	public String getFrommimg() {
		return frommimg;
	}
	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
}
