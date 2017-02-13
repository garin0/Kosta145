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
		   service.addPerson(new Student("011", "��ƶ�", "�Ǳ�", "14"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.addPerson(new Teacher("016", "����ȣ", "����", "����"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.addPerson(new Employee("017", "�̰��", "�Ǳ�", "�ѹ�"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.addPerson(new Teacher("016", "�߽ż�", "�Ǳ�", "����"));
		  } catch (DuplicateTelException e) {
		   System.out.println(e.getMessage());
		  }
		  service.printAll(); 
		  System.out.println("****************step1:add �Ϸ�****************");
		  
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
		  System.out.println("****************step2:find �Ϸ�****************"); 
		  try {
		   service.updatePerson(new Student("016", "�̴�ȣ", "�Ǳ�", "13"));
		   System.out.println(service.findPersonByTel("016"));
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.updatePerson(new Student("010", "������", "�Ǳ�", "13"));
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  System.out.println("****************step3:update �Ϸ�****************");
		   
		  try {
		   service.deletePersonByTel("016");
		   System.out.println("���� ok");
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  try {
		   service.deletePersonByTel("010");
		   System.out.println("���� ok");
		  } catch (PersonNotFoundException e) {
		   System.out.println(e.getMessage());
		  }
		  service.printAll();  
		  System.out.println("****************step4:delete �Ϸ�****************");
		
		  try{   
		   ArrayList<Person> list = service.findPersonListByAddress("�Ǳ�");   
		   for (int i = 0; i < list.size(); i++)
		    System.out.println(list.get(i));
		  }catch(PersonNotFoundException pe){   
		   System.out.println(pe.getMessage());
		  }
		  System.out.println("****************step5:findPersonListByAddress �Ϸ�****************");
		   
		  try{   
		   ArrayList<Person> list = service.findPersonListByAddress("����");   
		   for (int i = 0; i < list.size(); i++)
		    System.out.println(list.get(i));
		  }catch(PersonNotFoundException pe){   
		   System.out.println(pe.getMessage());
		  }
		  System.out.println("****************step5:findPersonListByAddress �Ϸ�****************"); /*
*/
	}

}

/*
016 tel�� �����Ͽ� �߰��Ұ�!
tel=011, name=��ƶ�, address=�Ǳ�, stuId:14
tel=016, name=����ȣ, address=����, subject:����
tel=017, name=�̰��, address=�Ǳ�, dept:�ѹ�
****************step1:add �Ϸ�****************
tel=017, name=�̰��, address=�Ǳ�, dept:�ѹ�
010 tel�� �������� �ʾ� ��ȸ�� �� �����ϴ�.!
****************step2:find �Ϸ�****************
tel=016, name=�̴�ȣ, address=�Ǳ�, stuId:13
010 tel�� �������� �ʾ� ������ �� �����ϴ�.!
****************step3:update �Ϸ�****************
���� ok
010 tel�� �������� �ʾ� ������ �� �����ϴ�.
tel=011, name=��ƶ�, address=�Ǳ�, stuId:14
tel=017, name=�̰��, address=�Ǳ�, dept:�ѹ�
****************step4:delete �Ϸ�****************
tel=011, name=��ƶ�, address=�Ǳ�, stuId:14
tel=017, name=�̰��, address=�Ǳ�, dept:�ѹ�
****************step5:findPersonListByAddress �Ϸ�****************
���ο� ��� �������� �����ϴ�.
****************step5:findPersonListByAddress �Ϸ�****************
 */ 
