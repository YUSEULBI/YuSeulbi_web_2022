<%@page import="hrd_기출문제1.controller.MemberDto"%>
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
		<h3>홈쇼핑 회원 목록</h3>
	</center> 
	
	<% 
		int custno = Integer.parseInt(request.getParameter("custno"));
		Dao dao = new Dao();
		MemberDto dto = dao.getMember(custno);
		
	%>
	
	<form name="updateform" method="get"  action="/hrd_exam1/join">
		<table style="margin: 0 auto;">
			<tr>
				<th>회원번호(자동발생)</th>
				<th>
					<input name="custno" type="hidden" value=<%=custno%>>
					<input name="chcustno" type="text" value=<%=dto.getCustno()%>>
				</th>
			</tr>
			<tr> 
				<th>회원성명</th>
				<th><input name="custname" type="text" value=<%=dto.getCustname()%>></th>
			</tr>
			<tr>
				<th>회원전화</th>
				<th><input name="phone" type="text" value=<%=dto.getPhone()%>></th>
			</tr>
			<tr>
				<th>회원주소</th>
				<th><input name="address" type="text" value=<%=dto.getAddress()%>></th>
			</tr>
			<tr>
				<th>가입일자</th>
				<th><input value="<%=dto.getJoindate()%>" name="joindate" type="text"></th>
			</tr>
			<tr>
				<th>고객등급 [A:VIP,B:일반,C:직원]</th>
				<th><input name="grade" type="text" value=<%=dto.getGrade()%>></th>
			</tr>
			<tr>
				<th>도시코드</th>
				<th><input name="city" type="text" value=<%=dto.getCity()%>></th>
			</tr>
			<tr>
				<th colspan="2">
					
					<button onclick="update()" type="button">수정</button>
					<a href="/hrd_exam1/view.jsp"> <button type="button">조회</button> </a>
					
				</th>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		function update(){
			document.updateform.submit();
			alert('회원정보 수정이 완료 되었습니다.')
		}
	</script>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>