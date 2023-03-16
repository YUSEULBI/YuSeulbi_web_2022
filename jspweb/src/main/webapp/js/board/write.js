console.log('write JS 실행')

console.log('memberInfo');
console.log(memberInfo);

if ( memberInfo.mid == null ){
	alert('로그인 하세요')
	location.href="/jspweb/member/login.jsp";
} // html이 생성된후 js가 실행되고 유효성검사를 해서 html이 잠시 보임 // 해결방법은 write.jsp에 적음

function bwrite(){
	
	// type="file" 에 직접적인 조작 불가능
	
	// input값을 받고싶을 때 all 이 아니라 querySelector를 쓰면 html이 들어옴
	// let writeForm = document.querySelector('.writeForm');
	
	// querySelectorAll 을 쓰면 input 값을 객체로 가져옴 - 객체배열
	let writeForm = document.querySelectorAll('.writeForm');
	
	// 폼객체 --> new FormData 클래스 [form 전송시]
	let writeFormData = new FormData(writeForm[0]);
	console.log(writeFormData)
	
	// 4. 
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "post" ,
		data : writeFormData ,
		//첨부파일 때문에 필수 multipart/form-data
		contentType : false ,      // true : 매개변수형식{파라미터}의 문자열타입[기본값] 
		processData : false , 
		success : (r)=>{
			console.log('통신')
			console.log(r)
			if ( r == 'true'){ 	
				alert('글쓰기 성공')
				location.href="/jspweb/board/list.jsp"; 
			}
			else{ alert('글쓰기 실패') }
		}
	})
}