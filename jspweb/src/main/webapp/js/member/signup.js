

/*
	
	JS정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할 때 사용되는 언어
		-- 문법
			/^		: 정규표현식 시작
			$/		: 정규표현식 끝
			[a-z]	: 소문자 a-z 패턴
			[A-Z]	: A-Z 패턴
			[0-9]	: 숫자 0~9 패턴
			[가-힣]	: 한글패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			
			[a-zA-Z] : 영문만 입력
			[a-zA-Z0-9] :영문+숫자 입력
			[a-zA-Z0-9가-힣] :영문+숫자+한글 입력
			
		-- 패턴 검사 함수
			정규표현식.test( 데이터 )	: 패턴이 적합하면 true / 아니면 false
			
			ex)
			/^[a-z]$/.test( qwe ) --> true
			/^[a-z]$/.test( QWE ) --> false
			 
 */

// 2. 아이디 유효성검사 [ 1.문자체크 2.중복검사 ]
function idcheck(){ // onkeyup : 키 누르고 떼기
	console.log('입력중');
	// 1. 입력할 때 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	console.log( mid );
	// 2. 정규표현식 
	// [ 영문(소문자)+숫자 5~30 글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	// 3. 정규표현식 검사
	console.log ( midj.test( mid ) )
	if ( midj.test(mid) ){
		
		// 아이디 중복검사 [ js -> 서블릿 -> dao 에게 해당 아이디 검색 select ]
		$.ajax({
			url : "/jspweb/mconfirm" ,
			method : "get" ,
			data : {"mid" : mid} , // 입력받은 아이디 보내기
			success : (r)=>{
				console.log('ajax통신');
				console.log(r)	// 응답 true 없으면false
				if ( r == 'true'){
					document.querySelector('.idcheckconfirm').innerHTML ='사용중인 아이디';
				}else{
					document.querySelector('.idcheckconfirm').innerHTML ='사용가능한 아이디';
				}
				
			}
		})
		
		
	}else{
		document.querySelector('.idcheckconfirm').innerHTML ='영소문자+숫자 조합 5~30사이로 입력해주세요';
	}
}


// 1.회원가입
function signup(){
	console.log('signup 함수 열림')
	
	// 1. 첨부파일 있을 때 html file input 직접적으로 조작 불가능
		// 1. from 객체 가져오기
	let signupForm = document.querySelectorAll('.signupForm')[0]; // 첫번째 form 가져오기
		// 2. form 안에 있는 data 객ㅊ ㅔ호출
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData );
	
	// 2. 첨부파일 있을 때
	$.ajax({
		url : "/jspweb/member", // 서블릿주소
		method : "post" ,		// 첨부파일 무조건 post/put
		data : signupFormData ,				// FormData 객체 전송
		// 첨부파일있을 때 추가 속성
		contentType : false ,		
		processData : false ,	// query string
				// 기본값 : true [ 매개변수(파라미터)형식의 문자열타입 ] / false : 해제
					// form-u rlencoded 타입으로 전송
				// false: 해제
					// multipart/form 형식으로 전송
		success : (r)=>{
			console.log('ajax 응답');
			console.log(r);
			if ( r == 'true'){
				alert('회원가입성공')
				location.href="/jspweb/index.jsp"
			}else{
				alert('회원가입실패')
			}
		}
	})
	
	
}


/*
	// 2. 첨부파일 없을 때
	let info = {
		mid : document.querySelector('.mid').value ,
		mpwd : document.querySelector('.mpwd').value ,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value ,
		memail : document.querySelector('.memail').value ,
		mimg : document.querySelector('.mimg').value 
	}
	console.log( info );
	
	//
	$.ajax({
		url : "/jspweb/member",		// 서블릿파일에 @WebServlet("/member")
		method : "post",			// 메소드선택
		data : info,
		success : ( r ) => {
			console.log('ajax응답');
			console.log(r);
			if ( r == 'true'){
				alert('회원가입성공')
				location.href="/jspweb/index.jsp"
			}else{
				alert('회원가입실패')
			}
		} // success end
	})// ajax end
	*/