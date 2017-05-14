package org.kosta.springmvc15.controller.aop;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.springmvc15.model.aop.ReportService;
import org.kosta.springmvc15.model.aop.ReportVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	@Resource
	private ReportService reportService;
	
	@RequestMapping("report.do")
	public ModelAndView report(){
		List<ReportVO> list = reportService.selectReportRank();
		return new ModelAndView("report","list",list);
	}
}
