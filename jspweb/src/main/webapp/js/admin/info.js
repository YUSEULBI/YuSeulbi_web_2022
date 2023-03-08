
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
							<th>번호</th> <th>프로필</th> <th>아이디</th> <th>이메일</th> <th>비고</th>
						</tr>`
			r.forEach( (o,i) => {
				html += `<tr>
							<td>${o.mno}</td> <td>${o.mimg}</td> <td>${o.mid}</td>  <td>${o.memail}</td> <td></td>
						</tr>`	
			})
			document.querySelector('.mListTable').innerHTML = html;
		}
	})
}