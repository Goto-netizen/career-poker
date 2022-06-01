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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewDistributionServlet
 */
@WebServlet("/ability-hand-integer-servlet")
public class AbilityHandIntegerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbilityHandIntegerServlet() {
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


		request.setCharacterEncoding("UTF-8");
		String[] ask = request.getParameterValues("submission");
		int number = 0;
		
		System.out.println(Arrays.toString(ask));
		List<Integer> abilityIndex = new ArrayList<Integer>();
			for(int i=0;i<ask.length;i++) {
				number = Integer.parseInt(ask[i]);
				abilityIndex.add(number);
			}
		System.out.println(abilityIndex);
		
		HttpSession session = request.getSession();
		//セッション

		session.setAttribute("abilityIndex", abilityIndex);


		
	    // リクエストの転送
	 	RequestDispatcher rd = request.getRequestDispatcher("Processing_withOptionServlet");
	 	rd.forward(request, response);
	}
	

}