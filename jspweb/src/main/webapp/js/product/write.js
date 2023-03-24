/**
 * 
 */
let plat = 0;
let plng = 0;

console.log('write js실행')

// 제품등록 버튼누르면
function onwrite(){
	// 1. 폼전송
	let writeForm = document.querySelectorAll('.writeForm')[0];
	//2. 폼데이터 객체 선언
	let writeFormdata = new FormData( writeForm );
	// 3. 좌표[위도/경도] 추가
		// 폼데이터 객체에 필드 추가
		writeFormdata.set("plat",plat);
		writeFormdata.set("plng",plng);
	
	$.ajax({
		url : "/jspweb/product/info" ,
		method : "post" ,
		data : writeFormdata ,
		contentType : false ,
		processData : false ,
		success : (r)=>{
			console.log(r)
			
		}
	})
}


// -----------------------카카오 지도를 표시할 div객체 ------------------------
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//----------------- 지도를 클릭한 위치에 표출할 마커입니다------------------------------
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//----------------- 지도에 클릭 이벤트를 등록합니다 ------------------------------------
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    var latlng = mouseEvent.latLng; // 클릭한 위도, 경도 정보를 가져옵니다 
    marker.setPosition(latlng); // 마커 위치를 클릭한 위치로 옮깁니다
    
    // 전역변수에 위도 경도 대입
    plat = latlng.getLat()
    console.log( "위도 : "+latlng.getLat() )
    plng = latlng.getLng()
    console.log( "경도 : "+latlng.getLng() )
    
});