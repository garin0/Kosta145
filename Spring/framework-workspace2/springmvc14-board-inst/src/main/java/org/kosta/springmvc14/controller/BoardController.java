package org.kosta.springmvc14.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.springmvc14.model.BoardService;
import org.kosta.springmvc14.model.BoardVO;
import org.kosta.springmvc14.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController{
	@Resource(name="boardServiceImpl")
	private BoardService boardService;
	@RequestMapping("writeForm.do")
	public String writeForm(){
		return "board/write";
	}	
	/** 
	 * 게시글을 insert 
	 * 새로고침시 재입력을 막기 위해 redirect 시킨다. 
	 * post 방식일때만 등록가능
	 * 회원정보를 세션에서 반환받아 BoardVO에 할당한다 
	 */
	@RequestMapping(value="write.do",method=RequestMethod.POST)	
	public ModelAndView write(HttpServletRequest request,BoardVO bvo) {
		HttpSession session=request.getSession(false);
		if(session!=null){
			MemberVO mvo=(MemberVO) session.getAttribute("mvo");
			if(mvo!=null){
				bvo.setMemberVO(mvo);
			}
		}		
		boardService.write(bvo);
		return new ModelAndView("redirect:showContentNoHit.do?no="+bvo.getNo());
	}	
	/**
	 * 최근 게시물 5개를 보여주는 메서드
	 * @param request
	 * @param response
	 * @return
	 * @
	 */
	@RequestMapping("list.do")
	public ModelAndView list(String pageNo) {	
		return new ModelAndView("board/list","lvo",boardService.getBoardList(pageNo));
	}
	/**
	 * 게시글 조회 , 조회수 업데이트
	 * 개별 게시물 보여준다. 	
	 * @param request
	 * @param response
	 * @return
	 * @
	 */
	@RequestMapping("showContent.do")
	public ModelAndView showContent(int no) {		
		boardService.updateCount(no);	
		return new ModelAndView("redirect:showContentNoHit.do?no="+no);
	}
	/**
	 * 등록, 수정시 사용하는 개별 게시물 조회 메서드 
	 * @param no
	 * @return
	 * @
	 */
	@RequestMapping("showContentNoHit.do")
	public ModelAndView showContentNoHit(int no) {			
		return new ModelAndView("board/show_content","bvo",boardService.showContentNoHit(no));
	}	
	
	@RequestMapping("deleteBoard.do")
	public ModelAndView deleteBoard(int no) {		
		boardService.deleteBoard(no);		
		return new ModelAndView("board/list","lvo",boardService.getBoardList());
	}
	@RequestMapping("updateView.do")
	public ModelAndView updateView(int no) {
		return new ModelAndView("board/update","bvo"
				,boardService.showContentNoHit(no));
	}
	@RequestMapping("updateBoard.do")
	public ModelAndView updateBoard(BoardVO bvo) {
		boardService.updateBoard(bvo);
		return new ModelAndView("board/show_content","bvo",boardService.showContentNoHit(bvo.getNo()));
	}
	
}






















