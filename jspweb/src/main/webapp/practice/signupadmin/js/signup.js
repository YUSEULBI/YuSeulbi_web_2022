console.log('js열림')


function pSignup(){ // DB에 등록시키기
	console.log('pSignup 실행')
	let signupForm = document.querySelectorAll('.pSignupForm')[0]; //첫번째 form가져오기
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData );
		
	$.ajax({
		url : "/jspweb/pppmember",
		method : "post",
		data : signupFormData ,
		contentType : false ,
		processData : false ,
		success : (r)=>{
			console.log('ajax 응답')
			console.log(r)
		}
	});	 
}