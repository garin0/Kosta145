package org.kosta.controller;

import javax.annotation.Resource;

import org.kosta.model.ProductService;
import org.springframework.stereotype.Controller;

// 컨트롤러에 명시하는 어노테이션
@Controller
public class ProductController {
	// 컨테이너에게 ProductService 타입의 구현체를 주입하라고 명시
	// @Autowired
	// 아래와 같이 별도의 bean id를 명시하지 않으면 @Autowired 처럼 타입으로 검색해서 주입한다.
	@Resource
	private ProductService productService;

	public String findProductById(String id) {
		return productService.findProductById(id);
	}
}
