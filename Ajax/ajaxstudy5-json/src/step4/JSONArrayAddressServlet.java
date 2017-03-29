package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class JSONArrayAddressServlet
 */
@WebServlet(name = "FindMemberListServlet", urlPatterns = { "/FindMemberListServlet" })
public class JSONArrayAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONArrayAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address = request.getParameter("address");
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberDAO dao = new MemberDAO();
		list = dao.findMemberListByAddress(address);
		JSONArray arr = new JSONArray(list);
		out.print(arr.toString());
		out.close();
	}

}
