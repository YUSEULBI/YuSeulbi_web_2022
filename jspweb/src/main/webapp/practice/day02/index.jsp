<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예1) [C] 'HTML' --[document.querySelector]--> 'JS' --[AJAX]---> 'servlet' --[메소드]--> 'dao' </h3>
	data1[문자열] 	:	<input type="text" class="data1"> <br>
	data2[패스워드] 	:	<input type="password" class="data2"> <br>
	data3[실수] 		:	<input type="text" class="data3"> <br>
	data4[정수]] 		:	<input type="number" class="data4"> <br>
	data5[날짜]		:	<input type="date" class="data5"> <br>
	data6[날짜/시간]]	:	<input type="datetime-local" class="data6"> <br>
	data7[선택버튼]	:	<input type="radio" name="data7" value="남"> 남
						<input type="radio" name="data7" value="여"> 여 <br>
	data8[체크상자]	: 	<input type="checkbox" class="data8"> 승인 <br>
	data9[목록상자]	:  	<select class="data9">
							<option>안산</option>
							<option>수원</option>
							<option>성남</option>
						</select> <br>
	data10[긴글]		: 	<textarea class="data10" rows="" cols=""></textarea>
 	
 	<button type="button" onclick="ex1()"> 전송 </button> 	
 	 	
	<h3> 예1) [R] 'dao' --[메소드]---> 'servlet' --[AJAX]--> 'JS' --[document.querySelector]--> 'HTML' </h3>
	<div class="ex1_box"></div>
	
	<h3>과제 [C]	</h3>
	이름[문자열]	: 	<input type="text" class="q1"> <br>
	전화번호[문자열]	:	<input type="text" class="q2"> <br>	
	키[실수]		: 	<input type="text" class="q3"> <br>
	나이[정수]		: 	<input type="number" class="q4"> <br>
	등록일[날짜]	:	<input type="date" class="q5">  <br>
	성별[체크박스]	:	<input type="radio" name="q6" value="남"> 남
					<input type="radio" name="q6" value="여"> 여 <br>
	개인정보 동의	: 	<input type="checkbox" class="q7"> 동의 <br>
	사는지역		: 	<select class="q8"> <br>
						<option>안산</option>
						<option>안양</option>
						<option>수원</option>
					</select> <br>
	자기소개 		:	<textarea class="q9" rows="" cols=""></textarea> <br>
	<button type="button" onclick="q1()">전송</button>
	
	<h3>과제 [R]	</h3>
	<div class="q2_box"></div>
	
	
	<!-- 1. JQUERY -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 2. 사용자 정의 js는 jquery 밑에 -->
	<script src="index.js" type="text/javascript"></script>
</body>
</html>