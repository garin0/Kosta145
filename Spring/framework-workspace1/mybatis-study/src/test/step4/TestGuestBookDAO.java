package test.step4;

import java.util.List;

import model.GuestBookDAO;
import model.GuestBookVO;

public class TestGuestBookDAO {
	public static void main(String[] args) {
		GuestBookDAO dao = GuestBookDAO.getInstance();
		// dao.insertGuestBook(new GuestBookVO("영화", "8월의크리스마스"));
		GuestBookVO vo = new GuestBookVO("노래", "그대라는 사치22");
		System.out.println(vo.getNo()); //0
		dao.insertGuestBook2(vo);
		System.out.println(vo.getNo()); //5
		List<GuestBookVO> list = dao.getAllGuestBookList();
		for(GuestBookVO gvo:list)
			System.out.println(gvo);
	}
}
