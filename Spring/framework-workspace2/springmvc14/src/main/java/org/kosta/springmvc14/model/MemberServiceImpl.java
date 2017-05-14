package org.kosta.springmvc14.model;

import javax.annotation.Resource;

import org.kosta.springmvc14.model.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberDAO memberDAO;
	
	/* (non-Javadoc)
	 * @see org.kosta.springmvc14.model.MemberService#login(org.kosta.springmvc14.model.MemberVO)
	 */
	@Override
	public MemberVO login(MemberVO mvo){
		return memberDAO.login(mvo);
	}
}
