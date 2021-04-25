<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<c:import url="url.jsp" var="urlEx" />
<!-- hedder.jsp에 파라미터를 넣어줌 -->
<c:import url="http://127.0.0.1:8000/jstl_test/jstl/header.jsp" var="head"> 
    <c:param name="id" value="tree" /> 
</c:import> 
<c:import url="footer.jsp" var="foot" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
${head} 

${urlEx} 

${foot} 
</body>
</html>