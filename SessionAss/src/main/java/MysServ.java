

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class MysServ
 */
public class MysServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("shubham");
		list.add("ajinkya");
		list.add("akshay");
		list.add("yash");
		list.add("amar");
		list.add("abhishek");
		HttpSession session= request.getSession();
		session.setAttribute("li", list);
		PrintWriter pw=response.getWriter();
		pw.println("session has been created");
	}

}
