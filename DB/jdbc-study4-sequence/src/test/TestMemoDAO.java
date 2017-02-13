package test;

import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO {

	public static void main(String[] args) {
		try {
			MemoDAO dao = new MemoDAO();
			dao.insertMemo(new MemoVO("저녁메뉴", "꽃등심"));
			System.out.println("메모등록 ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
