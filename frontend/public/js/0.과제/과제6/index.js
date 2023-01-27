


// 1. userbox , logbox , monbox -  Dom 객체 가져오기
let wrap = document.querySelector('.wrap')
let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let monbox = document.querySelector('.monbox')
let logbox2 = document.querySelector('.logbox2')
let mhpbox = document.querySelector('.mhpbox')
let userhpbox = document.querySelector('.userhpbox')
let result = document.querySelector('.result')
let expBoxGauge = document.querySelector('.expBoxGauge')
let levelNum = document.querySelector('.levelNum')
let powerNum = document.querySelector('.powerNum')

// 몬스터객체 배열
let monsterG = [ 
	{ m_img : '몬스터1.gif' , hp : 200 , left : 910 , power : 10 , top : 430 } ,
	{ m_img : '몬스터2.gif' , hp : 250 , left : 910 , power : 40 , top : 460 } ,
	{ m_img : '몬스터3.gif' , hp : 300 , left : 910 , power : 60 , top : 460 }
]

// 캐릭터 객체
let character = {
				img   :	`캐릭터1.png`	,
				left  :	10	,
				exp   :	0	,
				lev   :	1	,
				power : 20
			}


//*userbox 기본처음 위치
let u_left = 10;	//유저
let m_left = 910;	//몬스터
let nowMon = 0 //객체인덱스
let mhp = monsterG[nowMon].hp
let userhp = 250;

userbox.style.backgroundImage = `url("img/${character.img}")`
userbox.style.left = `${character.left}px`
expBoxGauge.style.width = `${character.exp}px`
levelNum.innerHTML = character.lev
mhpbox.style.width = `${monsterG[nowMon].hp}px`
powerNum.innerHTML = character.power

// 2. 문서안에서 키입력 이벤트
//-----------------------------------캐릭터이동-----------------------------
document.addEventListener( 'keydown' , (e) => { 
	// console.log('키입력')
	// console.log( e )
	// console.log( e.keyCode )
	
	let key = e.keyCode; // 입력된 키 코드를 변수에 저장
	if ( key == 37 && userhp != 0 ){ //왼쪽키
		 
		u_left -= 10
		u_left = u_left < 0 ? 0 : u_left // 만약에 차감된 왼쪽좌표가 0보다 작으면 u_left값을 0으로 아니면 그대로
		userbox.style.backgroundImage = `url("img/이동2.png")` // 이동모션이미지 
		
	}else if( key == 39 && userhp != 0 ){ //오른쪽키
		
		u_left += 10
		u_left = u_left > 910 ? 910 : u_left // 910 넘어가면 u_left값을 910으로
		userbox.style.backgroundImage = `url("img/이동.png")` // 이동모션이미지
		userbox.style.backgroundSize = `150%;`
		//console.log(  u_left )
	}else if( key == 65 && userhp != 0 ){ // a키 공격
		userbox.style.backgroundImage = `url("img/이동.png")` // 공격모션이미지
		attack(); // 공격함수~~~~
		// *
		
		
	} 
	
	userbox.style.left = `${u_left}px` // 키입력후 css left 변경
	
	logbox.innerHTML = `<div> 캐릭터좌표 : ${ u_left }</div>`
	
	
	
	
	
} ) 

// 2. 문서 안에서 키 떼었을 때 이벤트

document.addEventListener('keyup' , (e) => {
	
	userbox.style.backgroundImage = `url("img/캐릭터1.png")`
	
})

// 3. 방어

document.addEventListener( 'keydown' , (e) => { 
		
		let key = e.keyCode
		if ( key == 83 ){
			//console.log('s키누름')
			userbox.style.backgroundImage = `url("img/이동.png")` // 방어모션이미지
			
		}
		
		
	})


//-----------------------------------캐릭터이동 end -----------------------------


function attack(){ // User 몬스터 [ 공격 범위 ]
	if ( u_left > m_left-70 && u_left < m_left+70 ){
	
	hpDown()
	expUp();
	
	}

}

