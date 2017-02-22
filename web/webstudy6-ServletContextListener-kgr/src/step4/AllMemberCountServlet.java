package step4;

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
 * Servlet implementation class AllMemberCountServlet
 */
public class AllMemberCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String url,user,pass;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 메서드 호출한다.
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
	 * ServletContext의 초기파라미터를 사용할 수 없다 -> 이유는 ServletConfig는 생성자 호출 다음에 이루어지는
	 * init(ServletConfig) 호출시에 전달되기 때문에 
	 * jdbc 개발 단계
	 * 1. 드라이버 로딩 -> init
	 * 2. 커넥션
	 * 3. PreparedStatement
	 * 4. ResultSet
	 * 5. close
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletConfig로 부터 서블릿 이름을 반환받는다.
		String name = this.getServletConfig().getServletName();
		try {
			Connection con =DriverManager.getConnection(url,user,pass);
			String sql ="select count(*) from member";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs  = pstmt.executeQuery();
			out.print("현 서블릿: "+name+"<br><br>");
			if(rs.next())
				out.print("<h3>총 회원수: "+rs.getInt(1)+"명</h3>");
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
