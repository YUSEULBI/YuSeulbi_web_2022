console.log('js열림')

/*
	
	JS정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할 때 사용되는 언어
		-- 문법
			/^		: 정규표현식 시작
			$/		: 정규표현식 끝
			[a-z]	: 소문자 a-z 패턴
			[A-Z]	: A-Z 패턴
			[0-9]	: 숫자 0~9 패턴		<--------> \d
			[가-힣]	: 한글패턴
			{ 최소길이 , 최대길이 } : 문자열 길이 패턴
			{ 최소길이 } : 문자열 길이 패턴
			+ : 앞에 있는 패턴 1개 이상 반복
			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
			* : 앞에 있는 패턴 0개 반복
			\ : 이스케이프 문자
			
			
			----
			[a-zA-Z] : 영문만 입력
			[a-zA-Z0-9] :영문+숫자 입력
			[a-zA-Z0-9가-힣] :영문+숫자+한글 입력
		-------
			1개 이상 문자가 포함되어야 하는 경우
				(?=.*[패턴문자]) : 해당 패턴문자 한개 이상 입력 
			(?=.*[a-z]) : 소문자 한 개(이상) 필수
			(?=.*[A-Z]) : 대문자 한 개(이상) 필수
			(?=.*[0-9]) : 숫자 한개(이상) 필수
			(?=.*[!@#%^&*]) : 해당하는 특수문자 1개 이상
			
			(?=.*[!@#%^&*])[!@#%^&*] : 특수문자
			필수입력 설정해놓은것은 소괄호 바깥 []안에도 써야함.
			
			
		
		-- 패턴 검사 함수
			정규표현식.test( 데이터 )	: 패턴이 적합하면 true / 아니면 false
			
			ex)
			/^[a-z]$/.test( qwe ) --> true
			/^[a-z]$/.test( QWE ) --> false
			 
 */
// 컨펌박스 span 모두 가져오기 -->  여러개의 span 배열/리스트 객체에 대입 [ 인덱스 0 ~3 ]
// checkconfirm[0]
// checkconfirm[1]
// checkconfirm[2]


// 첨부파일 이미지 미리보기
// 정책상 사용자[클라이언트JS]에 운영체제 접근 불가.
// document.addEventListener('change' , (e)=>{ });
function premimg( object ){ // 매개변수 : 해당 함수를 실행시킨 주체 
	//console.log('첨부파일 바뀜'+object);
	//console.log(object.files[0]); // 현재 이벤트를 실행한 input의 등록한 파일명
	//console.log(document.querySelector('.mimg').files[0]) // 해당클래스 input의 등록한 파일호출
	// 1. JS 파일클래스 선언
	let file = new FileReader();	// 파일 읽기 클래스
	// 2. 해당 첨부된 파일을 읽어오기 ( file.readAsDAta URL(첨부파일))
	//console.log(object)
	//console.log( object.files[0])
	
	//FileList객체의 0번째 객체 , 아마 여러개 파일 등록시를 대비해서 FileList객체 안에 파일객체를 담는듯. 그래서 인덱스를 선택해야함.
	// let file1 = object.files[0];
	// file.readAsDataURL(file1);
	// FileList객체의 첫번째 파일을 가져와서 readAsDataURL함수를 실행해서 파일 읽기
	file.readAsDataURL( object.files[0] )	// 해당 파일 읽어오기 // 읽기동작
	
	// 3. 읽어온 파일 꺼내기 바이트
	file.onload = (e)=>{ // 읽기동작이 성공하면 발생하는 이벤트
		console.log( e.target.result)
		document.querySelector('.premimg').src = e.target.result;
	}
		//console.log( e.target.result )
		// e.target -> file.onload : 읽어온 파일
		// e.target.result 			: 읽어온 파일의 바이트 결과
		// 4. 이미지 태그의 src이미지 바이트 대입
		
	
	// 4.
	
}


let checkconfirm = document.querySelectorAll('.checkconfirm')

// 2. 아이디 유효성검사 [ 1.문자체크 2.중복검사 ]
function idcheck(){ // onkeyup : 키 누르고 떼기
	// console.log('입력중');
	// 1. 입력할 때 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	// console.log( mid );
	// 2. 정규표현식 
	// [ 영문(소문자)+숫자 5~30 글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	// 3. 정규표현식 검사
	// console.log ( midj.test( mid ) )
	if ( midj.test(mid) ){
		
		// 아이디 중복검사 [ js -> 서블릿 -> dao 에게 해당 아이디 검색 select ]
		$.ajax({
			url : "/jspweb/mconfirm" ,
			method : "get" ,
			data : {"mid" : mid} , // 입력받은 아이디 보내기
			success : (r)=>{
				// console.log('ajax통신');
				// console.log(r)	// 응답 true 없으면false
				if ( r == 'true'){
					checkconfirm[0].innerHTML ='사용중인 아이디';
				}else{
					checkconfirm[0].innerHTML ='O';
				}// if문 end
			}// success end
		})// ajax end
		
	}else{
		checkconfirm[0].innerHTML ='영소문자+숫자 조합 5~30사이로 입력해주세요';
	}
}//

// 3. 비밀번호 유효성검사
function pwdcheck(){
	console.log('pwdcheck')
	// 1. 입력받은 값 가져오기
	let mpwd = document.querySelector('.mpwd').value;
	console.log(mpwd);
	// 2. 정규표현식
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z\d]{5,20}$/		
		console.log(mpwdj.test(mpwd))
	// 3. 제어
	if ( mpwdj.test(mpwd) ){
		checkconfirm[1].innerHTML = 'O'; 
		pwdconfirmcheck();
	}else{
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20사이로 입력해주세요'
	}
}

