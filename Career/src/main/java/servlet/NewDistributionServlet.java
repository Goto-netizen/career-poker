package servlet;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

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
		//フィールドデキューの宣言
		Deque<Card> fieldDeque = new ArrayDeque<Card>();
		//Deckの生成
		Deck deck = new Deck();
		//List<Card> deckList = deck.distribution();
		deck.distribution();
		
		//セッション
	    HttpSession session = request.getSession();
	    //session.setAttribute("deckList", deckList);
	    session.setAttribute("deckList", deck.cardList);
	    
	    session.setAttribute("fieldDeque", fieldDeque);
		
	    // リクエストの転送
	 	RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
	 	rd.forward(request, response);
	}
	

}
