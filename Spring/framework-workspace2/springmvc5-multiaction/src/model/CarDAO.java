package model;

public interface CarDAO {

	void register(CarDTO dto);
	CarDTO findCarDTO();

}