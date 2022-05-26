package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/hand-integer-servlet")
public class HandIntegerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandIntegerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String[] ask = request.getParameterValues("submission");
		int number = 0;
		
		System.out.println(Arrays.toString(ask));
		List<Integer> check = new ArrayList<Integer>();
		for(int i=0;i<ask.length;i++) {
		number = Integer.parseInt(ask[i]);
		check.add(number);
		}
		System.out.println(check);
		request.setAttribute("check", check);
		
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("HandCheckServlet.jsp");
		rd.forward(request, response);

	}

}
