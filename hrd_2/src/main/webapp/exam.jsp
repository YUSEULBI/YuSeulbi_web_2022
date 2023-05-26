<%@page import="java.text.DecimalFormat"%>
<%@page import="controller.Dto"%>
<%@page import="java.util.List"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		<center>
			<h3>학생성적</h3>
			<table border="1" style="border-collapse:collapse; text-align:center; width:700px;" >
				<tr>
					<th>학년</th><th>반</th><th>번호</th><th>이름</th><th>국어</th><th>수학</th>
					<th>영어</th><th>역사</th><th>합계</th><th>평균</th><th>순위</th>
				</tr>
				
				
					<!-- 반복문 -->
					<%
						Dao dao = new Dao();
						List<Dto> dtolist = dao.getExamList();
						
						// 과목별 합계,평균 6개씩
						// 배열 선언/// 자료형[] 배열명 = { 초기값1 , 초기값2 }
						// 배열 선언/// 자료형[] 배열명 = new 자료형[길이];
						double[] sumArray = { 0 , 0 , 0 , 0 , 0 , 0 };
						int count = 0; // 점수가 있는 학생 개수;
						double[] avgArray = { 0.0 , 0.0 , 0.0 , 0.0 , 0.0 , 0.0 };
						
						
						for ( int i = 0 ; i < dtolist.size() ; i++ ){
							Dto dto = dtolist.get(i);
							
							// 과목별 합계
							sumArray[0] += dto.getEkor(); // 국어성적 누계
							sumArray[1] += dto.getEmath(); // 수학성적 누계
							sumArray[2] += dto.getEeng(); // 국어성적 누계
							sumArray[3] += dto.getEhist(); // 국어성적 누계
							sumArray[4] += dto.getSum(); // 국어성적 누계
							sumArray[5] += dto.getAvg(); // 국어성적 누계
							// 점수가 있는 학생
							if (dto.getEkor() != 0 ) count++;
							
							// 점수가 없으면
							if ( dto.getEkor() == 0 ){
								
								%>
								<tr>
									<td><%= dto.getSno1()%></td>
									<td><%= dto.getSno2()%></td>
									<td><%= dto.getSno3()%></td>
									<td><%= dto.getSname()%></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<%	
								
								
							// 점수가 있으면
							}else{
								
								
								%>
								<tr>
									<td><%= dto.getSno1()%></td>
									<td><%= dto.getSno2()%></td>
									<td><%= dto.getSno3()%></td>
									<td><%= dto.getSname()%></td>
									<td><%= dto.getEkor()%></td>
									<td><%= dto.getEmath()%></td>
									<td><%= dto.getEeng()%></td>
									<td><%= dto.getEhist()%></td>
									<td><%= dto.getSum()%></td>
									<td><%= dto.getAvg()%></td>
									<td><%= dto.getRank()%></td>
								</tr>
								<%	
								
								
							}
			
						} 
					%>
				<% DecimalFormat df = new DecimalFormat("#.#"); %>
				<tr>
					<td colspan="4">총합</td> 
					<% for( int i = 0 ; i <= 5 ; i++ ){ %>
						<td><%=df.format(sumArray[i]) %></td>
					<% } %>
				</tr>
				<tr>
					<td colspan="4">총 평균</td> 
					<% for( int i = 0 ; i <= 5 ; i++ ){ %>
						<td><%=df.format(sumArray[i]/count)%></td>
					<%} %>
				</tr>
			</table>
		</center>
	<%@ include file="footer.jsp" %>
</body>
</html>