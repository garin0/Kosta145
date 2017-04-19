package model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestLog {
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
			new TestLog().go();
		}

}
