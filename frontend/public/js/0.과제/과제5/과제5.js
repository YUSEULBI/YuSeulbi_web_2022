

let categoryList = [ '프리미엄' , '스페셜' , '와퍼' , '올데이킹' , '치킨버거' ]
let burgerList = [ 
	
	{name : '콰트로치즈와퍼' , price: 9500 , img : 'img/cheese.png' , category : '프리미엄' } , 
	{name : '몬스터X' , price: 8000 , img : 'img/monster_x.png' , category : '프리미엄' } ,
	{name : '스페셜' , price: 13000 , img : 'img/special.png' , category : '스페셜' }
]

let cartList = [ ]

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
	 html += `<div class="product">
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