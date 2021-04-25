<%@ page contentType="text/html; charset=UTF-8" %> 

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">

<script type="text/javascript"> //get, post, request 방식 모두 BbsController에 컨트롤러 만들어줘야함
  
    function updateM(){
      var url = "update"; //앞의 webtest/bbs/까지는 살아있기때문에 url 앞부분을 안적어도 됨 (슬래시로 절대경로로 다시 설정하면 경로가 바뀜)
      url += "?noticeno=${dto.noticeno}";
      
      location.href=url; //get 방식
    }
    function deleteM(){
      var url = "delete"; //앞의 webtest/bbs/까지는 살아있기때문에 url 앞부분을 안적어도 됨 (슬래시로 절대경로로 다시 설정하면 경로가 바뀜)
      url += "?noticeno=${dto.noticeno}";
      
      location.href=url;
    }
    
    function listM(){
        var url = "list"; //앞의 webtest/bbs/까지는 살아있기때문에 url 앞부분을 안적어도 됨 (슬래시로 절대경로로 다시 설정하면 경로가 바뀜)
        url += "?nowPage=${param.nowPage}";
        url += "&col=${param.col}";
        url += "&word=${param.word}";
        location.href=url;
      }
  </script>

</head>
<body>
	<div class="container">
		<h2>조회</h2>
		<div class="panel panel-default">
			<div class="panel-heading">작성자</div>
			<div class="panel-body">${dto.wname}</div>

			<div class="panel-heading">제목</div>
			<div class="panel-body">${dto.title}</div>

			<div class="panel-heading">내용</div>
			<div class="panel-body">${dto.content}</div>

			<div class="panel-heading">조회수</div>
			<div class="panel-body">${dto.cnt}</div>

			<div class="panel-heading">등록일</div>
			<div class="panel-body">${dto.rdate}</div>
		</div>
		<div>
			<button type="button" class="btn"
				onclick="location.href='./create.do'">등록</button>
			<button type="button" class="btn" onclick="updateM()">수정</button>
			<button type="button" class="btn" onclick="deleteM()">삭제</button>
			<button type="button" class="btn" onclick="listM()">목록</button>
		</div>
	</div><!-- container end -->
</body>
</html>
