package model;

import java.sql.SQLException;
import java.util.Map;

public interface ItemService {

	Map<String, Object> getListAndAvgPriceInfo(String maker) throws SQLException;

}