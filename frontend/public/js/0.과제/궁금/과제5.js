/*공통-DB -- 공통데이터 ------------전역변수*/

let categoryList = [ '프리미엄' , '스페셜' , '와퍼' , '올데이킹' , '치킨버거' ] //카테고리목록 문자열 배열

let burgerList = [ //메뉴전체 버거목록객체
	{name : '콰트로치즈와퍼' , price: 9500 , img : '콰트로치즈와퍼.png' , category : '프리미엄' } , 
	{name : '몬스터X' , price: 8000 , img : '몬스터X.png' , category : '프리미엄' } ,
	{name : '블랙어니언팩' , price: 13000 , img : '블랙어니언팩.png' , category : '스페셜' }
]
																																																												
// '버거객체' 배열
let cartList = [ ] // 카트목록
// '주문객체'배열
let orderList = [ ] // 주문목록

/*공통-DB--------------------------전역변수 end*/

/*스크립트가 열렸을때 실행되는 함수-------------*/
category_print(); //카테고리출력함수 1회 호출
category_select(0) //기본값 프리미엄 (css변경/카테고리별 제품출력)
product_print( 0 ) //기본값 프리미엄 // 결과적으론 없어도됨 product_print함수가 category_select함수에 들어가있음
cartprint()

/*-------------------------*/

// 1. 카테고리 출력하는 함수
function category_print(){
	
	// 1.HTML 구성
	let html = `<ul>`
	
	for ( let i = 0 ; i < categoryList.length ; i++ ){
		html += `<li 
					class="categoryli" 
					onclick="category_select( ${i} )"
					> ${ categoryList[i] } </li>`
	}
	html+= `</ul>`
	
	// 2.해당 마크업에 HTML 출력
	document.querySelector('.categorybox').innerHTML = html
} 


//2.카테고리선택함수
function category_select( i ){ // i : 선택된 li의 인덱스
	// 1. 모든 li 가져와서 배열 저장 
 	let categoryli = document.querySelectorAll('.categoryli') //동일한 식별자이름을 갖고있는 모든것을 배열로 가져옴
 
// categoryli[i].style.color = 'red';
	// 2. 모든 li 배열 반복문
	for ( let j = 0 ; j < categoryli.length ; j++ ){ // 0부터 마지막 인덱스 까지 버거객체 가져옴.
		if ( j == i ){ // 만약에 li 배열에서 내가 선택한 li의 인덱스와 같으면
			categoryli[j].classList.add('categoryselect'); // 해당 마크업의 class 식별자 추가			
		}else{ //선택되지 않은 li
			categoryli[j].classList.remove('categoryselect'); // 해당 마크업의 class 식별자 제거
		}
	}
	//3. 화면 업데이트 렌더링
	product_print( i )
}


//3. 제품출력함수
function product_print( index ) {
	 let html = '';
	 
	 for( let i = 0 ; i < burgerList.length ; i++ ){
	 if ( burgerList[i].category == categoryList[index] )
	 //i번째 버거객체의 카테고리와 선택된 카테고리와 같으면
	// 1. html 구성
	 html += `<div onclick="cartadd(${i})" class="product">
					<img src="img/${ burgerList[i].img }" width="100%" />
					<div class="productinfo">
						<div class="ptitle"> ${ burgerList[i].name }	</div>
						<div class="pprice"> ${ (burgerList[i].price).toLocaleString() } 원	</div> 
					</div>
				</div>`/*천단위쉼표*/
	}
	 // 2. 구성된 htlml을 마크업 대입
	 document.querySelector('.productbox').innerHTML = html;
}

//4. 제품선택함수 ( 선택한 제품을 카트에 담기 )

function cartadd( i ){
	//1. 선택한 i번째 버거의 객체를 cardlist에 추가
	cartList.push( burgerList[i] )
	cartprint();
	
} // f e





//5. 주문 취소 버튼
function cancel(){
	alert('주문취소함니다')
	cartList.splice(0); // 개수 생략시 모두 삭제
	cartprint(); // 카트내 제품 화면 렌더링 [새로고침]
}


