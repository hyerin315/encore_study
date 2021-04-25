<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<!-- 값이 없는 경우 스크립틀릿 : null / el : 공란, el이 조금 더 깔끔함-->
		code 파라미터(스크립틀릿 방식) : 
		<%
			String code = request.getParameter("code");
			out.print(code);
		%>
		<br>
		code 파라미터(el 방식) : ${param.code}
		<br>
	</h2>
</body>
</html>