package org.kosta.springmvc17.model.dao;

import javax.annotation.Resource;

import org.kosta.springmvc17.model.vo.PointVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {

	@Resource
	private SqlSessionTemplate template;
	@Override
	public PointVO findPointById(String id) {
		return template.selectOne("point.findPointById", id);
	}
	@Override
	public int register(PointVO vo) {
		return template.insert("point.register", vo);
	}

}
