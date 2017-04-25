package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * log4j:  프로그램 작성시 로그를 남기기 위해 사용되는 자바 기반 로깅 라이브러리
        설정 파일에 대상별(자바에서는 패키지)로 
        레벨을 지정이 가능하고 그 등급 이상의 로그만 저장하는 방식이다.

FATAL(가장 높은 로그레벨)
ERROR
WARN
INFO
DEBUG
TRACE(가장 낮은 로그레벨)
 */
public class TestLog4J {
	//log4j 객체 생성
	private Log log = LogFactory.getLog(getClass());
	public void go(){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
		log.fatal("fatal test");
	}
	public static void main(String[] args) {
		new TestLog4J().go();
	}

}
