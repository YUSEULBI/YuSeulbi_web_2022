<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="height: 100%"> <!-- 가로/세로 사이즈 생략시 auto( 내용물크기만큼 ) -->
	<%@ include file="/header.jsp" %> <!-- (프로젝트명 생략,webapp이하생략)절대경로 -->
	
	
	<!-- 검색창 구역 -->
	<div class="searchbox">
			검색창
	</div>
	
	
	<!-- div -->
	<div style="display: flex; width: 100%; height: 100%">
	
		<!-- 지도 -->
		<div id="map" style="width:75%;height:80%;"></div>
		
		<!-- 사이드바 -->
		<div class="productlistbox">
		
			<!-- 제품1개 -->
			<div class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/notebook.webp">
				</div>
				<div class="pcontentbox">
					<div class="pdate">  </div>
					<div class="pname"> LG 노트북 팝니다. LG 노트북 팝니다. LG 노트북 팝니다. LG 노트북 팝니다. LG 노트북 팝니다. LG 노트북 팝니다. </div>
					<div class="pprice"> 3,000원 </div>
					<div class="petc">
						<i class="far fa-eye"></i> 30
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2  
					</div> 
				</div>
			</div>
			
				<!-- 제품1개 -->
			<div class="productbox">
				<div class="pimgbox">
					<img src="/jspweb/product/pimg/notebook.webp">
				</div>
				<div class="pcontentbox">
					<div class="pdate">  </div>
					<div class="pname"> LG 노트북 팝니다. </div>
					<div class="pprice"> 3,000원 </div>
					<div class="petc">
						<i class="far fa-eye"></i> 30
						<i class="far fa-thumbs-up"></i> 5
						<i class="far fa-comment-dots"></i> 2  
					</div> 
				</div>
			</div>
			
		</div> <!-- 사이드바 end -->
		
	</div>
	
	<%@include file="/footer.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea&libraries=services,clusterer,drawing"></script>
	
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>