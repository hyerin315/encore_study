<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jstl_test를 실행하면 index가 기본으로(자동으로)열림 -->
	<h1>기본페이지 입니다</h1>
	<c:choose>
		<c:when test="${empty param.name }">
			<p style="font-size: large; color: olive;">인덱스 페이지입니다</p>
		</c:when>
		<c:otherwise>
			<p style="font-size: large; color: orange;">${param.name}님안녕하세요</p>
		</c:otherwise>
	</c:choose>
</body>
</html>