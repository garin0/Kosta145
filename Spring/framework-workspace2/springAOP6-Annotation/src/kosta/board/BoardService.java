package kosta.board;

import org.springframework.stereotype.Service;

@Service
public class BoardService {	
	public String find(){		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("find board");	
		return "게시물 정보";
	}
	public String findAllList(){		
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("findAllList board");
		return "게시물 목록";
	}
}






