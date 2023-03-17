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

	
	<!-- jsp 로그인제어 : html이 실행되기전에 유효성검사를 먼저하는방법 해결방법 -->
	<%
		// jsp
		Object o =  request.getSession().getAttribute("login");
		if ( o == null ){ 	
			
			 // 서블릿제공 페이지전환
			response.sendRedirect("/jspweb/member/login.jsp");
		}
		// 2. http url 안에 있는 매개변수 bno 호출
		String bno = request.getParameter("bno");
		
	%>
	<input type="hidden" class="bno" value="<%=bno%>">
	
	
	<div class="container">
		<h3> 글수정 </h3>
		<!-- form -->
		<form class="updateForm">
			<div>
				카테고리 : 
				<select name="cno" class="cno">
					<option value="1">공지사항</option>
					<option value="2">커뮤니티</option>
					<option value="3">QnA</option>
					<option value="4">노하우</option>
				</select>
			</div>
			<div>
				제목 : <input name="btitle" class="btitle" type="text"> <br/>
			</div>
			<div>
				내용 : <textarea name="bcontent" class="bcontent" rows="3" cols="50"></textarea> <br/>
			</div>
			<div class="bfilebox">
				
			</div>
			
		</form>
		
		<button onclick="bupdate()" type="button">수정</button>
		<a href="/jspweb/board/list.jsp"><button type="button">취소</button></a>
	</div>
		
	
	
	
	
	<script src="/jspweb/js/board/update.js" type="text/javascript"></script>
</body>
</html>