package kosta.model.board;

public class BoardService {
	public void insertContent(){
		System.out.println("board insertContent..");
	}
	public String selectContent(String no){
		System.out.println("board selectContent "+no);
		return no+" select content";
	}
}
