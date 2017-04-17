package step6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class JSONServlet
 */
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		System.out.println(command + " "+id);
		JSONObject obj = new JSONObject();
		obj.put("name", "정우성");
		obj.put("age", age++);
		System.out.println(obj.toString());
		out.print(obj.toString());
		
		out.close();
	}

	int age;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		JSONArray ja = new JSONArray();
		ja.put("정우성");
		ja.put("이나영");
		ja.put("이솜");
		System.out.println(ja.toString());
		out.print(ja.toString());			
		out.close();
	}
}
