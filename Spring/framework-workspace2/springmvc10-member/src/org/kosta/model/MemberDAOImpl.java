package org.kosta.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Resource
	private SqlSessionTemplate template;

	/* (non-Javadoc)
	 * @see org.kosta.model.MemberDAO#findMemberById(java.lang.String)
	 */
	@Override
	public MemberVO findMemberById(String id) {
		return template.selectOne("member.findMemberById", id);
	}
	@Override
	public List<String> getAddressKind(){
		return template.selectList("member.getAddressKind");
	}
	@Override
	public List<MemberVO> findMemberByAddress(String address){
		return template.selectList("member.findMemberByAddress", address);
	}
	@Override
	public MemberVO login(String id,String password){
		MemberVO vo = new MemberVO(id,password);
		return template.selectOne("member.login", vo);
	}
	@Override
	public int updateMember(MemberVO vo){
		return template.update("member.updateMember", vo);
		
	}
	@Override
	public int countMember(){
		return template.selectOne("member.countMember");
	}
	@Override
	public int idCheck(String id){
		return template.selectOne("member.idCheck",id);
	}
	@Override
	public int join(MemberVO vo){
		return template.insert("member.join", vo);
	}
}
