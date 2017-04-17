package step3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private HashMap<String,String> map=new HashMap<String,String>();
    public void init(){
    	map.put("기성용", "하와이");
    	map.put("이청용", "몰디브");
    	map.put("손흥민", "판교");
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이름을 클라이언트로부터 넘겨받아 
		// 주소를 map에서 찾아 클라이언트로 응답한다. 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		out.print(map.get(name));
		System.out.println(name+" "+map.get(name));
		out.close();
	}
}









