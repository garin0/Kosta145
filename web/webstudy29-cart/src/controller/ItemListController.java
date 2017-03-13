package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemDAO;
import model.ItemVO;

public class ItemListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ItemVO> list = ItemDAO.getInstance().getAllItemList();
		String url = null;
		if(!list.isEmpty()){
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			url = "item_list.jsp";
		}else{
			url = "error.jsp";
		}
		return url;
	}

}
