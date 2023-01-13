console.log('1.js실행')

let contentArray = [  ]  //누적기록 위해 함수지역 바깥에 배열 선언

// 1. 등록 버튼 클릭했을때 이벤트함수
function addContent(){ //f s
	let content = document.querySelector('.content').value
	contentArray.push ( content )
	printcontent()	
} // f e
	//** html'등록' <button>을 클릭했을때 addContent함수가 실행된다.
	//** addContent함수가 실행되면 클래스명:content인 <input>박스의 값을 content라고 선언
	//** .content<input>의 값을 contentArray배열에 추가한다.
	//** printcontent 함수를 실행한다.
	//** printcontent 함수가 실행되면 html에 테이블 번호,방문내용,비고칸이 추가되고
	//** i를 선언 i는 0부터 contentArray배열의 길이의 숫자 전까지 1씩 증가한다.
	//** html에 i+1

// 2. 삭제 버튼을 클릭했을 때 함수
function onDelete( dno ){
	contentArray.splice( dno , 1 )
	printcontent()
} //  f e
// 3. 배열내 존재하는 요소들을 출력하는 함수 [1.등록했을때 2.삭제했을때 ]
function printcontent( ){
	//4. html 구성 // 백팁 사용
	let html = `<tr> 
					<th>번호</th> 
					<th>방문내용</th> 
					<th>비고</th>  
				</tr>`
	// 5. 내용추가 [반복문 이용한 배열내 요소 출력]
	for( let i = 0 ; i<contentArray.length ; i++ ){
		html += `<tr> 
					<td> ${ i+1 } </td> 
					<td> ${ contentArray[i] } </td> 
					<td> <button onclick="onDelete(${i})" > 삭제 </button> </td> 
				</tr>`
				// onDelete ( 삭제할번호 ) 
	}
	
	
	// 6. 위에서 구성된 html을 해당 마크업에 대입
	document.querySelector('.contentTable').innerHTML = html
	
} // f e
	
/*

배열 선언 깡통 ( contentArray )

등록 <button> 누르면 함수실행 (addContent)
addContent()
	<input>의 value는 content 라고 선언
	printcontent() 함수실행 -> html선언, 값은 테이블 추가 , i는 0부터 배열개수 전까지  , 
	printcontent() 함수실행 -> 1열: i+1 , 2열은 i인덱스에해당하는 배열데이터 html에 추가
	printcontent() 함수실행 -> 3열은 onDelete(i)함수가 실행되는 삭제<button> 
	printcontent() 함수실행 -> 총3열을 html에 추가, html값을 .contentTable<table>에 덮어씌우기
	
삭제<button> 누르면 onDelete 함수실행
	배열에 i인덱스에 해당하는 배열값을 삭제 (i는 0부터~인덱스길이전까지)
	i는 삭제하는 버튼에 해당버튼 인수가 적혀있음.
	printcontent() 실행 -> html 테이블 초기값+삭제된것 제외하고 1열 2열 3열 생성 html에 추가 .contentTable<table>에 덮어씌우기 	

	
	
*/