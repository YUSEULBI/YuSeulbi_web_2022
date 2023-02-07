console.log('js실행')

//전역변수
let abc = [ 'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' ]
let selectSeat = []

//js실행시 함수실행
//좌석목록출력
seatPrint();

function seatPrint(){
	
	let html = ''
	for ( let a = 0 ; a <= 6 ; a++ ){
		for ( let i = 1 ; i <= 15 ; i++ ){
			html += `<button type="button" class="seatNum" onclick="seatSelect(${a},${i})">${abc[a]+i}</button>`
		}
		html += '<br>'
	}
	/*console.log(html)*/
	document.querySelector('.seat').innerHTML = html
	
}


// 좌석선택시 함수실행
function seatSelect( a , i ){
	let html = ''
	
	// 선택한 시트번호 구하기
	a = abc[a]
	console.log( a )
	console.log( i )
	seat = (a + i)
	
	
	
	//if ( selectSeat.indexOf(selectSeat[0]) >= 0 ){ html += ' , '}
	
	if ( selectSeat.indexOf(seat) > 0 ){
		selectSeat.push(seat)
		console.log(selectSeat)
			
	}
	else if ( selectSeat.indexOf(seat) >= 0 ){
		
		selectSeat.splice( selectSeat.indexOf(seat) , 1 )
		console.log(selectSeat)
		
	}
	
	for ( let s = 0 ; s < selectSeat.length ; s++  ){
			selectSeat[s]
	}
	
	document.querySelector('.seatNumber').innerHTML += html
}