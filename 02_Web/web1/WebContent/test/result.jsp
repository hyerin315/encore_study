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
//request.getParameter("�Ķ��̸�"):��û �Ķ���� ����, ���ڿ��� ����
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gen = request.getParameter("gen");
String[] hobby = request.getParameterValues("hobby");//�������� �Ķ���� ���� ���� �� �ִ� �迭(�ϳ��� üũ�ϸ� �ϳ��� �ִ� �迭)
int grade = Integer.parseInt(request.getParameter("grade"));

//��� ���
//1) out ��ü�� �� ���� ���
out.println("out ��ü�� ���<br/>");
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

<!-- 2) html���� ��� -->
<h3>html�� ���</h3>
id:<%=id %><br/>
pwd:<%=pwd %><br/>
gen:<%=gen %><br/>
grade:<%=grade %><br/>
<%
//html���� for�Լ��� �����Ƿ� �ڹٷ� ����
	for(String s:hobby){
%>
	<%=s %><br/>
<%
	}
%>
</body>
</html>