console.log( ' js 작동 ')

let 도서목록 = [ '혼자공부하는자바' , '이것이자바다' , '열혈 C언어'  ]
let 대여목록 = [ '혼자공부하는자바' ]

console.log ( ' 도서목록 : ' + 도서목록)
console.log ( ' 대여목록 : ' + 대여목록)
console.log( '도서목록[-1]의 값 : ' + 도서목록[-1] )

도서목록.splice( -1 , 1 )
console.log ( ' 도서목록 : ' + 도서목록)


//function bookDelete(dno) {
//	if( 대여목록.length < 1 ){
// 도서목록.splice( dno , 1 ) 
//if ( 도서목록[dno] == 대여목록[dno] ){
			//alert('대여중인 도서는 삭제할 수 없습니다.')
	//}else { 도서목록.splice( dno , 1 ) }
	
	
	//관리자테이블()
	//고객테이블()
	
//onsole.log( '도서목록 : ' + 도서목록 )
//onsole.log( '대여목록 : ' + 대여목록 )
// }