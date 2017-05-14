package org.kosta.springmvc16.model;

import java.util.List;

public interface BrokerDAO {
	public CustomerVO login(CustomerVO vo);

	List<StockVO> stockList();

	List<SharesVO> sharesList(String id);

	SharesVO findStock(SharesVO vo);

	int buyStock(SharesVO vo);

	int updateStock(SharesVO vo);

	int sellStock(SharesVO vo);
}
