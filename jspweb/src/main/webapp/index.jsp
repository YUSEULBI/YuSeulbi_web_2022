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
	<div style="display: flex; width: 100%; height: 70%">
	
		<!-- 지도 -->
		<div id="map" style="width:75%;height:100%;"></div>
		
		<!-- 사이드바 -->
		<div class="productlistbox">
			
		</div> <!-- 사이드바 end -->
		
	</div>
	
	<%@include file="/footer.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea&libraries=services,clusterer,drawing"></script>
	
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>