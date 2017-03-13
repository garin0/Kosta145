package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemVO;

public class DeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");
		@SuppressWarnings("unchecked")
		ArrayList<ItemVO> list = (ArrayList<ItemVO>) request.getSession().getAttribute("cart");
		Iterator<ItemVO> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getItemNo().equals(no)){
				it.remove();
			}
		}
		return "redirect:cart.jsp";
	}

}
