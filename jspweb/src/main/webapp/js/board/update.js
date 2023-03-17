console.log('update JS 실행')

console.log('memberInfo');
console.log(memberInfo);

let bno = document.querySelector('.bno').value
console.log("bno : "+bno);

getBoard();
// 1.수정할 게시물 출력
function getBoard(){
	$.ajax({
		url : "/jspweb/board/info",
		method : "get",
		data : {"type":2 , "bno":bno} ,
		success : (r)=>{
			console.log('통신')
			console.log(r)
			
			document.querySelector('.btitle').value = r.btitle;
			document.querySelector('.bcontent').value = r.bcontent;
			document.querySelector('.oldbfile').innerHTML = r.bfile;
			
			// 기존 select option 가져와서 select
			let cnoSelect = document.querySelector('.cno');
			console.log("cnoSelect : "+cnoSelect);
			console.log(cnoSelect.options[0]); // select 첫번째 옵션
			
			for( let i = 0 ; i < cnoSelect.options.length ; i++ ){
				// i는 0부터 옵션<option>태그 개수만큼 반복
				if ( cnoSelect.options[i].value == r.cno ){
					// i번째 옵션<option> 태그의 값과 현재 게시물의 카테고리번호와 일치하면
					cnoSelect.options[i].selected = true;
				}
			}
		}
	})
}

// 2.
function bupdate(){
	let updateForm = document.querySelectorAll('.updateForm')[0]
	// form안에 있는 데이터 객체화
	let updateFormData = new FormData(updateForm);
	
	// form밖에 있거나 스크립트에 있는 추가 데이터는 폼데이터에 추가할 수 있음.
		// formdata객체명.set('변수명','데이터')
		updateFormData.set("bno",bno); // 수정할 대상
	
	$.ajax({
		url : "/jspweb/board/info" ,
		method : "put",
		data : updateFormData ,
		contentType : false ,      // true : 매개변수형식{파라미터}의 문자열타입[기본값] 
		processData : false , 
		success : (r)=>{
			console.log(r)
			if( r == 'true'){
				alert('수정성공')
				location.href="/jspweb/board/view.jsp?bno="+bno;
			}else{
				alert('수정실패')
			}
		}
	})
	
	
	
	
}











