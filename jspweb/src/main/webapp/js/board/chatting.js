/*
	코드 작성 = 요리사		JS작성 = 개발자
	코드 실행 = 먹는사람		JS발생 = 유저

//----------------------------------------------------------------- 
	
	[클라이언트]							[서버]
	클라이언트소켓							서버소켓 
	 ㄴ[JS]각 클라이언트마다 갖고 있는 소켓	 	 ㄴ [JAVA]서버가 가지고 있는 소켓 : 1개
	new WebSocket
		클라이언트소켓.onopen	<--연결-->	@OnOpen
		클라이언트소켓.send		--보내기->	@OnMessage
							<-보내기--	세션명.getBasicRemote().sendText(보낼메시지);
		
	소켓 : 두 프로그램간의 양방향 비동기 통신 종착점(엔트포인트)(송수신 마지막 접점)
	통신기법이 다름 HTTP와 다름 request response 없음 
	C언어 파이썬에서의 소켓 문법이 다름
	
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

// 1.클라이언트소켓 생성과 서버소켓 연결

// 전체링크
//let 클라이언트소켓 = new WebSocket("ws://ip:포트번호/jspweb/chatting");
let 클라이언트소켓 = new WebSocket("ws://localhost:8080/jspweb/chatting");
console.log(클라이언트소켓)


// 2. 클라이언트소켓이 접속했을 때 이벤트/함수 정의
function 서버소켓연결(){
	console.log('서버소켓과 연결이 되었다.')
	contentbox.innerHTML += '<div>--------채팅방입장--------</div>'
	}
클라이언트소켓.onopen = function(e){ 서버소켓연결(e)}// 클라이언트 소켓 객체에 내가원하는것대입 




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
	 console.log(e)
	 contentbox.innerHTML += `<div>${e.data}</div>`;
 }
 클라이언트소켓.onmessage = function(e){메시지받기(e)}
 
 
 
 
 
 
 
 
 
 
 
 
 