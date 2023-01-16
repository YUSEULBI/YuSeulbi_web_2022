console.log('1. js실행')

// * 배열선언 [ board 객체 여러개를 저장하는 배열 / 함수 밖에 있는 이유 : 누적 저장 ]
let boardArray = [  ]
	// 예시 : [ { 속성:값 } , { 속성:값 } , { 속성:값 }   ]
// 1. 작성 버튼 클릭시 실행되는 함수
function 작성 () { // 작성버튼을 누르면 작성함수 실행
	console.log( '2. 함수실행')
	
	// 1. 입력받은 데이터 가져오기
	let 작성자 = document.querySelector('.작성자').value; //.작성자<input>의 값을 작성자 라고 선언
		console.log( ' 3.작성자 : ' + 작성자 )
	let 내용 = document.querySelector('.내용').value; //.내용<input>의 값을 내용 이라고 선언
		console.log(' 4. 내용 : ' + 내용)
		
	let 비밀번호 = document.querySelector('.비밀번호').value;
		console.log( ' 비밀번호 : ' + 비밀번호 )
		
	// 2. 여러개의 데이터를 하나로 객체화 / 데이터를 묶는거 객체  코드를묶는거 함수
	let board = { 	
			writer : 작성자 , 
			content : 내용 , 
			password : 비밀번호 }	// board 객체 선언 writer에 작성자<input>값 / content에 내용<input>값
		console.log( board ) // 객체 전체는 문자처리랑 같이 안쓰기
	
	// 3. 객체를 배열에 저장 [ 여러개 객체를 저장 ] board를 여러개
	boardArray.push( board )
	출력();
		console.log (boardArray)
		

	
} //f e


// 2. 해당 인덱스 객체 게시물을 1개 삭제 함수
function 삭제( i ){
	//삭제전 비밀번호 입력받는다.
	let 비밀번호 = prompt( '게시물 비밀번호 입력 : ' )
	
	//입력받은 비밀번호와 내가 선택한 게시물의 비밀번호와 같으면 삭제
	if ( 비밀번호 == boardArray[i].password ){
		boardArray.splice( i , 1 ); // i번째 인덱스 객체 삭제
		alert('게시물 삭제 성공')
		출력();
	} else {
		alert ('비밀번호가 다릅니다. 삭제실패')
	}
	//배열에 i번째인덱스 데이터를 1개 삭제한다.
	
	
	
}

// 4. 해당 인덱스 객체[게시물]를 1개 내용 수정 함수
function 수정( i ){
	// alert(i + ' 선택했군요')
	// 비밀번호 검증
	let 비밀번호 = prompt('게시물 비밀번호 입력 : ')
	// 입력받은 비밀번호와 해당 게시물의 비밀번호와 동일하면
	if ( 비밀번호 == boardArray[i].password ){
		// 수정값 입력받음
		let 수정내용 = prompt('수정내용을 입력하세요')
		// 속성값 수정
		boardArray[i].content = 수정내용;
		// boardArray[i] : 배열내 i번째 요소의 '값' ----> 객체임
		// boardArray[i].content : 객체의 속성명
		//	객체명.속성명 = 변경값
		alert (' 수정성공 ')
		출력(); // 업데이트
		
		
	}else{ //비밀번호 다르면
		alert(' 비밀번호가 일치하지 않습니다. 수정실패 ')
		
	}
}

function 출력() { // 1. 작성 성공시 2. 삭제 성공시
	
		// 4. 배열내 객체 출력
		// 1. 테이블 제목행 구현
	let html = `<tr> <th>번호</th> <th>내용</th> <th>작성자</th> <th>비고</th> </tr>`
		// 2.  반복문 이용한 배열내 모든 요소를 행 만들기 [누적]
			// 1. 반복 이용해서 배열내 객체 하나씩 호출 	: boardArray[i]
			// 2. 객체내 속성 호출						: boardArray[i].속성명
	for ( let i = 0 ; i < boardArray.length ; i++ ){
		html += `<tr>
					<td> ${i+1} </td> 
					<td> ${ boardArray[i].content } </td> 
					<td> ${ boardArray[i].writer }</td>
					<td> 
						<button onclick="삭제( ${i} )" > 삭제 </button>  
						<button onclick="수정( ${i} )" > 수정 </button>
					</td>
				</tr>`; // 배열안에 i번째 객체의 작성자 // 배열안에 i번째 객체의 내용
				//인덱스는 중복값이 안생김
	} //for end
	
		// 3. 반복문 종료시 누적된
	document.querySelector('.게시물테이블').innerHTML = html;
}