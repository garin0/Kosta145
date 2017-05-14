package org.kosta.springmvc15.model.aop;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ReportService {
	@Resource
	private ReportDAO reportDAO;
	
	public ReportVO selectReport(String keyword){
		return reportDAO.selectReport(keyword);
	}
	public int insertReport(String keyword){
		return reportDAO.insertReport(keyword);
	}
	public int updateReport(String keyword){
		return reportDAO.updateReport(keyword);
	}
	public List<ReportVO> selectReportRank(){
		return reportDAO.selectReportRank();
	}
}
