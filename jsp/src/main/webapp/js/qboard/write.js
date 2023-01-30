console.log('js실행')

let qwriteArray = []

function qboard_write(){
	
	//첨부파일 없는 경우
	let qboard = {
		
		writer : document.querySelector('.qwriter').value ,
		password : document.querySelector('.qpassword').value ,
		title : document.querySelector('.qtitle').value ,
		content : document.querySelector('.qcontent').value
		
		
	};
	console.log (qboard)
	
	//첨부파일 있는 경우
		// 1. 입력양식 form 가져와서 객체화 -> form 태그가 전부 가져와짐
		let qwriteform = document.querySelector('.qwriteform');
		console.log(qwriteform)	
		
		let qformdata = new FormData(qwriteform)
		console.log(qformdata)
		
	
	// 유효성검사 생략
	
	//java 데이터전송 , 결과받기 생략
	
	qwriteArray.push( qboard ); console.log(qwriteArray)
	
	// 결과 이벤트
	let result = true; // java 전송결과
	if ( result ){alert('글쓰기성공'); location.href = `list.html`; }
	else { alert('글쓰기실패')}
}