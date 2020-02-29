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

		String qiitaTitle=request.getParameter("qiitaTitle");
		String qiitaUser=request.getParameter("qiitaUser");
		String qiitaUrl=request.getParameter("qiitaUrl");
		String qiitaDate=request.getParameter("qiitaDate");
		String qiitaTag=request.getParameter("qiitaTag");
//
//		System.out.println(qiitaTitle);
//		System.out.println(qiitaUser);
//		System.out.println(qiitaUrl);
//		System.out.println(qiitaDate);
//		System.out.println(qiitaTag);
		QiitaDao qiitaDao=new QiitaDao();
		qiitaDao.findAll(qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag);


		//フォワード
		RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
		  dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
