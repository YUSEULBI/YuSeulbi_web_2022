console.log('글쓰기 스크립트')

let 게시물임시저장소 = []

// 1. 글 등록 했을 때 실행되는 함수
function board_write(){
	
	// 1. 입력받은 데이터 객체화
	
	// 첨부파일 없는경우 
		// 1. 입력값 각각 객체화
		let board = {
			title: document.querySelector('.btitle').value ,
			content : document.querySelector('.bcontent').value ,
			writer : document.querySelector('.bwriter').value ,
			password : document.querySelector('.bpassword').value
			// 첨부파일은 불가능 type=file value값 가져올 수 없음
		}; console.log(board)
	
	//첨부파일 있는 경우
		// 1. 입력 양식 form가져와서 하나의 객채화 가져오기
		let writeform = document.querySelector('.writeform');
		console.log(writeform)
		
		let formdata = new FormData( writeform )
		console.log(formdata)
	
	//* 유효성검사 생략
	
	// 2. java에게 데이터를 전송 후 결과를 받는다. [통신-AJAX 등] 
		// 생략
	게시물임시저장소.push( board ); console.log(게시물임시저장소)
		
	// 3. 결과에 따른 이벤트
	let result = true; // java로부터 전송결과
	if ( result ) { alert('글쓰기성공'); location.href = 'list.html';}
	else { alert('글쓰기실패')
	}
	
	/*
		-페이지 전환 함수
		 	location.href = '경로';
	*/
}


/* 썸머노트 api 실행 */
$(document).ready(function() {
  $('#summernote').summernote({  height : 300 , lang: 'ko-KR'  });
});



/*기능속성
	$('#summernote').summernote({  속성명 : 값 , 속성명 : 값  });
	1. height : 높이
	2. lang: 'ko-KR' : 한글버전
*/