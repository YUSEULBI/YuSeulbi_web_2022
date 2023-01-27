
// 1. userbox , logbox , monbox -  Dom 객체 가져오기

let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let monbox = document.querySelector('.monbox')
let logbox2 = document.querySelector('.logbox2')


//*userbox 기본처음 위치
let u_left = 10;	//유저
let m_left = 910;	//몬스터


// 2. 문서안에서 키입력 이벤트
document.addEventListener( 'keydown' , (e) => { 
	console.log('키입력')
	console.log( e )
	console.log( e.keyCode )
	
	let key = e.keyCode; // 입력된 키 코드를 변수에 저장
	if ( key == 37 ){ //왼쪽키 
		u_left -= 10
		u_left = u_left < 0 ? 0 : u_left // 만약에 차감된 왼쪽좌표가 0보다 작으면 u_left값을 0으로 아니면 그대로 
		
	}else if( key == 39 ){ //오른쪽키
		u_left += 10
		u_left = u_left > 910 ? 910 : u_left // 910 넘어가면 u_left값을 910으로
		userbox.style.backgroundImage = `url("img/이동.png")` // 이동모션이미지
		userbox.style.backgroundSize = `150%;`
		console.log(  u_left )
	}else if( key == 65 ){ // a키 공격
		userbox.style.backgroundImage = `url("img/이동.png")` // 공격모션이미지
		공격();
		// *
		
		
	}
	userbox.style.left = `${u_left}px` // 키입력후 css left 변경
	
	logbox.innerHTML = `<div> 캐릭터좌표 : ${ u_left }</div>`
} ) 

function 공격(){
	if ( u_left > m_left-70 && u_left < m_left+70   ) alert('공격');
}


// 2. 문서 안에서 키 떼었을 때 이벤트
document.addEventListener('keyup' , (e) => {
	userbox.style.backgroundImage = `url("img/캐릭터1.png")`
})

// 3. 몬스터 이동 난수 [랜덤 - 1초마다 실행 ]

// 특정시간마다 이벤트 실행시켜주는 함수 : setInterval( ( )=>{} , 밀리초(1000/1초))
// Math.random()  		0~1 사이의 실수
// Math.random()*10  	0~9.999 사이의 실수

setInterval( mon_moving , 1000 );

function mon_moving(){
	// 1. 난수 +- 10
	let rand = parseInt( Math.random()*100+1 );	// 이동거리
	let rand2 = parseInt( Math.random()*2 ) // 0 또는 1		// 이동 방향
	if ( rand2 == 1) m_left += rand
	else m_left -= rand
		
	
	// 2. 게임 화면 고정
	if ( m_left < 0) m_left = 0;
	if ( m_left > 910) m_left = 910;
	
	// 3. 
	monbox.style.left = `${m_left}px`
	
	logbox2.innerHTML = `<div> 몹좌표 : ${ m_left }</div>`
}


/*

	함수 형태
		1. 일반함수 : function 함수명 () {}
		2. 익명함수 : function(){ }
		3. 화살표함수(람다식함수) : ( ) => { }
		4. 변수함수 : let 변수명 = ( ) => { }
		


*/