package org.kosta.springmvc15.model.aop;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;	
	
	public ReportVO selectReport(String keyword){
		return sqlSessionTemplate.selectOne("report.selectKeyword", keyword);
	}
	
	public int insertReport(String keyword){
		return sqlSessionTemplate.insert("report.insertReport", keyword);
	}
	
	public int updateReport(String keyword){
		return sqlSessionTemplate.update("report.updateReport", keyword);
	}
	
	public List<ReportVO> selectReportRank(){
		return sqlSessionTemplate.selectList("report.selectReportRank");
	}
}
