package test;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO2 {
	public static void main(String[] args) {
		try{
			MemberDAO dao = new MemberDAO();
			MemberVO vo = new MemberVO("prince","angel","�蹮��","��������");
			if(dao.findMemberById(vo.getId())==null){
				dao.registerMember(vo);
				System.out.println(vo+ " insert ok");
			}else{
				System.out.println("ȸ�� ���̵� �����մϴ�.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
