<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>글작성 폼</h3>
<form action="${pageContext.request.contextPath }/BoardWrite" method="post">
<table border="1">
<tr>
  <th>작성자</th><td><input type="text" name="writer" value="${sessionScope.id }" readonly></td>
</tr>
<tr>
  <th>제목</th><td><input type="text" name="title"></td>
</tr>
<tr>
  <th>내용</th><td><textarea rows="20" cols="45" name="content"></textarea></td>
</tr>
<tr>
  <td colspan="2">
    <input type="submit" value="저장">
    <a href="${pageContext.request.contextPath }/BoardList">글목록으로 이동</a>
  </td>
</tr>
</table>
</form>
</body>
</html>