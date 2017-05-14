package org.kosta.springmvc14.model;

public interface MemberService {
	public MemberVO findMemberById(String id);
	public MemberVO login(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void registerMember(MemberVO vo) ;
	public String idcheck(String id) ;
}