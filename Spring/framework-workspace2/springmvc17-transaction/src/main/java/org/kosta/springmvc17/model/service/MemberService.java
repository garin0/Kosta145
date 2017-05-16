package org.kosta.springmvc17.model.service;

import org.kosta.springmvc17.model.vo.MemberVO;
import org.kosta.springmvc17.model.vo.PointVO;

public interface MemberService {
	public MemberVO findMemberById(String id);

	public PointVO findPointById(String id);
	
	void registerPoint(MemberVO mvo, PointVO pvo);
}
