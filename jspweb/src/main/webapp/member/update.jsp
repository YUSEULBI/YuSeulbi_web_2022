<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/header.jsp" %> 
	
	<div class="container">
		<h3>회원수정</h3>
		<div>
			<div>
				<img width="20%" class="mimg" alt="" src="/jspweb/member/pimg/default.webp">
			</div>
			
			<div>
				<div>아이디</div>
				<div class="mid"></div>
			</div>
			
			<div>
				<div>현재비밀번호</div>
				<input class="" type="password"></input>
			</div>
			
			<div>
				<div>새 비밀번호</div>
				<input class="" type="password"></input>
			</div>
			
			<div>
				<div>새 비밀번호 확인</div>
				<input class="" type="password"></input>
			</div>
			
			<div>
				<div>새 이메일</div>
				<input class="memail" type="text"></input>
				<button type="button">인증</button>
			</div>
			
			
			<a href="/jspweb/member/update.jsp"><button type="button">회원수정</button></a>
			
			
		</div>
	</div>
	
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">회원탈퇴</h3> 
			<div class="modal_content">
				정말 회원탈퇴 하시겠습니까?<br>
				비밀번호 : <input class="mpwd" type="password">
			</div>
			<div class="modal_btns">
				<button onclick="setDelete()" class="modal_check" type="button">확인</button>
				<button onclick="modal_close()" class="modal_close" type="button">취소</button>
			</div>
		</div>
	</div>
	
	<!-- 모달 js -->
	<script src="/jspweb/js/modal.js"" type="text/javascript"></script>
	
	<script src="/jspweb/js/member/info.js" type="text/javascript"></script>

</body>
</html>