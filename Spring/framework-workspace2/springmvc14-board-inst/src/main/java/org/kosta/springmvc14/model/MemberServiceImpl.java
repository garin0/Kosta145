package org.kosta.springmvc14.model;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	@Override
	public MemberVO findMemberById(String id){
		return memberDAO.findMemberById(id);
	}
	public MemberVO login(MemberVO vo){
		return memberDAO.login(vo);
	}
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);			
	}	
	public void registerMember(MemberVO vo) {		
		memberDAO.registerMember(vo);
	}	
	public String idcheck(String id) {
		int count=memberDAO.idcheck(id);
		return (count==0) ? "ok":"fail"; 
	}
}
