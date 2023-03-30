<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<center>
		<h3>홈쇼핑 회원 목록</h3>
	</center>
	
	<form name="joinform" method="post"  action="서블릿주소">
		<table style="margin: 0 auto;">
			<tr>
				<th>회원번호(자동발생)</th>
				<th><input name="custno" type="text"></th>
			</tr>
			<tr>
				<th>회원성명</th>
				<th><input name="custname" type="text"></th>
			</tr>
			<tr>
				<th>회원전화</th>
				<th><input name="phone" type="text"></th>
			</tr>
			<tr>
				<th>회원주소</th>
				<th><input name="address" type="text"></th>
			</tr>
			<tr>
				<th>가입일자</th>
				<th><input name="joindate" type="text"></th>
			</tr>
			<tr>
				<th>고객등급 [A:VIP,B:일반,C:직원]</th>
				<th><input name="grade" type="text"></th>
			</tr>
			<tr>
				<th>도시코드</th>
				<th><input name="city" type="text"></th>
			</tr>
			<tr>
				<th colspan="2">
					
					<button onclick="join()" type="button">등록</button>
					<a href="/hrd_기출문제1/view.jsp"> <button type="button">조회</button> </a>
					
				</th>
			</tr>
		</table>
	</form>
	
	<%
	
		
		
	%>
	
	
	<%@include file="footer.jsp" %>
	
	<script src="/hrd_기출문제1/join.js" type="text/javascript"></script>
</body>
</html>