package org.kosta.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Resource
	private SqlSessionTemplate template;

	@Override
	public CustomerVO findCustomerById(String id) {
		return template.selectOne("customer.findCustomerById", id);
	}

}
