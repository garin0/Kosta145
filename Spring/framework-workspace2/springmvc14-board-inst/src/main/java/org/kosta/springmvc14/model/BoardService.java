package org.kosta.springmvc14.model;






public interface BoardService {
	public  void write(BoardVO bvo);	
	public  ListVO getBoardList();
	public  ListVO getBoardList(String pageNo);
	public  BoardVO showContent(int no);	
	public BoardVO showContentNoHit(int no);
	public  void deleteBoard(int no);
	public  void updateBoard(BoardVO bvo);
	public  void updateCount(int no);	
}