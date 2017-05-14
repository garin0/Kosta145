package org.kosta.springmvc12.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Resource
	private CarDAO carDAO;
	
	/* (non-Javadoc)
	 * @see org.kosta.springmvc12.model.CarService#getTotalCount()
	 */
	@Override
	public int getTotalCount(){
		return carDAO.getTotalCount();
	}
	@Override
	public List<CarVO> getCarList(){
		return carDAO.getCarList();
	}
}
