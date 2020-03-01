package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QiitaDao {
	//DB接続用定数
	static final String DATABASE_NAME = "register";
	static final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
	static final String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	//DB接続用・ユーザ定数
	static final String USER = "root";
	static final String PASS = "root";

	//登録メソッド
	public boolean registerQiita(String qiitaTitle, String qiitaUser, String qiitaUrl, String qiitaDate,
			String qiitaTag) {
		try {
			//MySQL に接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースに接続
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			//SQL文
			String sql = "INSERT INTO articles(url,title,user_name,tag,date)"
					+ " VALUES(?,?,?,?,?)";

			PreparedStatement pStatement = conn.prepareStatement(sql);

			pStatement.setString(1, qiitaUrl);
			pStatement.setString(2, qiitaTitle);
			pStatement.setString(3, qiitaUser);
			pStatement.setString(4, qiitaTag);
			pStatement.setString(5, qiitaDate);

			int result=pStatement.executeUpdate();

			if (result!=1) {
				return false;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//登録メソッド
		public boolean findAll(String qiitaTitle, String qiitaUser, String qiitaUrl, String qiitaDate,
				String qiitaTag) {
			try {
				//MySQL に接続する
				Class.forName("com.mysql.cj.jdbc.Driver");
				//データベースに接続
				Connection conn = DriverManager.getConnection(URL, USER, PASS);
				//SQL文
				String sql = "INSERT INTO articles(url,title,user_name,tag,date)"
						+ " VALUES(?,?,?,?,?)";

				PreparedStatement pStatement = conn.prepareStatement(sql);

				pStatement.setString(1, qiitaUrl);
				pStatement.setString(2, qiitaTitle);
				pStatement.setString(3, qiitaUser);
				pStatement.setString(4, qiitaTag);
				pStatement.setString(5, qiitaDate);

				int result=pStatement.executeUpdate();

				if (result!=1) {
					return false;
				}

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}


}
