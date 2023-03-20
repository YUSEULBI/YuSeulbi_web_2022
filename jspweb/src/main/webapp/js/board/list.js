console.log('list js 실행')

/*
	*pageObject : 현재 페이지 , 현재검색 , 전송타입 보관된 객체
	let pageObject = {
	page : 1 , // page : 페이지번호
	key : "" , 
	keyword : "" ,
	type : 1 // 1: 전체출력 2:개별출력
}
*/


let pageObject = {
	page : 1 , // page : 페이지번호
	key : "" , 
	keyword : "" ,
	type : 1 ,// 1: 전체출력 2:개별출력
	cno : document.querySelector('.cno').value , // 카테고리번호
	listsize : 3
}

// 전체보기 검색제거
function clearSearch(){
	pageObject.key = '';
	pageObject.keyword = '';
	getBoardList(1);
}

// 페이지당 출력 게시물수 변경
function chlistsize(){
	console.log('chlistsize()실행')
	pageObject.listsize = document.querySelector('.listsize').value;
	getBoardList(1);
}

// -- 카테고리 제목 넣어주기
let cnameHTML = '';
if ( pageObject.cno == 1 ){ cnameHTML = '공지사항';	}
if ( pageObject.cno == 2 ){ cnameHTML = '커뮤니티';	}
if ( pageObject.cno == 3 ){ cnameHTML = 'QnA';	}
if ( pageObject.cno == 4 ){ cnameHTML = '노하우';	}
document.querySelector('.cname').innerHTML = cnameHTML;

getBoardList(1); // js 열릴때 페이지1 기본값설정

function getBoardList( page ){
	// 해당 함수로부터 페이징번호 받기 = page
	console.log('페이지 : '+page)
	console.log('getBoardList() 실행')
	pageObject.page = page; // 인수로 받은 현재페이지를 객체에 대입
	console.log("pageObject")
	console.log(pageObject)
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : pageObject ,  
		success : (r)=>{
			console.log('통신')
			console.log(r)
			//-----테이블출력-------------------------------------------
			let html = ``
			r.boardList.forEach((o,i)=>{
				html += `
						<div class="boardcontent">
							<div>
								<img class="hpimg" alt="" src="/jspweb/member/pimg/default.webp">
								<span class="mid"> ${o.mid} </span>
								<span class="bdate"> ${o.bdate} </span>
							</div>
							<div class="btitle"> ${o.btitle} </div>
							<div class="contentBottom">
								<span><i class="far fa-eye"></i> <span class="bview">${o.bview}</span> </span>
								<span><i class="far fa-thumbs-up"></i> <span class="bup">${o.bup}</span> </span>
								<span><i class="far fa-thumbs-down"></i> <span class="bdown">${o.bdown}</span> </span>
								<span><i class="far fa-comment-dots"></i> <span class="rcount">10</span> </span>
							</div>
						</div>	
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
			//----게시물수-----------------------------------------
			document.querySelector('.searchcount').innerHTML = `게시물수 : ${r.totalsize}`;
			
		}// success end
	}) // ajax end
}

function getsearch(){
	console.log('getsearch()함수열림')
	// * 입력받은 데이터를 전역객체 내 필드에 대입
	pageObject.key = document.querySelector('.key').value
	pageObject.keyword = document.querySelector('.keyword').value
	
	// 검색된 boardList 게시물호출
	getBoardList(1);
}

/*
	1. 클릭한 pk[식별자] 이동하는 경우의 수
	 1. HTTP get메소드 방식의 a태그 이용한 PK 이동
	 		<a href="/jspweb/board/view.jsp">
	 		<a href="/jspweb/board/view.jsp?bno=${o.bno}">
	 		<a href="/jspweb/board/view.jsp?변수명=데이터">
	 		<a href="/jspweb/board/view.jsp?변수명=데이터&변수명=데이터">

*/














