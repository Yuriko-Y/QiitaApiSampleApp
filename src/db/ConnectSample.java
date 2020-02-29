package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSample {

    public static void main(String[] args) {
        //DB接続用定数
        String DATABASE_NAME = "register";
        String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
        String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME+PROPATIES;
        //DB接続用・ユーザ定数
        String USER = "root";
        String PASS = "root";

        try {
            //MySQL に接続する
            Class.forName("com.mysql.cj.jdbc.Driver");
            //データベースに接続
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // データベースに対する処理
            System.out.println("データベースに接続に成功");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}