package org.kosta.springmvc12.model;

import java.util.List;

public interface CarDAO {

	int getTotalCount();

	List<CarVO> getCarList();

}