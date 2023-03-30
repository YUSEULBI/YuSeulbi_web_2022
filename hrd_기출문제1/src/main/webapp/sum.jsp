<%@page import="hrd_기출문제1.controller.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hrd_기출문제1.controller.Dao"%>
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
		<h3>회원매출조회</h3>
		<table border="1">
			<tr>
				<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
			</tr>
			<% 
				Dao dao = new Dao();
				ArrayList<MemberDto> list = dao.view();
				for ( MemberDto dto : list ){
			%>		
			
			<tr>
				<td><%=dto.getCustno()%></td><td><%=dto.getCustname()%></td>
				<td><%=dto.getGrade()%></td><td><%=dto.getPrice()%></td>
			</tr>
					
			<%	
				}
			%>
		</table>
	</center>
	
	<%@include file="footer.jsp" %>
</body>
</html>