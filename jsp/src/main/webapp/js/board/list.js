console.log('js실행')


let tbody = document.querySelector('.tbody')

tbodyTable( null , null ); // js실행될때 함수실행 

// 1. 게시물 출력함수
	// 인수 : 	1. 스크립트 열렸을때[조건X] ( null , null )
	// 			2.검색되었을때[조건O] ( keyword=입력받은값 , key=입력받은값 )
	// 			3. 페이지 전환 되었을 때
function tbodyTable( keyword , key ){ 

	
	//1. 자바[백엔드]로 부터 데이터 요청 // 추후~
		
		// 1. 검색이 없는 경우
		if( keyword == null && key == null){
			//alert('검색이 없는 게시물 출력')
			// JAVA에게 검색이 없는 게시물들을 요청
		}else{// 2. 검색이 있는 경우
			//alert('검색이 있는 게시물 출력')
			// JAVA에게 keyword, key 보내서 검색[조건]이 있는 게시물들을 요청
		}
		
		console.log ( keyword ); console.log ( key );  
		
	//  DB -> JAVA 로 전달된 게시물리스트 데이터라고 가정
	let boardlist = [
	   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
	   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
	   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
	   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
	   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
	]
	
	
	let html = ''
	
	// boardlist.forEach( (board) => {  
	//
	// }) 
	
	for ( let i = 0 ; i < boardlist.length ; i++ ){
		html += `<tr> 
					<td>${ boardlist[i].no }</td> 
					<td>${ boardlist[i].title }</td> 
					<td>${ boardlist[i].writer }</td> 
					<td>${ boardlist[i].date }</td> 
					<td>${ boardlist[i].view }</td> 
					<td>${ boardlist[i].up }</td> 
					<td>${ boardlist[i].down }</td> 
				</tr>`
	}
	tbody.innerHTML = html

}


// 2. 검색 버튼을 클릭햇을 때 키워드와 검색어 가져오기
document.querySelector('.searbtn').addEventListener('click', (e)=>{
	console.log('검색 클릭')
	// 1. 키워드
	let keyword = document.querySelector('.keyword').value
	// 2. 검색어
	let key = document.querySelector('.key').value
	console.log( 'keyword : ' + keyword ) ; 	console.log( 'key : ' + key ) ;
	
	// 3. 유효성검사 생략
	// 4. 게시물출력함수에게 키워드,검색어 전달 [ 백엔드 ]
	tbodyTable( keyword , key )
})