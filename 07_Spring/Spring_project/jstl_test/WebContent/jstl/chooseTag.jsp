<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
    <!-- choose 태그는 혼자서만 쓸 수 없음 -->
	<c:choose>
		<!-- URL상에서 앞의 조건이 만족되면 뒤에 조건은 읽지 않음 -->
		<c:when test="${param.name=='tree'}">
			<li> 당신의 이름은 ${param.name}입니다.
		</c:when>
		<c:when test="${param.age > 18}">
			<li> 당신의 나이는 18세 이상입니다.
		</c:when>
		<c:otherwise>
			<li> 당신은 tree도 아니고 18세 이상도 아닙니다.
		</c:otherwise>
	</c:choose>
</ul>
</body>
</html>