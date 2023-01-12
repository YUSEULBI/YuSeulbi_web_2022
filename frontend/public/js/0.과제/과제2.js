
//for( 초기값 ; 조건문 ; 증감식 ){ 실행문 }

// 테이블의 첫 행 [제목] html 대입
// let html변수명 = 'HTML 마크업작성' // 마크업 문자처리 잘하기

// let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>'; // 1번실행 결과누적
		
	
//
function onRusult(){
	let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>'; // 클릭할때마다 실행 [ 결과누적 X ] 
	console.log('클릭') // 3. 확인
	
	// 4. 단: <input> 곱:<input> 에 입력된 value 각 변수에 저장
	let dan = document.querySelector('.dan').value
	let gob = document.querySelector('.gob').value
	
		for( let 곱 = 1 ; 곱 <=gob ; 곱++ ){ //for s
		//곱은 1부터 입력받은 까지 1씩 증가 반복처리
				
		// 변수명과 수식은 문자처리 X
		// 4. 마크업과 변수 이용한 HTML 구성하고 변수에 추가
		테이블행 += // += 추가 [기존데이터에 +] / = 대입 [덮어씌우기]
		'<tr> <th> '+ dan +' </th> <th>' + 곱 + '</th> <th>'+ dan*곱 + '</th> </tr>'
	} //fos e
	
	// 5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기
	document.querySelector('.gu_table').innerHTML = 테이블행
}