<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	JSP 웹 프로젝트 시작 [ ctrl + f11 ]
	<h3> 예제1: 입력받은 데이터 -> JS -> 서블릿 -> DAO [CRUD중에 C:쓰기] </h3>
		<!-- 입력태그 class: 식별자[id,class,name] -->
	data : <input type="text" class="inputdata">
		<!-- 버튼태그 type="button"꼭쓰기~ onclick="js작성" -->
	<button type="button" onclick="예제1()">예제1 실행</button>

	<!-- 사용자정의 JS 가져오기 [/프로젝트명/[webapp,main폴더생략,webapp하위부터 작성]폴더/파일명] -->
	<script src="js/index.js" type="text/javascript"></script>
</body>
</html>