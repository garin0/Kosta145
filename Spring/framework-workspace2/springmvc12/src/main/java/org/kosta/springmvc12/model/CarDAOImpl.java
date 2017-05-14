package org.kosta.springmvc12.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class CarDAOImpl implements CarDAO {
	@Resource
	private SqlSessionTemplate template;
	
	/* (non-Javadoc)
	 * @see org.kosta.springmvc12.model.CarDAO#getTotalCount()
	 */
	@Override
	public int getTotalCount(){
		return template.selectOne("car.getTotalCount");
	}
	@Override
	public List<CarVO> getCarList(){
		return template.selectList("car.getCarList");
	}
}
