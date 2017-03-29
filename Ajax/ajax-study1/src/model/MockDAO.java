package model;

public class MockDAO {
	
	public String  getMemberInfo(String id){
		String info = null;
		if(id.equals("java")){
			info = "아이유 판교";
		}else if(id.equals("spring")){
			info = "스티브잡스 대구";
		}
		return info;
	}
	
	public String getDeptInfo(String deptNo){
		String info =null;
		switch(deptNo){
		case "10":
			info = "연구개발 판교";
			break;
		case "20":
			info = "영업 강남";
			break;
		case "30":
			info = "경영지원 종로";
			break;
		}
		return info;
	}
}
