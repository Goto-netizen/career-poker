package servlet;

import java.io.IOException;
import java.util.Deque;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.generalProcess.GeneralProcessing;
import model.item.Card;

/**
 * Servlet implementation class NewProcessingServlet
 */
@WebServlet("/NewProcessingServlet")
public class NewProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProcessingServlet() {
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
		
		/*受け取り*/
		int index = Integer.parseInt(request.getParameter("index"));
		index = 0;//テスト用の値
		HttpSession session = request.getSession();
		List<Card> deckList = (List<Card>)session.getAttribute("deck");
		Deque<Card> deque =(Deque<Card>)session.getAttribute("deque");
		
		/*処理の依頼*/
		GeneralProcessing gp = new GeneralProcessing(deckList);
		
		gp.generalProcess(deckList,index,deque);
		
		/*送信*/
		//リクエストの転送
		if(gp.getEndGameFlag() == true) {
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("game.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}
	
}
