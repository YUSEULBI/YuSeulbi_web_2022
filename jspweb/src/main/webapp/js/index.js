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

// 1. 제품목록출력
let productlist = null;
 function productlistprint( ){
	 let html = '<h3>제품목록페이지</h3>'
		productlist.forEach( (p , i)=>{
					
			html += `
						<!-- 제품1개 -->
						<div onclick="productprint(${i})" class="productbox">
							<div class="pimgbox">
								<img src="/jspweb/product/pimg/${p.pimglist[0]}">
							</div>
							<div class="pcontentbox">
								<div class="pdate"> ${p.pdate} </div>
								<div class="pname"> ${p.pname} </div>
								<div class="pprice"> ${p.pprice.toLocaleString()} </div>
								<div class="petc">
									<i class="far fa-eye"></i> ${p.pview}
									<i class="far fa-thumbs-up"></i> 5
									<i class="far fa-comment-dots"></i> 2  
								</div> 
							</div>
						</div>
					`
		})
		document.querySelector('.productlistbox').innerHTML = html;
 }// end
 
 // 제품 개별 조회
 function productprint( i ){
	 let p = productlist[i];
	 
	 	console.log(p.pno + "제품 클릭")
	    let imghtml = ``;
	    p.pimglist.forEach( (img ,i)=>{
			if ( i == 0 ){
				imghtml += `
					 		<div class="carousel-item active">
						      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
						    </div>
							`
			}else{
				imghtml += `
					 		<div class="carousel-item">
						      <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
						    </div>
							`
			}
		})
		
	    let html = ``  
			
		html += `
				<div class="pviewbox">
					<div class="pviewinfo">
						<div class="mimgbox">
							<img alt="" src="/jspweb/member/pimg/${p.mimg == null ? 'default.webp' : p.mimg }" class="hpimg">
							<span class="mid"> ${p.mid} </span>
						</div>
						<div>
							<button onclick="productlistprint()"  class="pbadge" type="button"> 목록보기 </button>
						</div>
					</div>
					
					<!-- 이미지 캐러셀 : 이미지 슬라이드 -->
					<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
					  
					  <div class="carousel-inner">
					    ${imghtml}
					  </div>
					  
					  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
					  </button>
					  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
					  </button>
					</div>
					
					<!-- 제품 상세 내용물 -->
					<div class="pdate"> ${p.pdate} </div>
					<div class="pname"> ${p.pname} </div>
					<div class="pcomment"> ${p.pprice} </div>
					<div class="pstate">  <span class="pbadge" >${ p.pstate == 1 ? '판매중' : p.pstate == 2 ? '거래중' : '판매완료' }</span> </div>
					<div class="pprice"> ${p.pprice.toLocaleString()} </div>
					<div class="petc">
							<i class="far fa-eye"></i> ${p.pview}
							<i class="far fa-thumbs-up"></i> 5
							<i class="far fa-comment-dots"></i> 2  
					</div>
					<div class="pviewbtnbox">
						<button class="plikebtn" onclick="setplike(${p.pno})" type="button"> <i class="far fa-heart"></i> </button>
						<button onclick="chatprint(${i})" type="button"> 채팅 </button> 
					</div>
				</div>
				`
		document.querySelector('.productlistbox').innerHTML = html;
		getPlike( p.pno );
 }
 
 // 채팅페이지 이동 ( 진짜이동 아니고 렌더링)
 function chatprint( i ){
	 
	 if (memberInfo.mid == null){
		 alert('회원 기능입니다.'); return;
	 }
	 
	 let p = productlist[i];
	 //let html = `<h3> ${p.pno}제품 채팅방 </h3>`;
	 let html = `
	 			<div class="chatbox">	
					<div class="pviewinfo">
						<div class="mimgbox">
							<img alt="" src="/jspweb/product/pimg/${p.pimglist[0]}" class="hpimg">
							<span class="pname"> ${p.pname} </span>
						</div>
						<div>
							<button onclick="productlistprint()"  class="pbadge" type="button"> 목록보기 </button>
						</div>
					</div>
					
					<div class="chatcontent">
						<div class="sendbox"> 구매 가능할까요? </div>
						<div class="receivebox"> 네 구매 가능 합니다. </div>
					</div>
					
					<div class="chatbtn">
						<textarea class="ncontentinput" rows="" cols=""></textarea>
						<button onclick="sendchat(${p.pno})" type="button">전송</button>
					</div>
				</div>	
	 			`;
	 document.querySelector('.productlistbox').innerHTML = html;
 }
 
