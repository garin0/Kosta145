package org.kosta.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	
	/* (non-Javadoc)
	 * @see org.kosta.model.MemberService#findMemberById(java.lang.String)
	 */
	@Override
	public MemberVO findMemberById(String id) {
		return memberDAO.findMemberById(id);
	}
	@Override
	public List<String> getAddressKind(){
		return memberDAO.getAddressKind();
	}
	@Override
	public List<MemberVO> findMemberByAddress(String address){
		return memberDAO.findMemberByAddress(address);
	}
	@Override
	public MemberVO login(String id,String password){
		return memberDAO.login(id, password);
				
	}
	@Override
	public int updateMember(MemberVO vo){
		return memberDAO.updateMember(vo);
	}
	@Override
	public int countMember(){
		return memberDAO.countMember();
	}
	@Override
	public int idCheck(String id){
		return memberDAO.idCheck(id);
	}
	@Override
	public int join(MemberVO vo){
		return memberDAO.join(vo);
	}
}
