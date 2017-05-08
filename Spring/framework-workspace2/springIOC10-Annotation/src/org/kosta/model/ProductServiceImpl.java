package org.kosta.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 비즈니스 계층에서 사용하는 어노테이션
// Spring Container에 의해 객체 생성된다.
@Service
public class ProductServiceImpl implements ProductService {
	// ProductDAO 인터페이스 타입의 구현체를 주입시킨다.
	// 만약 ProductDAO 인터페이스 타입의 구현체가 여러개일 경우에는 Exception 발생한다.
	// @Resource(name="bean id")
	// @Autowired
	// ProductDAOImpl2 클래스가 스프링 컨테이너에 의해 생성되면 bean id는 productDAOImpl2가 되므로
	// 이를 이용해 bean id를 직접 명시하는 방법으로 주입받으면 된다.
	@Resource(name = "productDAOImpl2")
	private ProductDAO productDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.kosta.model.ProductService#findProductById(java.lang.String)
	 */
	@Override
	public String findProductById(String id) {
		return productDAO.findProductById(id);
	}
}
