package org.kosta.springmvc11.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	@Override
	public MemberVO findMemberById(String id) {		
		return memberDAO.findMemberById(id);
	}
	@Override
	public List<String> getAddressKind(){
		return memberDAO.getAddressKind();
	}
	@Override
	public List<MemberVO> findMemberListByAddress(String address){
		return memberDAO.findMemberListByAddress(address);
	}
	@Override
	public MemberVO login(MemberVO memberVO) {		
		return memberDAO.login(memberVO);
	}
	@Override
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);
	}
	@Override
	public int getMemberCount() {		
		return memberDAO.getMemberCount();
	}
	@Override
	public void registerMember(MemberVO vo) {
		memberDAO.registerMember(vo);
	}
	@Override
	public int idcheck(String id) {		
		return memberDAO.idcheck(id);
	}
}
