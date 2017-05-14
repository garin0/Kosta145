package org.kosta.springmvc14.model;

import java.util.List;

public interface BoardService {

	int getTotalContent();


	int write(BoardVO vo);

	List<ListVO> getAllBoardList(int start, int end);


	BoardVO showContent(int no);


	int update(BoardVO vo);


	int updateHit(int no);


	int nextBoardNo();


	int deletePosting(int no);

}