package test;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO1 {

	public static void main(String[] args) {
		try{
			//생성자에서 오라클 드라이버 로딩
			MemberDAO dao = new MemberDAO();
			MemberVO vo =dao.findMemberById("java");
			if(vo!=null)
				System.out.println("검색결과: "+vo);
			else
				System.out.println("검색결과 없음");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
