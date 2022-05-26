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

import model.dao.DistributionDAO;
import model.entity.UserBean;

/**
 * 従業員情報の一覧表示を制御する
 * @author emBex Education
 */
@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		// リクエストオブジェクトのエンコーディング方式の指定
				request.setCharacterEncoding("UTF-8");

				// リクエストパラメータの取得
				String user_id = request.getParameter("user_id");
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String password = request.getParameter("password");

				UserBean user = new UserBean();
				user.setUser_id(user_id);
				user.setName(name);
				user.setAge(age);
				user.setPassword(password);

				// DAOの生成
				DistributionDAO dao = new DistributionDAO();

				int count = 0;	// 処理件数

				try {
					// DAOの利用
					count = dao.insert(user);

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				// リクエストスコープへの属性の設定
				request.setAttribute("count", count);
				request.setAttribute("user", user);

				// リクエストの転送
				RequestDispatcher rd = request.getRequestDispatcher("register-result.jsp");
				rd.forward(request, response);

			}

		}
