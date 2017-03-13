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
			c = new ItemListController();
		}else if(command.equals("login")){
			c = new LoginController();
		}else if(command.equals("detail")){
			c = new DetailController();
		}else if(command.equals("logout")){
			c = new LogoutController();
		}else if(command.equals("register")){
			c = new RegisterItemController();
		}else if(command.equals("addCart")){
			c = new AddCartController();
		}else if(command.equals("delete")){
			c = new DeleteController();
		}
		return c;
	}
}
