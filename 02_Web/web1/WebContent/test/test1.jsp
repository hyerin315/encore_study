<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
  <head>
   <meta charset="EUC-KR"> <!-- 캐시데이터 같은 거 -->
   <title>Insert title here</title>
  </head>
  <body> <!-- 웹페이지에 넣고 싶은 내용(글씨, 이미지) 이 아래에 삽입 -->
    hello web <br/> byebye <br/> <!-- 엔터친다고 줄바꿈이 되지 않음, 줄바꿈 : <br/> -->
    
    <!-- 이미지 띄우기 + 링크 달기 -->
    <a href="https://www.naver.com"><img src="../img/123.png" width="400" height="300"/></a><br/><!-- 이미지 띄우고 싶을 때 "" 안에는 이미지 파일 경로 -->
    <a href="https://www.daum.net">다음</a><br/> <!-- 글씨로 이동하고 싶을 때는 글씨로 -->
    <!-- 다음페이지 이동(다음 페이지 만들어줘야함) -->
    <a href ="next.jsp">다음페이지</a><br/> <!-- 같은 폴더니까 경로를 이렇게 쓰지만, 다른 경로에 있으면 다 써줘야함 -->
    
    <!-- 테이블 만들기 : tr  /tr 테이블은 여기서 끝난다, td /td 칸은 여기서 끝난다 (필기 이미지 참조-->
    <table border="1"> <!-- 선 굵기 -->
    <tr><td>아파치 img1</td><td>아파치 img2</td><td>아파치 img3</td></tr>
    <tr><td>aaa</td><td>bbb</td><td>ccc</td></tr>
    </table> <!-- 칸에 들어간 내용물 크기만큼 만들어짐 --><br/>
    
    
    <table border="2">
    <tr><td>아파치 img1</td><td>아파치 img2</td><td>아파치 img3</td></tr>
    <tr>
       <td><img src="../img/123.png" width="400" height="300"/></td>
       <td><img src="../img/234.jpg" width="400" height="300"/></td>
       <td>짬뽕 짜장면!</br>만두도 먹고 싶다!</td>
    </tr>
    </table> 
    
  </body> 
</html>