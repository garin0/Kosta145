package test;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO2 {

	public static void main(String[] args) {
		try { // 1�� 10�� Ǯ��
			ProductDAO dao = new ProductDAO(); // �����ڿ��� ����̹� �ε�
			ProductVO vo = new ProductVO("d", "������7", "����", 170);
			ProductVO pvo = dao.findProductById(vo.getId());
			if (pvo == null) {
				dao.registerProduct(vo);
				System.out.println(vo + " insert ok!");
			} else {
				System.out.println(vo.getId() + " ���̵� �����ϹǷ� �߰��Ұ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
