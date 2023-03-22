/*
	코드 작성 = 요리사		JS작성 = 개발자
	코드 실행 = 먹는사람		JS발생 = 유저

//----------------------------------------------------------------- 
	
	[클라이언트]							[서버]
	클라이언트소켓							서버소켓 
	 ㄴ[JS]각 클라이언트마다 갖고 있는 소켓	 	 ㄴ [JAVA]서버가 가지고 있는 소켓 : 1개
	new WebSocket
		클라이언트소켓.onopen	<--연결--->	@OnOpen
		클라이언트소켓.send		--보내기-->	@OnMessage
		클라이언트소켓.onmessage	<-보내기---	세션객체.getBasicRemote().sendText(보낼메시지);
		클라이언트소켓.onclose	<-연결끊기--	@OnClose
							
	소켓 : 두 프로그램간의 양방향 비동기 통신 종착점(엔트포인트)(송수신 마지막 접점)
	통신기법이 다름 HTTP와 다름 request response 없음 
	C언어 파이썬에서의 소켓 문법이 다름
	HTTP랑 다르게 요청하고 응답을 하는게 아니고 요청이없어도 서버가 클라이언트 조작응답가능
	
//-----------------------------------------------------------------
	오늘은 '웹'소켓!!!
	
	[JS WebSocket]	
		1. JS에서 제공하는 클래스 WebSocket
			/new WebSocket("ws://서버소켓URL"); 웹소캣의 경로/
		2. 소켓 객체 만들기 
			let 클라이언트소켓 = new WebSocket("ws://서버소켓URL");
		3. 소켓이 서버소켓과 연동
			(1) WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신()
	@어노테이션
	[JAVA serverSocket]
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			클래스 위에 @ServerEndpoint("/서버소켓경로URL") 
				: 서버소켓 URL 만들기
				참고) @WebServlet	: HTTP URL 만들기
		3. 클라이언트소켓이 서버소켓[엔드포인트]로 접속했을때 
				@OnOpen : 클라이언트소켓이 접속했을때 매핑[연결]
		
*/


console.log('chatting 실행')
let contentbox = document.querySelector('.contentbox')

//
let 클라이언트소켓 = null;
 
if ( memberInfo.mid == null ){ // 헤더js에 선언한 객체
	alert('로그인 하세요')
	location.href="/jspweb/member/login.jsp";
}else{
	// 1.클라이언트소켓 생성과 서버소켓 연결

	// 전체링크 / HTTP가 아닌 소켓을 쓰고있어서 링크에 ?매개변수 request 불가
	//let 클라이언트소켓 = new WebSocket("ws://ip:포트번호/jspweb/chatting");
	// 클라이언트소켓 = new WebSocket("ws://localhost:8080/jspweb/chatting/"+방번호);
	// 클라이언트소켓 = new WebSocket("ws://localhost:8080/jspweb/chatting/아이디/채팅방번호");
	// localhost대신에 ip로 변경하면 채팅가능
	클라이언트소켓 = new WebSocket("ws://localhost:8080/jspweb/chatting/"+memberInfo.mid);
	console.log(클라이언트소켓)
	클라이언트소켓.onopen = function(e){ 서버소켓연결(e)}// 클라이언트 소켓 객체에 내가원하는것대입
	클라이언트소켓.onmessage = function(e){메시지받기(e)}
	클라이언트소켓.onclose = function(e){연결해제 (e) }
}





// 2. 클라이언트소켓이 접속했을 때 이벤트/함수 정의
function 서버소켓연결(){
	console.log('서버소켓과 연결이 되었다.')
	contentbox.innerHTML += `<div class="alarm">
								<span> 채팅방 입장 하셨습니다. </span>
							</div>
							`
	}
 


// 엔터키 누르면 전송
//document.addEventListener("keydown",(e)=>{
//	if( e.keyCode == 13 ){
//		보내기();
//	}
//})

// 엔터키 누르면 전송
function enterkey(){
		console.log(window.event.keyCode)
		// 입력한 키코드가 13이면
		if(window.event.keyCode == 13 ){
			보내기();
		}
}


// 3. 클라이언트소켓이 서버에게 메시지를 보내기 [@OnMessage]
 function 보내기(){
	 console.log('메시지 전송')
	 let msgbox = document.querySelector('.msgbox').value
	 console.log(msgbox)
	 // ***메시지 전송하기
	 // JS가 /jspweb/chatting 서버소켓의 onMessage로 보냄
	 클라이언트소켓.send( msgbox );
	 //입력창 초기화
	 document.querySelector('.msgbox').value = '';
 }
 
 // 4. 서버로부터 메시지가 왔을 때 메시지 받기.
 // 자바 session.getBasicRemote().sendText(msg); -->클라이언트소켓.onmessage --> e
 function 메시지받기(e){
	 //console.log('메시지받기 실행')
	 //console.log(e)
	 //console.log(e.data) // 문자열
	 //console.log( JSON.parse(e.data) ); // 문자열json -> 객체json 형변환
	 //contentbox.innerHTML += `<div>${e.data}</div>`;
	 let data = JSON.parse(e.data); // 전달받은 메시지 dto
	 
	 // 보낸사람과 현재유저 동일하면 내가보낸메시지
	 if ( data.frommid == memberInfo.mid ){
		 contentbox.innerHTML +=`
		 							<div class="secontent">
										<div class="date"> ${data.time} </div>
										<div class="content"> ${data.msg} </div>
									</div>
		 						`
	 }else{
	 	// 받은 메시지
	 	contentbox.innerHTML +=`
		 							<div class="tocontent">
										<div> <img alt="" src="/jspweb/member/pimg/${ data.frommimg==null ? 'default.webp' : data.frommimg }" class="hpimg"> </div>
										<div class="rcontent">
											<div class="name"> ${data.frommid} </div>
											<div class="contentdate">
												<div class="content"> ${data.msg} </div>
												<div class="date"> ${data.time} </div>
											</div>
										</div>
										
									</div>
		 						`
	 }
	 // -------------스크롤 하단으로 자동내리기
	 	//let top = contentbox.scrollTop; // 현재 스크롤의 상단 위치 좌표
	 		//console.log(top)
	 	//let height = contentbox.scrollHeight; // 현재 스크롤의 전체높이 / 기본값: contentbox의 높이
	 		//console.log(height)
	 // 스크롤막대의 상단위치를 스크롤막대의 가장아래의 위치로 대입
	 contentbox.scrollTop = contentbox.scrollHeight;
 }
 
 
 
 
 // 5. 서버와 연결이 끊겼을 때. [ 클라이언트소켓 객체가 초기화될때 F5 , 페이지전환시 ]
 function 연결해제 (e){
	 console.log('연결해제')
 }
 
 
 
 /*
 	// 클라이언트소켓 객체 이미생성됨 onclose 이미 만들어진 함수? 그래서 대입[ = ]사용 오버라이드
 	클라이언트소켓 필드
 		onopen		=
 		onclose		=
 		onmessage	=
 		
 		// 통신결과를 e에 받음
 		클라이언트소켓.onclose = function(e){ console.log('연결해제')}
 		vs
 		클라이언트소켓.onclose = (e)=>{ console.log('연결해제')}
 		vs
 		function 함수명(e){console.log('연결해제')}
 		클라이언트소켓.onclose = (e)=>{ 함수명(e) }
 		
 	// ajax 객체생성하면서 결과값도 만들기 [ : ] 사용
 	ajax 필드({
 		// 통신결과를  r에 받음
 		success : function(r){}
 		success : (r)=>{}
 	})
 */
 
 
 
 
 
 