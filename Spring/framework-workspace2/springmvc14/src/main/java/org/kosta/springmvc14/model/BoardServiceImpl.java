package org.kosta.springmvc14.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource
	private BoardDAO boardDAO;
	
	/* (non-Javadoc)
	 * @see org.kosta.springmvc14.model.BoardService#getTotalContent()
	 */
	@Override
	public int getTotalContent(){
		return boardDAO.getTotalContent();
	}
	@Override
	public List<ListVO> getAllBoardList(int start,int end){
		return boardDAO.getAllBoardList(start, end);
		
	}
	@Override
	public int write(BoardVO vo){
		return boardDAO.write(vo);
	}
	@Override
	public BoardVO showContent(int no){
		return boardDAO.showConent(no);
	}
	@Override
	public int update(BoardVO vo){
		return boardDAO.update(vo);
	}
	@Override
	public int updateHit(int no){
		return boardDAO.updateHit(no);
	}
	@Override
	public int nextBoardNo(){
		return boardDAO.nextBoardNo();
	}
	@Override
	public int deletePosting(int no){
		return boardDAO.deletePosting(no);
	}
}
