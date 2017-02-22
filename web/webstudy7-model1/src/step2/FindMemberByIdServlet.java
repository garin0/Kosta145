package step2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMemberByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("memberId");
			MemberVO vo =  MemberDAO.getInstance().findMemberById(id);
			if(vo != null){
				out.print("아이디 "+vo.getId());
				out.println("<br>이름 "+vo.getName());
				out.println("<br>주소 "+vo.getAddress());
			}else{
				out.println(id +" 아이디에 해당하는 회원 없음");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
