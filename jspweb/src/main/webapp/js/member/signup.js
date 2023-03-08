alert('js열림');

// 1.회원가입
function signup(){
	console.log('signup 함수 열림')
	
	
	
	// 1. 첨부파일 있을 때 html file input 직접적으로 조작 불가능
		// 1. from 객체 가져오기
	let signupForm = document.querySelectorAll('.signupForm')[0]; // 첫번째 form 가져오기
		// 2. form 안에 있는 data 객ㅊ ㅔ호출
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData );
	
	// 2. 첨부파일 있을 때
	$.ajax({
		url : "/jspweb/member", // 서블릿주소
		method : "post" ,		// 첨부파일 무조건 post/put
		data : signupFormData ,				// FormData 객체 전송
		// 첨부파일있을 때 추가 속성
		contentType : false ,		
		processData : false ,	
				// 기본값 : true [ 매개변수(파라미터)형식의 문자열타입 ] / false : 해제
					// form-u rlencoded 타입으로 전송
				// false: 해제
					// multipart/form 형식으로 전송
		success : (r)=>{
			console.log('ajax 응답');
			console.log(r);
		}
	})
	
	
}


/*
	// 2. 첨부파일 없을 때
	let info = {
		mid : document.querySelector('.mid').value ,
		mpwd : document.querySelector('.mpwd').value ,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value ,
		memail : document.querySelector('.memail').value ,
		mimg : document.querySelector('.mimg').value 
	}
	console.log( info );
	
	//
	$.ajax({
		url : "/jspweb/member",		// 서블릿파일에 @WebServlet("/member")
		method : "post",			// 메소드선택
		data : info,
		success : ( r ) => {
			console.log('ajax응답');
			console.log(r);
			if ( r == 'true'){
				alert('회원가입성공')
				location.href="/jspweb/index.jsp"
			}else{
				alert('회원가입실패')
			}
		} // success end
	})// ajax end
	*/