<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%  List<Map> list = (List<Map>)request.getAttribute("team"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teamlist</title>
</head>
<body>

<div class="container">
  <h2>팀 정보 목록</h2>
  <p> MVC 연습입니다 </p>            
  <table class="table">
    <thead>
      <tr>
        <th>이름</th>
        <th>전화번호</th>
        <th>주소</th>
      </tr>
    </thead>
    <tbody>

<%  for(int i=0; i<list.size(); i++ ) {
	    Map<String,String> map = list.get(i);
%>
      <tr>
        <td><%=map.get("name") %></td>
        <td><%=map.get("phone") %></td>
        <td><%=map.get("addr") %></td>
      </tr>
<%  } %>
      
    </tbody>
  </table>
</div>

</body>
</html>