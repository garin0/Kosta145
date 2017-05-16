package org.kosta.springmvc17.model.dao;

import org.kosta.springmvc17.model.vo.PointVO;

public interface PointDAO {
	public PointVO findPointById(String id);
	
	public int register(PointVO vo);
}
