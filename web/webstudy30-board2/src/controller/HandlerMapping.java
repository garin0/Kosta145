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
		}else if(command.equals("delete")){
			c = new DeleteDataController();
		}else if(command.equals("pwcheck")){
			c = new PasswordCheckController();
		}else if(command.equals("update")){
			c = new UpdateDataController();
		}else if(command.equals("pw")){
			c = new PasswordConfirmController();
		}else if(command.equals("pwDel")){
			c = new PasswordConfirmController2();
		}
		return c;
	}
}
