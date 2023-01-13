console.log('1.js실행')

let contentArray = [  ]  //누적기록 위해 함수지역 바깥에 배열 선언

// 1. 등록 버튼 클릭했을때 이벤트함수
function addContent(){ //f s
	//function : 함수 선언 [정의] 시 사용되는 키워드
		// addContent : 함수 [ 아무거나]
		 	// ( ) : 인수
		 		// { } : 함수 호출시 실행되는 구역
	console.log(' 2. 함수작동')
	
	// 2. input 태그에서 입력받은 데이터[value] 가져와서 변수에 저장
	let content = document.querySelector('.content').value
		console.log ('3.content : '+content)
	// 3. 배열내 입력받은 변수 저장
	contentArray.push ( content )
		console.log ('4.contentArray : '+ contentArray) // push가 잘되었는지
	
	
	//4. html 구성 // 백팁 사용
	let html = `<tr> <th>번호</th> <th>방문내용</th> </tr>`
	
	// 5. 내용추가 [반복문 이용한 배열내 요소 출력]
	for( let i = 1 ; i<=contentArray.length ; i++ ){
		html += `<tr> <td> ${ i } </td> <td> ${ contentArray[i-1] } </td> </tr>`
	}
	
	
	// 6. 위에서 구성된 html을 해당 마크업에 대입
	document.querySelector('.contentTable').innerHTML = html
	
} // f e

/*

인풋.content , 등록버튼
테이블.contentTable

contentArray 배열을 선언 , 깡통
등록<button>을 클릭하면 addContent 함수 실행
addContent 함수 실행하면
<input>의 값은 content 라고 선언

content 값을 contentArray배열에 추가

번호, 방문내용 html테이블을 html이라고 선언
i는 1부터~ contentArray배열의개수 까지 1씩 증가 회전 처리

처리하는 것: html에 내용추가
html에 추가되는 내용:
테이블 2열 
1열 : 번호는 1부터 배열 개수만큼 증가
2열 : 내용 인덱스호출은 번호-1한 수로 인덱스 호출

1부터~ 배열개수까지 테이블추가

추가된 html내용을 html의.contentTable의 <table>에 덮어씌우기


*/