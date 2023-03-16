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
		<h3> 게시물 목록 </h3>
		<a href="write.jsp">글쓰기</a>
		
		<table class="boardTable table table-hover">
		</table>
		
		<!--  -->
		<div class="pagebox">

		</div>
		<div >
			<select class="key" > <!-- select시 사용되는 필드명 -->
				<option value="btitle">제목</option>
				<option value="bcontent">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input  class="keyword" type="text"> <!-- select 조건의 데이터 -->
			<button onclick="getsearch()" type="button">검색</button>
		</div>
		
	</div>
	
	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
</body>
</html>