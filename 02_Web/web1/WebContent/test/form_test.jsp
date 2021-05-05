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
  <!-- 폼 양식 : 사용자가 입력하는 입력양식 만들어줌, 사용자는 이 폼에 내용 작성해서 서버 전송 -->
  <!-- action : 입력한 데이터를 받을 서버페이지의 경로(사용자가 아이디를 적으면 action에 적힌 주소로 전송됨) -->
  <!-- method : 전송 방식 
  (post방식 : 숨겨서 보내는 방식, 한글도 덜깨짐
   get방식 : 전송한 데이터를 url 뒤에 붙여서 보냄, 한글 잘깨짐
           ex. http://www.~.net/join.jsp?id=aaa&pwd=123 = url 뒤에 ?(물음표)) 자동으로 붙여 보냄 -->
           
  <!-- post방식 -->
  <form action="${pageContext.request.contextPath }/ServletTest" method="post"> <!-- 요청을 Servlet에서 받도록 전송하는 역할  -->
  <!-- input : 입력 -->
  id:<input type="text" name="id"></br><!-- name : 불러올 때 name으로 불러오기때문에 다른 것과 이름이 같으면 안됨 -->
  pwd:<input type="password" name="pwd"></br> <!-- hidden : "password" -->
  
  <!-- 라디오 버튼 : 선택지 중 하나만 선택 -->
  성별:
  <input type="radio" name="gen" value="1">여성
  <input type="radio" name="gen" value="2">남성
  <!-- 라디오 버튼처럼 하나의 그룹일 경우 name이 같아함, 여성 남성 텍스트는 보여질 텍스트일뿐이고 전송되는 값은 value 1, 2 -->
  </br>
  <!-- 체크 박스 : 선택지 중 여러개 선택  -->
  취미(여러개 선택 가능):
  <input type ="checkbox" name="hobby" value="h1">수영
  <input type ="checkbox" name="hobby" value="h2">여행
  <input type ="checkbox" name="hobby" value="h3">악기연주
  </br>
  <!-- 콤보 박스(셀렉트 박스) : 목록을 option 태그로 보여줌, 다른 기능처럼 선택한 value값이 서버로 전송 -->
  학년:
  <select name="grade">
  <option value="1">1학년</option>
  <option value="2">2학년</option>
  <option value="3">3학년</option>
  <option value="4">4학년</option>
  </select>
  <br/>
  
  <!-- 모양은 세 개 다 버튼 모양으로 같으나, 기능이 다름 / 여기서의 value = 껍데기 -->
  <!-- 일반버튼 : 우리가 넣어주고 싶은 기능을 넣어주면 됨 -->
  <input type="button" value="일반버튼" onclick="javascript:alert('butoon click')"/> <!-- onclick : 알림창 띄우기 -->
  <!-- 초기화 -->
  <input type="reset" value="취소">
  <!-- 전송 : 위에서 설정한 경로로 전송(result.jsp) -->
  <input type="submit" value="전송">
  <!-- 오류 1) 404는 경로 실수 2) 505는 대부분 코드 오타 -->
  
  <!-- CSS 적용 방법 : style 태그 :(콜론)하고 값 -->
  <td style="color:red;width:100px">끝</td>

  </form>
</body>
</html>