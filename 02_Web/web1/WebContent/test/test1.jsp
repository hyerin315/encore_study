<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
  <head>
   <meta charset="EUC-KR"> <!-- ĳ�õ����� ���� �� -->
   <title>Insert title here</title>
  </head>
  <body> <!-- ���������� �ְ� ���� ����(�۾�, �̹���) �� �Ʒ��� ���� -->
    hello web <br/> byebye <br/> <!-- ����ģ�ٰ� �ٹٲ��� ���� ����, �ٹٲ� : <br/> -->
    
    <!-- �̹��� ���� + ��ũ �ޱ� -->
    <a href="https://www.naver.com"><img src="../img/123.png" width="400" height="300"/></a><br/><!-- �̹��� ���� ���� �� "" �ȿ��� �̹��� ���� ��� -->
    <a href="https://www.daum.net">����</a><br/> <!-- �۾��� �̵��ϰ� ���� ���� �۾��� -->
    <!-- ���������� �̵�(���� ������ ����������) -->
    <a href ="next.jsp">����������</a><br/> <!-- ���� �����ϱ� ��θ� �̷��� ������, �ٸ� ��ο� ������ �� ������� -->
    
    <!-- ���̺� ����� : tr  /tr ���̺��� ���⼭ ������, td /td ĭ�� ���⼭ ������ (�ʱ� �̹��� ����-->
    <table border="1"> <!-- �� ���� -->
    <tr><td>����ġ img1</td><td>����ġ img2</td><td>����ġ img3</td></tr>
    <tr><td>aaa</td><td>bbb</td><td>ccc</td></tr>
    </table> <!-- ĭ�� �� ���빰 ũ�⸸ŭ ������� --><br/>
    
    
    <table border="2">
    <tr><td>����ġ img1</td><td>����ġ img2</td><td>����ġ img3</td></tr>
    <tr>
       <td><img src="../img/123.png" width="400" height="300"/></td>
       <td><img src="../img/234.jpg" width="400" height="300"/></td>
       <td>«�� ¥���!</br>���ε� �԰� �ʹ�!</td>
    </tr>
    </table> 
    
  </body> 
</html>