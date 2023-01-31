console.log('js실행')

/* DB라고 가정 */
let contents = [
	
	/*{ date : '20230101' , content : '새해맞이 여행'} ,
	{ date : '20230103' , content : '친구 만나기'} ,
	{ date : '20230101' , content : '새해맞이쇼핑 새해맞이쇼핑 새해맞이쇼핑 새해맞이쇼핑 새해맞이쇼핑'}  */
]

/*--------------전역변수 : 모든 함수 공용으로 사용되는 메모리 -------------------*/
// 1. js 열렸을 때 현재 연도와 월을 구해서 변수에 저장
let year = new Date().getFullYear(); // 기본값: 현재 연도	//이전 다음 버튼누르면 변경
let month = new Date().getMonth()+1; // 기본값: 현재 월    //이전 다음 버튼누르면 변경
/*--------------------------------------------------------------------*/

/*--------js 열렸을 때 함수 실행 --------------------*/

cal_print();

/*----------------------------------------------*/


// 2. 캘린더 상단에 표시 함수 [ 1. js열렸을때 2. 이전달 다음달 버튼 클릭 했을때 ]
function cal_print(){
	// 1. 상단에 현재 연도 월 표시
	document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`;
	
	
	
	// 3. html 구성
	let html = `
				<div class="day weekday sunday"> 일 </div>
				<div class="day weekday"> 월 </div> <div class="day weekday"> 화 </div>
				<div class="day weekday"> 수 </div> <div class="day weekday"> 목 </div>
				<div class="day weekday"> 금 </div> <div class="day weekday"> 토 </div>
				`
	
	// month에 + 1 되어있는 상황
	// * 현재 설정된 날짜의 (월의 마지막일의) 객체
	let lastday = new Date ( year , month , 0 ).getDate(); console.log ( '현재 연월 캘린더 날짜 : ' + lastday)
				
	// * 현재 캘린더 설정된 날자의 1일 시작 요일 구하기
	let weekday = new Date( year , month-1 , 1 ).getDay(); console.log('시작요일 : ' + weekday)
	
	
	// * 2. 시작 요일 전에 공백 만들기
	for ( let b = 1 ; b<= weekday ; b++ ){
		html += `<div class="day"> </div>`
	}
	
	// * 1. 일 만들기 [ 1일 ~ 마지막일( new Date ( year , month , 0 ).getDate() ) 까지 ]
	for ( let day = 1 ; day<=lastday ; day++){
		
		// 4. 1일~ 마지막일 날짜 확인
		let date = date_format( new Date( year , month-1 , day ) );
		//console.log( date )  
		 
		
		html += `<div class="day" onclick="openModal( ${date})"> 
					${day} ${contents_print(date)} 
				</div>`
	}
	
	
	// 4. html 마크업 출력
	document.querySelector('.cal_day').innerHTML = html;
	
} //함수 끝

/*----------------------------------------------------------------------*/


// 3. 이전달 다음달 버튼 클릭이벤트에 따른 연도와 월이 변경
document.querySelector('.previousbtn').addEventListener('click' , (e) => {
	//console.log('이전달 버튼 클릭')
	
	// 1. 월 1차감 했을 경우 만약에 월이 1보다 작으면 -> 연도를 1 차감 월 12 설정
	month--;
	if ( month < 1 ){ year--; month = 12; }
	
	cal_print();
})
/*---------------------------------------------------------------------*/
document.querySelector('.nextbtn').addEventListener('click' , (e) => {
	//console.log('다음달 버튼 클릭')
	month++;
	
	// 1. 월이 1증가 했을 경우 만약에 월이 12보다 크면 -> 연도를 1 증가 월 1 설정
	if ( month > 12 ){ year++; month = 1;}
	
	cal_print();
})

/*---------------------------------------------------------------------*/
// 4. 날짜 포맷 함수 [ 인수 : 날짜 ----로직[반환]-----> 반환 : 변경된 날짜형식 ]
function date_format( date ){
	let d_year =  date.getFullYear();
	// 만약에 월/요일이 한자리수(<=9) 이면 앞에 0 붙이기
	let d_month = (date.getMonth()+1) <= 9 ? '0'+ (date.getMonth()+1) : (date.getMonth()+1) ;
	
	let d_day = (date.getDate()) <= 9 ? '0'+ (date.getDate()) : (date.getDate()) ;
	
	return `${d_year}${d_month}${d_day}`
}

/*---------------------------------------------------------------------*/
//5. 일정 출력 함수
function contents_print( date ){ console.log(date)
	// 1. 인수로 전달된 날짜와 동일한 일정 날짜 찾기
		// 1. html
		let html = ``
		
		contents.forEach( (o) => { // 반복문
			console.log( o.date )
			if ( date == o.date ){ // 일정목록이랑 날짜랑 같으면
				html += `<div class="content" style="background-color:${o.bg_color}"> ${o.content} </div>`
			}
		})
		console.log(html)
		return html;
	
}
/*---------------------------------------------------------------------*/
//6. 모달 열기 함수
function openModal( date){
	//console.log( date +'modal열기' )
	
	// 모달이 보이게 css수정
	document.querySelector('.modal_wrap').style.display = 'flex';
	
	// 모달에 선택된 날짜 표시하기
	document.querySelector('.modal_date').innerHTML = date;
	
	//해당하는 날짜에 모든 일정 출력
	schedule_print(); 
	
}

/*---------------------------------------------------------------------*/

//7. 모달 닫기 함수
document.querySelector('.modal_close').addEventListener('click' , (e)=> {
	/*모달숨기기*/
	document.querySelector('.modal_wrap').style.display = 'none';
})

/*---------------------------------------------------------------------*/

//8. 등록 버튼 눌렀을 때
document.querySelector('.modal_write').addEventListener('click', (e)=> {
	// 1. 입력받은 내용과 선택된 날짜를 가져와서 객체화
	let content = {
		date : document.querySelector('.modal_date').innerHTML ,
		content : document.querySelector('.modal_input').value ,
		bg_color : document.querySelector('.modal_color').value
	}; console.log(content)
	// 2. 유효성검사 생략
	//3.
	contents.push(content);
	//4.화면업데이트
		// 1. 입력된 데이터 초기화
			document.querySelector('.modal_input').value = ''
		// 2. 모달닫기
			document.querySelector('.modal_wrap').style.display = 'none';
			
		//3.캘린더 출력 함수
		cal_print();
})
/*---------------------------------------------------------------------*/
function schedule_print(){ 
	let html = `<tr> <th width="5%">#</th> <th>일정내용</th> <th width="15%">비고</th> </tr>`
	let date = document.querySelector('.modal_date').innerHTML;
	let j = 0 ;  // [출력용도] j : 동일한 일정의 객체들의 개수
	contents.forEach( (o , i) => { // 반복문  // [삭제용도] i : content 객체 인덱스 순서
			if ( date == o.date ){ // 일정목록이랑 날짜랑 클릭한 날짜랑 같으면
				j++; // 찾은 개수 증가
				html += `<tr> 
							<td>${ j }</td> 
							<td>${o.content}</td> 
							<td><button type="button" onclick="onDelete(${i})">삭제</button></td> 
						</tr>`
			}
		})
	document.querySelector('.table').innerHTML = html
}
/*---------------------------------------------------------------------*/
//9. 삭제함수
function onDelete(i){
	// 1. 배열내 해당 인덱스 삭제 
	contents.splice( i , 1 );
	// 2. 화면업데이트
	document.querySelector('.modal_wrap').style.display = 'none';
	//3.캘린더 출력 함수
		cal_print();
}


/*

	new Date() 날짜/시간 관련된 클래스
		1. let date = new Date() 					: 현재 날짜 / 시간 객체
		2. let date = new Date( 2023 , 01 , 31 ) 	: 사용자정의 날짜 객체
		3. let date = new Date( 연도 , 월+1 , 0 )		: 연도와 월 날짜에 따른 마지막 날짜
		3. let date = new Date( 연도 , 월 , 1 )		: 연도와 월 날짜에 따른 1일 날짜
			1. get 함수 제공
				1. date.getFullYear()		: 연도
				2. date.getMonth()			: 월 [ 0~11  0:1월 ~ 11:12월 ]
				3. date.getDate()			: 일
				4. date.getDay()			: 요일 [ 0 ~ 6 , 0:일요일 ~ 6:토요일 ]
*/


/*
let date = new Date(); console.log( 'date : ' + date )
let date2 = new Date( 2020 , 1 , 31 ); console.log('date2 : ' + date2 )
console.log ( '연도 : ' + date.getFullYear() );
console.log ('월 : ' + date.getMonth() );
console.log ('일 : ' + date.getDate() );
console.log ('요일 : ' + date.getDay() );
*/

/*

		`${ }`
*/

