package org.kosta.springmvc15.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDAO productDAO;
	@Override
	public int registerProduct(ProductVO productVO) {
		return productDAO.registerProduct(productVO);
	}
	@Override
	public ProductVO findProductById(String id) {
		return productDAO.findProductById(id);
	}
	@Override
	public List<ProductVO> findProductListByName(String name) {
		return productDAO.findProductListByName(name);
	}
	@Override
	public List<ProductVO> findProductListByMaker(String maker) {
		return productDAO.findProductListByMaker(maker);
	}

}
