package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import factory.SqlSessionFactoryManager;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private SqlSessionFactory factory; // MyBatis 객체

	private MemberDAO() {
		factory = SqlSessionFactoryManager.getInstance().getFactory();
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public MemberVO findMemberById(String id) {
		MemberVO vo = null;
		SqlSession session = factory.openSession();
		try { // sql id 검색 조건
			vo = session.selectOne("member.findMemberById", id);
		} finally {
			session.close();
		}
		return vo;
	}

	public void insertMember(MemberVO vo) {
		SqlSession session = factory.openSession();
		try {
			session.insert("member.insertMember", vo);
			session.commit();
		} finally {
			session.close();
		}
	}

	public List<MemberVO> getAllMemberList() {
		List<MemberVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("getAllMemberList");
		} finally {
			session.close();
		}
		return list;
	}

	public Map<String, String> findMemberMapById(String id) {
		Map<String, String> map = null;
		SqlSession session = factory.openSession();
		try {
			map = session.selectOne("member.findMemberMapById", id);
		} finally {
			session.close();
		}
		return map;
	}

	public List<MemberVO> findMemberListByAddress(String address) {
		List<MemberVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("member.findMemberListByAddress", address);
		} finally {
			session.close();
		}
		return list;
	}

	public List<Map<String, String>> findMemberListMapByAddressAndName(MemberVO paramVO) {
		List<Map<String, String>> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("member.findMemberListMapByAddressAndName", paramVO);
		} finally {
			session.close();
		}
		return list;
	}

	public void updateMember(HashMap<String, String> paramMap) {
		/*
		 * insert,delete,update는 commit을 실행해야 실제 db에 반영
		 * 방법은 openSession(true)로 명시해 
		 */
		SqlSession session = factory.openSession(true);
		try {
			session.update("member.updateMember", paramMap);
			// session.commit();
		} finally {
			session.close();
		}
	}

	public int deleteMemberByName(String name) {
		SqlSession session = factory.openSession(true);
		int count = 0;
		try {
			count = session.update("member.deleteMemberByName", name);
			// session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	public Map<String, MemberVO> getAllMemberMap() {
		Map<String, MemberVO> map=null;
		SqlSession session = factory.openSession();
		try{
			map = session.selectMap("member.getAllMemberMap", "id");
		}finally{
			session.close();
		}
		return map;
	}

	public List<String> getAddressKindList() {
		SqlSession session = factory.openSession();
		List<String> list =null;
		try{
			list = session.selectList("member.getAddressKindList");
		}finally{
			session.close();
		}
		return list;
	}

	public int getMemberCount() {
		int count = 0;
		SqlSession session = factory.openSession();
		try { // sql id 검색 조건
			count = session.selectOne("member.getMemberCount");
		} finally {
			session.close();
		}
		return count;
	}

}
