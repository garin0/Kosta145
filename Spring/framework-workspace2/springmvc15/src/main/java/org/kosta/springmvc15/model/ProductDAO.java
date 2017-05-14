package org.kosta.springmvc15.model;

import java.util.List;

public interface ProductDAO {
	public int registerProduct(ProductVO productVO);

	public ProductVO findProductById(String id);

	public List<ProductVO> findProductListByName(String name);
	
	public List<ProductVO> findProductListByMaker(String maker);
}
