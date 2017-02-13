package test;

import java.util.ArrayList;

import school.DuplicateTelException;
import school.Employee;
import school.Person;
import school.PersonNotFoundException;
import school.SchoolService;
import school.Student;
import school.Teacher;

public class TestUnit {

	public static void main(String[] args) {
		SchoolService service = new SchoolService();
		 try {
		   service.addPerson(new Student("011", "고아라", "판교", "14"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.addPerson(new Teacher("016", "박찬호", "강남", "국어"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.addPerson(new Employee("017", "이경규", "판교", "총무"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.addPerson(new Teacher("016", "추신수", "판교", "수학"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  service.printAll(); 
		  System.out.println("****************step1:add 완료****************");
		  
		  try { 
		   Person rp = service.findPersonByTel("017");
		   System.out.println(rp);
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   Person rp = service.findPersonByTel("010");
		   System.out.println(rp);
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  System.out.println("****************step2:find 완료****************"); 
		  try {
		   service.updatePerson(new Student("016", "이대호", "판교", "13"));
		   System.out.println(service.findPersonByTel("016"));
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.updatePerson(new Student("010", "구혜선", "판교", "13"));
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  System.out.println("****************step3:update 완료****************");
		   
		  try {
		   service.deletePersonByTel("016");
		   System.out.println("삭제 ok");
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.deletePersonByTel("010");
		   System.out.println("삭제 ok");
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  service.printAll();  
		  System.out.println("****************step4:delete 완료****************");
		
		  try{   
		   ArrayList<Person> list = service.findPersonListByAddress("판교");   
		   for (int i = 0; i < list.size(); i++)
		    System.out.println(list.get(i));
		  }catch(PersonNotFoundException pe){   
		   System.out.println(pe.getMessage());
		  }
		  System.out.println("****************step5:findPersonListByAddress 완료****************");
		   
		  try{   
		   ArrayList<Person> list = service.findPersonListByAddress("용인");   
		   for (int i = 0; i < list.size(); i++)
		    System.out.println(list.get(i));
		  }catch(PersonNotFoundException pe){   
		   System.out.println(pe.getMessage());
		  }
		  System.out.println("****************step5:findPersonListByAddress 완료****************"); /*
*/
	}

}

/*
016 tel이 존재하여 추가불가!
tel=011, name=고아라, address=판교, stuId:14
tel=016, name=박찬호, address=강남, subject:국어
tel=017, name=이경규, address=판교, dept:총무
****************step1:add 완료****************
tel=017, name=이경규, address=판교, dept:총무
010 tel이 존재하지 않아 조회할 수 없습니다.!
****************step2:find 완료****************
tel=016, name=이대호, address=판교, stuId:13
010 tel이 존재하지 않아 수정할 수 없습니다.!
****************step3:update 완료****************
삭제 ok
010 tel이 존재하지 않아 삭제할 수 없습니다.
tel=011, name=고아라, address=판교, stuId:14
tel=017, name=이경규, address=판교, dept:총무
****************step4:delete 완료****************
tel=011, name=고아라, address=판교, stuId:14
tel=017, name=이경규, address=판교, dept:총무
****************step5:findPersonListByAddress 완료****************
용인에 사는 구성원이 없습니다.
****************step5:findPersonListByAddress 완료****************
 */ 
