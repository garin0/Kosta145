package org.kosta.springmvc17.model.dao;

import javax.annotation.Resource;

import org.kosta.springmvc17.model.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSessionTemplate template;

	@Override
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById", id);
	}

	@Override
	public int register(MemberVO vo) {
		return template.insert("member.register", vo);
	}

}