//6. 주문 요청 버튼
 function order(){
	 alert('주문합니다.');
	 //console.log('주문하기전 카트리스트-----------')
	 //console.log(cartList)
	
	// 1. 주문번호 만들기
	let no = 0;
	//마지막인덱스 : 배열명.length -1
	if ( orderList.length == 0 ){no = 1;}
		// 2. 아니면 마지막인덱스의 주문번호+1 를 다음 주문번호로 사용
	else{ no = orderList [ orderList.length-1 ].no+1 }
	
	
	
	// forEach 와 map 의 차이 
	let for배열 = cartList.forEach( (o) => { return o;}) //반환이 안됨
	//console.log( for배열 )
	//console.log('구분선--------------')
	let map배열 = cartList.map ( (o) => { return o;}) // 반환됨 , 카트배열은 지워지는 상황이라 새로운 배열(메모리가 다름)에 저장
	//console.log( map배열 )
	
	// 2. 총 가격 만들기
	let total = 0;
	for ( let i = 0 ; i< map배열.length ; i++ ){ total += map배열[i].price }
	
	
	//1. 주문객체 만들기
	
		//1. order 객체 만들기
		let order = { 
			no : no , // 고유한 변경없는 번호 만들기
			items : map배열 , //.map( ()=>{} ) 새로운 배열에 메모리 저장해서 삭제가 안됨 / 전역변수로 저장하면 안되어서 새로운 배열에 저장 
			// map배열은 지역변수 ,함수가 실행될때마다 새로운 메모리를 만들고 orderlist에 map배열데이터를 저장시키고 선언된map배열은 삭제됨.
			time : new Date() , // new Date() : 현재 날짜/시간 호출
			state : true , 		// true : 일단 주문 	// false : 주문완료
			complete : 0,		// 아직 주문 완료되기 전
			price : total		// cartlist 배열내 버거객체들의 총금액 합계
			
		}
		
		//2.order 객체 배열에 저장
		orderList.push( order )
		//console.log('주문후 카트리스트-----------')
	 //console.log(cartList)
		//console.log( orderList )
	// 2. 주문완료후
	 cartList.splice(0)
	 cartprint();
	 orderTable();
	 salesTable();
 }

//7. 카트 내 버거 출력 [ 1. 제품 클릭할때마다 2. 취소/주문]
function cartprint(){
	//2. 버거개수 카운트
	document.querySelector('.pcount').innerHTML = cartList.length
	//3. 버거 총 개수
	let total = 0;
	for( let j = 0 ; j<cartList.length ; j++ ){
		total += cartList[j].price
	}
	document.querySelector('.ptotal').innerHTML = total.toLocaleString(); //천단위쉼표
	
	//4. 카트내 버거 출력
	let html = ''
	
	for( let j = 0 ; j < cartList.length ; j++ ){
		html += `<div class="item">
						<div class="ititle"> ${cartList[j].name} </div>
						<div class="iprice"> ${cartList[j].price.toLocaleString() }원 </div>
				</div>`
		
	}
		//2. 구성된 html 
		document.querySelector('.cartbottom').innerHTML = html;
}



/*-------------------------포스기------------------------------*/
burgerTable();
orderTable();
salesTable();

function newBurgerApply() {
	// 버거등록 버튼을 눌렀을 때 실행되는 함수
	
	// 1. 버거등록 input 입력값을 js로 가져오기
	let newName = document.querySelector('.newName').value
	let newCategory = document.querySelector('.newCategory').value
	let newPrice = document.querySelector('.newPrice').value
	let newImg = document.querySelector('.newImg').value
	
	// 2. 입력값 유효성검사
	
		// 2-1. 중복이름 검사
		for( let i = 0 ; i < burgerList.length ; i++ ){
			//burgurList의 인덱스
			
			if( burgerList[i].name == newName ){
				//burgerList 모든 객체 name중에 버거등록입력네임값이랑 같은 name이 있다면 
				alert('동일한 버거이름이 있습니다.') ; return false;
				//경고창 띄우고 false를 return하고 함수종료
			}
		}
		
		// 2-2. 카테고리 입력값 검사
		if( categoryList.indexOf(newCategory) < 0  ){
			//입력값이 catogoryList에 없으면 
			
				alert('존재하지 않는 카테고리입니다.') ; return false;
		}
		
		//2-3. 가격입력값이 숫자인지 문자인지 검사
		if ( isNaN( newPrice ) ){
			//금액 입력값이 문자이면
			alert('숫자를 입력하세요.') ; return false;
		}  
		
		
		// 3. 입력값을 newBurgerInfo객체에 저장 , 객체를 burgerList에 push
		let newBurgerInfo = {
			name : newName , 
			price: parseInt(newPrice) , 
			img : newImg , 
			category : newCategory
		}
			
		burgerList.push( newBurgerInfo )
		alert('버거 등록 성공')
			
			
		//console.log('newBurgersInfo--------')
		//console.log( newBurgerInfo )
		//console.log('burgerList--------')
		//console.log(burgerList)
			
		burgerTable();
		category_print(); //카테고리출력함수 1회 호출
		category_select(0); //기본값 프리미엄 (css변경/카테고리별 제품출력)
		product_print( 0 );
		salesTable();
		document.querySelector('.newName').value = ''
		document.querySelector('.newCategory').value = ''
		document.querySelector('.newPrice').value = ''
		document.querySelector('.newImg').value = ''
		
}


