$(function() {//read.jsp 페이지가 로딩될 때(보여질 때) 자동 호출 
	showList();//showList 호출
});// page loading function end...?

var replyUL = $(".chat");//class가 chat인 것을 찾아 할당
function showList() {
	//breply 함수 호출한 것과 같음
	replyService.getList({
		bbsno : bbsno,
		sno : sno,
		eno : eno
	},//레이블 접근 -> getList 호출 (레이블이 갖고 있던 함수가 리턴 + 호출) / 값은 read.jsp에 있던 것
	function(list) {//목록 생성 - json배열
		//데이터를 받아와서 길이가 없다면 그대로 리턴
		var str = "";
		if (list == null || list.length == 0) {
			return;
		}

		//reply가 몇개나 있는지 확인
		for (var i = 0, len = list.length || 0; i < len; i++) {
			str += "<li class='list-group-item' data-rnum='" + list[i].rnum
					+ "'>";
			str += "<div><div class='header'><strong class='primary-font'>"
					+ list[i].id + "</strong>";
			str += "<small class='pull-right text-muted'>" + list[i].regdate
					+ "</small></div>";
			str += replaceAll(list[i].content, '\n', '<br>') + "</div></li>";
		}

		replyUL.html(str);//제이쿼리 함수

		showReplyPage();
	}//function end
	);//getList end
}//showList end

function replaceAll(str, searchStr, replaceStr) {
    return str.split(searchStr).join(replaceStr);
}

var replyPageFooter = $(".panel-footer");

var param = "nPage="+nPage;
param += "&nowPage="+nowPage;
param += "&bbsno="+bbsno;
param += "&col="+colx;
param += "&word="+wordx;

function showReplyPage(){

	//alert(param);
	//bereply의 function getPage 부분에 전달되는 값이 들어옴
	replyService.getPage(param,
			function(paging){
				console.log(paging);

				var str = "<div><small class='text-muted'>" + paging
						+ "</small></div>";
				replyPageFooter.html(str);
			})
}//showReplyPage end

// 버튼 찾기
var modal = $(".modal");
var modalInputContent = modal.find("textarea[name='content']");
var modalModBtn = $("#modalModBtn");
var modalRemoveBtn = $("#modalRemoveBtn");
var modalRegisterBtn = $("#modalRegisterBtn");

// 모달 버튼을 누르는 순간 사라지게 하는 것
$("#modalCloseBtn").on("click", function(e) {
	modal.modal('hide');
});

$("#addReplyBtn").on("click", function(e) {
	//로그인이 되어 있을 때 모달창 뜨도록
	//if(${sessionScope.id}) - js파일에서는 el표현이 잘 구동되지 않음
	//그래서 read.jsp에서 선언해주고 가져와서 쓰는 방식
	if(session_id == ""){//로그인이 안되어 있다면(= 값이 비어있다면)
		if(confirm('로그인 후 댓글을 쓸 수 있습니다')) {//alert은 알려만 주는 것, confirm은 확인 취소를 누를 수 있음
			var url = "../member/login";//상위경로로 이동하는 느낌을 주는 게 ../
			//read페이지로 왔을 때 read가 필요로 하는 것
			/* 
			 * - ?와 &의 차이
			 * ? : 이제부터 주소가 아니고 파라미터야~ (주소와 파라미터를 구분해주는 것)
			 * & : 파라미터가 하나가 아니고 여러개야~ 
			 */
			url += "?col=" + colx;
			url += "&word=" + wordx;
			url += "&nowPage=" + nowPage;
			url += "&nPage=" + nPage;
			url += "&bbsno=" + bbsno;
			url += "&rurl=../bbs/read"; //rurl : reply url이라는 변수명
			location.href = url;
		}//confirm end
	}else {
		modalInputContent.val("");
		modal.find("button[id != 'modalCloseBtn']").hide()
		modalRegisterBtn.show();
		
		$(".modal").modal("show");		
	}//session_id end
});//addReplyBtn on end

modalRegisterBtn.on("click", function(e) {
	if (modalInputContent.val() == '') {
		alert("댓글을 입력하세요");
		return;
	}

	var reply = {
		content : modalInputContent.val(),
		id : session_id,
		bbsno : bbsno
	};

	replyService.add(reply, function(result) {
		modal.find("input").val("");
		modal.modal("hide");

		showList();

	});//add end
})//button click end

$(".chat").on("click", "li", function(e) {
	var rnum = $(this).data("rnum");
	replyService.get(rnum, function(reply) {
		modalInputContent.val(reply.content);
		modal.data("rnum", reply.rnum);//기존의 넣었던 값을 이 값으로 할당
		modal.find("button[id != 'modalCloseBtn']").hide();
		
		//id가 같을 경우에만 수정버튼과 삭제 버튼이 뜨도록
		if(session_id == reply.id){//로그인 한 id와 댓글 아이디가 같을 때만
			modalModBtn.show();
			modalRemoveBtn.show();
						
			modal.modal("show");
		}
		
	})//get end
})//.chat click end

modalModBtn.on("click",function(e){
	var reply = {
			rnum:modal.data("rnum"),
			content:modalInputContent.val()
	};

	replyService.update(reply,function(result){
		modal.modal("hide");
		showList();
	}); //update end

});//modalModBtn on end

modalRemoveBtn.on("click", function(e) {
	var rnum = modal.data("rnum");
	replyService.remove(rnum, function(result) {
		modal.modal("hide");
		showList();
	});//remove end
});//modalRemoveBtn on end
	