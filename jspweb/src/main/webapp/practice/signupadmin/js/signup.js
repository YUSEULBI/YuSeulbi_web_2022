console.log('js열림')

// 아이디 중복체크
function idCheck(){
	console.log('idCheck 실행')
	let mid = document.querySelector('.mid').value
	let midj = /^[a-zA-Z0-9]{5,30}$/
	console.log(midj.test(mid))
	if ( midj.test(mid)){
		$.ajax({
			url:"/jspweb/pppconfirm",
			method:"get",
			data: {"mid":mid} ,
			success :(r)=>{
				console.log('ajax응답')
				console.log(r)
				if(r=='true'){	
					document.querySelector('.idcheckconfirm').innerHTML = '중복 아이디 입니다.';
				}else{
					document.querySelector('.idcheckconfirm').innerHTML = '사용가능 아이디 입니다.';
				}
			}
		})
	}else{
		document.querySelector('.idcheckconfirm').innerHTML = '영소문자+숫자 조합 5~30사이로 입력해주세요';
	}
}


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




