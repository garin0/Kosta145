package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO5 {

	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO(); // �����ڿ��� ����̹� �ε�
			/*
			 * percent �� �ش��ϴ� ������ŭ price�� ���ε� �������� ��ǰ��������Ʈ�� ��ȯ�Ǿ� ��µȴ�.
			 */
			int percent = 10;
			ArrayList<ProductVO> list = dao.getProductListDiscountPrice(percent);
			// maker ������ ��µȴ�.
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
