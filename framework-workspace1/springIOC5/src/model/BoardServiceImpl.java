package model;

public class BoardServiceImpl implements BoardService {
	private BoardDAO dao;
	
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	@Override
	public String getContentByNo(String no){
		return dao.getContentByNo(no);
	}
}
