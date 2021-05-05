<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>cookie test</h3>
<%
Cookie[] c = request.getCookies();//저장한 쿠키 읽기
for(Cookie x:c){
	String name = x.getName();
	String val = x.getValue();
	out.print(name+" : "+val+"<br/>");
}
%>
</body>
</html>