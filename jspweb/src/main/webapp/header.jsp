<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 모든 페이지 공통 css -->
</head>
<body>
	<h3> 헤더 입니다. </h3>
	<!-- 모든 페이지 공통 메뉴 [ 헤더는 url 절대경로!!! ] -->
	<% String login = (String)request.getSession().getAttribute("login"); %>
	
	<a href="/jspweb/index.jsp">홈</a>
	<%
		if ( login == null ){ //로그인 안함
	%>
			<a href="/jspweb/member/signup.jsp">회원가입</a>
			<a href="/jspweb/member/login.jsp">로그인</a>
	<%		
		}else if( login == "admin"){
	%>		
			관리자모드
			<a href="/jspweb/admin/info.jsp">관리자페이지</a>
			<a href="/jspweb/member/logout.jsp">로그아웃</a>
	<%		
		}else{
	%>
			<%=login %>님 안녕하세요.
			<a href="/jspweb/member/logout.jsp">로그아웃</a>
	<%		
		}
	%>
	
	
	
	
	
	<!-- 모든 페이지 공통 js -->
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>