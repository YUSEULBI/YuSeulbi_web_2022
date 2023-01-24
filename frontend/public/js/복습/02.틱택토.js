console.log('js실행')

let btnList = [ null , null , null , null , null , null , null , null , null ]

function btn(number){
	
	if ( ! 알두기함수( number , 'O' ) ){ return ;}
	
	if ( 결과() ){ return; } // while문 무한루프 안돌게 막기
	
	
	while (true){
		let comNum = parseInt(Math.random()*9)+1
		console.log(comNum)
		
		if ( 알두기함수( comNum , 'X') ){ 결과(); return ;}
	}
	
}
function 알두기함수( Num , 알모양 ){
	let board = document.querySelectorAll('.btnClass')
	
	if ( btnList[Num-1] != null ){ return false; }
	board[Num-1].innerHTML = 알모양
	btnList[Num-1] = 알모양
	console.log('btnList'+ btnList)
	return true;
}


function 결과 (){
	//승리판단
	
	for ( let i = 0 ; i <= 6 ; i+=3 ){
		// 가로 승리자 판단 ( 012 , 345, 678 )
		if ( btnList[i] != null && btnList[i] == btnList[i+1] && btnList[i+1] == btnList[i+2] ){
			결과출력(btnList[i]) ; return true;
		}
	}
	
	// 세로 승리자 판단 ( 036 , 147, 258 )
	for ( let i = 0 ; i<=2 ; i++ ){
		if ( btnList[i] != null && btnList[i] == btnList[i+3] && btnList[i+3] == btnList[i+6] ){
			결과출력(btnList[i]) ; return true;
		}
	}
	// 대각선 승리자 판단 ( 0 4 8 , 2 4 6 )
	if ( btnList[0] != null && btnList[0] == btnList[4] && btnList[4] == btnList[8] ){
		결과출력(btnList[0]) ; return true;
	}
	if ( btnList[2] != null && btnList[2] == btnList[4] && btnList[4] == btnList[6] ){
		결과출력(btnList[2]) ; return true;
	}
	
	//무승부판단
	let 빈자리수 = 0;
	for ( 버튼 of btnList ){
		if ( 버튼 == null ){ 빈자리수++ ;}
		console.log('버튼: '+버튼)
		console.log('빈자리수: '+빈자리수)
	}
	if ( 빈자리수 == 0 ){ 결과출력(`-`); return true; }
	return false;
}

function 결과출력( 알모양 ){
	if ( 알모양 == `-` ){
	document.querySelector('.gameboard').innerHTML = '무승부'
	}else{
	document.querySelector('.gameboard').innerHTML = 알모양  + `승리`
	}
}