package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CardBean;
import model.entity.UserBean;




public class DistributionDAO {
	public int insert(UserBean user) throws SQLException, ClassNotFoundException {
		int count = 0; //処理件数

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO m_user VALUE(?, ?, ?, ?)")) {

			// DTOからのデータの取り出し
			String user_id = user.getUser_id();
			String name = user.getName();
			int age = user.getAge();
			String password = user.getPassword();

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setInt(4, age);

			// SQLステートメントの実行
			count = pstmt.executeUpdate();
		}

		return count;

	}
	public UserBean select(String user_id, String password)
			throws SQLException, ClassNotFoundException {

		UserBean user = new UserBean();
        
		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);
			pstmt.setString(2, password);

			// SQLステートメントの実行
			System.out.println(pstmt);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				System.out.println(res.getString("user_id"));

			// 結果の操作
				user.setUser_id(res.getString("user_id"));
				System.out.println(user.getUser_id());
			}
		}
		return user;
	}
public List<CardBean> selectAll()
		throws SQLException, ClassNotFoundException {

	List<CardBean> distributionList = new ArrayList<CardBean>();

	// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
	try (Connection con = ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("SELECT * FROM card")) {

		// 結果の操作
		while (res.next()) {
			int code = res.getInt("code");
			String num = res.getString("num");
			String mark = res.getString("mark");
			int strength = res.getInt("strength");



			CardBean distribution = new CardBean();
			distribution.setCode(code);
			distribution.setNum(num);
			distribution.setMark(mark);
			distribution.setStrength(strength);



			distributionList.add(distribution);
		}
	}
	return distributionList;
}
}
