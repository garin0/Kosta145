package org.kosta.springmvc16.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class BrokerServiceImpl implements BrokerService {

	@Resource
	private BrokerDAO dao;

	@Override
	public CustomerVO login(CustomerVO vo) {
		return dao.login(vo);
	}
	@Override
	public List<StockVO> stockList(){
		return dao.stockList();
	}
	@Override
	public List<SharesVO> sharesList(String id){
		return dao.sharesList(id);
	}
	@Override
	public SharesVO findStock(SharesVO vo){
		return dao.findStock(vo);
	}
	@Override
	public int buyStock(SharesVO vo){
		return dao.buyStock(vo);
	}
	@Override
	public int updateStock(SharesVO vo){
		return dao.updateStock(vo);
	}
	@Override
	public int sellStock(SharesVO vo){
		return dao.sellStock(vo);
	}
}
