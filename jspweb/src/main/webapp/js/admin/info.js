
getMemberList();

function getMemberList(){
	console.log('info 실행')	
	
	$.ajax({
		url : "/jspweb/member",		// 서블릿파일에 @WebServlet("/member")
		method : "get" ,
		success : ( r ) => {
			console.log('ajax 응답')
			console.log(r);
			let html = `<tr>
							<th width="10%">번호</th> 
							<th width="10%">프로필</th> 
							<th width="10%">아이디</th> 
							<th width="10%">이메일</th> 
							<th width="10%">비고</th>
						</tr>`
			r.forEach( (o,i) => {
				// 만약에 회원 mimg 프로필이미지가 null이면 기본프로필 사용 / 아니면 mimg 사용
				html += `<tr>
							<td>${o.mno}</td> 
							<td><img src="/jspweb/member/pimg/${o.mimg == null ? 'default.webp' : o.mimg }" width="100%"></td> 
							<td>${o.mid}</td>  
							<td>${o.memail}</td> <td></td>
						</tr>`	
			})
			document.querySelector('.mListTable').innerHTML = html;
		}
	})
}