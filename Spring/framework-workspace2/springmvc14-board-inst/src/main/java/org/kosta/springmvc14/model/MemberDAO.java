package org.kosta.springmvc14.model;

public interface MemberDAO {
	public MemberVO findMemberById(String id);
	public MemberVO login(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void registerMember(MemberVO vo) ;
	public int idcheck(String id) ;
}