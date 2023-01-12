console.log('실행')



let contentArray = [ ]





function addContent(){
	
	let 테이블행 =' <tr> <th> 번호 </th> <th> 방문록 </th> </tr>'
	let textBox = document.querySelector('.textBox').value	
	contentArray.push(textBox)	
	
	
	
	
	console.log( 'contentArray의 배열 :' + contentArray)
	
	
	
	
	
	for( let 번호 = 1 ; 번호<=contentArray.length ; 번호++){
		테이블행+=
		' <tr> <td> ' + 번호 + ' </td> <td>'+ contentArray[번호-1] + '</td> </tr>'
	}
	
	document.querySelector('.vTable').innerHTML = 테이블행
	document.querySelector('.textBox').value = ''
	
	
	
}