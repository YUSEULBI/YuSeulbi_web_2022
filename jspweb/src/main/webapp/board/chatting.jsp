<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<div class="container">
		
		<div class="chattingbox"> <!-- 채팅구역 -->
			<div class="contentbox"> <!-- 채팅창 -->
				
				
				
			</div>
			<!--form-control : bs   -->
			<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
			
			<div class="chattingbtnbox">
				
				<!-- bs
					클릭위치 : data-bs-toggle="dropdown"
					메뉴표시할구역  class="dropdown-menu"
				-->
				<!-- 드롭다운 버튼 -->
				<button class="emobtn" type="button" data-bs-toggle="dropdown">
					<i class="far fa-smile"></i>
				</button>
				
				<!-- 드롭다운 버튼 클릭시 보이는 구역 -->
				<div class="dropdown-menu emolist">
				</div>
				
				<button onclick="보내기()" class="sendbtn" type="button">보내기</button>
			</div>
			
		</div>
		
		
		
				
				
		
		
		
	</div>
	
	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>