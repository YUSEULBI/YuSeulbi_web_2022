<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<!-- js 로그인제어 : html이 실행되기전에 유효성검사를 먼저하는방법 해결방법 -->
<!-- 	<script type="text/javascript">
		if ( memberInfo.mid == null ){
			alert('로그인 하세요')
			location.href="/jspweb/member/login.jsp";
		}
		</script> -->
	
	
	<!-- jsp 로그인제어 : html이 실행되기전에 유효성검사를 먼저하는방법 해결방법 -->
	<%
		// jsp
		Object o =  request.getSession().getAttribute("login");
		if ( o == null ){ 	
			
			 // 서블릿제공 페이지전환
			response.sendRedirect("/jspweb/member/login.jsp");
		}
		
	%>
	
	
	
	<div class="container">
		<h3> 글쓰기 </h3>
		<!-- form -->
		<form class="writeForm">
			카테고리 : 
			<select name="cno" class="cno">
				<option value="1">공지사항</option>
				<option value="2">커뮤니티</option>
				<option value="3">QnA</option>
				<option value="4">노하우</option>
			</select> <br/>
			제목 : <input name="btitle" type="text"> <br/>
			<textarea id="summernote" name="bcontent" ></textarea> <br/>
			첨부파일 : <input name="bfile" type="file"> <br/>
		</form>
		
		<button onclick="bwrite()" type="button">쓰기</button>
		<a href="/jspweb/board/list.jsp"><button type="button">취소</button></a>
	</div>
		
	
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>
</body>
</html>