console.log('js열림')

function login(){
	console.log('login열림');
	// 1. 입력받은 값
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	// 2.
	$.ajax({
		url : "/jspweb/login" ,
		method : "post" ,
		data : {"mid":mid , "mpwd":mpwd } ,
		success : (r)=>{
			console.log("ajax 응답")
			console.log(r);
			if( r == 'true' ){
				location.href="/jspweb/index.jsp";
			}else{
				document.querySelector('.checkconfirm').innerHTML = '회원정보가 다릅니다.';
			}
		}
	})	
}

// 엔터 누르면 로그인됨
document.addEventListener("keydown" , (e)=>{
	console.log(e.keyCode)
	if ( e.keyCode == 13 ){
		console.log('enter를 누름')
		login();
	}
})


// 아이디 찾기
function findid(){
	
	console.log('findid 함수');
	
	// 1. 입력받은 이메일 갖고오기
	let memail = document.querySelector('.memail').value
	
	// 2. ajax에게 보내서 결과 받기
	$.ajax({
		url : "/jspweb/find" ,
		method : "get" ,
		// "type" : 1 아이디찾기 "type" : 2 비밀번호찾기
		data : {"type" : 1 , "memail" : memail} ,
		success : (r) => {
			console.log ('ajax 응답')
			console.log (r)
			if ( r == 'false'){
				document.querySelector('.checkconfirm').
					innerHTML = '동일한 회원정보가 없습니다.'; 
			}else{
				document.querySelector('.checkconfirm').
					innerHTML = '회원님 ID : '+r;
			}
			
		}
	})
	
}


function findpwd(){
	console.log('findpwd 함수')
	let info = {
		type : 2 ,
		mid : document.querySelector('.mid').value ,
		memail : document.querySelector('.memail').value 	
	}
	console.log(info);
	
	$.ajax({
		url : "/jspweb/find" ,
		method : "get" ,
		data : info ,
		success : (r) => {
			console.log('ajax 실행')
			console.log(r)
			if ( r == 'false'){
				document.querySelector('.checkconfirm').
					innerHTML = '동일한 회원정보가 없습니다.'; 
			}else{
				document.querySelector('.checkconfirm').
					innerHTML = '임시 비밀번호를 이메일로 전송했습니다.';
			}
			
		} // success end
	}) // ajax end
} // end


