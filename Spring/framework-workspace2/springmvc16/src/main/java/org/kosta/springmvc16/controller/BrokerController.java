package org.kosta.springmvc16.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.springmvc16.model.BrokerService;
import org.kosta.springmvc16.model.CustomerVO;
import org.kosta.springmvc16.model.SharesVO;
import org.kosta.springmvc16.model.StockVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrokerController {

	@Resource
	private BrokerService service;
	
	@RequestMapping("stockmarket.do")
	public String stockmarket(Model model,HttpServletRequest request){
		model.addAttribute("stockList", service.stockList());
		return "stock_market";
	}
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, CustomerVO vo,Model model) {		
		CustomerVO cvo = service.login(vo);
		String go = "";
		if (cvo != null) {
			request.getSession().setAttribute("cvo", cvo);		
			model.addAttribute("sharesList", service.sharesList(cvo.getId()));
			model.addAttribute("stockList", service.stockList());
			go = "stock_market";
		}else{
			go = "login_fail";
		}
		return go;
	}	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "redirect:stockmarket.do";
	}	
	
	@ResponseBody
	@RequestMapping("stockTrans.do")
	public List<SharesVO> stockTrans(SharesVO vo,String trans){
		SharesVO svo = service.findStock(vo);
		if(trans.equals("매수")){
			if(svo == null){ //insert
				service.buyStock(vo);
			}else{ //update
				service.updateStock(vo);
				System.out.println(vo);
			}
		}else{ //매도
			service.sellStock(vo);
		}
		return service.sharesList(vo.getId());
	}

}