// 5. 
function sendchat( pno ){
	console.log("pno : "+pno)
	let ncontent = document.querySelector('.ncontentinput').value
	console.log(ncontent)
	
	$.ajax({
		url : "" ,
		method : "post" ,
		data : { "pno":pno , "ncontent":ncontent} ,
		success : (r)=>{
			console.log('통신')
			console.log(r)
			if ( r == 'true'){
				document.querySelector('.ncontentinput').value = '';			
			}
		}
	})
	
	
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
 
// -------------------------- 마커 이미지변경---------------------------
//
var imageSrc = '/jspweb/img/marker.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다
    
// -------------------------- 마커 이미지변경---------------------------

 // 1. 제품 목록 호출 [ 1. 현재 보이는 지도좌표내 포함된 제품만 ]
 //getProductList(  );
 function getProductList(동 , 서 , 남 , 북){
	 // 클러스터 비우기
	 clusterer.clear();
	 $.ajax({
		 url : "/jspweb/product/info" ,
		 method : "get" ,
		 data : {"동":동 ,"서":서 ,"남":남 ,"북":북  },
		 async : false ,
		 success : (data)=>{
			 
		 
	
		     // 데이터를 가져오기 위해 jQuery를 사용합니다
	    	// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
	    
	  
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
	                position : new kakao.maps.LatLng(position.plat, position.plng) ,
	                image : markerImage
	            });
	            
	              // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
				      productprint(i);
				});
				
				return marker;
	        });
	
	        // 클러스터러에 마커들을 추가합니다
	        clusterer.addMarkers(markers);
	        
	        //-------------마커
        }// success end
    }); // ajax end
 } // function end

//좌표얻어서 현재 좌표안의 마커만 표시하기
get동서남북(); // js실행시
function get동서남북(){
	// 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    
    let 남 = swLatLng.getLat()
    let 서 = swLatLng.getLng()
    let 북 = neLatLng.getLat()
    let 동 = neLatLng.getLng()
    getProductList( 동 , 서 , 남 , 북  );
}

// ------------- 지도 중심좌표 이동 이벤트 ---------------------

// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {
	
	get동서남북(); // 드래그시

});

kakao.maps.event.addListener(map, 'zoom_changed', function() {
	
	get동서남북(); // 확대축소시

});

// 4.현재 회원이 해당 제품의 찜하기 상태 호출
function getPlike( pno ){
	
	if ( memberInfo.mid == null ){
		//return "♡"
		document.querySelector('.plikebtn').innerHTML = "♡"
	}else{
		$.ajax({
			url : "/jspweb/product/like?pno="+pno ,
			method : "get" ,
			async : false ,
			success : (r)=>{
				console.log ('현재라이크상태 : '+r)
				console.log(r=='true')
				if ( r=='true'){
					// return "♥"
					document.querySelector('.plikebtn').innerHTML = "♥"
				}
				else{
					// return "♡"
					document.querySelector('.plikebtn').innerHTML = "♡"
				}	
			}
		})
		
	}
}


// 찜하기 버튼을 눌렀을 때 [ 첫 클릭시 찜하기 / 다음 클릭시 찜하기 취소 / 다음 클릭시 찜하기 ]
function setplike( pno ){
	if ( memberInfo.mid == null ){
		alert('회원기능입니다. 로그인 후 사용해주세요.'); return;
	}
	
	$.ajax({
		url : "/jspweb/product/like" ,
		method : "post" ,
		data : { "pno":pno } ,
		success : (r)=>{ 
			console.log(r) 
			if ( r == 'true'){
				alert('찜하기 등록')
				document.querySelector('.plikebtn').innerHTML = '♥'
			}else{
				alert('찜하기 취소')
				document.querySelector('.plikebtn').innerHTML = '♡'
			}
		}
	})
	
	// get 방식 방법
//	$.ajax({
//		url : "/jspweb/product/like?pno="+pno ,
//		success : (r)=>{ console.log(r) }
//	})
	
	// $.get("/jspweb/product/like?pno="+pno,()=>{})
	
	//---------------------------------------------------
	// post방식 다른 방법
	// $.post("/jspweb/product/like", { "data":data } ,()=>{})
}


