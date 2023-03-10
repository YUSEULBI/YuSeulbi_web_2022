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
				html +=`
						<div class="dropdown"> <!-- class="btn btn-secondary dropdown-toggle" aria-expanded="false" -->
						  <button class="hpimgbtn" type="button" data-bs-toggle="dropdown" >
						    <img class="hpimg" src="/jspweb/member/pimg/${r.mimg == null ? 'default.webp' : r.mimg}">
						  </button>
						  <ul class="dropdown-menu"> <!-- 드롭다운시 표시되는 구역 -->
						    <li><a class="dropdown-item" href="#"> 내프로필 </a></li>
						    <li><a class="dropdown-item" href="#"> 친구목록 </a></li>
						    <li><a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃 </a></li>
						  </ul>
						</div> <!-- 드롭다운 끝 -->
						
						${r.mid}님
						<a href="#">쪽지함</a>
						<a href="#">포인트</a>
						`
				if ( r.mid == 'admin'){
					html += `<a href="/jspweb/admin/info.jsp">관리자</a>`
				}
				
			}
			document.querySelector('.submenu').innerHTML = html;
		}
	})
	
}