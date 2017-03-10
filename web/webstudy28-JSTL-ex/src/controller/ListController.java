package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarDAO;
import model.ListVO;
import model.PagingBean;

public class ListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ListVO listVO = new ListVO();
		listVO.setCarList(CarDAO.getInstance().getCarList());
		PagingBean pagingbean = new PagingBean();
		pagingbean.setNowPage(3);
		pagingbean.setStartPage(1);
		pagingbean.setEndPage(5);
		listVO.setPagingbean(pagingbean);
		request.setAttribute("listVO", listVO);
		return "list.jsp";
	}
	
}
