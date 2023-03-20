<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/list.css" rel="stylesheet">
	
	<!--  폰트어썸  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>

	<%@include file="/header.jsp" %>
	<!--
		// HTTP GET <a href="URL경로?변수명=값"> 전달된 매개변수 가져오기
		 
	 -->
	 <%
	 	String cno = request.getParameter("cno");
	 	
	 // 표현식 이용 input div 대입
	 %>
	 
	 <!-- cno 숨겨서 js에게 전달 -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	<!-- html / css -->
	<div class="container">
		<div class="boardbox">
		
			<div class="boardtop">
				<h3 class="cname">공지사항</h3>
				<p> 다양한 사람들과 정보를 공유 해보세요 </p>
			</div>
			
			<div class="boardtopetc">
				<a href="write.jsp">
					<button class="bbtn"> <i class="fas fa-pencil-alt"></i> 글쓰기</button>
				</a>
				<div>
					<span class="searchcount"></span>
					<button onclick="clearSearch()" class="bbtn" type="button">전체보기</button>
					<select class="bbtn listsize" onchange="chlistsize()">
						<option value="3">3</option>
						<option value="5">5</option>
						<option value="10">10</option>
					</select>
				</div>
			</div> <!-- boardtopetc end -->
			
			<div class="boardTable">
			</div>
				
		</div> <!-- boardbox end -->
	</div>
	
	
	<!--  -->
	<div class="container">
		<h3 class="cname"></h3>
		
		<a href="write.jsp">글쓰기</a>
		<button onclick="clearSearch()" type="button">전체보기[검색제거]</button>
		<div class="searchcount"> 총 게시물수 : </div>
		<select onchange="chlistsize()" class="listsize">
			<option value="3">3</option>
			<option value="5">5</option>
			<option value="10">10</option>
		</select>
		
		
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