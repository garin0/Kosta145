package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO1 {

	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO(); // 생성자에서 드라이버 로딩
			ProductVO pvo = dao.findProductById("a");
			System.out.println(pvo); // 없으면 null
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
