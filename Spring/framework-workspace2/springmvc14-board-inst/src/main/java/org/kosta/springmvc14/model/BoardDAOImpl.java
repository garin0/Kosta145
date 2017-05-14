package org.kosta.springmvc14.model;


import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;	
	
	@Override
	public void write(BoardVO bvo){
		sqlSessionTemplate.insert("board.write",bvo);
	}			
	
	
	@Override
	public BoardVO showContent(int no){
		return (BoardVO)sqlSessionTemplate.selectOne("board.showContent",no);
	}
	
	@Override
	public void updateCount(int no){
		sqlSessionTemplate.update("board.updateCount",no);
	}
	
	@Override
	public void deleteBoard(int no){
		sqlSessionTemplate.delete("board.deleteBoard", no);
	}
	
	@Override
	public void updateBoard(BoardVO bvo){
		sqlSessionTemplate.update("board.updateBoard", bvo);
	}
	
	@Override
	public int getTotalContentCount(){
		return sqlSessionTemplate.selectOne("board.getTotalContentCount");
	}

	@Override
	public List<BoardVO> getBoardList(PagingBean pagingBean) {
		return sqlSessionTemplate.selectList("board.getBoardList", pagingBean);
	}	
}














