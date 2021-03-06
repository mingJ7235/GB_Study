/**
 * javascript reply ajax module 
 */

var replyService = (function(){ //replyService는 json타입이다!
	
	//댓글 추가 
	function add (reply, callback, error) {
		console.log("add reply ...");
		$.ajax ({
			type : "post",
			url : "/replies/new",	
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (xhr, status, err) {
				if(error) {
					error (err);
				}
 			}
		})
	}
	
	//댓글 목록
	function getList (param, callback, error) {
		console.log ("getList...");
		var bno = param.bno;
		var page = param.page;
		
		$.getJSON ("/replies/pages/"+bno+"/"+page+".json"  //".json"을 붙이지 않으면 xml데이터
			,function(data) {
				if(callback) {
					callback (data.replyCnt, data.list);
				}
			})
		.fail(function(xhr, status, err){
			if(error) {
				error(err);
			}
		})
	}
	
	//댓글 삭제
	function remove (rno, callback, error) {
		console.log("remove.....");
		$.ajax ({
			type : "delete",
			url : "/replies/" + rno,
			success : function (result) {
				if(callback) {
					callback (result);
				}
			},
			error : function (xhr, status, err) {
				if(error) {
					error(err)
				}
			}
		});
	}
	
	//댓글 수정
	function update (reply, callback, error) {
		console.log("update .....");
		
		$.ajax ({
			type : "PUT",
			url : "/replies/" + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function (result) {
				if(callback) {
					callback(result);
				}	
			},
			success : function (xhr, status, err) {
				if(error) {
					callback(err)
				}
			}
			
		})
	}
	
	//댓글 조회 
	function get(rno, callback, error) {
		$.getJSON ("/replies/" + rno +".json",
			function (result) {
				if(callback) {
					callback (result)
				}
			}
		).fail(function(xhr, status, err) {if(error) error(err);})
	}
	
	
	return {add : add, getList : getList, remove : remove, update, update, get : get} ;
}) ();





















