package controller;
/**
 * 
 * @author KOSTA
 *
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){
		Controller c = null;
		if(command.equals("list")){
			c = new EmpListController();
		}else if(command.equals("detail")){
			c = new DetailEmpController();
		}
		return c;
	}
}
