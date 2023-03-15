console.log('list js 실행')

getBoardList();

function getBoardList(){
	console.log('getBoardList() 실행')
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : {"type" : 1 } , // 1: 전체출력 2:개별출력
		success : (r)=>{
			console.log('통신')
			console.log(r)
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
			r.forEach((o,i)=>{
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
		}
	})
}

/*
	1. 클릭한 pk[식별자] 이동하는 경우의 수
	 1. HTTP get메소드 방식의 a태그 이용한 PK 이동
	 		<a href="/jspweb/board/view.jsp">
	 		<a href="/jspweb/board/view.jsp?bno=${o.bno}">
	 		<a href="/jspweb/board/view.jsp?변수명=데이터">
	 		<a href="/jspweb/board/view.jsp?변수명=데이터&변수명=데이터">

*/














