package model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomerDAOImpl implements CustomerDAO {
	private SqlSessionTemplate template;
	public CustomerDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
	}
	/* (non-Javadoc)
	 * @see model.CustomerDAO#findCustomerById(java.lang.String)
	 */
	@Override
	public CustomerVO findCustomerById(String id){
		return template.selectOne("customer.findCustomerById", id);
	}
	@Override
	public int register(CustomerVO vo){
		return template.insert("customer.register", vo);
	}
	@Override
	public List<CustomerVO> getAllCutomerList(){
		return template.selectList("customer.getAllCutomerList");
	}
}
