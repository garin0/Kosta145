package org.kosta.springmvc15.aop;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.kosta.springmvc15.model.ProductVO;
import org.kosta.springmvc15.model.aop.ReportService;
import org.kosta.springmvc15.model.aop.ReportVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Aspect
public class ReportAspect {
	
	@Resource
	private ReportService reportService;
	
	@Around("execution(public java.util.List org.kosta.springmvc15.model.*Service.find*List*(..))")
	public Object checkSearch(ProceedingJoinPoint point){
		/*String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();*/
		Object retValue = null;
		Object[] ob = point.getArgs();
		String keyword = (String) ob[0];
	
		try {
			retValue = point.proceed();
			@SuppressWarnings("unchecked")
			List<ProductVO> list = (List<ProductVO>)retValue;
//			System.out.println(className+" "+methodName);
//			System.out.println("검색어: "+keyword);
			ReportVO vo = reportService.selectReport(keyword);
			if(!list.isEmpty()){
				if(vo == null){
					reportService.insertReport(keyword);
					System.out.println("insert");
				}else{
					reportService.updateReport(keyword);
				}
			}else{
				System.out.println("검색어 없음");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return retValue;
		
	}
	
}
