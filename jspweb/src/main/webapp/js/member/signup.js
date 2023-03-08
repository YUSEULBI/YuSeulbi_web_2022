alert('js열림');

// 1.회원가입
function signup(){
	console.log('signup 함수 열림')
	
	let info = {
		mid : document.querySelector('.mid').value ,
		mpwd : document.querySelector('.mpwd').value ,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value ,
		memail : document.querySelector('.memail').value ,
		mimg : document.querySelector('.mimg').value 
	}
	
	console.log( info );
	
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
}