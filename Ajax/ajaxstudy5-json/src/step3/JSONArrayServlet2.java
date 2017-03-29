package step3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.CarDTO;

/**
 * Servlet implementation class JSONArrayServlet2
 */
@WebServlet("/JSONArrayServlet2")
public class JSONArrayServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSONArrayServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<CarDTO> list = new ArrayList<CarDTO>();
		list.add(new CarDTO("sm5", 500));
		list.add(new CarDTO("k7", 700));
		list.add(new CarDTO("bmw", 900));
		JSONArray arr = new JSONArray(list);
		System.out.println(arr.toString());
		out.print(arr.toString());
		out.close();
	}

}
