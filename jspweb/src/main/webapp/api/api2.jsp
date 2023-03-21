<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<div class="container">
		<!-- 클릭한 위치에 좌표 알기 -->
		<div id="clickLatlng"></div>
		<!-- 카카오지도 div -->
		<div id="map" style="width:100%;height:700px;"></div>
	</div>
	
	
	<!-- 카카오지도 필요한 클래스/메소드 갖고있는 js라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea"></script>
	
	<script src="/jspweb/js/api/api2.js" type="text/javascript"></script>
</body>
</html>