package model;

public class CarDAOImpl implements CarDAO {
	/* (non-Javadoc)
	 * @see model.CarDAO#register(model.CarDTO)
	 */
	@Override
	public void register(CarDTO dto){
		System.out.println(dto + " insert ok~");
	}
	@Override
	public CarDTO findCarDTO(){
		return new CarDTO("sm5",500);
	}
}
