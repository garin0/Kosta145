package org.kosta.springmvc12.model;

import java.util.List;

public interface CarService {

	int getTotalCount();

	List<CarVO> getCarList();

}