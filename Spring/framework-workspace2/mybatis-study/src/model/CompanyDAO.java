package model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import factory.SqlSessionFactoryManager;

public class CompanyDAO {
	private static CompanyDAO instance = new CompanyDAO();
	private SqlSessionFactory factory;
	private CompanyDAO(){
		factory = SqlSessionFactoryManager.getInstance().getFactory();
	}
	public static CompanyDAO getInstance(){
		return instance;
	}
	public List<Map<String, String>> getAllDeptList() {
		List<Map<String, String>> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getAllDeptList");
		} finally {
			session.close();
		}
		return list;
	}
	public List<DeptVO> getAllDeptListDeptnoDesc() {
		List<DeptVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getAllDeptListDeptnoDesc");
		} finally {
			session.close();
		}
		return list;
	}
	public DeptVO findDeptByDeptNo(int no) {
		DeptVO vo  =null;                                                                                                                                                                                                                                                                                                                 
		SqlSession session = factory.openSession();
		try {
			vo = session.selectOne("company.findDeptByDeptNo", no);
		} finally {
			session.close();
		}
		return vo;
	}
	public List<EmpVO> getAllEmpList() {
		List<EmpVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getAllEmpList");
		} finally {
			session.close();
		}
		return list;
	}
	public List<EmpVO> getEmpListLikeName(String name) {
		List<EmpVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getEmpListLikeName",name);
		} finally {
			session.close();
		}
		return list;
	}
	public List<EmpVO> getEmpListLikeNameAndJob(Map<String, String> paramMap) {
		List<EmpVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getEmpListLikeNameAndJob",paramMap);
		} finally {
			session.close();
		}
		return list;
	}
	public List<EmpVO> getEmpListBySal(int money) {
		List<EmpVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getEmpListBySal",money);
		} finally {
			session.close();
		}
		return list;
	}
	public Map<String, String> getEmpAndDeptInfo(String empNo) {
		Map<String, String> map = null;
		SqlSession session = factory.openSession();
		try {
			map = session.selectOne("company.getEmpAndDeptInfo",empNo);
		} finally {
			session.close();
		}
		return map;
	}
	public Map<String, Object> getEmpAndSalGrade(String empNo) {
		Map<String, Object> map = null;
		SqlSession session = factory.openSession();
		try {
			map = session.selectOne("company.getEmpAndSalGrade",empNo);//pk로 검색 
		} finally {
			session.close(); //롤백
		}
		return map;
	}
	public List<Map<String, Object>> getEmpAndDeptOuterJoin() {
		List<Map<String, Object>> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getEmpAndDeptOuterJoin");
		} finally {
			session.close();
		}
		return list;
	}
	public List<EmpVO> getEmpListByDinamicSQL(EmpVO paramVO) {
		List<EmpVO> list = null;
		SqlSession session = factory.openSession();
		try {
			list = session.selectList("company.getEmpListByDinamicSQL",paramVO);
		} finally {
			session.close();
		}
		return list;
	}
}
