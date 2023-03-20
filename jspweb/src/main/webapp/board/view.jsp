<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/list.css" rel="stylesheet">
	<link href="/jspweb/css/view.css" rel="stylesheet">
</head>
<body>
	<%@include file="/header.jsp" %>
	<%
		// JAVA코드 들어가는 자리
		
		// 1. jsp 이용한 http url 변수 호출
		String bno = request.getParameter("bno");
	%>
	
	<!-- 표현식코드 자바코드를 출력하는 자리 -->
	<input type="hidden" class="bno" value="<%=bno%>">
	
	<div class="container">
		<div class="boardbox">
			<div class="viewtop">
				<div>
					<img alt="" src="/jspweb/member/pimg/default.webp" class="hpimg mimg"> 
				</div>
				<div class="rviewtop">
					<div class="mid"></div>
					<div>
						<span class="bdate"></span>
						
						<span class="binfo">
							<i class="far fa-eye"></i> 
							<span class="bview"></span> 
						</span>
						
						<span class="binfo">
							<i class="far fa-thumbs-up"></i> 
							<span onclick="bIncrease(2)"  class="bup"></span> 
						</span>
						
						<span class="binfo">
							<i class="far fa-thumbs-down"></i> 
							<span onclick="bIncrease(3)" class="bdown"></span> 
						</span>
						
					</div>

				</div>
			</div>
			<div class="btitle"></div>
			<div class="bcontent"></div>
			<div class="bfile"></div>
			<div class="btnbox"></div>
			
			<div class="replycount"> 3개의 댓글 </div>
			<div class="replywritebox">
				<textarea class="rcontent" rows="" cols=""></textarea>
				<button class="rwritebtn bbtn" onclick="rwrite()" type="button">댓글작성</button>
			</div>
			<div class="comments">
				<div class="commentsone">
					<div class="comments_first">
						<div>
							<img alt="" src="/jspweb/member/pimg/default.webp" class="hpimg mimg"> 
						</div>
						<div class="commentmid"> qwe1234 </div>
						<div> 댓글을 작성합니다. </div>
					</div>
					<div class="comments_end">
						<div class="cdate"> 2023-03-22 </div>
						<button class="bbtn commentsbtn">답글보기</button>
						<div class="recomments"></div>
					</div>
				</div>
			</div>
			
			<div class="replyListbox">
				
			</div>
		</div>
	</div>
	
	
	
	
		
		
		
		
		
	

	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
</body>
</html>

















