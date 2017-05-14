package org.kosta.springmvc11.model;

import java.util.List;

public interface MemberDAO {
	MemberVO findMemberById(String id);

	List<String> getAddressKind();

	List<MemberVO> findMemberListByAddress(String address);

	MemberVO login(MemberVO memberVO);

	void updateMember(MemberVO memberVO);

	int getMemberCount();

	void registerMember(MemberVO vo);

	int idcheck(String id);
}
