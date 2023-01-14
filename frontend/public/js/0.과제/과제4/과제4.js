// console.log('js작동') // 연동 확인용

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
let 대여목록 = [ '혼자공부하는자바' ]
// console.log( 도서목록 )

//.bookTable 테이블에 덮어씌울 bookTable 초기값


관리자테이블();
	
고객테이블();






function newClick( ){
	console.log('newClick 실행')
	
	let newBook =  document.querySelector('.newBookinput').value
	
		if( newBook.length>4 && newBook.length<11 ){
			도서목록.push(newBook)
		}else{
			alert('5~10자 사이의 도서명을 입력하세요.')
		}
	
	
	
	
	관리자테이블();
	
	고객테이블();
	
	
	
	console.log( '도서목록:' + 도서목록 )
	console.log( '대여목록:' + 대여목록 )
	
	
}

function bookDelete(dno) {
	도서목록.splice( dno , 1 )
	관리자테이블()
	고객테이블()
	console.log( '도서목록 :' + 도서목록 )
}

function 대여함수(out){
	for( i = 0 ; i < 도서목록.length ; i++ ){
		for( j = 0 ; j < 대여목록.length ; j++ ){
			if(도서목록[i] == 대여목록[j] ){
				contentArray.splice( out , 1 )
			}else{ 
				console.log( '대여목록 : '+ 대여목록)
				대여목록.push( 도서목록[out] )
				
			}	
		}
	}
	
}
	
	
function 관리자테이블(){
	let bookTable = ` <tr> <th>번호</th> <th>도서명</th> <th>도서대여여부</th> <th>비고</th> </tr> `
		
		for(let i = 0 ; i < 도서목록.length ; i++  ){
		bookTable += `<tr> 
						<th> ${i+1} </th> 
						<th> ${ 도서목록[i]} </th> 
						<th> <div class="checkOut"></div> </th> 
						<th> <button onclick="bookDelete(${i})" >삭제</button> </th> 
					</tr>`
		
		}
		document.querySelector('.bookTable').innerHTML = bookTable
}

function 고객테이블(){
	let bookTable2 = ` <tr> <th>번호</th> <th>도서명</th> <th>도서대여여부</th> <th>비고</th> </tr> `
	
	for(let i = 0 ; i < 도서목록.length ; i++  ){
		for ( let j = 0 ; j < 대여목록 ; j++ ){
			if ( 도서목록[i] == 대여목록[j]){
				bookTable2 += `<tr> 
								<th> ${i+1} </th> 
								<th> ${ 도서목록[i]} </th> 
								<th> O </th> 
								<th> <button class="반납버튼" >반납</button> </th> 
							</tr>`
			} else {
				bookTable2 += `<tr> 
								<th> ${i+1} </th> 
								<th> ${ 도서목록[i]} </th> 
								<th> X </th> 
								<th> <button class="대여버튼"  >대여</button> </th> 
							</tr>`
			}
		}
	}
	document.querySelector('.bookList').innerHTML = bookTable2
	
	
}


