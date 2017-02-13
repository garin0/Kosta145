package test;

import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO4 {

	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO(); // 생성자에서 드라이버 로딩
			ArrayList<String> list = dao.getProductMakerKind();
			//maker 종류가 출력된다.
			for(int i = 0 ; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
