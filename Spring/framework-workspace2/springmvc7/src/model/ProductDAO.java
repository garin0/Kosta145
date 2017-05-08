package model;

import java.util.List;

public interface ProductDAO {

	ProductVO register(ProductVO vo);

	List<ProductVO> searchByMaker(String input);

	List<ProductVO> searchByName(String input);

	ProductVO searchById(String id);

}