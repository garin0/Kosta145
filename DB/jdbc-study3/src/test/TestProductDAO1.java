package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO1 {

	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO(); // �����ڿ��� ����̹� �ε�
			ProductVO pvo = dao.findProductById("a");
			System.out.println(pvo); // ������ null
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
