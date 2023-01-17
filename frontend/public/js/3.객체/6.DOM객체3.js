
// 1. keyup 이벤트 : 키보드 눌렀을 때
	// 1. <textarea> 마크업 객체화
	const textarea  = document.querySelector('textarea')
	const h3 = document.querySelector('h3')
	
	// 2. 해당 마크업의 이벤트 등록 [ 객체명.addEventListener]
	textarea.addEventListener('keyup', ( 이벤트상태 ) => { // key를 누르고 뗐을때 // 인수를 쓰면 - > 콜백함수 addEven~함수가 앞의이벤트(keyup했을때) 나온 값을 다음함수의 인수로 전달
		
		// 3. 해당 마크업 사이에 html 대입 [ 객체명.innerHTML = html형식의 문자 ]
		h3.innerHTML = `글자 수 : ${ textarea.value.length }`
		
		//4. 키 상태 확인
		console.log( 이벤트상태 )	
		console.log( '조합 alt키 : ' + 이벤트상태.altKey )	
		console.log( '조합 ctrl키 : ' + 이벤트상태.ctrlKey )
		console.log( '조합 shift 키 : ' + 이벤트상태.shiftKey ) 
		console.log( 'code 키 : ' + 이벤트상태.code )
		console.log( 'name 키 : ' + 이벤트상태.key )
	})
	
	
	
// 2. keydown 이벤트 : 키보드 키를 입력했을때
	textarea.style.position = 'absolute' // cs 조작 // static이 기본값[작성순서대로 배치됨] left right top bottom 못씀
	let x = 0  // x축
	let y = 0  // y축
	let block = 30; //이동속도?이동단위
	
print();	
function print() {
	textarea.style.left = `${ x*block }px` // ( x*이동단위 ) + 'px' 도 가능
	textarea.style.top = `${ y*block }px`
} 

	
document.body.addEventListener( 'keydown' , ( e ) => {
		
	if ( control ){ // control 이 true인 경우에만 실행
		// console.log('키 눌림')
		let key = e.keyCode;	console.log( e.keyCode );

		if( key == 37 ){ x--; }
		else if( key == 38 ){ y--; } 
		else if( key == 39 ){ x++; }
		else if( key == 40 ){ y++; }
		print()
	}
})

// ***이벤트 제어권 변수
let control = true;

// 3. 
document.querySelector('.moving').addEventListener('click' , () => {
	// 스위치 on/off 변경
	// control ? control = false : control = true //삼항연산자
	control = !control
})