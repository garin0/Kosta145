package test.step1;

import java.util.Map;

import model.MemberDAO;

public class TestMemberDAO {
	public static void main(String[] args) {
		MemberDAO dao = MemberDAO.getInstance();
		//insert test
		/*dao.insertMember(new MemberVO("mybatis","abcd","김호겸","야탑"));
		System.out.println("검색 결과: "+dao.findMemberById("mybatis"));*/
		/*List<MemberVO> list = dao.getAllMemberList();
		for(MemberVO vo:list){
			System.out.println(vo);
		}*/
		Map<String,String> map = dao.findMemberMapById("mybatis");
		System.out.println(map);
	}
}
