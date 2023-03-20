console.log('view js 열림')
let bno = document.querySelector('.bno').value;
console.log(memberInfo);

// 로그인 안되어 있으면
if ( memberInfo.mid == null ){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rcontent').value = '로그인 후에 작성 가능합니다.';
	document.querySelector('.rwritebtn').disabled = true;
}

getBoard()
function getBoard(){
	console.log("getBoard에서 호출bno : "+bno)
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : {"type" : 2 , "bno":bno } ,
		success : (r)=>{
			console.log('getBoard get 통신')
			console.log(r)
			
			let html = ``
			
			document.querySelector('.mimg').src=`/jspweb/member/pimg/${r.mimg == null ? 'default.webp' : r.mimg}`;
			document.querySelector('.mid').innerHTML = r.mid;
			document.querySelector('.bdate').innerHTML = r.bdate;
			document.querySelector('.bview').innerHTML = r.bview;
			document.querySelector('.bup').innerHTML = r.bup;
			document.querySelector('.bdown').innerHTML = r.bdown;
			document.querySelector('.btitle').innerHTML = r.btitle
			document.querySelector('.bcontent').innerHTML = r.bcontent
			
			if ( r.bfile == null ){
					
			}else{ //첨부파일 있을 때
				//html = `${r.bfile} <button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`
				html = `
						<a href="/jspweb/filedownload?bfile=${r.bfile}">
							<i class="fas fa-download"></i>${r.bfile}
						</a>
						`
				document.querySelector('.bfile').innerHTML = html;
			}
			// -------------------------------------------
			// 로그인된 회원과 작성자가 일치하면 수정/삭제버튼 출력
			if ( memberInfo.mid == r.mid ){
				html = `
						<button class="bbtn" onclick="bdelete(${bno} , ${r.cno} )" type="button">삭제</button>
						<button class="bbtn" onclick="bupdate(${bno })" type="button">수정</button>
						`
						;
				document.querySelector('.btnbox').innerHTML = html;
				
			}
			// 댓글출력
			getReplyList();
		}
	})
} // getBoard function end


// 3. typq : 조회수[1] 좋아요수[2] 싫어요수[3]
bIncrease( 1 ); // 현재 jsp/js가 열리는 순간 [ 조회수 증가 ]
function bIncrease( type ){
	
	// 1. 현재 게시물의 번호 [ 증가할 대상 ]
	console.log( "bno : "+bno);
	// 2. 
	$.ajax({
		url : "/jspweb/board/view",
		method: "get" , 
		data : { "type" : type , "bno" : bno  },
		success : (r)=>{
			console.log('bIncrease get 통신'); console.log("bIncrease r : " +r);
			getBoard(); // 새로고침
		}
	})
}



// 2. 다운로드 [ 다운로드할 파일명 인수로 받기 ]
function bdownload( bfile ){
	console.log('선택한 파일명 : ' + bfile);
	
//	$.ajax({
//		url : "/jspweb/filedownload" ,
//		method : "get" ,
//		data : {"bfile" : bfile} ,
//		success : (r)=>{
//			console.log('통신');
//			console.log(r);
//			
//		}
//	}) // ajax and

	// location.href 에 get메소드 기능 들어있음 <a> , <form> 등등	
	location.href="/jspweb/filedownload?bfile="+bfile;

} // m end

function bdelete(bno ,cno){
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "delete" ,
		data : {"bno":bno , "type":1} ,// 1:게시물삭제 / 2:첨부파일만삭제
		success : (r)=>{
			console.log('통신')
			console.log(r)
			if ( r == 'true'){
				alert('삭제성공');
				location.href="/jspweb/board/list.jsp?cno="+cno;
			}else{
				alert('삭제실패');
			}
		}
	})
}

function bupdate(bno){
	location.href = "/jspweb/board/update.jsp?bno="+bno;
}

