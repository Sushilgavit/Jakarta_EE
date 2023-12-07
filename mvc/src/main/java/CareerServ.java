

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.CareerExpert;

import java.io.IOException;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         String s=request.getParameter("qualification");
         CareerExpert c1=new CareerExpert();
         String advice=c1.getAdvice(s);
         request.setAttribute("advice", advice);
         request.getRequestDispatcher("CareerDetails.jsp").forward(request, response);
         
	}

}
