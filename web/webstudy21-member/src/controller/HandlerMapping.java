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
		Controller controller = null;
		if(command.equals("findById")){
			controller = new FindMemberById();
		}else if(command.equals("findByAddress")){
			controller = new FindMemberByAddress();
		}else if(command.equals("login")){
			controller = new LoginController();
		}else if(command.equals("logout")){
			controller = new LogoutController();
		}else if(command.equals("register")){
			controller = new RegisterController();
		}else if(command.equals("update")){
			controller = new UpdateController();
		}else if(command.equals("idcheck")){
			controller = new IdCheckController();
		}

		
		return controller;
	}
}
