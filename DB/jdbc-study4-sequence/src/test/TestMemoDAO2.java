package test;

import java.util.ArrayList;

import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO2 {

	public static void main(String[] args) {
		try {
			MemoDAO dao = new MemoDAO(); // driver loading
			ArrayList<MemoVO> list = dao.getAllMemoList();
			// 최신순- 내림차순
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
