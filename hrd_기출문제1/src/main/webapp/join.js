console.log('join js 실행')

function join(){
	console.log('join 함수 실행')
	
	// 유효성검사
	if ( document.joinform.custno.value == "" ){
		alert('회원번호를 입력해주세요.');
		document.joinform.custno.focus(); // 커서이동
		return false;
	}
	if ( document.joinform.custname.value == "" ){
		alert('회원성명을 입력해주세요.');
		document.joinform.custname.focus(); // 커서이동
		return false;
	}
	if ( document.joinform.phone.value == "" ){
		alert('회원전화번호를 입력해주세요.');
		document.joinform.phone.focus(); // 커서이동
		return false;
	}
	if ( document.joinform.address.value == "" ){
		alert('회원주소를 입력해주세요.');
		document.joinform.address.focus(); // 커서이동
		return false;
	}
	if ( document.joinform.joindate.value == "" ){
		alert('가입일자를 입력해주세요.');
		document.joinform.joindate.focus(); // 커서이동
		return false;
	}
	if ( document.joinform.grade.value == "" ){
		alert('고객등급을 입력해주세요.');
		document.joinform.grade.focus(); // 커서이동
		return false;
	}
	if ( document.joinform.city.value == "" ){
		alert('도시코드를 입력해주세요.');
		document.joinform.city.focus(); // 커서이동
		return false;
	}
	
	//폼 전송
	document.joinform.submit();
	alert('회원 등록이 완료 되었습니다.')
	
}

