package org.kosta.model;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl2 implements ProductDAO {

	@Override
	public String findProductById(String id) {
		return "상품정보 ver2";
	}

}
