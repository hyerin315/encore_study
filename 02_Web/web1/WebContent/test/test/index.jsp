<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 태그 라이브러리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
${joinMsg } <!-- 회원가입 완료가 됐을 때까지 -->
<!-- 조인 메세지가 입력된 게 없으면 에러 나나? -> 안남! 값이 있으면 출력, 없으면 아무 동작도 안함-->
<h3><a href="${pageContext.request.contextPath }/Join">회원가입</a>
<a href="${pageContext.request.contextPath }/Login">로그인</a></h3>
<a href="${pageContext.request.contextPath }/MemList">모든 멤버</a></h3>
<!-- if문과 같음(not empty : 값이 안에 들어 있음) -->
<c:if test="${not empty sessionScope.id }">
<!-- ${sessionScope.id } 세션에 담은 건 이렇게 정보를 담아 써줌(다른 페이지로 가도 유지됨) -->
${sessionScope.id }님 로그인 중
<h3><a href="${pageContext.request.contextPath }/MyInfo">내 정보 보기</a>
<a href="${pageContext.request.contextPath }/Logout">로그아웃</a>
<a href="${pageContext.request.contextPath }/Out">탈퇴</a>
<a href="">게시판</a></h3>
</c:if>
</body>
</html>