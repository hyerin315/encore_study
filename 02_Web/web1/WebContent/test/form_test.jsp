<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type = "text/css">
button{
backgreound-color:yellow;
}
</style>
</head>
<body>
  <!-- �� ��� : ����ڰ� �Է��ϴ� �Է¾�� �������, ����ڴ� �� ���� ���� �ۼ��ؼ� ���� ���� -->
  <!-- action : �Է��� �����͸� ���� ������������ ���(����ڰ� ���̵� ������ action�� ���� �ּҷ� ���۵�) -->
  <!-- method : ���� ��� 
  (post��� : ���ܼ� ������ ���, �ѱ۵� ������
   get��� : ������ �����͸� url �ڿ� �ٿ��� ����, �ѱ� �߱���
           ex. http://www.~.net/join.jsp?id=aaa&pwd=123 = url �ڿ� ?(����ǥ)) �ڵ����� �ٿ� ���� -->
           
  <!-- post��� -->
  <form action="${pageContext.request.contextPath }/ServletTest" method="post"> <!-- ��û�� Servlet���� �޵��� �����ϴ� ����  -->
  <!-- input : �Է� -->
  id:<input type="text" name="id"></br><!-- name : �ҷ��� �� name���� �ҷ����⶧���� �ٸ� �Ͱ� �̸��� ������ �ȵ� -->
  pwd:<input type="password" name="pwd"></br> <!-- hidden : "password" -->
  
  <!-- ���� ��ư : ������ �� �ϳ��� ���� -->
  ����:
  <input type="radio" name="gen" value="1">����
  <input type="radio" name="gen" value="2">����
  <!-- ���� ��ưó�� �ϳ��� �׷��� ��� name�� ������, ���� ���� �ؽ�Ʈ�� ������ �ؽ�Ʈ�ϻ��̰� ���۵Ǵ� ���� value 1, 2 -->
  </br>
  <!-- üũ �ڽ� : ������ �� ������ ����  -->
  ���(������ ���� ����):
  <input type ="checkbox" name="hobby" value="h1">����
  <input type ="checkbox" name="hobby" value="h2">����
  <input type ="checkbox" name="hobby" value="h3">�Ǳ⿬��
  </br>
  <!-- �޺� �ڽ�(����Ʈ �ڽ�) : ����� option �±׷� ������, �ٸ� ���ó�� ������ value���� ������ ���� -->
  �г�:
  <select name="grade">
  <option value="1">1�г�</option>
  <option value="2">2�г�</option>
  <option value="3">3�г�</option>
  <option value="4">4�г�</option>
  </select>
  <br/>
  
  <!-- ����� �� �� �� ��ư ������� ������, ����� �ٸ� / ���⼭�� value = ������ -->
  <!-- �Ϲݹ�ư : �츮�� �־��ְ� ���� ����� �־��ָ� �� -->
  <input type="button" value="�Ϲݹ�ư" onclick="javascript:alert('butoon click')"/> <!-- onclick : �˸�â ���� -->
  <!-- �ʱ�ȭ -->
  <input type="reset" value="���">
  <!-- ���� : ������ ������ ��η� ����(result.jsp) -->
  <input type="submit" value="����">
  <!-- ���� 1) 404�� ��� �Ǽ� 2) 505�� ��κ� �ڵ� ��Ÿ -->
  
  <!-- CSS ���� ��� : style �±� :(�ݷ�)�ϰ� �� -->
  <td style="color:red;width:100px">��</td>

  </form>
</body>
</html>