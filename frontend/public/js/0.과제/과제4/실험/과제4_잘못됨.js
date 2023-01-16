

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
let 대여목록 = [ '혼자공부하는자바' ]

관리테이블()
고객테이블()


function 관리테이블(){
	
	let table1 = ` <tr> <th>번호</th> <th>도서명</th> <th>도서대여여부</th> <th>삭제</th> </tr> `
	for ( let i = 0 ; i < 도서목록.length ; i++ ){
		table1 += ` <tr> 
						<th> ${i+1} </th> 
						<th> ${ 도서목록[i] } </th> 
						<th class="대여여부"> 대여가능 </th> 
						<th> <button> 삭제 </button> </th> 
					</tr> `
	}
	
	document.querySelector('.bookTable').innerHTML = table1
	
	for ( let i = 0 ; i < 도서목록.length ; i++ ){
		for( let j = 0 ; j < 대여목록.length ; j++ ){
			if ( 도서목록[i] == 대여목록[j]){
				document.querySelector('.대여여부').innerHTML = '대여중'
			}
		}
		
	}

}

function 고객테이블(){
	
	let table2 = ` <tr> <th>번호</th> <th>도서명</th> <th>도서대여여부</th> <th>비고</th> </tr> `
	for ( let i = 0 ; i < 도서목록.length ; i++ ){
		table2 += ` <tr> 
						<th> ${i+1} </th> 
						<th> ${ 도서목록[i] } </th> 
						<th class="대여여부2"> 대여가능 </th> 
						<th class="대여버튼"> <button onclick="대여이벤트(${i})" > 대여 </button> </th> 
					</tr> `
	}
	
	document.querySelector('.bookList').innerHTML = table2
	
	for ( let i = 0 ; i < 도서목록.length ; i++ ){
		for( let j = 0 ; j < 대여목록.length ; j++ ){
			if ( 도서목록[i] == 대여목록[j]){
				document.querySelector('.대여여부2').innerHTML = '대여중'
			}
		}
		
	}
	
	for ( let i = 0 ; i < 도서목록.length ; i++ ){
		for( let j = 0 ; j < 대여목록.length ; j++ ){
			if ( 도서목록[i] == 대여목록[j]){
				document.querySelector('.대여버튼').innerHTML = '<button> 반납 </button>'
			}
		}
		
	}
}

function 대여이벤트( 대여 ){
	대여목록.push( 도서목록[대여])
	console.log( '대여목록: ' + 대여목록 )
	
	관리테이블()
	고객테이블()
	
	for( let j = 0 ; j < 대여목록.length ; j++ ){
		if ( 도서목록[ 대여 ] == 대여목록[j]){
			document.querySelector('.대여버튼').innerHTML = '<button> 반납 </button>'
		}
	}
	
	
}
