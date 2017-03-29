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
		if(command.equals("empNoList")){
			c = new EmpNoListController();
		}else if(command.equals("ead")){
			c = new EmpAndDeptController();
		}
		return c;
	}
}
