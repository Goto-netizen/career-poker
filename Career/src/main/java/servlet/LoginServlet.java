/*
 * WebApp_05_sp03_UseBean
 * servlet.EmployeeListServlet.java
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DistributionDAO;
import model.entity.UserBean;

/**
 * 従業員情報の一覧表示を制御する
 * @author emBex Education
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String user_id = request.getParameter("id");
        String password = request.getParameter("password");
	   System.out.println("user"+user_id + password);

		// DAOの生成
	   DistributionDAO dao = new DistributionDAO();
		//転送先	
		String url=null;

		try {
			// DAOの利用
			UserBean user = dao.select(user_id, password);
            if(user.getUser_id() != null) {
            	url="menu.jsp";
            }else {
            	url="login-failure.html";
            }
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定
		HttpSession session = request.getSession();
		session.setAttribute("user_id", user_id);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}