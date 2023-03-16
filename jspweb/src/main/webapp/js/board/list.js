console.log('list js 실행')

getBoardList(1); // js 열릴때 페이지1 기본값설정

function getBoardList( page ){
	// 해당 함수로부터 페이징번호 받기 = page
	console.log('페이지 : '+page)
	console.log('getBoardList() 실행')
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : {"type" : 1 , "page":page } , // 1: 전체출력 2:개별출력 / page : 페이지번호
		success : (r)=>{
			console.log('통신')
			console.log(r)
			//-----테이블출력-------------------------------------------
			let html = `
						<tr>
							<th>번호</th> 
							<th>제목</th> 
							<th>작성일</th> 
							<th>조회수</th> 
							<th>좋아요</th> 
							<th>싫어요</th> 
							<th>작성자</th> 
						</tr>
						`
			r.boardList.forEach((o,i)=>{
				html += `
						<tr>
							<th>${o.bno}</th> 
							<th><a href="/jspweb/board/view.jsp?bno=${o.bno}">${o.btitle}</a></th> 
							<th>${o.bdate}</th> 
							<th>${o.bview}</th> 
							<th>${o.bup}</th> 
							<th>${o.bdown}</th> 
							<th>${o.mid}</th> 
						</tr>
						`
			})
			document.querySelector('.boardTable').innerHTML = html;
			
			//----페이징버튼출력-----------------------------------------
			
			html = ''; // 기존에 들어있던 내용 제거
			//이전 [ 현재페이지가 1이하이면 이전버튼은 현재페이지버튼이됨]
			html += page <= 1 ?
					`<button onclick="getBoardList(${page})" type="button">이전</button>`
					: `<button onclick="getBoardList(${page-1})" type="button">이전</button>`
			// 페이지 번호 버튼 들
			for ( let i = r.startbtn ; i <= r.endbtn ; i++ ){ // 1부터 마지막페이지수까지 버튼 생성
				html += `
					<button onclick="getBoardList(${i})" type="button">${i}</button>
					`
			}
			// 다음 [ 현재페이지가 마지막페이지면 다음버튼은 현재페이지 버튼이됨]
			html += page >= r.totalpage ?
					` <button onclick="getBoardList(${page})" type="button">다음</button> `
					: ` <button onclick="getBoardList(${page+1})" type="button">다음</button> `
					
			document.querySelector('.pagebox').innerHTML = html;
			
		}// success end
	}) // ajax end
}

/*
	1. 클릭한 pk[식별자] 이동하는 경우의 수
	 1. HTTP get메소드 방식의 a태그 이용한 PK 이동
	 		<a href="/jspweb/board/view.jsp">
	 		<a href="/jspweb/board/view.jsp?bno=${o.bno}">
	 		<a href="/jspweb/board/view.jsp?변수명=데이터">
	 		<a href="/jspweb/board/view.jsp?변수명=데이터&변수명=데이터">

*/