// 4. 비밀번호 확인 유효성검사
function pwdconfirmcheck(){
	console.log('pwdconfirmcheck')
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	console.log(mpwdconfirm);
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z\d]{5,20}$/
	
	// 3. 제어
	// 정규표현식 통과하면
	if ( mpwdj.test(mpwdconfirm)){
		// 두 비밀번호 동일한지 체크
		if ( mpwd != mpwdconfirm ){ // 두비밀번호 다르면
			checkconfirm[1].innerHTML = '두 비밀번호가 일치하지 않습니다.'
		}else{ // 두비밀번호 같으면
			checkconfirm[1].innerHTML = 'O'
		}	
	}else{ // 정규표현식 틀리면
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20사이로 입력해주세요'
	}
	
}//

// 5. 이메일 유효성검사
function emailCheck(){
	console.log('emailcheck()')
	let memail = document.querySelector('.memail').value;
	console.log('memail : ' + memail)
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	console.log ( memailj.test(memail));
	if ( memailj.test(memail) ){
		checkconfirm[2].innerHTML = '이메일 형식 확인, 인증해주세요.'
		document.querySelector('.authbtn').disabled = false; // 인증 버튼 사용
	}else{
		checkconfirm[2].innerHTML = '이메일 형식으로 입력해주세요'
		document.querySelector('.authbtn').disabled = true; // 인증 버튼 미사용
	}
			// 아이디 구역
			// [a-zA-Z0-9_-] 		: 영문+숫자+ _ + -
			// +@ 					: 아이디와 도메인 사이의 @ 
			// 도메인구역
			// [a-zA-Z0-9-]			: 영문+숫자+ -			naver
			// +\.					: 도메인 중간에 .		.
			// [a-zA-Z0-9-]			: 영문+숫자+ -			com
			// +					: . 한개이상 			naver.co.kr
}// emailCheck	end	

// 6. 이메일 인증 함수
function getauth(){
	console.log('getauth()함수 실행')
	
	// 메일 전송 테스트 할 경우 -------
	
	// * ajax JAVA에게 이메일 전송 후 인증코드 받기;
//	$.ajax({
//		url : "/jspweb/email" ,
//		method : "post" ,
//		data : {"memail" : document.querySelector('.memail').value } ,
//		success : (r) =>{
//			console.log('ajax 응답');
//			console.log(r);
//			
//			let html = `
//				<div class="timebox">02 : 00</div>
//				<input type="text" class="authinput" placeholder="인증코드">
//				<button onclick="authconfirm()" type="button">확인</button>
//				`
//				// 2. html 대입
//				document.querySelector('.authbox').innerHTML = html;
//				// 3. 타이머 함수 실행
//				auth = r; // 인증코드 [ 이메일에게 보낸 난수 대입 ]
//				timer = 119; // 인증시간 대입 5초 120초
//				settimer(); // 타이머 함수 실행
//		}
//	}) 
	// ajax end
	
	
	// 메일 전송 테스트 안하는 경우 -------
	// 1. 인증구역 html구성
	let html = `
				<div class="timebox">02 : 00</div>
				<input type="text" class="authinput" placeholder="인증코드">
				<button onclick="authconfirm()" type="button">확인</button>
				`
	// 2. html 대입
	document.querySelector('.authbox').innerHTML = html;
	// 3. 타이머 함수 실행
	auth = 1234; // 인증코드 [ 이메일에게 보낸 난수 대입 ]
	timer = 119; // 인증시간 대입 5초 120초
	settimer(); // 타이머 함수 실행
	
}

let auth = 0;
let timer = 0; // 인증시간
let timerInter; // Interval 함수 저장할 변수

// 7. 타이머 함수
function settimer(){
	
	// setInterval : 특정 시간마다 함수 실행
	// setInterval( ()=>{} , 시간/밀리초 )
		// clearInterval : interval 종료
	timerInter = setInterval( ()=>{
		
		let minutes = parseInt(timer / 60); // 분계산
		let seconds =  parseInt( timer % 60 )  ; // 분 계산후 나마지가 초
		// 한자리수 이면 0추가
		minutes = minutes < 10 ? "0"+minutes : minutes;
		seconds = seconds < 10 ? "0"+seconds : seconds;
		
		let timeHTML = minutes + " : " + seconds;
			console.log(timeHTML)
		
		document.querySelector('.timebox').innerHTML = timeHTML;
		
		timer--;
		
		if ( timer < 0 ){
			clearInterval( timerInter );
			checkconfirm[2].innerHTML = '인증실패';
			document.querySelector('.authbox').innerHTML = "";
		}
	} , 1000 ); // 1초마다 {} 코드 실행
	
}

// 8. 인증코드 확인
function authconfirm(){
	console.log('authconfirm 실행')
	// 1. 입력받은 인증코드 호출
	let authinput = document.querySelector('.authinput').value;
	
	if ( auth == authinput ){
		clearInterval( timerInter );
		document.querySelector('.authbox').innerHTML = "";
		document.querySelector('.authbtn').innerHTML = "완료";
		document.querySelector('.authbtn').disabled = true;
		checkconfirm[2].innerHTML = 'O';
	}else{
		checkconfirm[2].innerHTML = '인증코드가 일치하지 않습니다.';
	}
}

// 1.회원가입
function signup(){
	// * 유효성검사
	let count = 0;
	for( let i = 0 ; i < checkconfirm.length ; i++ ){
		if (checkconfirm[i].innerHTML == 'O'){
			count++
		}
	}
	if ( checkconfirm.length != count  ){ alert('정상적으로 입력되지 않은 데이터가 있습니다.'); return;	}
	 
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