package org.kosta.springmvc14.model;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSessionTemplate template;
	
	/* (non-Javadoc)
	 * @see org.kosta.springmvc14.model.MemberDAO#login(org.kosta.springmvc14.model.MemberVO)
	 */
	@Override
	public MemberVO login(MemberVO mvo){
		return template.selectOne("member.login", mvo);
	}
}
