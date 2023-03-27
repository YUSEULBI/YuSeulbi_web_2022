/**
 * 
 */
// 회원제페이지
if ( memberInfo.mid == null ){
	alert('로그인후 제품등록 가능합니다.')
	location.href="/jspweb/member/login.jsp"
}

let plat = 0;
let plng = 0;

//
let fileList = []; // 드래그앤드랍용


console.log('write js실행')

// 제품등록 버튼누르면
function onwrite(){
	console.log('onwrite()실행')
	// 1. 폼전송
	let writeForm = document.querySelectorAll('.writeForm')[0];
	//2. 폼데이터 객체 선언
	let writeFormdata = new FormData( writeForm );
	// 3. 좌표[위도/경도] 추가
		// 폼데이터 객체에 필드 추가
	writeFormdata.set("plat",plat);
	writeFormdata.set("plng",plng);
	
	// 위도 경도 안들어오면 등록 안됨
	if ( plat==0 || plng == 0 ){return;}
	if( fileList.length <1 ){ alert('하나 이상의 제품이미지 등록해주세요'); return; }
	
	// 폼에 첨부파일 등록
	fileList.forEach( (f)=>{
		writeFormdata.append("fileList" , f);
	})
	
	$.ajax({
		url : "/jspweb/product/info" ,
		method : "post" ,
		data : writeFormdata ,
		contentType : false ,
		processData : false ,
		success : (r)=>{
			console.log(r)
			console.log(r == 'true' )
			if ( r == 'true'){
				alert('제품등록 성공')
				location.href="/jspweb/index.jsp";
			}else{
				alert('제품등록 실패')
			}
			
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


//---------------------------드래그 앤 드랍 표현-------------------------------
// 1. 드래그앤드랍할 구역[DOM] 객체 호출
let fileDrop = document.querySelector('.fileDrop');

// 2. 해당구역 이벤트 등록
fileDrop.addEventListener("dragenter" , (e)=>{
	//alert('해당 구역 클릭')
	console.log('드래그요소가 닿으면 실행')
	e.preventDefault(); // 고유 브라우저내 이벤트 제거
})

fileDrop.addEventListener('dragover',(e)=>{
	console.log('드래그 요소가 해당 위치에 있을 때 ')
	e.preventDefault(); // 고유 브라우저내 이벤트 제거
	fileDrop.style.backgroundColor = "#e8e8e8";
})

fileDrop.addEventListener('dragleave', (e)=>{
	console.log('드래그 요소 나감')
	e.preventDefault(); // 고유 브라우저내 이벤트 제거
	fileDrop.style.backgroundColor = "#ffffff";
})

fileDrop.addEventListener('drop', (e)=>{
	console.log('드래그 요소 해당구역에 드랍 되었을 때')
	// 문제점 : 브라우저 영역에 드랍했을 때 해당 페이지 열림 [ 브라우저 이벤트가 먼저 실행 ]
	e.preventDefault(); // 고유 브라우저내 이벤트 제거
	
	// 1.  드랍된 파일[dataTransfer]을 호출 
	let files = e.dataTransfer.files;
	console.log( files ); // forEach 사용불가
	for ( let i = 0 ; i < files.length ; i++){
		console.log(files[i])
		if(files[i] != null && files[i] != undefined ){ // 파일이 존재하면 // 비어있지 않고 정의되어 있으면
			// 비어있지않고 정의되어있으면(파일이 존재하면)
			fileList.push( files[i] ); // 각 파일들을 하나씩 배열 저장
		}
	} // for end
	console.log(fileList)
	fileDrop.style.backgroundColor = "#ffffff"; //배경색 되돌리기
	printFiles(); // 파일목록출력
})// event end

// 3. 해당구역에 드랍된 파일 목록 출력 
function printFiles(){
	let html = ``;
	fileList.forEach( (f , i)=>{
		console.log(f)
		let fname = f.name;
		console.log( f.name );
		let fsize = (f.size / 1024).toFixed(1); // 파일용량 [바이트 --> mb로 변경]
			// .toFixed(표시할소수점자리수) 소수점 자르기
		console.log( f.size );
		
		html +=`
				<div>
					<span>${fname}</span>
					<span>${fsize} KB</span>
					<span><button type="button" onclick="filedelete(${i})">삭제</button></span>
				</div>
				`
		
	})
	fileDrop.innerHTML = html;
}

// 4. 드래그앤드랍된 파일 목록에 특정인덱스의 파일 제거
function filedelete( i ){
	fileList.splice(i,1);
	printFiles(); //렌더링
}