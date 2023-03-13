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
		<form class="updateForm">
			<div>
				<div>
					<img width="20%" class="mimg" alt="" src="/jspweb/member/pimg/default.webp">
					<br> 프로필변경 : <input type="file" name="newmimg">
					<br> <input type="checkbox" class="defaultimg"> 기본프로필 사용
				</div>
				
				<div>
					<div>아이디</div>
					<div class="mid"></div>
				</div>
				
				<div>
					<div>현재비밀번호</div>
					<input class="mpwd" type="password" name="mpwd"></input>
				</div>
				
				<div>
					<div>새 비밀번호</div>
					<input class="newmpwd" type="password" name="newmpwd"></input>
				</div>
				
				<div>
					<div>새 비밀번호 확인</div> <!-- 유효성검사생략 -->
					<input class="newmpwdconfirm" type="password"></input>
				</div>
				
				<div>
					<div>새 이메일</div>
					<input class="memail" type="text" name="memail"></input>
					<button type="button">인증</button>
				</div>
				
				
				<button onclick="setUpdate()" type="button">회원수정</button>
				
				
			</div>
		</form>
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
	
<!-- 	<script src="/jspweb/js/member/info.js" type="text/javascript"></script> -->
	<script src="/jspweb/js/member/update.js" type="text/javascript"></script>

</body>
</html>