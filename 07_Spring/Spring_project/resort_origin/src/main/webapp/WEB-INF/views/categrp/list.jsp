<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, width=device-width" /> 
<title>Resort world</title>
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
 
  
</script>
 
</head> 
 
<body>
 
  <DIV class='title_line'>카테고리 그룹</DIV>
 
 <!-- 카테고리 등록을 위한 폼 페이지 -->
  <div id='panel_create' style='padding: 10px 0px 10px 0px; background-color: #F9F9F9; width: 100%; text-align: center;'>
    <form name='frm_create' id='frm_create' method='POST' action='./create'><!-- Post방식이기 때문에 처리가 된 후 페이지가 보임 -->
      <!-- <input type='hidden' name='lang' id='lang' value='en'> --> <!-- ko, en -->
        
      <label>그룹 이름</label>
      <input type='text' name='name' value='' required="required" style='width: 25%;'>
 
      <label>순서</label>
      <input type='number' name='seqno' value='1' required="required" 
                min='1' max='1000' step='1' style='width: 5%;'>
  
      <label>형식</label>
      <select name='visible'>
        <option value='Y' selected="selected">Y</option>
        <option value='N'>N</option>
      </select>
       
      <button type="submit" id='submit'>등록</button><!-- 등록을 누르면 create이 Post 방식으로 작용하면서 아래의 라벨들 불러와서 등록 -->
      <button type="reset">취소</button><!-- type="button" onclick="cancel(); 부분에 하고 싶은 게 있으면 바꾸기 -->
    </form>
  </div>
 
  
<table class='table table-striped'>
  <colgroup>
    <col style='width: 10%;'/>
    <col style='width: 40%;'/>
    <col style='width: 20%;'/>
    <col style='width: 10%;'/>    
    <col style='width: 20%;'/>
  </colgroup>
 
  <thead>  
  <TR>
    <TH class="th_bs">순서</TH>
    <TH class="th_bs">대분류명</TH>
    <TH class="th_bs">등록일</TH>
    <TH class="th_bs">출력</TH>
    <TH class="th_bs">기타</TH>
  </TR>
  </thead>
  
  <!-- 카테고리 객체를 가져와 set에 담아 tb안에서는 번호, 카테고리명, 등록날짜를 보여주고 있음-->
  <tbody>
  <c:forEach var="categrpVO" items="${list}">
    <c:set var="categrpno" value="${categrpVO.categrpno }" />
    <tr>
      <td class="td_bs">${categrpVO.seqno }</TD>
      <td class="td_bs_left"><a href="../cate/list?categrpno=${categrpno }">${categrpVO.name }</a></td><!-- 대분류 안의 중분류가 있는지 정보를 /cate/list가 갖고 있음 -->
      <td class="td_bs">${categrpVO.rdate.substring(0, 10) }</TD>
      
      <td class="td_bs">
        <c:choose>
          <c:when test="${categrpVO.visible == 'Y'}">
            <a href="./update_visible?categrpno=${categrpno }&visible=${categrpVO.visible }"><IMG src="./images/open.png" style='width: 18px;'></a>
          </c:when>
          <c:otherwise>
            <a href="./update_visible?categrpno=${categrpno }&visible=${categrpVO.visible }"><IMG src="./images/close.png" style='width: 18px;'></a>
          </c:otherwise>
        </c:choose>
      </td>   
      
      <!-- 파라미터는 categrpno값 -->
      <td class="td_bs">
      	<!-- Get 방식 -->
        <a href="./read_update?categrpno=${categrpno }" title="수정"><span class="glyphicon glyphicon-pencil"></span></a>
        <a href="./read_delete?categrpno=${categrpno }" title="삭제"><span class="glyphicon glyphicon-trash"></span></a>
        <a href="./update_seqno_up?categrpno=${categrpno }" title="우선순위 상향"><span class="glyphicon glyphicon-arrow-up"></span></a>
        <a href="./update_seqno_down?categrpno=${categrpno }" title="우선순위 하향"><span class="glyphicon glyphicon-arrow-down"></span></a>         
      </td>   
    </tr>   
  </c:forEach> 
  </tbody>
 
</table>
 

</body>
 
</html> 
 
 
 