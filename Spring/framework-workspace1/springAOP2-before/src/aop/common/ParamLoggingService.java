package aop.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

// 공통 관심 사항 정의 클래스
public class ParamLoggingService {
	private Log log = LogFactory.getLog(getClass());

	public void beforeLogging(JoinPoint point) {
		// 대상 메서드(Target)가 전달받는 데이터

		Object params[] = point.getArgs();
		// 대상클래스명 메서드명 인자값...
		String className = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		String data = "";
		for (int i = 0; i < params.length; i++) {
			data += params[i] + " ";
		}
		log.info(className + " " + methodName + " " + data);
	}
}
