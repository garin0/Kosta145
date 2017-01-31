package step5;

import java.util.ArrayList;

public class CartService {

	ArrayList<ProductVO> list = new ArrayList<ProductVO>();

	public void addProduct(ProductVO pvo) {
		list.add(pvo);
	}

	public void printAllName() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}

	public ArrayList<ProductVO> findProductByMaker(String maker) {
		ArrayList<ProductVO> findList = new ArrayList<ProductVO>();
		for (int i = 0; i < list.size(); i++) {
			if (maker.equals(list.get(i).getMaker())) {
				findList.add(list.get(i));
			}
		}
		return findList;
	}

}
