console.log('info JS 열림')

console.log(memberInfo)
// 1. header.js 에서 ajax 동기식으로 회원정보 가져온 상태 [memberInfo]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mimg').src = `/jspweb/member/pimg/${memberInfo.mimg == null ? 'default.webp' : memberInfo.mimg}` ;
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;

// * 회원정보.js : 만약 로그인이 안되어 있으면 불가능 [ 제어 ]
if ( memberInfo.mid == null ){
	alert('로그인 하세요')
	location.href="/jspweb/member/login.jsp";
}

// 1. 회원탈퇴
// function delete(){} 불가능 [js에서 이미 사용중인 키워드]
function setDelete(){
	console.log('setDelete() 함수 열림')
	
	$.ajax({
		url : "/jspweb/member" ,
		method : "delete",
		success : (r)=>{
			console.log('ajax응답');
			console.log(r)
			if ( r == 'true'){
				alert('회원탈퇴성공');
				location.href = "/jspweb/member/logout.jsp"; // 세션없애기 위해서 로그아웃jsp거치기
			}else{
				alert('회원탈퇴실패 - [관리자에게 문의]');
			}
		}
	})	
}



// 탈퇴버튼
document.querySelector('.modal_check').addEventListener('click',(e)=>{
	let mpwdcheck = document.querySelector('.modal_input').value
	$.ajax({
		url : "" ,
		method : "" ,
		data : { "mpwdcheck" : mpwdcheck },
		success : (r) => {
			console.log('ajax응답')
			console.log(r)
		}
	})
	
})