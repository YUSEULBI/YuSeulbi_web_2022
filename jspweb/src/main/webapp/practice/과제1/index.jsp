<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/practice/과제1/modal.css" rel="stylesheet">
</head>
<body>
	<div><img width="30%" alt="" src="/jspweb/practice/과제1/img/logo.gif"></div>
	
	<h3> 인사등록 </h3>
	<form class="form" action="">
		사원명 <input class="ename" name="ename" type="text"> <br/>
		직급 <select  class="erank" name="erank">
				<option>사원</option>
				<option>대리</option>
				<option>부장</option>
				<option>과장</option>
				<option>대표 </option>
			</select>  <br/>
		고용형태 <select class="etype" name="etype">
				<option>일용직</option>
				<option>정규직</option>
				<option>임원</option>
			</select> <br/>
		부서 <select class="dept" name="dept">
				<option>인사팀</option>
				<option>영업팀</option>
				<option>개발팀</option>
			</select> 			   <br/>
		입사일 <input class="edate" name="edate" type="date">	 <br/>	
		사원사진 <input class="epic" name="epic" type="file">  <br/>

		담당부서 <select class="rdept" name="rdept">
				<option>없음</option>
				<option>인사팀</option>
				<option>영업팀</option>
				<option>개발팀</option>
			</select> 
	</form>
	<button onclick="signupbtn()" class="signupbtn">등록</button>
	
	
	
	
	<h3> 인사출력 </h3>
	사원검색 : <input class="findEm" type="text"> 
	<button onclick="searchEm()" class="searchEm" type="button">검색</button> 
	<span class="searchnull"></span><br>
	
	<button onclick="allprint()" class="allprint" type="button">전체출력</button>
	<button onclick="workprint()" class="workprint" type="button">직무</button>
	<button onclick="deprint()" class="deprint" type="button">퇴사</button>
	
	<table class="employee_table" border="1"></table> <br/>
	
	<!-- 임시 -->
<!-- 	<table class="employee_Wortable" border="1"></table> <br/> -->
<!-- 	<table class="employee_deltable" border="1"></table> <br/> -->
	
	
	
	
	<!-- 모달 HTML -->
   <div class="modal_wrap updatemodal">
      <div class="modal_box">
         <h3 class="modal_title">사원정보 수정</h3>
         <div class="modal_content">
            <form class="updateform" action="">
				사원명 <input class="chname" name="chname" type="text"> <br/>
				직급 <select  class="chrank" name="chrank">
						<option>사원</option>
						<option>대리</option>
						<option>부장</option>
						<option>과장</option>
						<option>대표 </option>
					</select>  <br/>
				고용형태 <select class="chtype" name="chtype">
						<option>일용직</option>
						<option>정규직</option>
						<option>임원</option>
					</select> <br/>
				부서 <select class="chdept" name="chdept">
						<option>인사팀</option>
						<option>영업팀</option>
						<option>개발팀</option>
					</select> 			   <br/>
				
					
				사원사진 <input onchange="picpreview(this)" class="chepic" name="chepic" type="file">  <br/>
				<img class="picpreview" alt="" src="/jspweb/practice/과제1/img/default.webp">  <br/>
				
		
				담당부서 <select class="chrdept" name="chrdept">
						<option  value="" selected >없음</option>
						<option>인사팀</option>
						<option>영업팀</option>
						<option>개발팀</option>
					</select> 
				퇴사일 <input class="dedate" name="dedate" type="date">	 <br/>
				퇴사사유 <textarea class="dereason" name="dereason" rows="" cols=""></textarea>
			</form>
	
         </div>
         <div class="modal_btns">
            <button onclick="updatebtn()"  class="modal_check"      type="button">수정</button>
            <button onclick="closeModal()" class="modal_cancel"   type="button">취소</button>
         </div>
      </div>
   </div> <!-- 모달 end -->
	
	<!-- 모달 HTML 삭제!!!! -->
   <div class="modal_wrap deletemodal">
      <div class="modal_box">
         <h3 class="modal_title">직원 삭제</h3>
         <div class="modal_content">
            삭제하시겠습니까?
            사번 : <input class="input_eno" type="text">
         </div>
         <div class="modal_btns">
            <button onclick="deleteEmploye()"  class="modal_check"      type="button">삭제</button>
            <button onclick="closeModal()" class="modal_cancel"   type="button">취소</button>
         </div>
      </div>
   </div>
	
	
	<!-- 제이쿼리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 사용자정의 -->
	<script src="/jspweb/practice/과제1/modal.js" type="text/javascript"></script>
	<script src="index.js" type="text/javascript"></script>
		
</body>
</html>

<!-- 		퇴사일  <input class="dedate" name="dedate" type="date">	 <br/> -->
<!-- 		퇴사사유  <input class="dereason" name="dereason" type="text"> <br/> -->