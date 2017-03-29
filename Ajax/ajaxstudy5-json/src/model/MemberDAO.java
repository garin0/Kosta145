package model;

import java.util.ArrayList;

public class MemberDAO {
	public MemberVO findMemberById(String id) {
		MemberVO vo = null;
		if (id.equals("java")) {
			vo = new MemberVO("java", "1234", "아이유", "판교");
		} else if (id.equals("spring")) {
			vo = new MemberVO("spring", "abcd", "정석희", "수내동");
		} else if (id.equals("ajax")) {
			vo = new MemberVO("ajax", "jtbc", "손석희", "평창동");
		}
		return vo;
	}
	 public ArrayList<MemberVO> findMemberListByAddress(String address){
		  ArrayList<MemberVO> list=new ArrayList<MemberVO>();
		  if(address.equals("판교")){
		   list.add(new MemberVO("java",null,"이현근","판교"));   
		   list.add(new MemberVO("ajax",null,"김성환","판교"));   
		   list.add(new MemberVO("jquery",null,"임경수","판교"));
		   list.add(new MemberVO("git",null,"김지원","판교"));
		  }else if(address.equals("종로")){
		   list.add(new MemberVO("spring",null,"한지선","종로"));
		   list.add(new MemberVO("mybatis",null,"강정호","종로"));
		  }
		  return list;
		 }
}
