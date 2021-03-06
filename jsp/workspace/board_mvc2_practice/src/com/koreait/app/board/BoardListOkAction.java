package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;

public class BoardListOkAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO b_dao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		String temp = req.getParameter("page");
		
		//요청한 페이지가 없다는말 (null) 이라면 default로 1페이지를 응답해주고
		//요청한 페이지가 있다면 해당 페이지로 응답해주라는 말임. 
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		//한 페이지당 ?개의 게시글이 보이도록 설정
		int boardSize = 10;
		int pageSize = 10;
		
		//한 페이지에서 가장 마지막 행 번호
		int endRow = page * boardSize;
		
		//한 페이지에서 가장 첫번째 행 번호
		int startRow = endRow - (boardSize-1);
		
		//페이지 번호(가로)
		int startPage = ((page -1) / pageSize) * pageSize + 1;
		int endPage = startPage + (pageSize-1);
		
		int totalCnt = b_dao.getBoardCnt();
		
		int realEndPage = (totalCnt-1) / pageSize + 1;
		
		//삼항연산자에 넣기
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		//전달할값
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("boardList", b_dao.getBoardList(startRow, endRow));
		
		//전달할것을 기억해서 전달해야하니까 포워드에 담아서 전달
		forward.setRedirect(false);
		//한번은 jsp로 가줘야한다. 프론트로가면
		forward.setPath("/app/board/boardList.jsp");
		
		
		return forward;
	}
	
	
}
