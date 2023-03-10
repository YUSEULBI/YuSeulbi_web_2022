<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/signup.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="/header.jsp" %> <!-- (프로젝트명 생략,webapp이하생략)절대경로 -->
	
	<div class="container">
		
		<form class="signupForm"> <!-- 폼 전송시 자식 input 매개변수 식별 : name -->
			<h3> 아이디 찾기 </h3>
			<p> 회원님의 계정 정보를 찾아드립니다. </p>
			
			<div class="title">이메일</div> 		
			<input type="text" name="memail" class="memail">
			
			
			
			<div class="checkconfirm"></div>
			
			
			
			<button class="signupbtn" type="button" onclick="findid()"> 아이디찾기 </button>
		</form>
	</div>

	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>

</body>
</html>