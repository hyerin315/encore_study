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
<h3>�۸��</h3>
<a href="${pageContext.request.contextPath }/BoardWrite">���ۼ�</a><br/>
<c:if test="${empty list }">��ϵ� ���� ����</c:if>

<c:if test="${not empty list }">
<table border="1">
  <tr><th>�۹�ȣ</th><th>����</th><th>�ۼ���</th></tr>
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