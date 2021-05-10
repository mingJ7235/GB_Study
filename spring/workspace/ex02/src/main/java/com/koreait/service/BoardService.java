package com.koreait.service;

import java.util.List;

import com.koreait.domain.BoardVO;

public interface BoardService {
	//서비스의 목적은 컨트롤러에서 편하게 사용하자! 이거다. 
	
	//게시판 등록
	public void register (BoardVO board);
	
	//특정 게시물 가져오기
	public BoardVO get(Long bno);
	
	//게시물 수정
	public boolean modify (BoardVO board);
	
	//게시물 삭제
	public boolean remove(Long bno);
	
	//전체 게시물 가져오기
	public List<BoardVO> getList();
}