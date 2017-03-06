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
		if(command.equals("find")){
			controller = new FindController();
		}else if(command.equals("insert")){
			controller = new InsertController();
		}else if(command.equals("findByAddress")){
			controller = new FindByAddressController();
		}else if(command.equals("update")){
			controller = new UpdateController();
		}
		
		return controller;
	}
}
