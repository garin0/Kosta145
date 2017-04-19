package model;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductService {
	private Log log = LogFactory.getLog(getClass());
	public void deleteProduct(){
		log.info("실행");
		System.out.println("deleteProduct");
	}
	public void findProductById(){
		log.info("실행");
		System.out.println("findProductById");
	}
}
