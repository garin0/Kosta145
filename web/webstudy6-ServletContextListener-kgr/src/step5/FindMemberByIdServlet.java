package step5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url,user,pass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMemberByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException{
/*    	String driver= getServletConfig().getServletContext().getInitParameter("db_driver");
    	try {
			Class.forName(driver);
			System.out.println(driver+" loading");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
    	
    	url = getServletConfig().getServletContext().getInitParameter("url");
    	user = getServletConfig().getServletContext().getInitParameter("user");
    	pass = getServletConfig().getServletContext().getInitParameter("pass");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletConfig로 부터 서블릿 이름을 반환받는다.
		String name = this.getServletConfig().getServletName();
		String id = request.getParameter("memberId");
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String sql = "select id,name,address from member where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs  = pstmt.executeQuery();
			if(rs.next()){
				out.print("아이디 "+ rs.getString("id"));
				out.print("<br>이름 "+ rs.getString("name")); 
				out.println("<br>주소 "+rs.getString("address")); 
			}else{
				out.print(id+" 아이디에 해당하는 회원이 없습니다.");
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			out.println(name+" db 연동시 문제 발생!");
			e.printStackTrace();
		}
		out.close();
	}
}
