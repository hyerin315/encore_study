<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="el.*" %>
<%
	ELDTO dto = new ELDTO("스티브잡스", "애플");
	request.setAttribute("dto", dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		EL을 사용하지 않은 경우 <br>
		<br>
		<%
		Object obj = request.getAttribute("dto");

		ELDTO eldto = (ELDTO) obj;
		out.print("영화명 : " + eldto.getMovie() + "<br><br>");
		out.print("주 연 : " + eldto.getName() + "<br><br>");
		%>
		<br> EL을 사용한 경우 <br>
		<br> 영화명 : ${requestScope.dto.movie}<br>
		<br> 주 연 : ${requestScope.dto.name}<br>
		<br> Type2 - 주 연 : ${dto.movie}=${dto.name}<br>
		<br>
		<!-- Type3, Type4처럼 저장되어진 이름.필드명이 아니면 쓸 수 없음 -->
		Type3 - 주 연(X) : ${requestScope.movie}<br>
		<br> Type4 - 주 연(X) : ${movie}<br>
		<br>
	</h2>
</body>
</html>