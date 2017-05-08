package org.kosta.model;

import java.util.List;

public interface MemberService {
	MemberVO findMemberById(String id);

	List<String> getAddressKind();

	List<MemberVO> findMemberListByAddress(String address);

	MemberVO login(MemberVO memberVO);
	
	void updateMember(MemberVO memberVO);
	
	int getMemberCount();

	void registerMember(MemberVO vo);

	int idcheck(String id);
}
