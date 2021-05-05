<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function del(){
	flag = confirm("���� �����Ͻðڽ��ϱ�?");
	if(flag){
		//�ڹ� ��ũ��Ʈ���� ������ �̵� (�̵��� ������ ����)
		location.href="${pageContext.request.contextPath }/BoardDel?num=${b.num }";
	} else {
		alert("���� ���");
	}
}
</script>
</head>
<body>
<c:if test="${sessionScope.id!=b.writer }">
  <c:set var="str">readonly</c:set>
</c:if>
<h3>��������</h3>
<form action="${pageContext.request.contextPath }/BoardRead" method="post">
<table border="1">
<tr>
  <th>�۹�ȣ</th><td><input type="text" name="num" value="${b.num }" readonly></td>
</tr>
<tr>
  <th>�ۼ���</th><td><input type="text" name="writer" value="${b.writer }" readonly></td>
</tr>
<tr>
  <th>�ۼ���</th><td><input type="text" value="${b.w_date }" readonly></td>
</tr>
<tr>
  <th>����</th><td><input type="text" name="title" value="${b.title }" ${str }></td>
</tr>
<tr>
  <th>����</th><td><textarea rows="20" cols="45" name="content" ${str }>${b.content }</textarea></td>
</tr>
<c:if test="${sessionScope.id==b.writer }">
<tr>
  <td colspan="2">
       <input type="submit" value="����">
       <input type="button" value="����"  onclick="del()"> 
  </td>
 </tr>
</c:if>
</table>
</form>
</body>
</html>