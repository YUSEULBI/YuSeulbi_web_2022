<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %> <!-- (프로젝트명 생략,webapp이하생략)절대경로 -->
	
	
	
	<div id="map" style="width:100%;height:700px;"></div>
	
	<%@include file="/footer.jsp" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea&libraries=clusterer"></script>
	
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>