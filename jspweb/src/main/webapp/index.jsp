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
	<div style="position: fixed; left: 10px; top: 40%; z-index : 999; 
			width: 100px; height: 100px; background-color: white;">
		검색창
	</div>
	
	<!-- div -->
	<div style="display: flex; width: 100%; height: 100%">
	
		<!-- 지도 -->
		<div id="map" style="width:80%;height:80%;"></div>
		
		<!-- 사이드바 -->
		<div class="productlistbox" style="width: 20%">
			
		</div>
	</div>
	
	<%@include file="/footer.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea&libraries=services,clusterer,drawing"></script>
	
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>