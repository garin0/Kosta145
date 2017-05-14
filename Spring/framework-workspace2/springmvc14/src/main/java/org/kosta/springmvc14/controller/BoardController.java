package org.kosta.springmvc14.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.kosta.springmvc14.model.BoardService;
import org.kosta.springmvc14.model.BoardVO;
import org.kosta.springmvc14.model.ListVO;
import org.kosta.springmvc14.model.PagingBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Resource
	private BoardService service;
	
	@RequestMapping("index.do")
	public String home(HttpServletRequest request,Model model){
		int total = service.getTotalContent();
		PagingBean pb = null;
		pb = new PagingBean(total);
		int start = pb.getStartRowNumber();
		int end = pb.getEndRowNumber();
		List<ListVO> list = service.getAllBoardList(start, end);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("total", total);
		map.put("pb", pb);
		model.addAttribute("map",map);
		return "board/list";
	}
	@RequestMapping("list.do")
	public String list(HttpServletRequest request,Model model){
		int total = service.getTotalContent();
		int pageNO = Integer.parseInt(request.getParameter("page"));
		PagingBean pb = null;
		if(pageNO!=0){
			pb = new PagingBean(total,pageNO);
		}else{
			pb = new PagingBean(total);
		}
		int start = pb.getStartRowNumber();
		int end = pb.getEndRowNumber();
		List<ListVO> list = service.getAllBoardList(start, end);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("total", total);
		map.put("pb", pb);
		model.addAttribute("map",map);
		return "board/list";
	}
	@RequestMapping("board_writeView.do")
	public String writeView(){
		return "board/write";
	}
	@RequestMapping("board_write.do")
	public String write(BoardVO vo,HttpServletRequest request,Model model){
		service.write(vo);
		model.addAttribute("bvo", vo);
		return "redirect:board_showContent.do?no="+vo.getNo();
	}
	@RequestMapping("board_showContent.do")
	public String showContent(HttpServletRequest request,Model model,BoardVO vo){
		int no = Integer.parseInt(request.getParameter("no"));
		vo = service.showContent(no);
		model.addAttribute("bvo", vo);
		return "board/show_content";
	}
	
	@RequestMapping("board_showContentHit.do")
	public String showContentHit(HttpServletRequest request,Model model){
		int no = Integer.parseInt(request.getParameter("no"));
		service.updateHit(no);
		BoardVO vo = service.showContent(no);
		model.addAttribute("bvo", vo);
		return "board/show_content";
	}
	@RequestMapping("board_updateView.do")
	public String updateView(HttpServletRequest request,Model model){
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = service.showContent(no);
		model.addAttribute("bvo", vo);
		return "board/update";
	}
	@RequestMapping("board_update.do")
	public String update(HttpServletRequest request,Model model,BoardVO vo){
		int no = Integer.parseInt(request.getParameter("no"));
		service.update(vo);
		model.addAttribute("bvo", vo);
		return "redirect:board_showContent.do?no="+no;
	}
	@RequestMapping("board_deletePosting.do")
	public String deletePosting(HttpServletRequest request){
		int no = Integer.parseInt(request.getParameter("no"));
		service.deletePosting(no);
		return "redirect:index.do";
	}

}
