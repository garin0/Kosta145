package org.kosta.springmvc14.model;

import java.util.List;

public interface BoardDAO {

	int getTotalContent();


	int write(BoardVO vo);

	public List<ListVO> getAllBoardList(int start,int end);


	BoardVO showConent(int no);


	int update(BoardVO vo);


	int updateHit(int no);


	int nextBoardNo();


	int deletePosting(int no);

}