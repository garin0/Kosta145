package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {

	ArrayList<ItemVO> getItemListByMaker(String maker) throws SQLException;

	int getAvgPriceByMaker(String maker) throws SQLException;

}