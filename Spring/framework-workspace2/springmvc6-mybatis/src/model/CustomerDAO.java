package model;

import java.util.ArrayList;
import java.util.List;

public interface CustomerDAO {

	CustomerVO findCustomerById(String id);

	int register(CustomerVO vo);

	List<CustomerVO> getAllCutomerList();

}