<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="/header.jsp" %> <!-- (프로젝트명 생략,webapp이하생략)절대경로 -->
	
	<div class="container">
		
		<h3> char.js 사용 </h3>
		 <canvas id="myChart"></canvas>
		
		<h3> 모든 회원 명단 </h3>
		<div>
			<span class="totalsize"></span>
		</div>
		<div>
			<select onchange="mlistsize()" class="listsize">
				<option >3</option>
				<option >5</option>
				<option >10</option>
			</select> 
		</div>
		<table class="mListTable table" border="1">
		</table>
		
		<div class="infopagebtn">
			<!-- 페이지버튼자리 -->
				
		</div>
		<div>
			<select class="mkey">
				<option value="mno">회원번호</option>
				<option value="mid">아이디</option>
				<option value="memail">이메일</option>
			</select>
			<input class="mkeyword" type="text">
			<button onclick="msearchbtn()" class="msearchbtn" type="button">검색</button>
			<button onclick="resetPrint()" type="button">회원전체보기</button>
		</div>
		
	</div>
	
		
	<!-- chart.js -->
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
</body>
</html>