

let categoryList = [ '프리미엄' , '스페셜' , '와퍼' , '올데이킹' , '치킨버거' ] //카테고리목록
let burgerList = [ //메뉴전체 버거목록
	
	{name : '콰트로치즈와퍼' , price: 9500 , img : 'cheese.png' , category : '프리미엄' } , 
	{name : '몬스터X' , price: 8000 , img : 'monster_x.png' , category : '프리미엄' } ,
	{name : '스페셜' , price: 13000 , img : 'special.png' , category : '스페셜' }
]

let cartList = [ ] // 카트목록
let orderList = [ ] // 주문목록

category_print();
category_select(0) //기본값 프리미엄
product_print( 0 ) //기본값 프리미엄

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
	 console.log('주문하기전 카트리스트-----------')
	 console.log(cartList)
	
	// 1. 주문번호 만들기
	let no = 0;
	//마지막인덱스 : 배열명.length -1
	if ( orderList.length == 0 ){no = 1;}
		// 2. 아니면 마지막인덱스의 주문번호+1 를 다음 주문번호로 사용
	else{ no = orderList [ orderList.length-1 ].no+1 }
	
	
	
	// forEach 와 map 의 차이 
	let for배열 = cartList.forEach( (o) => {console.log(o); return o;}) //반환이 안됨
	console.log( for배열 )
	console.log('구분선--------------')
	let map배열 = cartList.map ( (o) => {console.log(o); return o;}) // 반환됨 , 카트배열은 지워지는 상황이라 새로운 배열(메모리가 다름)에 저장
	console.log( map배열 )
	
	// 2. 총 가격 만들기
	let total = 0;
	for ( let i = 0 ; i< map배열.length ; i++ ){ total += map배열[i].price }
	
	
	//1. 주문객체 만들기
	
		//1. order 객체 만들기
		let order = { 
			no : no ,
			items : map배열 , //.map( ()=>{} ) 새로운 배열에 메모리 저장해서 삭제가 안됨
			time : new Date() , // new Date() : 현재 날짜/시간 호출
			state : true , 		// true : 일단 주문 	// false : 주문완료
			complete : 0,		// 아직 주문 완료되기 전
			price : total		// cartlist 배열내 버거객체들의 총금액 합계
			
		}
		
		//2.order 객체 배열에 저장
		orderList.push( order )
		console.log('주문후 카트리스트-----------')
	 console.log(cartList)
		console.log( orderList )
	// 2. 주문완료후
	 cartList.splice(0)
	 cartprint();
	 
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










