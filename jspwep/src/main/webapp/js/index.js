/**
 * 
 */
// JS 함수
// function 함수명 ( 매개변수 ){ 실행코드 }

 alert('js파일열림');
 
 function 예제1(){
	 
	 		
	 let data = document.querySelector('.inputdata').value;
	 console.log(data);
 }
 
 // document : 미리 만들어진 DOM객체
	 	// querySelector( 식별자 ) : 객체 또는 변수에 저장 
	 		// 1. ('.클래스명')
	 		// 2. ('#id명')
	 		// 3. ('tag[name="name"]')
	 		
	 	// 2. querySelectorAll( 식별자 ) : 태그 여러개 가져옴 , 배열또는 리스트로 저장
	 		
	 		// querySelector().속성명 
	 		// 1)  querySelector().value : input , select , textarea [ divX , tableX ]
	 		// 2) querySelector().innerHTML : div , span , td 등등
 