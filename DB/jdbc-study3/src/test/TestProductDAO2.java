package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO2 {

	public static void main(String[] args) {
		try { // 1시 10분 풀이
			ProductDAO dao = new ProductDAO(); // 생성자에서 드라이버 로딩
			ProductVO vo = new ProductVO("d", "아이폰7", "애플", 170);
			ProductVO pvo = dao.findProductById(vo.getId());
			if (pvo == null) {
				dao.registerProduct(vo);
				System.out.println(vo + " insert ok!");
			} else {
				System.out.println(vo.getId() + " 아이디 존재하므로 추가불가");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
