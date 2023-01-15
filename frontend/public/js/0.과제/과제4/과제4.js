// console.log('js작동') // 연동 확인용

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
let 대여목록 = [ '혼자공부하는자바' ]
// console.log( 도서목록 )

//.bookTable 테이블에 덮어씌울 bookTable 초기값


관리자테이블();
	
고객테이블();

	console.log( '대여목록 : ' + 대여목록 )
	console.log( '도서목록 : ' + 도서목록 )




function newClick( ){
	console.log('newClick 실행')
	
	let newBook =  document.querySelector('.newBookinput').value
	
		if( newBook.length>10 || newBook.length<5 ){
			
			alert('5~10자 사이의 도서명을 입력하세요.')
			return;
		}
		
		for( let i = 0 ; i < 도서목록.length ; i++ ){
		
			if( 도서목록[i] == newBook ){
				
				alert('이미 등록된 도서명 입니다.')
				return;
			}
		}
		
	도서목록.push(newBook) 
		
	관리자테이블();
	
	고객테이블();
	
	
	
	console.log( '도서목록 : ' + 도서목록 )
	console.log( '대여목록 : ' + 대여목록 )
	
	
}

function bookDelete(dno) {
	if( 대여목록.length < 1 ){
		도서목록.splice( dno , 1 )
		관리자테이블()
		고객테이블()
		console.log( '도서목록 : ' + 도서목록 )
		console.log( '대여목록 : ' + 대여목록 )
		return;
	}
	
	if ( 도서목록[dno] == 대여목록[dno] ){
			alert('대여중인 도서는 삭제할 수 없습니다.')
	}else { 도서목록.splice( dno , 1 ) }
	
	
	관리자테이블()
	고객테이블()
	
	console.log( '도서목록 : ' + 도서목록 )
	console.log( '대여목록 : ' + 대여목록 )
}


	
	
function 관리자테이블(){
	let bookTable = ` <tr> <th>번호</th> <th>도서명</th> <th>도서대여여부</th> <th>비고</th> </tr> `
	
	
	for(  i = 0 ; i < 도서목록.length ; i++  ){
			
			if( 대여목록.indexOf(도서목록[i])>=0 ){
				bookTable += `<tr> 
								<th> ${i+1} </th> 
								<th> ${ 도서목록[i]} </th> 
								<th> 대여중 </th> 
								<th> <button onclick="bookDelete(${i})" >삭제</button> </th> 
							</tr>`
			}else if ( 대여목록.indexOf(도서목록[i])<0 ){
				bookTable += `<tr> 
							<th> ${i+1} </th> 
							<th> ${ 도서목록[i]} </th> 
							<th> 대여가능 </th> 
							<th> <button onclick="bookDelete(${i})" >삭제</button> </th> 
						</tr>`
			}
			
	
	}
		document.querySelector('.bookTable').innerHTML = bookTable
}

function 고객테이블(){
	let bookTable2 = ` <tr> <th>번호</th> <th>도서명</th> <th>도서대여여부</th> <th>비고</th> </tr> `
	
	
	for(let i = 0 ; i < 도서목록.length ; i++  ){
		if ( 대여목록.indexOf( 도서목록[i]) >=0 ){
				bookTable2 += `<tr> 
								<th> ${i+1} </th> 
								<th> ${ 도서목록[i]} </th> 
								<th> 대여중 </th> 
								<th> <button onclick="returnBook(${i})" class="반납버튼" >반납</button> </th> 
							</tr>`
			} else if ( 대여목록.indexOf( 도서목록[i])<0 ) {
				bookTable2 += `<tr> 
								<th> ${i+1} </th> 
								<th> ${ 도서목록[i]} </th> 
								<th> 대여가능 </th> 
								<th> <button onclick="checkOutBook(${i})" class="대여버튼"  >대여</button> </th> 
							</tr>`
		}
		
	}
	document.querySelector('.bookList').innerHTML = bookTable2
	
	
}

function returnBook(dno) {
	대여목록.splice( 대여목록.indexOf(dno) , 1 )
	관리자테이블()
	고객테이블()
	
	console.log( '대여목록 : ' + 대여목록 )
	console.log( '도서목록 : ' + 도서목록 )
}

function checkOutBook(dno){
	/*for ( let j = 0 ; j < 대여목록.length ; j++ ){
		if ( 대여목록[j] == 도서목록[dno]){
			
		}else if ( 대여목록[j] != 도서목록[dno]){
			대여목록.push(도서목록[dno])			
		}
	}*/
	대여목록.push(도서목록[dno])
	관리자테이블()
	고객테이블()
	console.log( '대여목록 : ' + 대여목록 )
	console.log( '도서목록 : ' + 도서목록 )
}