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
		HttpSession session = request.getSession();
		List<Integer> indexList = (List<Integer>)session.getAttribute("index");
		int index = indexList.get(0);
		//index = 0;//テスト用の値
		
		List<Card> deckList = (List<Card>)session.getAttribute("deckList");
		Deque<Card> fieldDeque =(Deque<Card>)session.getAttribute("fieldDeque");
		
		/*処理の依頼*/
		GeneralProcessing gp = new GeneralProcessing(deckList,fieldDeque);
		
		gp.generalProcess(index);
		deckList = gp.getDeckList();
		fieldDeque = gp.getFieldDeque();
		
		/*送信*/
		session.setAttribute("deckList",deckList);
		session.setAttribute("fieldDeque",fieldDeque);
		session.setAttribute("winner", "CPU");
		
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
