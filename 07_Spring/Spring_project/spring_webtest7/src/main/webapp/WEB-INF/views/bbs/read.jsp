<%@ page contentType="text/html; charset=UTF-8" %> 

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">

<script type="text/javascript">
  //get, post, request 방식 모두 BbsController에 컨트롤러 만들어줘야함
  
    function updateM(){
      var url = "update"; //앞의 webtest/bbs/까지는 살아있기때문에 url 앞부분을 안적어도 됨 (슬래시로 절대경로로 다시 설정하면 경로가 바뀜)
      url += "?bbsno=${dto.bbsno}";
      url += "&oldfile=${dto.filename}";
      
      location.href=url; //get 방식
    }
    function deleteM(){
      var url = "delete"; //앞의 webtest/bbs/까지는 살아있기때문에 url 앞부분을 안적어도 됨 (슬래시로 절대경로로 다시 설정하면 경로가 바뀜)
      url += "?bbsno=${dto.bbsno}";
      url += "&oldfile=${dto.filename}";
      
      location.href=url;
    }

    function delete_Ajax(){
        var url = "delete_Ajax"; 
        url += "?bbsno=${dto.bbsno}";
        url += "&oldfile=${dto.filename}";

        location.href=url;
    }
    
    function replyM(){
        var url = "reply"; //앞의 webtest/bbs/까지는 살아있기때문에 url 앞부분을 안적어도 됨 (슬래시로 절대경로로 다시 설정하면 경로가 바뀜)
        url += "?bbsno=${dto.bbsno}";
        
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
			<div class="panel-body">${dto.viewcnt}</div>

			<div class="panel-heading">등록일</div>
			<div class="panel-body">${dto.wdate}</div>
			<!-- el표현은 null이 표시되지 않으므로 if일 필요가 없음 -->
			<div class="panel-heading">파일</div>
			<div class="panel-body">${dto.filename}</div>
		</div>

		<div>
			<button type="button" class="btn"
				onclick="location.href='./create.do'">등록</button>
			<button type="button" class="btn" onclick="updateM()">수정</button>
			<button type="button" class="btn" onclick="deleteM()">삭제</button>
			<button type="button" class="btn" onclick="delete_Ajax()">삭제2</button>
			<button type="button" class="btn" onclick="replyM()">답변</button>
			<button type="button" class="btn" onclick="listM()">목록</button>
		</div>
		
		<br>
		
		<div class='row'>
			<!-- 댓글 목록 시작 -->
			<div class="col-lg-12"> <!-- 부트스트랩 -->
				<!-- panel(댓글이 보여질 공간) start--> 
				<div class=" panel panel-default">

					<div class="panel-heading"> <!-- 댓글 제목 + 새로운 댓글을 클릭할 때 뜰 것 -->
						<i class="fa fa-comments fa-fw"></i> 댓글
						<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>
						New Reply</button>
					</div>

					<!-- 목록 출력 공간 -->
					<!-- 페이지가 로딩되면서 비동기 통신으로 이 부분이 보임  -->
					<div class="panel-body"> 
						<ul class="chat list-group">
							<!-- 사라질 공간 -->
							<li class="left clearfix" data-rno="12">
								<div>
									<div class="header">
										<strong class="primary-font">user1</strong> <small
											class="pull-right text-muted">2019-05-12</small>
									</div>
									<p>Good job!</p>
								</div>
							</li>
						</ul>
						<!-- ul end  -->
					</div>
					<!-- 댓글 페이징 -->
					<div class="panel-footer"></div>
				</div>
				<!-- panel end-->
			</div>
			<!--  col-lg-12 end -->
		</div>
		<!-- row end -->
	</div>
	<!-- container end -->

	<!-- Modal -->
	<!-- 수정 삭제 등록 처리도 포함되어 있음 -->
	<!-- 띄어쓰기 하면 클래스명 2개 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>내용</label>
						<textarea cols="10" rows="3" class="form-control" name='content'>New Reply!!!!</textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
					<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
					<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
					<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!-- 댓글 처리 관련 js 파일 추가(비동기 통신을 위한 js 공간) -->
	<!-- ajax 요청 부분 : 서버와 비동기 통신 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/breply.js"> //src : 자바스크립트 코드가 모듈별로 나누어 추가한 것 (양쪽 모두에서 사용할 수 있음)
	</script>
	
	<!-- 페이지 로딩시 댓글 목록 처리-->
	<!-- jstl내부 javascript에서 사용가능 -->
	<script type="text/javascript"> 
	  // replyprocess에서 쓸 변수들
	  var bbsno = "${dto.bbsno}"; <%-- <%=bbsno%>, ${bbsno}와 같음  : js파일에서 인식 못하는 경우가 있어서 이렇게 씀--%>
	  var sno = "${sno}";
	  var eno = "${eno}";
      // 댓글용 pading, 게시판 검색
	  var nowPage = "${param.nowPage}";
	  var colx = "${param.col}";
	  var wordx = "${param.word}";
	  var nPage = "${nPage}";
	  // 세션값 이용
	  var session_id ='${sessionScope.id}';//el로 표현하면 null이 아니라 빈값이 들어감
	 </script>
	 <!-- 비동기 통신 요청 후 전달된 데이터를 화면에 출력하는 코드 -->
	 <!-- 스크립트 타입과 주소를 설정했기 때문에 위에서 선언한 변수들을 사용할 수 있음 -->
	 <script type="text/javascript" 
	 		 src="${pageContext.request.contextPath}/js/replyprocess.js">
	 </script> 
</body>
</html>
