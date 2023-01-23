console.log('js실행')
let clickBtns = []
let comNum = [ ]

function buyBtn(){
	let html = ''
	for ( i = 1 ; i <= 45 ; i++ ){
		html += `<button onclick="clickBtn(${i})"> ${i} </button>`
		if ( i % 5 == 0 ){ html += `<br>`}
	}
	document.querySelector('.btnBox').innerHTML = html
	document.querySelector('.cancelBtnC').style.display = 'inline'
}

function cancelBtn(){
	//구매취소 눌렀을때 실행되는 함수
	// 사라지게할것 0.구매취소버튼 1.버튼목록 2.선택한번호배열 3.추첨된번호배열 4.추첨결과
	document.querySelector('.cancelBtnC').style.display = 'none'
	document.querySelector('.btnBox').innerHTML = ''
	clickBtns = []
	document.querySelector('.selectBox').innerHTML = clickBtns
	document.querySelector('.drawBtn').style.display = 'none'
}



function clickBtn(i){
	// 버튼목록 클릭했을 때
	// 배열에 선택한 번호가 추가
	// 선택한번호 div에 번호 추가
	// 유효성검사 : 중복 , 6자리 초과
	
	if ( clickBtns.indexOf(i) >= 0 ){
		alert('중복 선택입니다. 선택실패')
		//번호를 다시 누르면 배열에서 삭제
		clickBtns.splice( clickBtns.indexOf(i) , 1 )
		document.querySelector('.selectBox').innerHTML = clickBtns
		return;
	}
	if ( clickBtns.length == 6 ){
		alert('6개를 초과했습니다.선택실패')
		return;
	}
	
	clickBtns.push(i)
	document.querySelector('.selectBox').innerHTML = clickBtns
	apperDrawBtn()
}

//번호를 6개 선택하면 추첨하기 버튼이 생김.
function apperDrawBtn(){
	if ( clickBtns.length == 6 ){
		document.querySelector('.drawBtn').style.display = 'inline'
	}else{
		document.querySelector('.drawBtn').style.display = 'none'
	}
}


function drawBtn(){
	//추첨하기 버튼 누르면 실행
	for ( i = 1 ; i <= 6 ; i++ ){
		
		let Num = parseInt(Math.random()*45+1)
		if ( comNum.indexOf(Num) >= 0 ){
			i--
		}else{ comNum.push( Num ) }
		
	}
	document.querySelector('.drawBox').innerHTML = comNum
	
	//추첨번호와 선택번호 비교
	let winNum = 0;
	
	for ( let j = 0 ; j < comNum.length ; j++ ){
		if ( clickBtns.indexOf(comNum[j]) >= 0 ){
				winNum++	
		}
	
	}
	document.querySelector('.winBox').innerHTML = winNum+'개 맞추셨습니다~ '
	document.querySelector('.drawBtn').style.display = 'none'
}
