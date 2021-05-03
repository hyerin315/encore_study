<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<!-- 상단 메뉴 -->
	<tiles:insertAttribute name="header" />
	<!-- 상단 메뉴 끝 -->

	<!-- 내용 시작 -->
	<!-- 	<div style="width: 100%; padding-top: 30px;"> -->
	<%-- 		<jsp:include page="<%=CONTENT_PAGE%>" flush="false" /> --%>
	<!-- 	</div> -->

	<tiles:insertAttribute name="body" />
	<!-- 내용 끝 -->

</body>
</html>