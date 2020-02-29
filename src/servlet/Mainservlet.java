package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QiitaDao;


@WebServlet("/Mainservlet")
public class Mainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg="";

		String qiitaTitle=request.getParameter("qiitaTitle");
		String qiitaUser=request.getParameter("qiitaUser");
		String qiitaUrl=request.getParameter("qiitaUrl");
		String qiitaDate=request.getParameter("qiitaDate");
		String qiitaTag=request.getParameter("qiitaTag");

		QiitaDao qiitaDao=new QiitaDao();
		boolean canRegister=qiitaDao.registerQiita(qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag);

		if (canRegister) {
			//登録成功
			msg="登録に成功しました。";
			System.out.println(msg);
		}else {
			//登録失敗
			msg="登録に失敗しました。";
			System.out.println(msg);
		}
		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		  dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
