package model;

public class MemberServiceImpl implements MemberService {
	/* (non-Javadoc)
	 * @see model.MemberService#findMemberById(java.lang.String)
	 */
	@Override
	public String findMemberById(String id){
		if(id.equals("java"))
			return "임경수 구미";
		else
			return null;
	}
}
