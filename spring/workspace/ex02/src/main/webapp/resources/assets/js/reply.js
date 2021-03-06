/**
 * javascript의 모듈화
	함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
	화면 내에서 Javascript 처리를 하다 보면 1) 이벤트 처리, 2) DOM, 3) Ajax 처리 등이 섞여있다. 
	복잡하게 섞여서 유지보수가 힘들다. 
	따라서 Javascript를 하나의 모듈처럼 구성하여 사용한다. 

 */

console.log("Reply Module.....");


var replyService = (function() {
	/** 자바스크립트에서 객체로 넘기는 방법 : json으로 넘기는 것이다. 
		json toString으로 넘겨야한다. 
	 */
	function add (reply, callback, error) { /** reply가 json으로 넘겨질 것이다. 또한 js는 매개변수가 3개여도 다 전달안해도*/
		/* callback과 error는 함수를 전달 한다.
		 */
		console.log("add reply......");
		$.ajax({
			type : "post", /** replycontroller 에 있는 댓글등록의 전달방식이 Post이기때문이다. */
			url : "/replies/new",
			data : JSON.stringify(reply), /** json타입인 reply를 전달한다. 
								JSON으로 값을 전달할때는 항상 문자열로 전달한다. 
								그런데 key값에도 쌍따옴표를 써줘야한다. 
								그런데, googlejson에서는 JSON.stringify 라는 라이브러리를 제공하여서 key값과 value값에
								쌍따옴표를 붙여줘서 문자열로 만들어줌. (datatype은 내가 전달받을 데이터 ) json타입으로 보내는 것이다. */ 
			contentType :"application/json; charset=utf-8",/**전달할  데이터 타입 */
			success : function (result) { /** success는 callback / success를 담아줄 매개변수 -> result */
				if(callback) { /** callback이 전달되었는지 판단. if문에들어오면 boolean타입이 된다 result가 컨트롤러에 담기게 된다. */
					callback (result);
				}
			},
			error : function (xhr, status, er) /** error는 error를 */{
				if(error) {
					error(er);
				}
				
			}
			
		});	
	}
	
	function getList (param, callback, error) {
		
		/** 구글 제이슨에 있는 것이다 간단하다. get은 get방식이라는 의미이다. 1번째는 url, 2번째는 success(callback) 그 후에 fail을서서 error를 잡는다.*/
		
		var bno = param.bno;
		var page = param.page || 1; /** param.page가 전달이안되면 1이다 라는 의미 */
		$.getJSON ("/replies/list/" + bno + "/" + page +".json", /** json데이터화 하기위해서 .json을 붙여준다. 디폴트가 xml형식이다. */ 
			function(data){
				//getList 컨트롤러에서는 댓글 목록과 댓글 전체 개수를 응답해준다. 
				//따로 전달받지 않고 ReplyPageDTO객체로 한 번에 전달 받는다. 
				if(callback) {
					callback(data.replyCnt, data.list); // callback 함수에 전체 개수와 목록을 따로 전달해준다. 
				}
			}).fail(function(xhr, status, err){
				if(error) {
					error(err);
				}
			});
	}
	
	//댓글 삭제
	/*function removeReply (param, callback, error) {
		var rno = param.rno;
		$.getJSON ("/replies/" + rno + ".json",
			function(data) {
				if(callback) {
					callback(data);
				}
			}).fail(function(xhr, status, err) {
				if(error) {
					error(err);
				}
			});
	} */
	
	function remove (rno, callback, error) {
		$.ajax({
			type:"delete",
			url:"/replies/" + rno,
			success: function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (xhr, status, err) {
				if(error) {
					error(err);
				}
			}
			
		})
	}
	
	function modify (reply, callback, error) {
		console.log("RNO : " + reply.rno);
		
		$.ajax ({
			type : "put",
			url : "/replies/" + reply.rno,
			data : JSON.stringify(reply),
			contentType :"application/json; charset=utf-8",
			success: function(result) {
				/*console.log("UPDATE : " +result);*/
				if(callback) {
					callback(result);
				}
			},
			error : function(xhr, status, err) {
				/*console.log("ERROR");*/
				if(error){
					error(err);
				}
				
			}
			
		})
	}
	
	function get (rno, callback, error) {
		$.getJSON("/replies/" + rno +".json", function (result){
			if(callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error) {
				error(err);
			}
		})
	}
	
	return {add : add, getList : getList, remove : remove, modify: modify, get : get /*removeReply :removeReply*/ }
	
	/*return {name : "AAAA"}*//** replyService의 리턴값이 제이슨형식이*/
})(); /*function을 선언하자마자 바로 실행한다.*/ ;


/**
/**
 * Javascript의 모듈화
 *    함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
 *    화면 내에서 Javascript 처리를 하다 보면 이벤트 처리와 DOM, Ajax 처리 등
 *    복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript를 하나의 모듈처럼 구성하여
 *    사용한다.
 */

/*console.log("Reply Module.........");

var replyService = (function(){
   
   function add(reply, callback, error){
      console.log("add reply..........");
      $.ajax({
         type: "post",
         url: "/replies/new",
         data: JSON.stringify(reply),
         contentType: "application/json; charset=utf-8",
         success: function(result){
            if(callback){
               callback(result);
            }
         },
         error: function(xhr, status, er){
            if(error){
               error(er);
            }
         }
      });
   }
   
   function getList(param, callback, error){
      var bno = param.bno;
      var page = param.page || 1;
      $.getJSON("/replies/pages/" + bno + "/" + page + ".json", 
            function(data){
               if(callback){callback(data);}
      }).fail(function(xhr, status, err){
               if(error){error(err);}
      });
   }
   
   function remove(rno, callback, error){
      $.ajax({
         type:"delete",
         url:"/replies/" + rno,
         success:function(result){
            if(callback){
               callback(result);
            }
         },
         error:function(xhr, status, err){
            if(error){
               error(err);
            }
         }
      });
   }
   
   function modify(reply, callback, error){
      console.log("RNO : " + reply.rno);
      
      $.ajax({
         type: "put",
         url: "/replies/" + reply.rno,
         data: JSON.stringify(reply),
         contentType: "application/json; charset=utf-8",
         success:function(result){
            if(callback){callback(result);}
         },
         error: function(xhr, status, err){
            if(error){error(err);}
         }
      });
   }
   
   function get(rno, callback, error){
      $.get("/replies/" + rno + ".json", function(result){
         if(callback){callback(result);}
      }).fail(function(xhr, status, err){
         if(error){
            error(err);
         }
      })
   }
   
   return {add : add, getList : getList, remove : remove, modify : modify, get : get}
})();*/









































