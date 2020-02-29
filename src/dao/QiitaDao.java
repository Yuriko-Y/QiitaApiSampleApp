package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QiitaDao {
	//DB接続用定数
	static final String DATABASE_NAME = "register";
	static final String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
	static final String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME + PROPATIES;
	//DB接続用・ユーザ定数
	static final String USER = "root";
	static final String PASS = "root";

	public void findAll(String qiitaTitle, String qiitaUser, String qiitaUrl, String qiitaDate, String qiitaTag) {
		try {
			//MySQL に接続する
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースに接続
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			// データベースに対する処理
			System.out.println("データベースに接続に成功");

			System.out.println(qiitaTitle);
			System.out.println(qiitaUser);
			System.out.println(qiitaUrl);
			System.out.println(qiitaDate);
			System.out.println(qiitaTag);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
