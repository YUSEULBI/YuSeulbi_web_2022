<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 	<link href="/jspweb/src/main/webapp/css/modal.css" rel="stylesheet"> -->
</head>
<body>
	<%@include file="/header.jsp" %> <!-- 모달있음 -->
	
	<div class="container">
		<!-- 클릭한 위치에 좌표 알기 -->
		<div id="clickLatlng"></div>
		<!-- 카카오지도 div -->
		<div id="map" style="width:100%;height:700px;"></div>
	</div>
	
	
	
	<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
			</div>
			<div class="modal_btns">
				<button class="modal_check" 	type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	
	<!-- 카카오지도 필요한 클래스/메소드 갖고있는 js라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4737aaadbf0b5529b4a298b1282498ea&libraries=clusterer"></script>
	
	<script src="/jspweb/js/api/api2.js" type="text/javascript"></script>
	
</body>
</html>