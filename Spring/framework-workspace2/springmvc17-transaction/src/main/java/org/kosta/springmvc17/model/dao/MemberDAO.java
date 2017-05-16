package org.kosta.springmvc17.model.dao;

import org.kosta.springmvc17.model.vo.MemberVO;

public interface MemberDAO {
	public MemberVO findMemberById(String id);
	public int register(MemberVO vo);
}
