package model;

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
		try {						// sql id				검색 조건
			vo = session.selectOne("member.findMemberById", id);
		} finally {
			session.close();
		}
		return vo;
	}
	public void insertMember(MemberVO vo){
		SqlSession session = factory.openSession();
		try{
			session.insert("member.insertMember", vo);
			session.commit();
		}finally{
			session.close();
		}
	}

	public List<MemberVO> getAllMemberList() {
		List<MemberVO> list = null;
		SqlSession session = factory.openSession();
		try{
			list = session.selectList("getAllMemberList");
		}finally{
			session.close();
		}
		return list;
	}

	public Map<String, String> findMemberMapById(String id) {
		Map<String, String> map =null;
		SqlSession session = factory.openSession();
		try{
			map = session.selectOne("member.findMemberMapById", id);
		}finally{
			session.close();
		}
		return map;
	}

}
