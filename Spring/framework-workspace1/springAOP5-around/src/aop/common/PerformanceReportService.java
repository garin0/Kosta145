package aop.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import kosta.member.MemberNotFoundException;

public class PerformanceReportService {
	private Log log = LogFactory.getLog(getClass());

	public Object checkTime(ProceedingJoinPoint point) throws Throwable {
		StopWatch sw = new StopWatch();
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		Object retValue = null;
		try {
			sw.start();
			retValue = point.proceed();
		} catch (MemberNotFoundException e) {
			throw e;
		} finally {
			sw.stop();
			if (sw.getTotalTimeMillis() > 500 && sw.getTotalTimeMillis() <= 1000) {
				log.warn(className + " " + methodName + " time:" + sw.getTotalTimeMillis());
			}else if(sw.getTotalTimeMillis() >=1000){
				log.error(className + " " + methodName + " time:" + sw.getTotalTimeMillis());
			}
		}
		return retValue;
	}
}
