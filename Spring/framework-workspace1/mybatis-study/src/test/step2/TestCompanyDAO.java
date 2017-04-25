package test.step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.CompanyDAO;
import model.EmpVO;

public class TestCompanyDAO {

	public static void main(String[] args) {
		CompanyDAO dao = CompanyDAO.getInstance();
		/*List<Map<String,String>> list =dao.getAllDeptList();
		for(Map<String,String> map:list)
			System.out.println(map);*/
		/*List<DeptVO> list = dao.getAllDeptListDeptnoDesc();
		for(DeptVO dvo:list)
			System.out.println(dvo);*/
		// SqlSessionConfig.xml에서 model.DetpVO를
		// deptVO라는 별칭을 준다.
		/*DeptVO dvo = dao.findDeptByDeptNo(10);
		System.out.println(dvo);*/
		// resultMap 이용: resultMap id는 empRM
		/*List<EmpVO> list =dao.getAllEmpList();
		for(EmpVO vo:list)
			System.out.println(vo);*/
		/*List<EmpVO> list = dao.getEmpListLikeName("A");
		for(EmpVO vo:list)
			System.out.println(vo);*/
		/*Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("JOB", "MANAGER");
		paramMap.put("NAME", "A");
		List<EmpVO> list = dao.getEmpListLikeNameAndJob(paramMap);
		for(EmpVO vo :list)
			System.out.println(vo);*/
		//job이 MANAGER이고 ENAME에 A가 포함된 사원명단
		//////////////////////////////////////////////////////////////////
		/*int money = 1500;
		 * 
		 * 
		List<EmpVO> list = dao.getEmpListBySal(money);
		for(EmpVO vo:list)
			System.out.println(vo);*/
		String empNo = "7369";
		/*Map<String,String> map = dao.getEmpAndDeptInfo(empNo);
		System.out.println(map.get("ENAME"));
		System.out.println(map.get("DNAME"));
		System.out.println(map.get("LOC"));*/
		/*Map<String,Object> map = dao.getEmpAndSalGrade(empNo);
		System.out.println(map.get("SAL"));
		System.out.println(map.get("ENAME"));
		System.out.println(map.get("GRADE"));*/
		// Outer Join
		// dept 부서 테이블에는 10.20.30.40번의 부서가 존재
		// emp 사원 테이블에는 사원이 40번 부서에는 존재하지 않음
		// 그럼에도 Outer Join을 이용해 사원이 존재하지 않는 부서 40번 정보 또한 조회대상에 포함
		// 부서 번호 오름차순으로 사원과 부서정보를 조회
		/*List<Map<String,Object>> list =dao.getEmpAndDeptOuterJoin();
		for(Map<String,Object> map:list)
			System.out.println(map);*/
		
		/*
		 * 검색
		 * 1. 전체검색
		 * 2.deptno 부서번호 검색
		 * 3.ename 사원명 검색
		 * 4.deptno와 ename검색
		 * 
		 * Mybatis Dynamic SQL을 이용해 한번에 처리
		 */
		EmpVO paramVO=new EmpVO();
		paramVO.setDeptno(30); // deptno가 30
		paramVO.setEname("S"); //Ename에 S가 포함된 사원
		List<EmpVO> list = dao.getEmpListByDinamicSQL(paramVO);
		for(EmpVO vo:list)
			System.out.println(vo);
	}

}
