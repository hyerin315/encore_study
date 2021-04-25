<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.Date" %>
<!--     taglib는 prefix와 uri(ctl+spacebar)가 선언되어야 함 -->
<%@ taglib prefix="elfunc" uri="/ELFunctions" %>
<%
	Date today = new Date();

	request.setAttribute("today", today);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>
	<!-- el태그 -->
	오늘은 <b>${elfunc:dateFormat(today)}</b> 입니다. <br>
	<!-- 표현식 -->	
	오늘은 <b><%=today %></b> 입니다. <br>
	
</h2>
</body>
</html>