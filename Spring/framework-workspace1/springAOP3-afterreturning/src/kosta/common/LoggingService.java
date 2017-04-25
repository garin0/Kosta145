package kosta.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LoggingService {
	private Log log = LogFactory.getLog(getClass());

	public void testLog(JoinPoint point, Object retValue) {
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		log.info(className + " " + methodName + " 리턴정보:" + retValue);
	}
}
