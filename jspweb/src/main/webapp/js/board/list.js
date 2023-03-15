console.log('list js 실행')

getBoardList();

function getBoardList(){
	console.log('getBoardList() 실행')
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		success : (r)=>{
			console.log('통신')
			console.log(r)
			let html = `
						<tr>
							<th>번호</th> <th>제목</th> <th>내용</th> <th>첨부파일</th> <th>작성일</th> <th>조회수</th> <th>좋아요</th> <th>싫어요</th> <th>카테고리</th> <th>작성자</th> 
						</tr>
						`
			
		}
	})
}