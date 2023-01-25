console.log('js실행')

// * 함수 밖에 만드는 이유 : 전역변수 : 모든 함수에서 동일한 메모리 사용
let contents = [ ]
onPrint();

	//이벤트함수
		// 1. <button type="button" onclick="onwrite()">
			// function onwrite(){}
		// 2. <button type="button" class="onwritebtn">
			// document.querySelector('.onwritebtn').addEventListener( 'click' , (e) => { } )

// 1. 
function onwrite(){ // 글 등록 함수
	console.log('onwrite실행') // 함수 열리는지 꼭 확인
	
	// 1. 입력받은 4개 데이터를 하나의 객체로 선언
	let info = { // let 객체명 = { 속성명 : 데이터 , 속성명 : 데이터 }
		bwriter : document.querySelector('.bwriter').value ,
		bpassword : document.querySelector('.bpassword').value ,
		btitle : document.querySelector('.btitle').value ,
		bcontent : document.querySelector('.bcontent').value ,
		bdate : new Date() , // 현재 날짜와 시간 반환 
		bview : 0 // 조회수
	}
	console.log( 'info' )
	console.log( info ) // 객체 출력시 문자열 연결연산자 금지
	
	// 2. 유효성검사 // 객체명.속성명
		// 1. 입력받은  데이터 길이 체크
	if ( 	info.bwriter.length <= 0 || info.bpassword.length <= 0 || 
			info.btitle.length <= 0 || info.bcontent.length <= 0 ){
				alert('빈칸을 작성해주세요.')
				return; // 함수종료 : 해당함수에서 더이상 진행 불가
	}
	
	// 3. 배열에 저장 *추후에는 백엔드에게 통신해서 데이터 전달 [ 백엔드 : java , db ] //db는 보조기억장치 -영구저장
	contents.push( info ) // push 는 배열의 맨 뒤에 데이터 추가
	alert('글 등록 성공')
	onPrint(); // 등록했을때 실행
	console.log ( 'contents' )
	console.log ( contents )
	
	// 4. input 초기화
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
	
} // f e


// 2. 글 테이블 출력 함수
function onPrint(){ // 1. js 열렸을때  2. 글등록 3. 글삭제 4. 글수정 등등
	console.log( 'onPrint' )
	// 1. 기본 html 구성
	let html = `<tr> <th>번호</th> <th>제목</th> <th>작성자</th> <th>작성일</th> <th>조회수</th> </tr>`
	// 2. 내용 html 구성
	for( let i = 0 ; i < contents.length ; i++ ){
		
		let date = contents[i].bdate.getFullYear() + '년' + 
					contents[i].bdate.getMonth()+1 + '월' + 
					contents[i].bdate.getDate() + '일' +
					contents[i].bdate.getHours() + ':' +
					contents[i].bdate.getMinutes() + ':' +
					contents[i].bdate.getSeconds() 
		
		html += `<tr onclick="onview(${i})"> 
					<th>${i+1}</th> 
					<th>${contents[i].btitle }</th> 
					<th>${contents[i].bwriter }</th>
					<th>${date }</th>
					<th>${contents[i].bview }</th>  
				</tr>`
	}
	// 3. 마크업에 html 대입
	document.querySelector('.boardtable').innerHTML = html;
} // f e


// 3. 글 보기 함수 
function onview( i ){ // f s // 1. 글목록에서 해당 행을 클릭했을 때
	// ( 조회수 증가 )
	contents[i].bview += 1; onPrint();
	
	console.log( ' i  ')
	console.log( i )
	
	let html = `<div> 제목 : ${contents[i].btitle} </div>
				<div> 내용 : ${contents[i].bcontent } </div>
				<div> 작성자 : ${contents[i].bwriter } </div>
				<div> <button onclick="onDelete(${i})" >삭제</button> </div>
				`
	document.querySelector('.viewbox').innerHTML = html;
}	// f e


// 4.글 삭제 함수
function onDelete(i){
	let password = prompt('비밀번호 : ')
	if ( password == contents[i].bpassword ){
		alert('삭제성공')
		contents.splice( i , 1 )
		onPrint();
		document.querySelector('.viewbox').innerHTML = '';
	}else{
		alert('삭제실패')
	}
}





























