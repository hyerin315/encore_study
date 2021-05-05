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
	flag = confirm("정말 삭제하시겠습니까?");
	if(flag){
		//자바 스크립트에서 페이지 이동 (이동할 페이지 삽입)
		location.href="${pageContext.request.contextPath }/BoardDel?num=${b.num }";
	} else {
		alert("삭제 취소");
	}
}
</script>
</head>
<body>
<c:if test="${sessionScope.id!=b.writer }">
  <c:set var="str">readonly</c:set>
</c:if>
<h3>상세페이지</h3>
<form action="${pageContext.request.contextPath }/BoardRead" method="post">
<table border="1">
<tr>
  <th>글번호</th><td><input type="text" name="num" value="${b.num }" readonly></td>
</tr>
<tr>
  <th>작성자</th><td><input type="text" name="writer" value="${b.writer }" readonly></td>
</tr>
<tr>
  <th>작성일</th><td><input type="text" value="${b.w_date }" readonly></td>
</tr>
<tr>
  <th>제목</th><td><input type="text" name="title" value="${b.title }" ${str }></td>
</tr>
<tr>
  <th>내용</th><td><textarea rows="20" cols="45" name="content" ${str }>${b.content }</textarea></td>
</tr>
<c:if test="${sessionScope.id==b.writer }">
<tr>
  <td colspan="2">
       <input type="submit" value="수정">
       <input type="button" value="삭제"  onclick="del()"> 
  </td>
 </tr>
</c:if>
</table>
</form>
</body>
</html>