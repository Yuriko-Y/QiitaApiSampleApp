package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Article;

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


	public List<Article> findAll() {
		List<Article> articleList = new ArrayList<Article>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			//全部の記事表示
			String sql = "SELECT * FROM articles ORDER BY date DESC";

			PreparedStatement pStatement = conn.prepareStatement(sql);

			ResultSet rSet = pStatement.executeQuery();

			while (rSet.next()) {

				int id = rSet.getInt("id");
				String url = rSet.getString("url");
				String title = rSet.getString("title");
				String user_name = rSet.getString("user_name");
				String tag = rSet.getString("tag");
				String date = rSet.getString("date");

				Article article =new Article(id, url, title, user_name, tag, date);
				articleList.add(article);

			}

			return articleList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return articleList;

	}
	//idが一致するものをデータベースから削除
		public boolean deleteSql(String parameterId) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(URL, USER, PASS);

				String sql = "DELETE FROM articles WHERE id=?";

				PreparedStatement pStatement = conn.prepareStatement(sql);
				pStatement.setString(1, parameterId);

				int result = pStatement.executeUpdate();
				if (result != 1) {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;

			}
			return true;

		}


}
