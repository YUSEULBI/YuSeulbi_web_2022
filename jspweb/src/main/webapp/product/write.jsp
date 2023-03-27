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
	
		<form class="writeForm">
			제품명 : <input type="text" name="pname"> <br>
			제품설명 :  <input type="text" name="pcomment"> <br>
			제품가격 :  <input type="text" name="pprice"> <br>
			거래위치 : <div id="map" style="width:100%;height:350px;"></div>
			
			<!--  
			<h5>첨부파일 1개</h5>
			<input type="file" name="pfile" accept="image/*"> <br>
			
			<h5>첨부파일 여러개 cos가능</h5>
			<input type="file" name="pfile1" accept="image/*">
			<input type="file" name="pfile2" accept="audio/*">
			<input type="file" name="pfile3" accept="video/*">  <br>
			-->
			
			<h5>첨부파일 한꺼번에 여러개 [ multiple cos불가능 , commons.jar 가능 ]</h5>
			<input name="pfiles" type="file" multiple="multiple" accept="image/*">  <br>
			
			<button onclick="onwrite()" type="button">제품등록</button>
		</form>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	4737aaadbf0b5529b4a298b1282498ea"></script>
	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>
</body>
</html>