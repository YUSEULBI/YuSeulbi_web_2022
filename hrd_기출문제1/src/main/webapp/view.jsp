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
		<h3>회원목록조회/수정</h3>
		<table border="1">
			<tr>
				<th>회원번호</th> <th>회원성명</th>
				<th>전화번호</th> <th>주소</th>
				<th>가입일자</th> <th>고객등급</th>
				<th>거주지역</th>
			</tr>
			
	<%
		Dao dao = new Dao();
		ArrayList<MemberDto> memberlist = dao.getMemberList();
		for ( MemberDto m : memberlist ){
	%>
			<tr>
				<!-- 변수명=데이터&변수명=데이터 -->
				<td><a href="/hrd_exam1/update.jsp?custno=<%=m.getCustno()%>"><%=m.getCustno()%></a></td> 	
				<td><%=m.getCustname()%></td>
				<td><%=m.getPhone()%></td> 		
				<td><%=m.getAddress()%></td>
				<td><%=m.getJoindate()%></td> 	
				<td><%=m.getGrade()%></td>
				<td><%=m.getCity()%></td>
			</tr>
	<%		
		}
	%>
		</table>
	</center>
	<%@include file="footer.jsp" %>
</body>
</html>