<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>내 정보</h3>
<a href=""${pageContext.request.contextPath }/member/index.jsp">index로 이동</a><br/>
<form action="${pageContext.request.contextPath }/MyInfo" method="post" name="f">
<table border="1">
<!-- readonly : 수정이 안됨, 읽기만 가능 -->
<tr><th>id</th><td><input type="text" name="id" value="${m.id }" readonly></td></tr>
<tr><th>pwd</th><td><input type="text" name="pwd" value="${m.pwd }"></td></tr>
<tr><th>name</th><td><input type="text" name="name" value="${m.name }" readonly></td></tr>
<tr><th>email</th><td><input type="text" name="email" value="${m.email }"></td></tr>
<tr><td colspan="2">
<!-- submit은 전송이 되는 방식이니까, 그 전에 체크하는 방식 button -->
<input type = "submit" value="수정"> 
</td></tr>
</table>
</form>
</body>
</html>