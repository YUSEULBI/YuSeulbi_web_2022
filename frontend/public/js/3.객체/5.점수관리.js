let studentArray = [ ] // 학생들 점수객체 여러개 저장


let addbtn = document.querySelector('.addbtn')

// 
addbtn.addEventListener( 'click' , () => { 
	//alert('클릭됨')
	
	let info = { // 숫자입력해도 value는 문자열로 가져옴 -> 형변환 필요 // parseInt : 정수 숫자로 변경해줌.
		name : document.querySelector('.name').value , 
		kor : parseInt( document.querySelector('.kor').value ) ,
		eng : parseInt( document.querySelector('.eng').value ) ,
		mat : parseInt( document.querySelector('.mat').value ) 
	}
	
	
		
	//유효성검사
	let check = true;	// 유효성검사 상태 저장하는 변수 , 4개중 하나라도 충족하면 저장실패, check는 아무거나 이름바꿔도 됨.
	
		// 1. 중복이름검사
	for ( let i = 0 ; i < studentArray.length ; i++ ){
		if ( studentArray[i].name == info.name ){
			alert('이미 등록된 이름입니다.'); check = false;
			document.querySelector('.namebox').innerHTML = '이미 등록된 이름입니다.'
		}
	}
	 
		// 2. 점수 0~100 사이만 입력
	 if( 	( info.kor<0 || info.kor>100 ) ||
      		( info.eng<0 || info.eng>100 ) || 
      		( info.mat<0 || info.mat>100 ) ) {
      		alert('입력할수 없는 점수 범위 입니다. [ 0~100 사이만 가능 '); check = false;
   		}
		
		// 3. [유효성검사추가]이름이 3~5 사이만 입력가능
		if ( info.name.length < 3 && info.name.length > 5 ){
			alert( '이름은 3~5글자 입력해주세요.'); check = false;
		}
		
		// 4. [유효성검사추가] 점수가 숫자가 아닐경우
		// isNaN( ) : 숫자인지 아닌지 체크 / 숫자이면 true 아니면 false
		// console.log( info.kor )
		// console.log( is( isNaN info.kor ) )
		if ( isNaN ( info.kor ) || isNaN( info.eng ) || isNaN( info.mat ) ) { // 문자이면 true -> alert
			alert ('숫자형식으로 입력하세요'); check = false;
		}
		
		
		// 3. 저장 [ 위 유효성 검사에서 하나라도 충족하지 않았을때 ]
		if ( check ){ // check가 true이면 ( ==true 생략 )
			studentArray.push( info );
			alert (' 학생점수 등록했습니다.');
			printTable();
		}
		console.log ( studentArray )
} )


// 2. 배열내 객체 정보를 테이블에 출력하는 함수 [ 1. JS열렸을때  2. 등록할때마다 업데이트 3.삭제할때마다 4.수정할때마다 ]
printTable(); // 함수를 쓰려면 함수를 호출해야함.
function printTable() {
	
	// 1. html 
	let html = `<tr> 
						<th>번호</th> 
						<th>이름</th> 
						<th>국어</th> 
						<th>영어</th> 
						<th>수학</th> 
						<th>총점</th> 
						<th>평균</th> 
						<th>순위</th> 
						<th>비고</th> 
				</tr>`
				
		
	
	// 2. 배열내 객체 
			studentArray.forEach( ( o , i ) => {
				let total = o.kor+o.eng+o.mat;
		
				let rank = 1;
				studentArray.forEach( (o2) => {
					let total2 = o2.kor + o2.eng + o2.mat ;
					
					// 2. 총점이 비교할 총점보다 작으면 순위 하락
					if ( total < total2 ){ 	rank++; }
				})	
				
				html += `<tr> 
									<td>${i+1}</td> 
									<td>${o.name}</td> 
									<td>${o.kor}</td> 
									<td>${o.eng}</td> 
									<td>${o.mat}</td> 
									<td>${total} </td> 
									<td>${ parseInt( total/3 ) } </td> 
									<td> ${rank} </td> 
									<td> 
										<button onclick="onDelete( ${ i } )">삭제</button> 
										<button onclick="onUpdate( ${ i } )">수정</button> 
									</td> 
							</tr>`
					
	} )
	
	document.querySelector('.listTable').innerHTML = html; 

}


//3. 배열내 삭제 [ 삭제할 인덱스 (이름은 중복체크가 되었기때문에 이름도 가능 )]
function onDelete( i ){
	studentArray.splice( i , 1 ); // 선택한 i번째 인덱스 객체 삭제
	printTable();// 삭제후 새로고침/업데이트
}

// 4. 수정버튼을 클릭했을 때 [ 수정할 인덱스 !!! ]
let upindex = -1; // 수정할 인덱스 // 여러 함수(){ } 에서 동일한 인수(변수) 사용하려고 // 전역변수 //아무숫자나 넣어도 되는데 인덱스는 -1이 아무것도 없다는 의미니까 안전하게 -1로 적음

function onUpdate( i ){
	upindex = i ;  // 내가 선택한 i번째 인덱스 // 지역변수
	// 1. 수정페이지 보여주기
	document.querySelector('.updatebox').style.display = 'block'
	// 2. 선택한 i번째 데이터를  대입해주기
	document.querySelector('.upname').value = studentArray[upindex].name
	document.querySelector('.upkor').value = studentArray[upindex].kor
	document.querySelector('.upeng').value = studentArray[upindex].eng
	document.querySelector('.upmat').value = studentArray[upindex].mat
	
	
} // f e

//5. 수정완료 버튼을 클릭했을 때
let updatebtn = document.querySelector('.updatebtn')
updatebtn.addEventListener( 'click' , () => {
	//수정처리 
	studentArray[upindex].kor = parseInt( document.querySelector('.upkor').value )
	studentArray[upindex].eng = parseInt( document.querySelector('.upeng').value )
	studentArray[upindex].mat = parseInt( document.querySelector('.upmat').value )
	
	
	//점수수정버튼을 누르면 updatebox 숨기기
	document.querySelector('.updatebox').style.display = 'none'
	
	printTable(); // 수정후에는 업데이트
})








