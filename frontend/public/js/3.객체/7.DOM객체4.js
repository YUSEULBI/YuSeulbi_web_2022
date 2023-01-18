/*


	


*/

// 1. select 변경 이벤트
let selectbox = document.querySelector('.selectbox')
selectbox.addEventListener( 'change' , (e) => {
	console.log( e ) // e : 이벤트 결과 정보
	// 1. 선택된 option
	e.currentTarget // 이벤트를 실행한 마크업(타겟) 누가 실행했냐
	console.log( e.currentTarget )
	
	let options = e.currentTarget.options // select 모든 옵션들을 '배열'로 가져오기
	console.log(e.currentTarget.options)
	
	let index = e.currentTarget.options.selectedIndex // select에서 선택한 '인덱스' 가져오기
	console.log( e.currentTarget.options.selectedIndex )
	
	console.log ( options[index].value ) // 중요함 .textContent .innerHTML 가능
	
	document.querySelector('h3').innerHTML = `선택한 옵션 : ${ options[index].value }`
	
})

// 2. checkbox 변경 이벤트
let checkbox = document.querySelector('.checkbox')
checkbox.addEventListener( 'change' , (e) => {
	console.log(e)
	// 1. 체크 여부 확인
	e.currentTarget
	console.log( e.currentTarget )
	e.currentTarget.checked
	console.log( e.currentTarget.checked )
	
})
	
	
//3,
let timer = 0 // 타이머 시간(초) 저장하는 변수
let timerId = 0 // 전역변수

let timerbox = document.querySelector('.timerbox')
let timerspan = document.querySelector('.timerspan')

timerbox.addEventListener( 'change' , (e) => {
	if ( e.currentTarget.checked ){
		// 만약에 체크박스에 체크가 되어 있으면
		
		// setInterval : 특정 시간마다 함수 실행 / 밀리초:1000분의 1초 , 1000이 1초
		// setInterval( 함수명 , 시간(밀리초) )
		// setInterval( () => { 실행문 } , 1000 ) : 1초마다 화살표 함수가 실행 / interval : 시간간격
			// 클리어 하려면 let 변수명 = 
		timerId = setInterval( ()  => { //변수를 바깥에 만들어서 다른 중괄호에서 같이 사용하려고
			timer++; // 변수를 1씩 증가
			timerspan.innerHTML = timer + '초'; 
		 } , 1000 )		
	}else{ // clearInterval : 셋팅값 클리어 , Interval 초기화
	 	clearInterval( timerId )		
	}
})