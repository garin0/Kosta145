package aop.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import kosta.member.MemberNotFoundException;

@Component
@Aspect
public class PerformanceReportService {
	private Log log = LogFactory.getLog(getClass());
	// adivce와 pointcut을 어노테이션으로 명시한다.
	@Around("execution(public * kosta..*Service.*(..))")
	public Object checkTime(ProceedingJoinPoint point) throws Throwable {
		StopWatch sw = new StopWatch();
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		Object retValue = null;
		sw.start();
		try {
			retValue = point.proceed();
		} catch (MemberNotFoundException e) {
			throw e;
		} finally {
			sw.stop();
			if (sw.getTotalTimeMillis() > 500 && sw.getTotalTimeMillis() <= 1000) {
				log.warn(className + " " + methodName + " time:" + sw.getTotalTimeMillis());
			} else if (sw.getTotalTimeMillis() >= 1000) {
				log.error(className + " " + methodName + " time:" + sw.getTotalTimeMillis());
			}
		}
		return retValue;
	}
}
