package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class AjaxFindIdServlet
 */
@WebServlet("/AjaxFindIdServlet")
public class AjaxFindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxFindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		MemberVO info;
		try {
			info = MemberDAO.getInstance().findMemberById(id);
			if(info!=null){
				out.println("아이디: "+info.getId());
				out.println("이름: "+info.getName());
				out.println("주소: "+info.getAddress());
			System.out.println(info.getId());
			}else{
				out.println("없눈뎅");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
