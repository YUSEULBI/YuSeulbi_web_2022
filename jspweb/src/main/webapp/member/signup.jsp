<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%@ include file="../header.jsp" %>  --%>
	<%@ include file="/header.jsp" %> <!-- (프로젝트명 생략,webapp이하생략)절대경로 -->
	<h3> 회원가입 </h3>
	<form class="signupForm"> <!-- 폼 전송시 자식 input 매개변수 식별 : name -->
		아이디 : 		<input onkeyup="idcheck()" maxlength="30" type="text" name="mid" class="mid">
		<span class="checkconfirm"></span> <br>
		비밀번호 :		<input onkeyup="pwdcheck()" maxlength="20" type="password" name="mpwd" class="mpwd"> <br>
		비밀번호 확인 :	<input onkeyup="pwdconfirmcheck()" maxlength="20" type="password" name="mpwdconfirm" class="mpwdconfirm">
		<span class="checkconfirm"></span> <br>		
		이메일 :		<input onkeyup="emailCheck()" type="text" name="memail" 		class="memail">	
		<span class="checkconfirm"></span> <br>
		프로필 :		<input onchange="premimg(this)" type="file" name="mimg" 			class="mimg">
			미리보기 <!-- onchange 첨부파일 바뀌었을때 / this input 값이 들어감 -->
			<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp">			
		<br>
		
		<button type="button" onclick="signup()"> 가입 </button>
	</form>
	
	

	<script src="/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>