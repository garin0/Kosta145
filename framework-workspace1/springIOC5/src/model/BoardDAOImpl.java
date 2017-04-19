package model;

public class BoardDAOImpl implements BoardDAO {
	@Override
	public String getContentByNo(String no){
		return no+"번 게시물 정보";
	}
}
