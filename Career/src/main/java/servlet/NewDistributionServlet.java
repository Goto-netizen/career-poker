package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.item.Card;
import model.item.Deck;

/**
 * Servlet implementation class NewDistributionServlet
 */
@WebServlet("/new-distribution-servlet")
public class NewDistributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDistributionServlet() {
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
		//フィールドスタックの宣言
		Stack<Card> fieldStack = new Stack<Card>();
		//Deckの生成
		Deck deck = new Deck();
		List<Card> cardList = deck.distribution();
		
		//セッション
	    HttpSession session = request.getSession();
	    session.setAttribute("cardList", cardList);
	    session.setAttribute("fieldStack", fieldStack);

		
	 // リクエストの転送
	 		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
	 		rd.forward(request, response);
	}
	

}
