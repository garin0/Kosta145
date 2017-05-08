package model;

public class CustomerDAOImpl implements CustomerDAO {
	/* (non-Javadoc)
	 * @see model.CustomerDAO#findCustomerById(java.lang.String)
	 */
	@Override
	public String findCustomerById(String id){
		if(id.equals("java"))
			return "임경수 판교";
		else
			return null;
	}
}
