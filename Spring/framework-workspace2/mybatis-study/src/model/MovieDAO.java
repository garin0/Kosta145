package model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import factory.SqlSessionFactoryManager;

public class MovieDAO {
	public static MovieDAO instance = new MovieDAO();
	private SqlSessionFactory factory;
	private MovieDAO(){
		factory = SqlSessionFactoryManager.getInstance().getFactory();
	}
	public static MovieDAO getInstance(){
		return instance;
	}
	public Map<String, String> getDirectorInfo(String directorId) {
		Map<String, String> map = null;
		SqlSession session = factory.openSession();
		try {
			map = session.selectOne("movie.getDirectorInfo", directorId);
		} finally {
			session.close();
		}
		return map;
	}
	public void insertMovieMap(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		try {
			session.insert("movie.insertMovieMap", map);
			session.commit();
		} finally {
			session.close();
		}
	}
	public Map<String, Object> getMoviewMap(String movieId) {
		Map<String, Object> map = null;
		SqlSession session = factory.openSession();
		try {
			map = session.selectOne("movie.getMoviewMap", movieId);
		} finally {
			session.close();
		}
		return map;
	}
	public void insertDirectorVO(DirectorVO dvo) {
		SqlSession session = factory.openSession();
		try {
			session.insert("movie.insertDirectorVO", dvo);
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<DirectorVO> getAllDirectorList() {
		List<DirectorVO> list= null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("movie.getAllDirectorList");
		} finally {
			session.close();
		}
		return list;
	}
	public void insertMovieVO(MovieVO mvo) {
		SqlSession session = factory.openSession();
		try {
			session.insert("movie.insertMovieVO", mvo);
			session.commit();
		} finally {
			session.close();
		}
	}
	public List<MovieVO> getMovieListAndDirectorInfo() {
		List<MovieVO> list= null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("movie.getMovieListAndDirectorInfo");
		} finally {
			session.close();
		}
		return list;
	}
	public MovieVO getMovieAndDirectorDetailInfo(String movieId) {
		MovieVO vo= null;
		SqlSession session = factory.openSession();
		try {
			vo = session.selectOne("movie.getMovieAndDirectorDetailInfo",movieId);
		} finally {
			session.close();
		}
		return vo;
	}
}
