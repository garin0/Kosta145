package org.kosta.springmvc16.model;

import java.util.List;

public interface BrokerService {
	public CustomerVO login(CustomerVO vo);

	List<StockVO> stockList();

	List<SharesVO> sharesList(String id);

	int buyStock(SharesVO vo);

	int updateStock(SharesVO vo);

	SharesVO findStock(SharesVO vo);

	int sellStock(SharesVO vo);
}
