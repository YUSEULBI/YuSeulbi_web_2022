let pageObject={
	page : 1 ,
	mkey : '',
	mkeyword : '' ,
	listsize : 3 
}


getMemberList(1);

function getMemberList( page ){
	console.log('info 실행')	
	pageObject.page = page 
	
	$.ajax({
		url : "/jspweb/member",		// 서블릿파일에 @WebServlet("/member")
		method : "get" ,
		data : pageObject ,
		success : ( r ) => {
			console.log('ajax 응답')
			console.log(r);
						
			let html = `<tr>
							<th width="5%">번호</th> 
							<th width="5%">프로필</th> 
							<th width="25%">아이디</th> 
							<th width="25%">이메일</th> 
							<th width="20%">비고</th>
						</tr>`
			r.memberlist.forEach( (o,i) => {
				// 만약에 회원 mimg 프로필이미지가 null이면 기본프로필 사용 / 아니면 mimg 사용
				html += `<tr>
							<td>${o.mno}</td> 
							<td><img src="/jspweb/member/pimg/${o.mimg == null ? 'default.webp' : o.mimg }" width="100%"></td> 
							<td>${o.mid}</td>  
							<td>${o.memail}</td> <td></td>
						</tr>`	
			})
			document.querySelector('.mListTable').innerHTML = html;
			
			//-------페이징 처리 ----------------------------------
			// 시작페이지부터 마지막페이지를 구해야함.
			html = '';
			html += page<=1 ? 
				`<button onclick="getMemberList(${page})" type="button">이전</button>` :
				`<button onclick="getMemberList(${page-1})" type="button">이전</button>`
			for ( i = 1 ; i <= r.totalpage ; i++){
				html += `<button onclick="getMemberList(${i})" type="button">${i}</button>`
			}
			html += page>= r.totalpage ?
				`<button onclick="getMemberList(${page})" type="button">다음</button>` :
				`<button onclick="getMemberList(${page+1})" type="button">다음</button>`
			document.querySelector('.infopagebtn').innerHTML = html;
			
			//--------------------------------------------------
			// 출력결과 회원수
			document.querySelector('.totalsize').innerHTML = '검색된 회원수 : '+r.totalsize;
			
		}
	})
}


function msearchbtn(){
	pageObject.mkey = document.querySelector('.mkey').value
	pageObject.mkeyword = document.querySelector('.mkeyword').value
	console.log(pageObject)
	getMemberList(1);
	
}

function resetPrint(){
	pageObject.mkey = '';
	pageObject.mkeyword = '';
	console.log(pageObject)
	getMemberList(1);
}

function mlistsize(){
	console.log(document.querySelector('.listsize').value)
	pageObject.listsize = document.querySelector('.listsize').value;
	console.log(pageObject); 
	getMemberList(1);
}










