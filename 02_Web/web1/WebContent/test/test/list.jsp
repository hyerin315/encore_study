<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 태그 라이브러리 : 기능이 담긴 xml 파일을 가져오는 거 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>members</h3>
<c:if test="${empty list }">
등록된 멤버가 없습니다.
</c:if>
<c:if test="${not empty list }">
<table border="1">
  <tr><th>id</th><th>pwd</th><th>name</th><th>email</th></tr>
  <c:forEach var="m" items="${list }">
    <tr>
     <td>${m.id }</td><td>${m.pwd }</td><td>${m.name }</td><td>${m.email }</td>
    </tr>
  </c:forEach>
</table>
</c:if>
</body>
</html>