function burgerTable(){
	//현재 버거 목록을 테이블에 출력하는 함수
	
	let html2 = `<tr>
					<th>번호</th> <th>이미지</th> <th>버거이름</th> <th>카테고리</th> <th>가격</th> <th>비고</th>
				</tr>`
	for ( let i = 0 ; i < burgerList.length ; i++ ){					
		html2 += `<tr>
					<td>${ i+1 }</td> 
					<td class="burgerTableImg"><img src="img/${burgerList[i].img}" /></td> 
					<td>${burgerList[i].name}</td> 
					<td>${burgerList[i].category}</td> 
					<td>${burgerList[i].price.toLocaleString()}원</td> 
					<td> <button class="bugerListBtn" onclick="bListDelete(${i})" type="button">[삭제]</button> <button class="bugerListBtn" onclick="pChangeBox(${i})" type="button">[가격수정]</button> </td>
				</tr>`
	}
	document.querySelector('.burgerTable').innerHTML = html2
}

function bListDelete(i){
	//삭제버튼을 클릭하면 함수실행
	
	burgerList.splice( i , 1 );
	//버거리스트의 i번 인덱스를 1개 삭제
	burgerTable();
	category_print(); //카테고리출력함수 1회 호출
	category_select(0); //기본값 프리미엄 (css변경/카테고리별 제품출력)
	product_print( 0 );
	salesTable()
}


function pChangeBox(i){
	//가격수정 버튼을 클릭하면 함수실행
	let html = `<tr> <td colspan="6" class="changeTr" > 수정금액: <input class="changePrice" type="text"> <button onclick="changeBtn(${i})" type="button"> 수정 </button> </td> </tr>`
	document.querySelector('.burgerTable').innerHTML += html
	
}

function changeBtn(i){
	//버거리스트의 인덱스번호가 인수로 들어옴
	let changePrice = document.querySelector('.changePrice').value
	burgerList[i].price = changePrice
	burgerTable();
}

function orderTable(){
	
	let html = `<tr>
					<th>주문번호</th> <th>버거이름</th> <th>상태</th> <th>요청/완료시간</th> <th>비고</th>
				</tr>`
	for( let i = 0 ; i < orderList.length ; i++ ){			
		for( let j = 0 ; j < orderList[i].items.length ; j++ ){
			let state = (i) => { if ( orderList[i].state == true){ return '주문요청' }else{ return'주문완료'} }
			let complete = (i) => { if ( orderList[i].state == true){ 
				return `<button class="oComplete" onclick="oComplete(${i})" type="button" >주문완료</button>` 
			}else{ return'<span class="completed">주문완료</span>'} }
				html += `<tr>
							<td>${ orderList[i].no }</td> 
							<td>${ orderList[i].items[j].name }</td> 
							<td>  ${state(i)}   </td> 
							<td class="time">${ orderList[i].time }</td> 
							<td>  ${complete(i)}   </td>
						</tr>`
			//console.log('orderList[i].items')
			//console.log(orderList[i].items)
		}
	}
	
	document.querySelector('.orderTable').innerHTML = html
	
	
	
}

// 주문현황에 주문완료 버튼 눌렀을 때
function oComplete(index){
	orderList[index].state = false;
	//console.log ( orderList[index].state )
	
	
	orderList[index].time = new Date();
	orderTable()
	
}


// 매출현황출력

function salesTable(){
	let html = `<tr>
					<th>제품번호</th> <th>버거이름</th> <th>판매수량</th> <th>매출액</th> <th>순위 [매출액]</th>
				</tr>`
	function counthamsu (index){
		let count = 0;
		for ( let j = 0 ; j < orderList.length ; j++ ){
				// 0부터 orderList의 인덱스까지
				for ( let b = 0 ; b < orderList[j].items.length ; b++ ){
					// 0부터 버거객체의 인덱스까지
					
						
					if( orderList[j].items[b].name == burgerList[index].name ){count++}
			
				}
		}
		return count;
	}		
	
	function total(i){ 
		let total = counthamsu(i)*burgerList[i].price
		return total; 
	}
	
	let rank1 = [ ]
	let rank = 1;
	
	function rankhamsu(i){
				
		for ( let a = 0 ; a < burgerList.length ; a++ ){
		
			if ( total(i) < total(a) ){ rank++;  }
			console.log(i)
			console.log(rank)
			rank1.push(rank)
			console.log(rank1)
			
			return rank;
			
		}
	}
	
	
	for ( let i = 0 ; i < burgerList.length ; i++ ){
		
		 /*	for ( let a = 0 ; a < burgerList.length ; a++ ){
					 
			if ( total(i) < total(a)){ rank++ }
			rank1.push(rank)
			console.log(rank1)*/
				
		
				html += `<tr>
							<td> ${i+1}</th> 
							<td> ${burgerList[i].name}</td> 
							<td> ${ counthamsu(i) } </td> 
							<td> ${ total(i).toLocaleString() }원 </td>
							<td> ${ rankhamsu(i) } </td>
						</tr>`
	
	
	document.querySelector('.salesTable').innerHTML = html
	}
}
