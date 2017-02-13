package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO3 {

	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO(); // 생성자에서 드라이버 로딩
			int highPrice = 150;
			int lowPrice = 120;
			// lowprice 이상~ highprice 이하 상품을 내림차순으로 조회
			ArrayList<ProductVO> list = dao.getProductListByPrice(lowPrice, highPrice);
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
