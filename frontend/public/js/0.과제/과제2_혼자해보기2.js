console.log('실행')






function tResult() {
	let dan = document.querySelector('.dan').value
	let gob = document.querySelector('.gob').value
	let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>'

	//곱만들기
	for(let 곱 = 1 ; 곱<=gob ; 곱++ ){
		
		테이블행+=
		'<tr> <th>'+ dan + ' </th> <th> '+ 곱 + ' </th> <th>'+ (dan*곱) +'</th> </tr>'
		document.querySelector('.gu_table').innerHTML = 테이블행
	}
	
	
}
//구구단 콘솔에 출력
//단 만들기
for(let 단 = 1 ; 단<=9 ; 단++)
{
	//곱만들기
	for(let 곱 = 1 ; 곱<=9 ; 곱++ ){
		console.log
		( 단 + '*' + 곱 + '=' + (단*곱)	)
	}
}