
console.log('js실행')
//버튼을 클릭하면 O표시
let gamebtnArray = [ null , null , null , null , null , null , null , null , null ]



function clickbtn(i){
	if ( ! btnchange( i , 'O') ) { return ; }
	
	if ( winner() ){ return ; }
	
	while ( true ){
	let comN = parseInt( Math.random()*9 )+1 // 1~10미만의 정수
	
	if ( btnchange( comN , 'X') ){ winner(); return; }
	
	
	
	}
}

function btnchange( i , shape ){
	let gamebtn	= document.querySelectorAll('.gamebtn')//배열에 gamebtn추가
	if ( gamebtnArray[i-1] != null ){ return false; }
	gamebtn[i-1].innerHTML = shape 
	gamebtnArray[i-1] = shape
	return true;
}

function winner(){
	// 승자판단
	// 0 1 2
	// 3 4 5
	// 6 7 8
	
	// 1. 가로형 ( 0 1 2 , 3 4 5 , 6 7 8 )
	for ( let i = 0 ; i <= 6 ; i+=3  ){
		if ( gamebtnArray[i] != null && gamebtnArray[i] == gamebtnArray[i+1] && gamebtnArray[i+1] == gamebtnArray[i+2]  ){
			result( i )
			return true;
		}
	}
	// 2. 세로형 ( 0 3 6 , 1 4 7 , 2 5 8 )
	for ( let i = 0 ; i <= 2 ; i++ ){
		if ( gamebtnArray[i] != null && gamebtnArray[i] == gamebtnArray[i+3] && gamebtnArray[i+3] == gamebtnArray[i+6] ){
			result( i )
			return true;
		}
	}
	// 3. 대각선 ( 0 4 8 , 2 4 6 )
	if ( gamebtnArray[0] != null && gamebtnArray[0] == gamebtnArray[4] && gamebtnArray[4] == gamebtnArray[8] ){
		result( 0 );
		return true;
	}
	if ( gamebtnArray[2] != null && gamebtnArray[2] == gamebtnArray[4] && gamebtnArray[4] == gamebtnArray[6] ){
		result( 2 );
		return true;
	}
	// 4. 무승부
	Blank = 0;
	for ( let i = 0 ; i <= 8 ; i++ ){
		if ( gamebtnArray[i] == null ){ Blank++ } 
	}
	if ( Blank == 0 ){	result( '-' ); return true;	}
	
	return false;
}

function result( i ){
	if ( i == '-' ){
	document.querySelector('.gameboard').innerHTML = `무승부`
	}else{
	document.querySelector('.gameboard').innerHTML = gamebtnArray[i]+`승리!`
	}
}