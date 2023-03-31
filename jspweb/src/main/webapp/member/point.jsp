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
		
		<h3></h3>
		<button onclick="setpay(10000)">10000원</button> <!-- 결제하기 버튼 생성 -->
		<button onclick="setpay(50000)">50000원</button> <!-- 결제하기 버튼 생성 -->
		<br>
		<button onclick="requestPay()">카드결제</button> <!-- 결제하기 버튼 생성 -->
		
		<h3>본인인증</h3>
	</div>
	
	
	<!-- 포트원 결제 JS -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<!-- 본인인증 -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	<script src="/jspweb/js/member/point.js" type="text/javascript"></script>
	
	
</body>
</html>