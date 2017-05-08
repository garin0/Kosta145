package model;

public class CarServiceImpl implements CarService {
	private CarDAO carDAO;

	public CarServiceImpl(CarDAO carDAO) {
		super();
		this.carDAO = carDAO;
	}
	/* (non-Javadoc)
	 * @see model.CarService#register(model.CarDTO)
	 */
	@Override
	public void register(CarDTO dto){
		carDAO.register(dto);
	}
}
