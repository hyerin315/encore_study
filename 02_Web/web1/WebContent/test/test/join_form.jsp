<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
//자바스크립트 코드 (타입 지정 안함)
function check() {
	if(f.id.value=="" || f.id.value==null){//여기에서의 f는 아래의 name="f"
		alert("id는 필수 입력 사항입니다.");
		return;
	}
	if(f.pwd.value=="" || f.pwd.value==null){
		alert("pwd은 필수 입력 사항입니다.");
		return;
	}
	if(f.name.value=="" || f.name.value==null){
		alert("name은 필수 입력 사항입니다.");
		return;
	}
	if(f.email.value=="" || f.email.value==null){
		alert("email은 필수 입력 사항입니다.");
		return;
	}
	f.submit();//서버로 전송
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/Join" method="post" name="f">
<table border="1">
<!-- <td>는 제목글씨 출력, 글씨가 조금 굵어짐 -->
<tr><th>id</th><td><input type="text" name="id"></td></tr>
<tr><th>pwd</th><td><input type="text" name="pwd"></td></tr>
<tr><th>name</th><td><input type="text" name="name"></td></tr>
<tr><th>email</th><td><input type="text" name="email"></td></tr>
<!-- colspan : 칸을 가로로 병합하는 것(옆의 숫자는 합칠 칸의 수) / rowspan : 세로로 칸을 병합하는 것(옆의 숫자는 합칠 칸의 수) -->
<tr><td colspan="2">
<!-- submit은 전송이 되는 방식이니까, 그 전에 체크하는 방식 button -->
<input type = "button" value="가입" onclick="check()"> <!-- 함수 호출하면 위의 자바스크립트 호출 -->
</td></tr>
</table>
</form>
</body>
</html>