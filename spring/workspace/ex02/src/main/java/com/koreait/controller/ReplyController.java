package com.koreait.controller;



import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.domain.Criteria;
import com.koreait.domain.ReplyPageDTO;
import com.koreait.domain.ReplyVO;
import com.koreait.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController //restcontroller는 자동으로 view resolver로 가지 않는다.즉, return을 내마음대로 할수 있다.
				//각 메소드의 리턴은 ViewResolver로 가지 않으므로 매소드의 return값을 그대로 리턴한다. (뒤에 .jsp가 붙지않는다.)
@Log4j
public class ReplyController {
	
	@Setter (onMethod_ = @Autowired)
	private ReplyService service;
	
	//댓글 작성
	
	//문자열을 전달할 때 한글이 깨지지 않게 하기 위해서는 text/plain; charset=utf-8를 작성한다. 
	@PostMapping (value ="/new", consumes ="application/json", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> register (@RequestBody ReplyVO reply) throws UnsupportedEncodingException{
		log.info("등록된 댓글 : " + reply);
		return service.register(reply) == 1 ? new ResponseEntity<>(new String("댓글 등록 성공".getBytes(),"UTF-8"), HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//댓글 목록
	
	@GetMapping (value ="/list/{bno}/{page}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	//서비스에 있는 getListWithPaging은 댓글 목록과 댓글 전체 개수 두 개를 가지고 있는 ReplyPageDTO 타입이다. 
	//그렇기때문에 리턴타입의 제네릭에 ReplyPageDTO를 써준것이다. 
	public ResponseEntity<ReplyPageDTO> getList (@PathVariable("bno") Long bno,@PathVariable ("page") int page) {
		log.info("list");
		Criteria cri = new Criteria(page, 10);
		log.info(cri);
		
		return new ResponseEntity<ReplyPageDTO>(service.getListWithPaging(cri, bno), HttpStatus.OK);
	}
	
	//댓글 조회
	
	@GetMapping (value="/{rno}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE}) 
	public ResponseEntity<ReplyVO> get (@PathVariable("rno") Long rno) {
		log.info("get");
		return new ResponseEntity<ReplyVO>(service.get(rno), HttpStatus.OK);
	}
	
	//댓글 수정
	@RequestMapping (method = {RequestMethod.PUT, RequestMethod.PATCH}, value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (@RequestBody ReplyVO reply, @PathVariable("rno") Long rno) {
		reply.setRno(rno);
		
		return service.modify(reply) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//댓글 삭제
	
	@DeleteMapping (value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete (@PathVariable("rno") Long rno) {
		log.info("delete");
		return service.remove(rno) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK): new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}






































