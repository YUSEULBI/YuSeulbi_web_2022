console.log('view js 열림')

getBoard()
function getBoard(){
	let bno = document.querySelector('.bno').innerHTML;
	console.log("getBoard에서 호출bno : "+bno)
	
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : {"type" : 2 , "bno":bno } ,
		success : (r)=>{
			console.log('getBoard get 통신')
			console.log(r)
			
			let html = `${ r.bdate } / 
						${ r.bview } / 
						<button onclick="bIncrease(2)" type="type"> ${ r.bup } </button> /
						<button onclick="bIncrease(3)" type="type"> ${ r.bdown } </button> /`
			
			document.querySelector('.infobox').innerHTML = html;
			document.querySelector('.pimgbox').innerHTML = r.mid;
			document.querySelector('.btitle').innerHTML = r.btitle
			document.querySelector('.bcontent').innerHTML = r.bcontent
			
			if ( r.bfile == null ){
				document.querySelector('.bfile').innerHTML = '첨부파일없음';	
			}else{ //첨부파일 있을 때
				html = `${r.bfile} <button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`
				document.querySelector('.bfile').innerHTML = html;
			}
			// -------------------------------------------
			// 로그인된 회원과 작성자가 일치하면 수정/삭제버튼 출력
			if ( memberInfo.mid == r.mid ){
				html = `
						<button onclick="bdelete(${bno} , ${r.cno} )" type="button">삭제</button>
						<button onclick="bupdate(${bno })" type="button">수정</button>
						`
						;
				document.querySelector('.btnbox').innerHTML = html;
				
			}
		}
	})
} // getBoard function end


// 3. typq : 조회수[1] 좋아요수[2] 싫어요수[3]
bIncrease( 1 ); // 현재 jsp/js가 열리는 순간 [ 조회수 증가 ]
function bIncrease( type ){
	
	// 1. 현재 게시물의 번호 [ 증가할 대상 ]
	let bno = document.querySelector('.bno').innerHTML;
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