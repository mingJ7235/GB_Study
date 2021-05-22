package com.joshua.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joshua.domain.Criteria;
import com.joshua.domain.ReplyPageDTO;
import com.joshua.domain.ReplyVO;
import com.joshua.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImple implements ReplyService{
	
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO reply) {
		return mapper.insert(reply);
	}
	
	@Override
	public ReplyVO getReply(long rno) {
		return mapper.read(rno);
	}
	
	@Override
	public ReplyPageDTO getListWithPaging(Criteria cri, long bno) {
		return mapper.getListWithPaging(cri, bno);
	}
	
	@Override
	public int update(ReplyVO reply) {
		return mapper.update(reply);
	}
	
	@Override
	public int delete(long rno) {
		return mapper.delete(rno);
	}
}
