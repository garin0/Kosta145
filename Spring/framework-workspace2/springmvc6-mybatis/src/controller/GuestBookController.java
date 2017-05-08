package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.GuestBookDAO;

public class GuestBookController extends MultiActionController{
	private GuestBookDAO guestBookDAO;

	public GuestBookController(GuestBookDAO guestBookDAO) {
		super();
		this.guestBookDAO = guestBookDAO;
	}
	public ModelAndView getAllGuestBookList(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("guestbook_list","guestList",guestBookDAO.getAllGuestBookList());
	}
}
