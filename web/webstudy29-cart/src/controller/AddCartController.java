package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemDAO;
import model.ItemVO;

public class AddCartController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		ItemVO vo = ItemDAO.getInstance().findItemByNo(no);
		@SuppressWarnings("unchecked")
		ArrayList<ItemVO> list = (ArrayList<ItemVO>) request.getSession().getAttribute("cart");
		if(list == null){
			list =  new ArrayList<ItemVO>();
			request.getSession().setAttribute("cart", list);
		}
		
		Iterator<ItemVO> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getItemNo().equals(no)){
				return "duplicate_cart.jsp";
			}
		}
			list.add(vo);
			return "redirect:cart.jsp";
		
	}

}
