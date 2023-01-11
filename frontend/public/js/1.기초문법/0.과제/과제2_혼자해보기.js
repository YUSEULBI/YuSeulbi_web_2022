
//for( 초기값 ; 조건문 ; 증감식 ){ 실행문 }

// 테이블의 첫 행 [제목] html 대입
// let html변수명 = 'HTML 마크업작성' // 마크업 문자처리 잘하기

		
	function result(){
		let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';
		let input1 = document.querySelector('.input1') 
		let input2 = document.querySelector('.input2')
		let input1Value = input1.value
		let input2Value = input2.value

		


		for( let 곱 = 1 ; 곱<=input2Value ; 곱++ ){ //for s
		//곱은 1부터 9까지 1씩 증가 반복처리
		console.log( 곱 ) //반복문 확인용
		
		// 변수명과 수식은 문자처리 X
		// 4. 마크업과 변수 이용한 HTML 구성하고 변수에 추가
		테이블행 += // += 추가 [기존데이터에 +] / = 대입 [덮어씌우기]
		'<tr> <th>' + input1Value + '</th> <th>' + 곱 + '</th> <th>'+ input1Value*곱 + '</th> </tr>'
		document.querySelector('.gu_table').innerHTML = 테이블행
	} //fos e
	
	// 5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기
	
		
	}
	
	
	
	 	