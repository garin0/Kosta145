package model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class ProductDAOImpl implements ProductDAO {
	private SqlSessionTemplate template;
	public ProductDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
	}
	/* (non-Javadoc)
	 * @see model.ProductDAO#register(model.ProductVO)
	 */
	@Override
	public ProductVO register(ProductVO vo){
		template.insert("product.register", vo);
		return vo;
	}
	@Override
	public List<ProductVO> searchByMaker(String input){
		return  template.selectList("product.searchByMaker", input);
	}
	@Override
	public List<ProductVO> searchByName(String input){
		return  template.selectList("product.searchByName", input);
	}
	@Override
	public ProductVO searchById(String id){
		return  template.selectOne("product.searchById", id);
	}
}
