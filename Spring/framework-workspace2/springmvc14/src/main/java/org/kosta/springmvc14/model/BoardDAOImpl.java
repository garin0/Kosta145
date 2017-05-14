package org.kosta.springmvc14.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Resource
	private SqlSessionTemplate template;
	
	/* (non-Javadoc)
	 * @see org.kosta.springmvc14.model.BoardDAO#getTotalContent()
	 */
	@Override
	public int getTotalContent(){
		return template.selectOne("board.getTotalContent");
	}
	@Override
	public List<ListVO> getAllBoardList(int start,int end){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		return template.selectList("board.getAllBoardList", map);
	}
	@Override
	public int write(BoardVO vo){
		return template.insert("board.write",vo);
	}
	@Override
	public BoardVO showConent(int no){
		return template.selectOne("board.showContent", no);
	}
	@Override
	public int update(BoardVO vo){
		return template.update("board.update", vo);
	}
	@Override
	public int updateHit(int no){
		return template.update("board.updateHit",no);
	}
	@Override
	public int nextBoardNo(){
		return template.selectOne("board.nextBoardNo");
	}
	@Override
	public int deletePosting(int no){
		return template.delete("board.deletePosting", no);
	}
	
	
}
