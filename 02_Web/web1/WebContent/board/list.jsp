<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>글목록</h3>
<a href="${pageContext.request.contextPath }/BoardWrite">글작성</a><br/>
<c:if test="${empty list }">등록된 글이 없음</c:if>

<c:if test="${not empty list }">
<table border="1">
  <tr><th>글번호</th><th>제목</th><th>작성자</th></tr>
  <c:forEach var="b" items="${list }">
   <tr>
     <td>${b.num }</td>
     <td><a href="${pageContext.request.contextPath }/BoardRead?num=${b.num }">
     ${b.title }</td><td>${b.writer }</td>
   </tr>
  </c:forEach>
</table>
</c:if>
</body>
</html>