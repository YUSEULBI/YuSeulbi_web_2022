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
		let 알파벳 = abc[a]
		
		for ( let i = 1 ; i <= 15 ; i++ ){
			// 선택한 시트번호 구하기
			
			seat = (알파벳 + i)
			html += `<button type="button" class="seatNum${seat} seatNum" onclick="seatSelect(${a},${i})">${seat}</button>`
		}
		html += '<br>'
	}
	
	document.querySelector('.seat').innerHTML = html
	
}


// 좌석선택시 함수실행
function seatSelect(a,i){
	
	let 알파벳 = abc[a]
	seat = (알파벳 + i)
	
	
	// 동일한 좌석번호가 배열에 없으면
	if ( selectSeat.indexOf(seat) < 0 ){
		console.log ( selectSeat.indexOf(seat) )
		selectSeat.push(seat)
		console.log(selectSeat)
		
		// 선택한 좌석에 클래스 추가
		document.querySelector(`.seatNum${seat}`).classList.add('selectbox')
	
	// 동일한 좌석번호가 배열에 있으면 배열에서 삭제
	} else if ( selectSeat.indexOf(seat) >= 0  ){
		selectSeat.splice( selectSeat.indexOf(seat) , 1 )
		console.log ( selectSeat)
		
		// 선택한 좌석에 클래스 삭제
		document.querySelector(`.seatNum${seat}`).classList.remove('selectbox')
	}
	
		
			
	

	
	
	
	
	document.querySelector('.seatNumber').innerHTML = selectSeat
}