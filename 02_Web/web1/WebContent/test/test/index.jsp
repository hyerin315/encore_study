<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- �±� ���̺귯�� -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${joinMsg } <!-- ȸ������ �Ϸᰡ ���� ������ -->
<!-- ���� �޼����� �Էµ� �� ������ ���� ����? -> �ȳ�! ���� ������ ���, ������ �ƹ� ���۵� ����-->
<h3><a href="${pageContext.request.contextPath }/Join">ȸ������</a>
<a href="${pageContext.request.contextPath }/Login">�α���</a></h3>
<a href="${pageContext.request.contextPath }/MemList">��� ���</a></h3>
<!-- if���� ����(not empty : ���� �ȿ� ��� ����) -->
<c:if test="${not empty sessionScope.id }">
<!-- ${sessionScope.id } ���ǿ� ���� �� �̷��� ������ ��� ����(�ٸ� �������� ���� ������) -->
${sessionScope.id }�� �α��� ��
<h3><a href="${pageContext.request.contextPath }/MyInfo">�� ���� ����</a>
<a href="${pageContext.request.contextPath }/Logout">�α׾ƿ�</a>
<a href="${pageContext.request.contextPath }/Out">Ż��</a>
<a href="">�Խ���</a></h3>
</c:if>
</body>
</html>