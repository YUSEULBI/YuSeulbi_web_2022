<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	JSP 웹 프로젝트 시작 [ ctrl+f11 ]
	강력 새로고침  [ ctrl+f5 ]
	<h3> 예제1: [C:쓰기] 입력받은 데이터 -> JS -> 서블릿 -> DAO </h3>
		<!-- <input> 입력 tag 	class : 식별자[ id , class , name ] -->
	data : <input type="text" class="inputdata">	
		<!-- <button> 버튼 tag 	type="button"	onclick="js작성" -->
	<button type="button" onclick="Ex1()"> 예제1 실행 </button>
	
	<h3> 예제2 : [R : 읽기] DAO -> 서블릿[JAVA] -> JS -> HTML </h3>
	<div class="ex2box">
		<!-- 서블릿에게 받은 데이터 표시되는 구역 -->
	</div>
	
	<h3> 과제1 : [C:쓰기]</h3>
	data : <input type="text" class="inputdata2">
	<button type="button" onclick="Q1()">과제1 실행</button>	
	
	<h3> 과제1 : [R:읽기]</h3>
	<div class="q1box">
	
	</div>
	
	
	
	
	
	
	
	
	
	
	
	<!-- 최신 jquery[ js 라이브러리 ] 가져오기  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자정의 js -->
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>