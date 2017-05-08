package test.step1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO {
	public static void main(String[] args) {
		MemberDAO dao = MemberDAO.getInstance();
		// insert test
		// dao.insertMember(new MemberVO("dfsf","12da","김호겸","야탑"));
		// System.out.println("검색 결과: "+dao.findMemberById("mybatis"));
		/*
		 * List<MemberVO> list = dao.getAllMemberList(); for(MemberVO vo:list){
		 * System.out.println(vo); }
		 */
		/*
		 * Map<String,String> map = dao.findMemberMapById("aop");
		 * System.out.println(map);
		 */
		// System.out.println(map.get("NAME")); //MAP은 컬럼명이 대문자이다.
		// String address= "야탑";
		/*
		 * List<MemberVO> list =dao.findMemberListByAddress(address);
		 * for(MemberVO vo:list) System.out.println(vo);
		 */
		/*
		 * String name="김호겸"; MemberVO paramVO = new MemberVO(null, null, name,
		 * address); List<Map<String,String>> list =
		 * dao.findMemberListMapByAddressAndName(paramVO);
		 * for(Map<String,String> m:list) System.out.println(m);
		 */
		/*
		 * HashMap<String, String> paramMap = new HashMap<String, String>();
		 * paramMap.put("ID", "mybatis"); paramMap.put("PASS", "abcd");
		 * paramMap.put("NAME", "공유"); paramMap.put("ADDR", "하와이");
		 * System.out.println(dao.findMemberById("mybatis")+" 수정전");
		 * dao.updateMember(paramMap);
		 * System.out.println(dao.findMemberById("mybatis")+" 수정후");
		 */
		/*
		 * int count = dao.deleteMemberByName("김호겸");
		 * System.out.println("삭제 회원수 : " + count);
		 */
		/*
		 * List<MemberVO> list = dao.getAllMemberList(); for(MemberVO vo:list)
		 * System.out.println(vo);
		 */
		/*Map<String,MemberVO> map = dao.getAllMemberMap();*/
		//System.out.println(map);
	/*	System.out.println(map.get("java"));
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()){
			String key = it.next();
			System.out.println("key: "+key+" value: "+map.get(key));
		}*/
		/*List<String> addressList = dao.getAddressKindList();
		for(String addr : addressList)
			System.out.println(addr);*/
		int count = dao.getMemberCount();
		System.out.println("회원수:"+count);
	}
}
