package org.kosta.springmvc16.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BrokerDAOImpl implements BrokerDAO {

	@Resource
	SqlSessionTemplate template;
	@Override
	public CustomerVO login(CustomerVO vo) {
		return template.selectOne("broker.login",vo);
	}
	@Override
	public List<StockVO> stockList(){
		return template.selectList("broker.stockList");
	}
	@Override
	public List<SharesVO> sharesList(String id){
		return template.selectList("broker.sharesList",id);
	}
	@Override
	public SharesVO findStock(SharesVO vo){
		return template.selectOne("broker.findStock", vo);
	}
	@Override
	public int buyStock(SharesVO vo){
		return template.insert("broker.buyStock", vo);
	}
	@Override
	public int updateStock(SharesVO vo){
		return template.update("broker.updateStock", vo);
	}
	@Override
	public int sellStock(SharesVO vo){
		return template.update("broker.sellStock",vo);
	}

}
