// console.log('js실행')

let 버튼목록현황 = [ null , null , null , null , null , null , null , null , null  ]

function 클릭이벤트( 버튼번호 ){
	if ( ! 알두기( 버튼번호 , 'O' ) ) { return; }
	
}

function 알두기( 버튼번호 , 알모양 ){
	let 버튼목록 = document.querySelectorAll('.버튼'); //버튼목록 배열선언, .버튼<table> 데이터를 버튼목록 배열에 넣기
	if( 버튼목록현황[버튼번호-1] != null ){ return false; } //현황배열에 클릭한버튼과 같은순서의 데이터 값이 null이 아니면 false
	버튼목록[버튼번호-1].innerHTML = 알모양 ; // .버튼<table>이 담긴 버튼목록배열에서 클릭한버튼과 같은 순서의 데이터에 알모양 덮어쓰기
	
	
	
}


