/**
 * 
 */
console.log('index js실행')


 
//$.ajax({
//	url : "/jspweb/product/info" ,
//	method : "get" ,
//	success : (r)=>{
//		console.log(r)
//	}
//})
let productlist = null;
 function productlistprint( ){
	 let html = '<h3>제품목록페이지</h3>'
		productlist.forEach( (p)=>{
			html += `<div>
						<span> ${p.pname} </span>
						<span> ${p.pcomment} </span>
						<span> ${p.pprice} </span>
						<span> ${p.pstate} </span>
						<span> ${p.pview} </span>
						<span> ${p.pdate} </span>
					</div>`
		})
		document.querySelector('.productlistbox').innerHTML = html;
 }
 

 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
        level : 13 // 지도의 확대 레벨 
    });
    
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });
 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    // $.ajax
    $.get("/jspweb/product/info", function(data) {
		//---------------사이드바------------------------
		productlist = data;	// 제품목록 결과를 전역변수에 담기
		productlistprint();
		
		//---------------------마커 ---------------------------------
		
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        
        // map함수는 return된 값을 배열에 대입 vs forEach() return X
        // map( (인덱스,반복객체명)=>{})
        // forEach( (반복객체명,인덱스)=>{})
        var markers = $(data).map(function(i, position) {
			console.log(position)
			
			// 마커에 추가코드 작성하기 위해 벼
            let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.plat, position.plng)
            });
            
              // 마커에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(marker, 'click', function() {
			      console.log(position.pno + "제품 클릭")
			      let html = `
			      			<button onclick="productlistprint()" > <== </button>
			      			<h3>제품상세페이지</h3>
			      			`  
			      html += `<div>
						<span> ${position.pname} </span>
						<span> ${position.pcomment} </span>
						<span> ${position.pprice} </span>
						<span> ${position.pstate} </span>
						<span> ${position.pview} </span>
						<span> ${position.pdate} </span>
						<span> <button type="button" > ♡ </button> </span>
					</div>`
				document.querySelector('.productlistbox').innerHTML = html;
			});
			
			return marker;
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
        
        //-------------마커
    });