<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
//�ڹٽ�ũ��Ʈ �ڵ� (Ÿ�� ���� ����)
function check() {
	if(f.id.value=="" || f.id.value==null){//���⿡���� f�� �Ʒ��� name="f"
		alert("id�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	if(f.pwd.value=="" || f.pwd.value==null){
		alert("pwd�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	if(f.name.value=="" || f.name.value==null){
		alert("name�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	if(f.email.value=="" || f.email.value==null){
		alert("email�� �ʼ� �Է� �����Դϴ�.");
		return;
	}
	f.submit();//������ ����
}
</script>
</head>
<body>
<h3>ȸ������</h3>
<form action="${pageContext.request.contextPath }/Join" method="post" name="f">
<table border="1">
<!-- <td>�� ����۾� ���, �۾��� ���� ������ -->
<tr><th>id</th><td><input type="text" name="id"></td></tr>
<tr><th>pwd</th><td><input type="text" name="pwd"></td></tr>
<tr><th>name</th><td><input type="text" name="name"></td></tr>
<tr><th>email</th><td><input type="text" name="email"></td></tr>
<!-- colspan : ĭ�� ���η� �����ϴ� ��(���� ���ڴ� ��ĥ ĭ�� ��) / rowspan : ���η� ĭ�� �����ϴ� ��(���� ���ڴ� ��ĥ ĭ�� ��) -->
<tr><td colspan="2">
<!-- submit�� ������ �Ǵ� ����̴ϱ�, �� ���� üũ�ϴ� ��� button -->
<input type = "button" value="����" onclick="check()"> <!-- �Լ� ȣ���ϸ� ���� �ڹٽ�ũ��Ʈ ȣ�� -->
</td></tr>
</table>
</form>
</body>
</html>