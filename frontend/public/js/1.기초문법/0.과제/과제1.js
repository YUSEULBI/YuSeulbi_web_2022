

//과제1번


/*is not defined
	1. 정의 2. 이름오타 3. 저장새로고침 안함.
*/

/*
*카멜 표기법: studentarray -> studentArray
				onlogin -> onLogin 
*/ 

// 배열선언 위치 [1. 함수안에서 선언(함수실행마다 선언 - 누적 저장 안됨 , 초기화 ) 
//             2. 함수 밖에서 선언 (스크립트 실행시 1번만 선언 - 누적)]
 
 // 4. 배열 선언과 동시에 3개의 요소 저장
let studentArray = [ '20230110' , '20230109' , '20230108' ]


// 3. HTML : onclick="onlogin()"에 대한 함수 정의[만들기]
function onlogin() { // 함수[onLogin] 시작점 
	
	console.log('onlogin 함수 실행;') // 확인용
	
	//5. input 마크업 js변수로 가져오기 [DOM객체]
	 let sno = document.querySelector('.sno')
	 // 5. <input> 마크업에 입력된 데이터 호출
	 let snoValue = sno.value;
		// * 확인
		console.log( '5번체크' + snoValue )
	// 6. 찾기 [만약에 배열내 입력한 값이 존재하면 / 못찾으면-1 찾으면=해당인덱스번호] 	
	let sIndex = studentArray.indexOf(snoValue)
		// * 확인
		console.log('6번체크 : ' + sIndex )
		
	// 7. 논리 // 8. 출력 [ innerHTML 이용한 문구 출력 ]
	if ( sIndex == -1 && snoValue.length==8 ){
	/*{ alert('로그인실패')}*/
	document.querySelector('.resultBox') .innerHTML = '없는 학번입니다.'
	}
	if (sIndex == 0 && snoValue.length==8) { /*else ( alert ('로그인성공') )*/
		document.querySelector('.resultBox') .innerHTML = '로그인성공!' ;
		document.querySelector('.sno').value = '';
	}
	
	if ( snoValue.length!=8 )
		{document.querySelector('.resultBox') .innerHTML = '8자리로 입력해주세요.' ;}
	
	if(sIndex == -1 && document.querySelector('.sno').value=="")
		{document.querySelector('.resultBox') .innerHTML = '공백이면 학번을 입력해주세요~' }
	
	
	 
	
} // 함수[onLogin] 끝


//--------------------------2. 과제2 함수 ---------------------


function onAdd() { // 함수 onAdd 시작점
	
	// 5. input 마크업 js 변수로 가져오기
	let sno2 = document.querySelector('.sno2')
	// 5. input 마크업에 입력된 데이터 호출
	let sno2Value = sno2.value;
	// * 5번 확인
		console.log ('입력값 확인' + sno2Value) 
	//6. 찾기
	let sIndex2 = studentArray.indexOf(sno2Value)
	//* 6번 확인
		console.log ('6번체크' + sIndex2) //맞으면 0 틀리면-1
		
	//7. 논리 , 출력
	
	if ( sIndex2 != -1 ) { 
	document.querySelector('.resultBox2') .innerHTML = '실패! 이미 존재하는 학번입니다!' 
		 }
	
	if(sIndex2 == -1 && document.querySelector('.sno2').value=="")
		{document.querySelector('.resultBox2') .innerHTML = '공백이면 학번을 입력해주세요~' } 
	
	if (sIndex2 == -1 && sno2Value.length!=8 && document.querySelector('.sno2').value!="" )
		{document.querySelector('.resultBox2') .innerHTML = '8자리로 입력해주세요.' ;} 
		
	if ( sIndex2 == -1 && sno2Value.length==8 )
	{	document.querySelector('.resultBox2') .innerHTML = '등록 성공'; studentArray.push(sno2Value) ; 
		document.querySelector('.sno2') .value = ''; }
		console.log (studentArray)
	
	// 공백 안내 resultBox2 에 출력
	
	
	
} // 함수 onAdd 끝