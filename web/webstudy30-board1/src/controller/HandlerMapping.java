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
			c = new ListBoardController();
		}else if(command.equals("showContent")){
			c = new ShowContentController();
		}else if(command.equals("write")){
			c = new WriteBoardController();
		}
		return c;
	}
}
