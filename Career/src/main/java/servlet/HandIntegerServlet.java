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

import model.item.Card;

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
		
		System.out.println("Arrays.toString"+Arrays.toString(ask));
		List<Integer> index = new ArrayList<Integer>();
		for(int i=0;i<ask.length;i++) {
			number = Integer.parseInt(ask[i]);
			index.add(number);
		}
		System.out.println("手札リストの要素番号:"+index);
		
		HttpSession session = request.getSession();
		session.setAttribute("index", index);
		int x = (Integer)session.getAttribute("x");
		x++;
		session.setAttribute("x", x);
		
		//7,10,12の捨てるカード用
		List<Integer> abilityIndex = new ArrayList<Integer>();
		abilityIndex.add(number);
		session.setAttribute("abilityIndex", abilityIndex);

		
		//リクエストの転送
		//10を選んだ時に捨てるカード選択画面に行きます
		List<Card> deckList = (List<Card>)session.getAttribute("deckList");

		if(index.get(0) == -1) {
			RequestDispatcher rd = request.getRequestDispatcher("Processing_withOptionServlet");
			rd.forward(request, response);
		}else if(deckList.get(index.get(0)).getStrength()==7) {
			RequestDispatcher rd = request.getRequestDispatcher("seven.jsp");
			rd.forward(request, response);
		}else if(deckList.get(index.get(0)).getStrength()==10) {
			RequestDispatcher rd = request.getRequestDispatcher("ten.jsp");
			rd.forward(request, response);
		}else if(deckList.get(index.get(0)).getStrength()==12){
			RequestDispatcher rd = request.getRequestDispatcher("Queen.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Processing_withOptionServlet");
			rd.forward(request, response);
		}
	



	}

}
