<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예제1 : HTTP 메소드 </h3>
	<button onclick="doPOST()" type="button"> POST 메소드 </button>
	<button onclick="doGET()" type="button"> GET 메소드 </button>
	<button onclick="doPUT()" type="button"> PUT 메소드 </button>
	<button onclick="doDELETE()" type="button"> DELETE 메소드 </button>
	
	<h3> 예제2 : 방문록 </h3>
	내용 : <input type="text" class="content">	<br>
	작성자 : <input type="text" class="writer">	<br>
	<button onclick="onwrite()" type="button"> 방문록 등록 </button>
	
	<div class="result_box" ></div>
	
	<!-- 
		
		jsp , js ,  기존 파일
		dto , servlet 새로 파일 만들기
		dao 는 새로만들어도 되고 선택
		
			1. 제품등록 [ 제품명 , 가격 ]
			2. 제품출력	 [ 테이블에 모두 출력 ]
			3. 제품삭제	 [ 제품번호 이용한 삭제 ]
			4. 제품수정	 [ 제품번호 이용해서 [제품명 , 가격] 수정 = prompt 수정할 데이터 입력받기 ]
			
		
	 -->
	<h3> 과제3 </h3>
	제품명 : <input type="text" class="pname"> <br>
	가격 : <input type="text" class="pprice"> <br>
	<button onclick="onProduct()" type="button">제품등록</button>
	
	<table class="product_Box" border='1'></table>
	
	<!-- 1. JQUERY -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 사용자정의  -->
	<script src="index.js" type="text/javascript"></script>
</body>
</html>