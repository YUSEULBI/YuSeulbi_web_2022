console.log('header 열림');
let memberInfo = null; // <-- 전역변수

// 로그인한 회원정보 호출
getLogin(); // 헤더 파일 열릴 때 실행
function getLogin(){
	
	$.ajax({
		url : "/jspweb/login",
		async : false , // 비동기 ---> 동기화 변경
		method : "get" ,
		success : (r)=>{
			console.log('ajax응답')
			console.log(r) // r은 dto객체 1개 가져옴 ( 비번제외 )
			memberInfo = r;	// <--- 응답 결과를 전역변수로 옮기기 [ 왜? 다른 함수에서 쓰려고 ]
			// 1. html 구성
			let html = '';
			// 문자통신을 해서 ''
			if ( r.mid == null ){ // 로그인 안함
				html += `<a href="/jspweb/member/signup.jsp">회원가입</a>`
				html += `<a href="/jspweb/member/login.jsp">로그인</a>`
				
			}else{ // 일반회원,관리자 로그인
				html +=`
						<div class="dropdown"> <!-- class="btn btn-secondary dropdown-toggle" aria-expanded="false" -->
						  <button class="hpimgbtn" type="button" data-bs-toggle="dropdown" >
						    <img class="hpimg" src="/jspweb/member/pimg/${r.mimg == null ? 'default.webp' : r.mimg}">
						  </button>
						  <ul class="dropdown-menu"> <!-- 드롭다운시 표시되는 구역 -->
						    <li><a class="dropdown-item" href="/jspweb/member/info.jsp"> 내프로필 </a></li>
						    <li><a class="dropdown-item" href="#"> 친구목록 </a></li>
						    <li><a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃 </a></li>
						  </ul>
						</div> <!-- 드롭다운 끝 -->
						
						<span class="nickname">${r.mid}님</span>
						<a href="#">쪽지함</a>
						<a href="#">${r.mpoint} 포인트</a>
						`
				if ( r.mid == 'admin'){
					html += `<a href="/jspweb/admin/info.jsp">관리자</a>`
				}
				
			}
			document.querySelector('.submenu').innerHTML = html;
		}
	})
	
} // end


//----------------------알림용 클라이언트 소켓---------------------------
let 알림용소켓 = null;

if ( memberInfo.mid == null ){
	
}else{
	// JS 실행주체 = 클라이언트 // JAVA = 서버
	// 1. js : 클라이언트 소켓 생성
	알림용소켓 = new WebSocket('ws://localhost:8080/jspweb/alarm/'+memberInfo.mid)
	
	// 2. 클라이언트 소켓내 필드의 이벤트 메소드 정의
	알림용소켓.onopen = (e) => { console.log('알림용 서버솟켓에 들어옴')}
	알림용소켓.onclose = (e) => { console.log('알림용 서버소켓 나감')}
	알림용소켓.onerror = (e) => { console.log('알림용 서버소켓 오류')}
	알림용소켓.onmessage = (e) => { onalarm(e)}
}

//
function onalarm(e){
	console.log('채팅 왔습니다.'+e.data )
	let msgbox = document.querySelector('.msgbox')
	msgbox.style.bottom = "50px";
	
	// 4초 후에 자동 내려가기
	// n초 후에 이벤트 실행 setTimeout( ()=>{} , 밀리초 }
	// n초 마다 이벤트 실행 setInterval( ()=>{} , 밀리초 }
	
	setTimeout( ()=>{
		msgbox.style.bottom = "-100px";
	} , 4000)
	
	// 여러명이 채팅 요청 하면 Dao 메소드 충돌 발생할 수 있음.
		// Dao메소드에 synchronized
		// 스레드1 해당 메소드 사용하고 있을 때 [ return 전 ] 다른 스레드2 해당 메소드에 대기상태
		// 멀티스레드 : 서블릿 자체가 멀티스레드 HttpServlet
	getcontent(); // 채팅 받았을때 렌더링
	
}








