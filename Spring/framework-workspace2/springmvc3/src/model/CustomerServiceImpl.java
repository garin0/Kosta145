package model;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAO;

	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	/* (non-Javadoc)
	 * @see model.CustomerService#findCustomerById(java.lang.String)
	 */
	@Override
	public String findCustomerById(String id){
		return customerDAO.findCustomerById(id);
	}
}
