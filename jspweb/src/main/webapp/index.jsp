<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> <!-- 가로/세로 사이즈 생략시 auto( 내용물크기만큼 ) -->
	<%@ include file="/header.jsp" %> <!-- (프로젝트명 생략,webapp이하생략)절대경로 -->
	
	
	<!-- 검색창 구역 -->
	<div class="searchbox">
			검색창
	</div>
	
	
	<!-- div -->
	<div style="display: flex; width: 100%; height: 100%">
	
		<!-- 지도 -->
		<div id="map" style="width:75%;height:100%;"></div>
		
		<!-- 사이드바 -->
		<div class="productlistbox">
		
			<div class="pviewbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img alt="" src="/jspweb/member/pimg/default.webp" class="hpimg">
						<span class="mid"> qweqwe </span>
					</div>
					<div>
						<button class="pbadge" type="button"> 목록보기 </button>
					</div>
				</div>
				<!-- 이미지 캐러셀 : 이미지 슬라이드 -->
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/jspweb/product/pimg/notebook.webp" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jspweb/product/pimg/notebook.webp" class="d-block w-100" alt="...">
				    </div>
				    <div class="carousel-item">
				      <img src="/jspweb/product/pimg/notebook.webp" class="d-block w-100" alt="...">
				    </div>
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
				<div class="pdate"> 2023-03-28 </div>
				<div class="pname"> 커피포트 팝니다 </div>
				<div class="pcomment"> 내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물 </div>
				<div class="pstate"> <span class="pbadge" >판매중</span> </div>
				<div class="pprice"> 13,000원 </div>
				<div class="petc">
						<i class="far fa-eye"></i> 10
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2  
				</div>
				<div class="pviewbtnbox">
					<button type="button"> <i class="far fa-heart"></i> </button>
					<button type="button"> 채팅 </button> 
				</div>
			</div>
			
			
		
		</div> <!-- 사이드바 end -->
		
	</div>
	
	<%@include file="/footer.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea&libraries=services,clusterer,drawing"></script>
	
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>