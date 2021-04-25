<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html> 
<head>
  <title>글삭제</title>
  <meta charset="utf-8">
  <style type="text/css">
  #red{
    color:red;
  }
  </style>
  <script type="text/javascript">
	$(function(){
		//삭제버튼을 누를때 페이지가 로딩되면서 id=btn1인거를 찾겠다
		//# -> id 
		//on -> 이벤트 설정
		$('#btn1').on('click', function(){
			//비동기 통신으로 데이터를 요청할 때
			var form = {
						//해석 : bbsno가 갖고 있는 input태그(어떤 태그인지 알아야함)인 밸류 값을 가져와라
						//Json 객체로 형성
						bbsno : $('#bbsno').val(),
						passwd : $('#passwd').val(),
						filename: $('#oldfile').val()
						}
			//비동기 통신
			//alert(form.bbsno);
			
			$.ajax({
	            url: "./delete_Ajax",
	            //post 매핑 선언해야함
	            type: "POST",
	            data : JSON.stringify(form),
	            //header한테 알려주는 것
	            contentType: "application/json; charset=utf-8;",
	            //ajax 비동기 통신을 했을 때, 결과값에 대한 형식을 json형식으로 받아올 것이다
	            dataType: "json",
	            success: function(data){
	             	//아이디가 red인 것에 text형식을 지우고, json 객체 중 str이라는 이름을 갖고 있는 밸류 값을 뿌려주겠다
	             	//json 형식 : .(온점)
	             	//alert("success")
	                $('#red').text('');
	                $('#red').text(data.str);
	                $('#red').css('color', data.color);
	            },
	            error: function(request,status,error){
	             alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
	            }
	        });//Ajax end
		});//버튼 이벤트 설정		
	});//페이지 로딩
  </script>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${flag}">
				<div class='well well-lg'>
					답변있는 글이므로 삭제할 수 없습니다.<br> <br>
					<button class='btn' onclick='history.back()'>다시시도</button>
					<br>
				</div>
			</c:when>
			<c:otherwise>
				<h1 class="col-sm-offset-2 col-sm-10">삭제</h1>
					<input type="hidden" name="bbsno" id="bbsno" value="${param.bbsno}">
					<!-- 포워드 방식이기때문에 request로 받아올 수 있음 -->
					<input type="hidden" name="oldfile" id="oldfile" value="${param.oldfile}">
					<div class="form-group">
						<label class="control-label col-sm-2" for="passwd">비밀번호</label>
						<div class="col-sm-6">
							<input type="password" name="passwd" id="passwd" class="form-control">
						</div>
					</div>

					<p id="red" class="col-sm-offset-2 col-sm-6">삭제하면 복구할 수 없습니다</p>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-5">
							<!-- 얘에 대한 이벤트 설정을 위에서 해줌 (Jquery로 - 자바스크립트를 쉽게 사용할 수 있도록 만들어준것) -->
							<button  class="btn" id="btn1">삭제</button>
							<button type="reset" class="btn">취소</button>
						</div>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>