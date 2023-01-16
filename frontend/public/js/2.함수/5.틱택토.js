//alert('1.js실행')
// 2. 함수 호출 : 
	// 1. js : 함수명()
	// 2. html : <마크업 이벤트속성="함수명()" />
//클릭이벤트()

// 4.배열선언 [ 버튼의 상태를 저장하는 배열 -> null : 빈자리 ]
let 버튼목록현황 = [ null , null , null , null , null , null ,null , null , null ]
// 1.사용자 버튼 클릭했을떄 실행되는 함수 / 1. 함수 정의/만들기
function 클릭이벤트( 버튼번호 ){ // f s 
	// 1. 선택된 번호와 알모양을 알두기 함수 전달하고 반환이 false이면 알두기 실패 / true 성공 후 컴퓨터 차례
		//  ! : 반대/부정 false->true   / true->false
	if( ! 알두기( 버튼번호 , 'O' ) ) { return; }
	if ( 결과() ) { return ;}
	// 2. 컴퓨터 차례  무한루프 [ 정상적으로 알 두기 전까지 ]
	while( true ){ // w s 
		let 컴퓨터번호 = parseInt( Math.random()*9 )+1 // 1~9 사이의 난수 생성
		if( 알두기( 컴퓨터번호 , 'X' ) ) { 결과(); return; }
	} // w e 
} // f e 
// 2. 알두기 [ 반환값 : 알 정상적으로 두었는지 확인 false:0:'실패'  / true:1:'성공' -> 신호 번호 ]
function 알두기( 버튼번호 , 알모양 ){
	// 1. <div> 버튼 목록 가져와서 배열에 저장 [ div 9개 호출 ]
	let 버튼목록 = document.querySelectorAll('.버튼');	
	// 2.배열에 상태 변경  // * 만약에 빈자리 가 아니면 실패 false 반환 
	if( 버튼목록현황[버튼번호-1] !=  null ){ return false; }
	// 3. 알모양과 상태 변경 // 클릭된 번호의 div 찾기 [ 선택번호-1 ] // -1 : 인덱스 0부터 시작하니까
	버튼목록[버튼번호-1].innerHTML = 알모양 ; // html 알 상태 변경
	버튼목록현황[버튼번호-1] = 알모양;  // js 알 상태 변경
	// 4. 성공 true 반환
	return true; // 성공했으면 true 반환
} // f e
// 3. 결과 함수 [ 사람/컴퓨터 알두기성공했을때 1.승리 2.패배 2.무승부[빈자리없으면] ]
function 결과(){ 
	// 1. 가로 승리자 판단 
		// * 배열의 초기값이 모두 null 이기 때문에 null 제외
	for( let i = 0 ; i<=6 ; i+=3 ){ // i는 0부터 6까지 3씩증가 반복처리 -> 3회반복 : 0 3 6 
		if( 버튼목록현황[i] != null && 버튼목록현황[i] == 버튼목록현황[i+1] && 버튼목록현황[i+1] == 버튼목록현황[i+2]  ){
			결과출력 ( 버튼목록현황[i] )
			return true; // 승리가 존재한다는 신호
		} // if e 
	} // for e
	// 2. 세로 승리자 판단 
	for( let i = 0 ; i<=2 ; i++ ){ // i는 0부터 2까지 1씩증가 반복처리 -> 3회반복 : 0 1 2 
		if( 버튼목록현황[i] != null && 버튼목록현황[i] == 버튼목록현황[i+3] && 버튼목록현황[i+3] == 버튼목록현황[i+6] ){
			결과출력 ( 버튼목록현황[i] )
			return true;
		}
	} // for e
	// 3. 대각선 승리자 판단 [ 2개 ]
	if( 버튼목록현황[0] != null && 버튼목록현황[0] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[8] ){
		결과출력 ( 버튼목록현황[0] )
		return true;
	}
	if( 버튼목록현황[2] != null && 버튼목록현황[2] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[6]){
		결과출력 ( 버튼목록현황[2] )
		return true;
	}
	
	//무승부판단
	let 빈자리수 = 0;
	for( 버튼 of 버튼목록현황 ){
		if ( 버튼 == null ){ 빈자리수++; }
	} // for e
	
	if( 빈자리수 == 0 ){ 결과출력('-'); return true; }
	
	return false; // 아직 승리나 무승부가 아닌경우 false -- 없어도됨.
}

/*
	
	버튼목록현황 인덱스
	[ 0 ] [ 1 ] [ 2 ]
	[ 3 ] [ 4 ] [ 5 ]
	[ 6 ] [ 7 ] [ 8 ]

	승리판단 3가지 ( 경우의수 8개 )
		1. 가로로 이겼을 때 : 0 1 2 / 3 4 5 / 6 7 8
		
			0 1 2 모양이 모두 동일하면
			3 4 5 모양이 모두 동일하면
			6 7 8 모양이 모두 동일하면

		2. 세로로 이겼을 때 : 0 3 6 / 1 4 7 / 2 5 8
		3. 대각선 이겼을 때 : 0 4 8 / 2 4 6
		
	
	- 무승부 : 알이 모두 존재 했을 때 = null이 0개 -> 빈자리가 없다.
	
	- 
*/

// 게임 승리자 출력
function 결과출력( 알모양 ) {
	// 1. 출력할 위치의 div 호출
	let 게임판 = document.querySelector('.게임판')
	//2.
	
	
	if ( 알모양 == '-'){
		게임판. innerHTML = ' 무승부 '
	}else { 게임판.innerHTML = 알모양 + '승리' }
} 









