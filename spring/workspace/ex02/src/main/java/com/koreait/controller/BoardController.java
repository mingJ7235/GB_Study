package com.koreait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.domain.BoardVO;
import com.koreait.service.BoardService;
import com.koreait.service.BoardServiceImple;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping ("/board/*") // board라는 요청이들어오면 여기로 들어오도록 한다! (톰켓의 모듈 루트는 /로 설정했다.)
@AllArgsConstructor
public class BoardController {
	
	//이걸로 주입해서 사용 ! 
	private BoardService service;
	
	//목록처리 메소드
	@GetMapping("/list")
	public void list (Model model) {
		log.info("list");
		//void로 리턴한다는건 views/board/list.jsp 라는 의미다. 요청을 이렇게 했기 때문이다.
		//void로 리턴하면 이 경로로 요청한 jsp의 주소를 리턴한다. 자동으로!!
		model.addAttribute("list", service.getList());
	}
	
	//등록 메소드
	@PostMapping ("/register")
	public String register(BoardVO board, /*Model model*/ RedirectAttributes rttr) { 
		//model은 결국 리퀘스트라는 내장객체를 사용하고 있는 것이다. 
		
		log.info("register:" + board);
		service.register(board);
		/*model.addAttribute("result", board.getBno());*/ //번호를 보내줘야한다. 그런데 리다이렉트라 model을 사용못함!
			//새롭게 등록된 번호를 .jsp에 전달하기 위해서는 
			//request객체에 담아야 한다. 하지만 redirect 방식으로 전송할 때에는
			//request가 초기화 된다. 따라서 session에 있는 Flash영역에 담아놓고
			//초기화된 request 객체에 전달해주면 결과값을 안전하게 이동시킬 수 있다.
			//이 때 RedirectAttributes를 이용한다. 
		
		rttr.addFlashAttribute("result", board.getBno()); //이렇게 사용하면 redirect방식으로 데이터를 전달할수있다!
				//flash라는 애는 session을 사용한다. 그렇기때문에 redirect를 해도 유지가 되는것이다. 
				//session에 flash라는 영역이 있다. flash에 담고 redirect가 된후에 전달하고 flash에서 없앤다. 잠깐 머무는 것이다. 
		
			//'redirect:'접두어를 사용하면 스프링 MVC가 내부적으로
			//response.sendRedirect()를 처리해준다. 
		return "redirect:/board/list"; //redirect방식으로 전달할때는 String타입으로 리턴하여 이렇게 전달해줘야한다. 등록은 redirect방식으로 전달해야하기때문이다.
										//쓰지않으면 forward바식으로 전달된다. forward가 디폴트값이기때문이다. redirect를 사용하면 초기화된다.
										//redirect로 데이터를 전달하면 model.addAttribute를 통해서 전달할수없기에 GET방식으로 url을 통해 보내야한다. 
										//그래서 GET방식으로 쿼리스트링으로 return "redirect:/board/list?result=board.getBno()";해도되지만!!
										//43번째줄처럼 RedirectAttributes 타입의 객체의 addFlashAttribute 메소드를 통해 보낼수있다.
										
	}
	
	//조회 메소드
	//@GetMapping("/get")
	/*public String read(long bno, RedirectAttributes rttr) {
		log.info("read");
		rttr.addFlashAttribute("read", service.get(bno));
		return "redirect:/board/list";
	}*/
	
	@GetMapping("/get")
	//RequestParam은 매개변수에 객체와 일반 변수가 동시에 있을 때 분리하기 위해 작성한다.
	//그러므로 매개변수에 (Long bno, 클래스타입 객체명) 이렇게있으면 못찾는다. 그렇기 때문에 requestParam을 통해서
	//제대로 찾도록 도와주는 것이다. 
	public void get(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board", service.get(bno));
	}
	
	//수정하기 즉 redirect로 보내줘야한다. 
	@PostMapping("/modify")
	//redirect쓸거면 당연히 리턴은 String이다. 
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify : " + board); //찍어보기 
		
		//수정되었을 때 result에 success를 보내기! 
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list"; //수정 완료한다음에 list로 갈것이므로 이렇게 return해주면된다. 
		//return "redirect:/board/get?bno=board.getBno()" //만약에 상세보기로 그 게시판에 보내고싶으면 이렇게!
	}
	
	@GetMapping("/remove") 
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove: " + bno);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	
	
	
}









