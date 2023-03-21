
var container = document.getElementById('map');

var options = {
	center: new kakao.maps.LatLng(37.3218778,126.8308848),
	level: 3
};

var map = new kakao.maps.Map(container, options);

//// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();
//------------------------------------------------

var imageSrc = '/jspweb/img/pharmacy.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다

//-------------------------------------------
// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 5 // 클러스터 할 최소 지도 레벨 
});
 //-----------------------------------------------------
 
 //-------------------------------------------------------
// 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
/*
$.get(
	"https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&returnType=JSON&serviceKey=Iqz2hhoDi1svJ0zCQoU1Ol%2F%2Bq6uALaVVHNlDUHV9UF%2F7XsZwh82IOjzCL77bBoSdnftYuB9kq38EGPG9xOeamg%3D%3D"
, function(data) {

	        
		//-------------------------------------
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(data.data).map(function(i, position) {
			//console.log(position.주소)
			
			
			//--------------------------------------------------------------
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch( position.주소 , function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
						//console.log(status)
				       var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
						//console.log("coords"+coords)
				        
				         let marker = new kakao.maps.Marker({
		               	 	position : coords ,
		               	 	image: markerImage // 마커이미지 설정 
			        	});
			        	//console.log(marker)
			        	return marker;
				    } 
				});    
			//--------------------------------------------------------------
			
        });
		// 클러스터러에 마커들을 추가합니다
		clusterer.addMarkers(markers);
         
});
*/
let markers = []
 $.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&returnType=JSON&serviceKey=Iqz2hhoDi1svJ0zCQoU1Ol%2F%2Bq6uALaVVHNlDUHV9UF%2F7XsZwh82IOjzCL77bBoSdnftYuB9kq38EGPG9xOeamg%3D%3D" ,
	method : "get",
	async : false,
	success: (r)=>{
		console.log(r.data)
		/*var markers =*/ 
		r.data.map((o)=>{
			console.log(o.주소)
			
			// 주소로 좌표를 검색합니다 -------------------------------------------------
			geocoder.addressSearch( o.주소 , function(result, status) {
		
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
					console.log(status)
			       var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					console.log("coords : "+coords)
			        
			         let marker = new kakao.maps.Marker({
	               	 	position : coords ,
	               	 	image: markerImage // 마커이미지 설정 
		        	});
		        	
		        	// 마커에 클릭이벤트를 등록합니다
					kakao.maps.event.addListener(marker, 'click', function() {
					      
					      // 모달 정보 담기
					      document.querySelector('.modal_title').innerHTML = o.약국명
					      document.querySelector('.modal_title').style.fontSize = '20px'
					      document.querySelector('.modal_content').innerHTML = o.주소
					      // 모달
					      modal_open();
					});
		        	
		        	console.log(marker)
		        	markers.push(marker)
			    }
			  //------------------------------------------------------------ 
			});    
		})
		// 클러스터러에 마커들을 추가합니다
		setTimeout(() => {
        	clusterer.addMarkers(markers);
			console.log(markers);
    	}, 3000);
		
		
	}
})



// 지도를 클릭한 위치에 표출할 마커입니다
/*var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() , 
    image: markerImage // 마커객체에 이미지객체 대입 - 마커이미지 설정
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);*/

