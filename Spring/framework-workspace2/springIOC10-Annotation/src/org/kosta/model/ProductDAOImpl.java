package org.kosta.model;

import org.springframework.stereotype.Repository;
// 영속성 계층에서 사용하는 어노테이션
// Spring Container에 의해 객체 생성된다.
@Repository
public class ProductDAOImpl implements ProductDAO {

	@Override
	public String findProductById(String id) {
		return "상품정보";
	}

}
