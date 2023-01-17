let studentArray = [ ] // 학생들 점수객체 여러개 저장


let addbtn = document.querySelector('.addbtn')

// 
addbtn.addEventListener( 'click' , () => { 
	//alert('클릭됨')
	
	let info = { // 숫자입력해도 value는 문자열로 가져옴 -> 형변환 필요
		name : document.querySelector('.name').value , 
		kor : parseInt( document.querySelector('.kor').value ) ,
		eng : parseInt( document.querySelector('.eng').value ) ,
		mat : parseInt( document.querySelector('.mat').value ) 
	}
	
		console.log ( info )
		
	//유효성검사
		// 1. 중복이름검사
	studentArray.forEach( (obj) => { 
		if ( obj.name == info.name ){ //배열에있는이름과 입력값이름 비교 
			alert('현재 등록된 학생명입니다.'); 
			return; }
	} ) // if end
	
	if ( ( info.kor >= 0 && info.kor <= 100 ) || 
		( info.eng >= 0 && info.eng <= 100 ) || 
		( info.met >= 0 && info.mat <= 100 )  ){
		alert('입력할 수 없는 점수범위 입니다.')
	}
		
	
} )