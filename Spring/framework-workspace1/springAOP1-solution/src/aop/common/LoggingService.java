package aop.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

// 공통 관심 사항을 정의하는 클래스
public class LoggingService {
	private Log log = LogFactory.getLog(getClass());

	public void beforeLogging(JoinPoint point) {
		// System.out.println("aop 실행^^");
		// Core 적용대상 클래스명을 반환
		String className = point.getTarget().getClass().getName();
		// Core 적용대상 메서드명을 반환
		String methodName = point.getSignature().getName();
		log.info(className+" "+methodName);
	}
}
