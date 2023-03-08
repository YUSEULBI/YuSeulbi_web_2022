<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 회원가입 연습 </h3>
	<form class="pSignupForm">
		아이디 : 		<input onkeyup="idCheck()" type="text" name="mid" class="mid">
		<span class="idcheckconfirm"></span>	
		<br>
		비밀번호 : 		<input type="text" name="mpwd" class="mpwd">	<br>
		비밀번호확인 : 	<input type="text" name="mpwdconfirm" class="mpwdconfirm">	<br>
		이메일 : 		<input type="text" name="memail" class="memail">	<br>
		프로필 : 		<input type="file" name="mimg" class="mimg">	<br>
		<button type="button" onclick="pSignup()">가입</button>
	</form>
	
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자정의 -->
	<script src="/jspweb/practice/signupadmin/js/signup.js" type="text/javascript"></script>
</body>
</html>