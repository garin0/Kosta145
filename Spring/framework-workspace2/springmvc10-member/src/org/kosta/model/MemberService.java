package org.kosta.model;

import java.util.List;

public interface MemberService {

	MemberVO findMemberById(String id);

	List<String> getAddressKind();

	List<MemberVO> findMemberByAddress(String address);

	MemberVO login(String id, String password);

	int updateMember(MemberVO vo);

	int countMember();

	int idCheck(String id);

	int join(MemberVO vo);

}