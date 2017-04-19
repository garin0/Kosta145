package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ItemServiceImpl implements ItemService {
	private ItemDAO dao;

	public ItemServiceImpl(ItemDAO dao) {
		super();
		this.dao = dao;
	}
	@Override
	public Map<String, Object> getListAndAvgPriceInfo(String maker) throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.getItemListByMaker(maker));
		map.put("avgPriceInfo", dao.getAvgPriceByMaker(maker));
		return map;
	}

}