// 댓글쓰기
function rwrite(){
	console.log('rwrite 함수 실행')
	// rcontent / mno 세션 / bno 전역변수
	let rcontent = document.querySelector('.rcontent').value
	console.log("rcontent : "+rcontent)
	$.ajax({
		url : "/jspweb/board/reply" ,
		method : "post" ,
		data : { "type":1 , "bno":bno , "rcontent":rcontent  } ,
		success : (r)=>{
			console.log('댓글쓰기 post ajax통신')
			console.log(r)
			if ( r == 'true'){alert('댓글작성성공')
				document.querySelector('.rcontent').value = '';
				
				// [제이쿼리] 특정 div만 렌더링
				//$('.replyListbox').load( location.href+' .replyListbox');
				// [JS] 현재페이지 새로고침 (F5)
				location.reload();
			}
			else {alert('댓글작성실패') }
		}
	})
}

// 7. 댓글 출력
function getReplyList(){
	$.ajax({
		url : "/jspweb/board/reply" ,
		method : "get" ,
		data : { "type":1 , "bno":bno} ,
		success : (r)=>{
			console.log('댓글출력 get ajax통신');
			console.log(r);
			html = ''
			r.forEach((o,i)=>{
				html += `
						<div>
							<span>${o.mimg}</span>
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
							<button onclick="rereplyview(${o.rno})" type="button">답변보기</button>
							<div class="rereplybox${o.rno}"></div>
						</div>
						`
			})
			
			document.querySelector('.replyListbox').innerHTML = html
		}
	})
}

// 하위댓글 구역
function rereplyview( rno ){
	console.log("bno : "+bno)
	console.log("rno : "+rno)
	$.ajax({
		url : "/jspweb/board/reply" ,
		async : 'false' , //동기화 통신
		method : "get" ,
		data : { "type":2 , "bno":bno , "rindex":rno } ,
		success : (r)=>{
			console.log(r)
			html = `<div>
						--------------------------------
					</div>`
			r.forEach( (o)=>{
				html += `
						<div>
							<span>${o.mimg}</span>
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
							<button onclick="rereplyview(${o.rno})" type="button">답변보기</button>
							<div class="rereplybox${o.rno}"></div>
						</div>
						`
			})
			html += `
				<textarea class="rrcontent${rno}"></textarea>
				<button onclick="rrwrite(${rno})" type="button">대댓글작성</button>
				`
			console.log('대댓글 클릭')
			// 하위댓글만 출력하려면
			
			let rereplybox = `rereplybox${rno}`
			document.querySelector('.'+rereplybox).innerHTML = html;
			
		} // success end
	}) // ajax end
} // function end

// 하위댓글 작성 [ ]
function rrwrite( rno ){
	// bno , mno , rrcontent , rindex(상위댓글번호)
	$.ajax({
		url : "/jspweb/board/reply" ,
		method : "post" ,
		data : { "type" : 2 , "bno":bno , "rindex":rno , // 하위댓글 2
		"rcontent":document.querySelector('.rrcontent'+rno).value } ,
		success : (r)=>{
			console.log(r)
			if ( r == 'true'){
				alert('대댓글 출력')
				location.reload();
			}
		} 
		
	})
}



/*

1. 


	.접근연산자 때문에 인수로 넣을 때 오류발생 
		-> bdownload(짱구4.jpg) : .파일확장자 구분기호가 아닌 .접근연산자로 사용 
			-> bdownload('짱구4.jpg') : 문자처리되어서 파일확장자 구분기호로 전달됨.
			
	`<button onclick="bdownload(${r.bfile})" type="button">다운로드</button>`
		`<button onclick="bdownload(짱구4.jpg)" type="button">다운로드</button>`  
		
	`<button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`
		`<button onclick="bdownload('짱구4.jpg')" type="button">다운로드</button>`

2. 
		전송 방법
			HTML	:	1.<form>				2.<a href="">
			JS 		:	1.location.href="" 	
			JQUERY	:	1.$.ajax({ })
			servlet : 	
					1.response.getwriter.print(문자데이터);
					2.response.sendRedirect('경로');

bcontent
bdate
bdown
bfile
bno
btitle
bup
bview
cno

mid

mno
*/