
let productList = [
	{ img: 'p1.jpg' ,  title : '인스 빨강망토 추추' , size : '[ 12×12cm ]' , price : 10000 , discount : 0.1 , like : 54 , review : 412 } ,
	{ img: 'p2.jpg' ,  title : '인스 하트 넘버링 스카이' , size : '[ 12×12cm ]' , price : 10000 , discount : 0.1 , like : 54 , review : 412 } ,
	{ img: 'p3.jpg' ,  title : '인스 고양이사우나' , size : '[ 12×12cm ]' , price : 10000 , discount : 0.1 , like : 54 , review : 412 } ,
	{ img: 'p4.jpg' ,  title : '인스 백설공주' , size : '[ 12×12cm ]' , price : 10000 , discount : 0.1 , like : 54 , review : 412 } ,
	{ img: 'p5.jpg' ,  title : '인스 인형가게' , size : '[ 12×12cm ]' , price : 10000 , discount : 0.1 , like : 54 , review : 412 } ,
	{ img: 'p6.jpg' ,  title : '인스 오늘날씨는' , size : '[ 12×12cm ]' , price : 10000 , discount : 0.1 , like : 54 , review : 412 }
	
]


product_print()

// 1. 제품 출력 // 1. js 열릴 때
function product_print(){
	let html = ''
	productList.forEach( (o,i) => {
		
		html += `
			<div class="item">				<!-- 제품 1개 -->
				<img src="img/${o.img}"><!-- 제품이미지 -->
				<div class="item_info"> <!-- 제품정보 구역 -->
					<div class="item_title"> ${o.title} </div> <!-- 제품명 -->
					<div class="item_size"> ${o.size} </div>	<!-- 제품사이즈 -->
					<div class="item_price"> ${o.price.toLocaleString()}원 </div>	<!-- 원가 -->
					<div>
						<span class="item_sale"> ${ (o.price - parseInt(o.price*o.discount) ).toLocaleString()}원 </span>	<!-- 판매가 -->
						<span class="item_discount"> ${ parseInt(o.discount*100) }% </span>	<!-- 할인율 -->
					</div>
				</div>
				<div class="item_bottom"> <!-- 제품 하단구역 -->
					<div>
						<span class="badge rounded-pill text-bg-warning">주문폭주</span>
						<span class="badge rounded-pill text-bg-danger">1+1</span>
					</div>
					<div class="item_review"> 찜 ${o.like} · 리뷰수 ${o.review} </div>
					<!-- alt + 숫자키패드 1 + 8 + 3 순차대로 누르면 · -->
				</div>
			</div>
			`
	})
	
	
	document.querySelector('.itembox').innerHTML = html;
}