function expUp(){
	if ( character.exp == 100 ){ 
		character.exp = 0;
		console.log('character.exp')
		console.log(character.exp)
		expBoxGauge.style.width = `${character.exp}px`
		character.lev += 1;
		levelNum.innerHTML = character.lev
		character.power = character.power*2
		console.log('character.power')
		console.log(character.power)
		powerNum.innerHTML = character.power
	}
	character.exp += 10
	expBoxGauge.style.width = `${character.exp}px`
	console.log('character.exp')
	console.log(character.exp)
}

function hpDown(){ // User -> 몬스터 [ user공격력 , 몬스터hp깎임 ]
	let userPower = parseInt(Math.random()*character.power+1) // 10~30
	if ( mhp < 10 ){ userPower = mhp }
	mhp = mhp - userPower 
	mhpbox.style.width = `${ mhp }px`
	
	winner();
}

//-----------------------------------------------------------------------

function damage(){ // 몬스터  [ 공격 범위 ]
	if ( u_left > m_left-70 && u_left < m_left+70 ){
		
		userhpDown();
		
		
		
	}
}


function userhpDown(){ // 몬스터 -> User [ 몬스터 공격력 , 유저 hp깎임 ]
	
	let mpower = parseInt(Math.random()*monsterG[nowMon].power+1) // 1~10
	if ( userhp < 10 ){ userhp = mpower }
	
	userhp = userhp -  mpower
	userhpbox.style.width = `${userhp}px`
	
	winner();
	
}

//-----------------------------------------------------------------------------

function winner(){ // 유저hp , 몬스터hp 검사
	if ( userhp == 0 ){ 
		console.log('패배')
		//userbox.style.display ='none'
		//mhpbox.style.display = 'none'
		userhpbox.style.display = 'none'
		result.innerHTML = '패배'
		
	}else if ( mhp == 0 ){
		if ( nowMon == 3 ){ win();  return;}
		nowMon += 1
		//console.log('nowMon : '+nowMon)
		mhpbox.style.width = `${ monsterG[nowMon].hp }px`
		monbox.style.backgroundImage = `url("img/${monsterG[nowMon].m_img}")`
		monbox.style.left = `${monsterG[nowMon].left}px`
		m_left = monsterG[nowMon].left
		monbox.style.top = `${monsterG[nowMon].top}px`
		mhp = monsterG[nowMon].hp
	}
}

function win(){
		wrap.innerHTML = '<div class="win"> 승리! </div>'
		console.log('mhp'+ mhp); console.log('nowMon'+ nowMon);
}

//-----------------------------------몬스터이동-----------------------------
// 3. 몬스터 이동 난수 [랜덤 - 1초마다 실행 ]

// 특정시간마다 이벤트 실행시켜주는 함수 : setInterval( ( )=>{} , 밀리초(1000/1초))
// Math.random()  		0~1 사이의 실수
// Math.random()*10  	0~9.999 사이의 실수

if ( mhp == 0 && nowMon == 3 ){
	console.log('함수종료')
}else{ setInterval( mon_moving , 1000 ); }


function mon_moving(){
	// 1. 난수 +- 10
	//if ( hp == 0 ){ return; }
	let rand = parseInt( Math.random()*100+1 );	// 이동거리
	let rand2 = parseInt( Math.random()*2 ) // 0 또는 1		// 이동 방향
	if ( rand2 == 1) m_left += rand
	else m_left -= rand
		
	
	// 2. 게임 화면 고정
	if ( m_left < 0 ) m_left = 0;
	if ( m_left > 910 ) m_left = 910;
	
	// 3. 
	monbox.style.left = `${m_left}px`
	
	logbox2.innerHTML = `<div> 몹좌표 : ${ m_left }</div>`
	
	damage();
	//console.log( mhp )
}
//-----------------------------------몬스터이동-----------------------------

/*

	함수 형태
		1. 일반함수 : function 함수명 () {}
		2. 익명함수 : function(){ }
		3. 화살표함수(람다식함수) : ( ) => { }
		4. 변수함수 : let 변수명 = ( ) => { }
		


*/