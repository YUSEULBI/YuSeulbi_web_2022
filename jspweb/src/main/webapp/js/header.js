console.log('header 열림');

// 로그인한 회원정보 호출
getLogin(); // 헤더 파일 열릴 때 실행
function getLogin(){
	
	$.ajax({
		url : "/jspweb/login",
		method : "get" ,
		success : (r)=>{
			console.log('ajax응답')
			console.log(r) // r은 dto객체 1개 가져옴 ( 비번제외 )
			
			// 1. html 구성
			let html = '';
			// 문자통신을 해서 ''
			if ( r == null ){ // 로그인 안함
				html += `<a href="/jspweb/member/signup.jsp">회원가입</a>`
				html += `<a href="/jspweb/member/login.jsp">로그인</a>`
				
			}else{ // 일반회원,관리자 로그인
				
				if ( r.mid == 'admin'){
					html += `<a href="/jspweb/admin/info.jsp">관리자페이지</a>`
				}
				html +=	`<img class="hpimg" src="/jspweb/member/pimg/${r.mimg == null ? 'default.webp' : r.mimg}">`
				html += `${r.mid}님 안녕하세요.`
				html += `<a href="/jspweb/member/logout.jsp">로그아웃</a>`
			}
			document.querySelector('.submenu').innerHTML = html;
		}
	})
	
}