console.log('view js 열림')

getBoard()
function getBoard(){
	let bno = document.querySelector('.bno').innerHTML;
	console.log("bno : "+bno)
	
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "get" ,
		data : {"type" : 2 , "bno":bno } ,
		success : (r)=>{
			console.log('통신')
			console.log(r)
			document.querySelector('.infobox').innerHTML = `${r.bdate} / ${r.bview} / ${r.bup} / ${r.bdown}`
			document.querySelector('.pimgbox').innerHTML = r.mid
			document.querySelector('.btitle').innerHTML = r.btitle
			document.querySelector('.bcontent').innerHTML = r.bcontent
			
			if ( r.bfile == null ){
				document.querySelector('.bfile').innerHTML = '첨부파일없음';	
			}else{ //첨부파일 있을 때
				html = `${r.bfile} <button onclick="bdownload('${r.bfile}')" type="button">다운로드</button>`
				document.querySelector('.bfile').innerHTML = html;
			}
			
			
		}
	})
} // getBoard function end

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