package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flag = request.getParameter("flag");
		int no =Integer.parseInt(request.getParameter("no"));
		request.getSession().setAttribute("no", no);
		String url = null;
		if(flag.equals("delete")){
			url =  "board/pwcheck_delete.jsp";
		}else{
			url ="board/pwcheck_update.jsp";
		}
		return url;
	}

}
