package org.kosta.springmvc15.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;	
	
	@Override
	public int registerProduct(ProductVO productVO) {
		return sqlSessionTemplate.insert("product.registerProduct", productVO);
	}

	@Override
	public ProductVO findProductById(String id) {
		return sqlSessionTemplate.selectOne("product.findProductById", id);
	}
	@Override
	public  List<ProductVO> findProductListByName(String name){
		return sqlSessionTemplate.selectList("product.findProductListByName", name);
	}

	@Override
	public List<ProductVO> findProductListByMaker(String maker) {
		return sqlSessionTemplate.selectList("product.findProductListByMaker", maker);
	}

}
