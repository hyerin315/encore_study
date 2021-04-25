<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<c:choose>
	<c:when test="${empty sessionScope.id && sessionScope.grade == 'A'}"><!-- get 부분 -->
		<c:set var="str">관리자 페이지 입니다.</c:set>
	</c:when>
	<c:when test="${empty sessionScope.id && sessionScope.grade != 'A'}">
		<c:set var='str'>안녕하세요 ${sessionScope.id }님, 반가워요!</c:set>
	</c:when>
	<c:otherwise>
		<c:set var='str'>기본페이지 입니다.</c:set>
	</c:otherwise>
</c:choose>
<!DOCTYPE html>
<html>
<head>
<title>memo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
#grade {
	color: orange;
}
</style>
</head>
<body>
	<!--상단메뉴-->
	<div class="container">

		<div class="page-header row">
			<div class="col-sm-4">
				<img src="${root}/images/img_chania.jpg"
					class="img-responsive img-thumbnail" alt="Cinque Terre">
			</div>
			<div class="col-sm-8">
				<h1>Homepage</h1>
				<br>

				<p id="grade">${str}</p>

			</div>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a href="${root}/">Home</a></li>

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">게시판 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${root}/bbs/list">게시판 목록</a></li>
					<li><a href="${root}/bbs/create">게시판 생성</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">MVC실습 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">#</a></li>
					<li><a href="#">#</a></li>
				</ul></li>
			<c:choose>
				<c:when test="${empty sessionScope.id }">
				<!-- 세션에 Id가 없으면 아래 창이 뜬다 -->
				<!-- 세션 객체는 페이지마다 세션 ID를 각각 갖고 있음 / 하지만 이 친구는 가만히 있을 경우(5~20분) 사라짐...?-->
					<li><a href="${root}/member/agree">회원가입</a></li>
					<li><a href="${root}/member/login">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${root}/member/read">나의 정보</a></li>
					<li><a href="${root}/member/update">회원수정</a></li>
					<li><a href="${root}/member/logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
			<c:if test="${empty sessionScope.id && sessionScope.grade == 'A'}">
				<li><a href="${root}/member/update">회원목록</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>