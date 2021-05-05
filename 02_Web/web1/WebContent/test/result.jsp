<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
//request.getParameter("파람이름"):요청 파라메터 읽음, 문자열로 받음
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gen = request.getParameter("gen");
String[] hobby = request.getParameterValues("hobby");//여러개의 파라메터 값을 담을 수 있는 배열(하나만 체크하면 하나만 있는 배열)
int grade = Integer.parseInt(request.getParameter("grade"));

//출력 방법
//1) out 객체로 한 번씩 출력
out.println("out 객체로 출력<br/>");
out.println("id:"+id+"<br/>");
out.println("pwd:"+pwd+"<br/>");
out.println("gen:"+gen+"<br/>");
out.print("hobby:");
for(String s: hobby){
	out.print(s);
}
out.println("<br/>");
out.println("grade:"+grade+"<br/>");
%>

<!-- 2) html에서 출력 -->
<h3>html로 출력</h3>
id:<%=id %><br/>
pwd:<%=pwd %><br/>
gen:<%=gen %><br/>
grade:<%=grade %><br/>
<%
//html에는 for함수가 없으므로 자바로 생성
	for(String s:hobby){
%>
	<%=s %><br/>
<%
	}
%>
</body>
</html>