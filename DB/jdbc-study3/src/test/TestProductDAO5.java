package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO5 {

	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO(); // 생성자에서 드라이버 로딩
			/*
			 * percent 에 해당하는 비율만큼 price가 할인된 가격으로 상품정보리스트가 반환되어 출력된다.
			 */
			int percent = 10;
			ArrayList<ProductVO> list = dao.getProductListDiscountPrice(percent);
			// maker 종류가 출력된다.
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
