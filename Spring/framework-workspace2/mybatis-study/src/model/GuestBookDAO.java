package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import factory.SqlSessionFactoryManager;

public class GuestBookDAO {
	public static GuestBookDAO instance = new GuestBookDAO();
	private SqlSessionFactory factory;
	private GuestBookDAO(){
		factory = SqlSessionFactoryManager.getInstance().getFactory();
	}
	public static GuestBookDAO getInstance(){
		return instance;
	}
	public List<GuestBookVO> getAllGuestBookList() {
		List<GuestBookVO> list= null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("guestbook.getAllGuestBookList");
		} finally {
			session.close();
		}
		return list;
	}
	public void insertGuestBook(GuestBookVO guestBookVO) {
		SqlSession session = factory.openSession(true);
		try{
			session.insert("insertGuestBook", guestBookVO);
		}finally{
			session.close();
		}
	}
	public void insertGuestBook2(GuestBookVO guestBookVO) {
		SqlSession session = factory.openSession(true);
		try{
			session.insert("insertGuestBook2", guestBookVO);
		}finally{
			session.close();
		}
		
	}
	
}
