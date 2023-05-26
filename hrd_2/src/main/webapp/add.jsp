<%@page import="controller.Dto"%>
<%@page import="controller.Dao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		<center>
			<h3>성적입력</h3>
			<form name="addForm" action="http://localhost/hrd_2/hrd2/add" method="post">
				<table border="1" style="border-collapse:collapse;">
					<tr> <td>학번</td><td><input type="text" name="sno" class="sno" /></td> </tr>
					<tr> <td>국어점수</td><td><input type="text" name="ekor" class="ekor" /></td> </tr>
					<tr> <td>수학점수</td><td><input type="text" name="emath" class="emath" /></td> </tr>
					<tr> <td>영어점수</td><td><input type="text" name="eeng" class="eeng" /></td> </tr>
					<tr> <td>역사점수</td><td><input type="text" name="ehist" class="ehist" /></td> </tr>
					<tr> <td colspan="2"><center><button type="button" onclick="add()">등록하기</button></center></td> </tr>
				</table>
			</form>
		</center>
	<%@ include file="footer.jsp" %>
	<script src="index.js" type="text/javascript"></script>

</body>
</html>

