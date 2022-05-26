package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DistributionDAO;
import model.entity.CardBean;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/distribution-servlet")
public class DistributionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributionServlet() {
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
	List<CardBean> distributionList = null;
	List<CardBean> MyHandList = null;
	List<CardBean> EnemyHandList = null;
	List<CardBean> FieldList = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		
		// DAOの生成
		DistributionDAO dao = new DistributionDAO();
		

		try {
			// DAOの利用
			distributionList = dao.selectAll();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		Collections.shuffle(distributionList);
		//手札の分配
		MyHandList = distributionList.subList(0, 16);
		EnemyHandList = distributionList.subList(16, 32);
		
		//並び替え（昇順）	
		MyHandList.sort(Comparator.comparing(CardBean::getStrength));
		EnemyHandList.sort(Comparator.comparing(CardBean::getStrength));
		
		//先攻後攻の判定
		Random rand = new Random();
	    int num = rand.nextInt(1);
	    String url = null;
	    if(num==0) {
	    	url="game.jsp";
	    }else {
	    	url="cpu.jsp";
	    }
		

		// リクエストスコープへの属性の設定
	    HttpSession session = request.getSession();
	    session.setAttribute("MyHandList", MyHandList);
	    session.setAttribute("FieldList", FieldList);
	    session.setAttribute("EnemyHandList", EnemyHandList);
	

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}