console.log('*****Reply Module......')

//rest ful을 사용해보기 위해 작성
/*
 * 목록을 가져오려면 DB에서 가져와서 뿌려야함 -> read.jsp에서 그 작업을 함
 * 뿌려주는 역할을 read.jsp에 다시 와서 해주는 게 아니라 데이터만 요청해서 뿌려라 -> 이거를 지동기 통신 ajax가 함
 * 웹페이지가 열려있지만 비동기 통신할 수 있도록 정의된 게 breply.js -> ajax를 할 수 있도록 선언만 하고 있음
 * 선언된 것을 비동기 통신 요청을 해서 결과를 보여주고 싶고, 쏙 넣어주는 역할은 replyprocess
 * replyprocess :페이지가 로딩되며 목록을 부르고 비동기 통신을 하고 있고, get 페이지를
*/

var replyService = (function() { //함수 호출을 할당 -> 리턴 값 받을 수 있음 (있으면 받고, 없으면 안받고)
	
	function remove(rnum, callback, error){
		$.ajax({
			type: "delete",
			url: "./reply/" + rnum,
			success: function(result, status, xhr){
				if(callback){
					callback(result)
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		})//ajax end
	}//remove end
	
	
	function update(reply, callback,error){
		console.log("rnum:"+reply.rnum);
		
		$.ajax({
			type:'put',
			url:'./reply/'+reply.rnum,
			data:JSON.stringify(reply),
			contentType:"application/json;charset=utf-8",
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		})//ajax end
	}//updat end
	
	function add(reply, callback, error) {//F12 콘솔창에 출력
		console.log("add reply.............")

				
		$.ajax({
			type : 'post',
			url : './reply/create',
			data : JSON.stringify(reply),
			contentType : "application/json;charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result)
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er)

				}
			}
		});
	}
	
	function get(rnum, callback, error){
		$.get("./reply/" + rnum + ".json", function(result){
			if(callback){
				callback(result)
			}
		//요청에 실패가 있을 경우
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}

	function getList(param, callback) {
		var bbsno = param.bbsno;
		var sno = param.sno;
		var eno = param.eno;
		//alert(param.bbsno);
		//비동기 통신 부분 - 파라미터를 json 형식으로 받고 있음 (서버에서 데이터를 보낼 때, json타입으로 옴)
		$.getJSON("./reply/list/" + bbsno + "/" + sno + "/" + eno + ".json", //요청했을 때 응답한 데이터가 아래 function의 데이터
				function(data) {//응답되어진 데이터를 함수가 처리 (데이터 받는 게 성공했을 때)
					//alert(data);
					if (callback) {//정의되어져 있다면, 콜백에 데이터를 넣어 호출하겠다
						//요청받은 데이터 - replyprocess.jsp의 for 부분
						callback(data);
					}
				}
		);
	}
	
	function getPage(param, callback, error) {
		$.ajax({//{}안에 들어가 있는 것 : json 객체
			type : 'get',
			url : './reply/page',
			data : param,
			contentType : "application/text; charset=utf-8",
			success : function(result, status, xhr) {//result : 요청을 처리하는 컨트롤러에서 전달해준 값
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	};
	
	return {//이 함수가 갖고 있는 것 = json 객체 -> 함수가 호출한 곳으로 리턴되어짐
		getList: getList, //getLsit(이름) : getLsit(값 = 함수 - 위의 getList를 의미)
		getPage: getPage,
		add: add,
		get: get,
		update: update,
		remove: remove
	};
})(); //() : function()호출(실행) -> json 객체만 갖고 있음, 안의 함수는 아직 호출 안된 상태
