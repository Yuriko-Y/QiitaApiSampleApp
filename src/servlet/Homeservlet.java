package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.Article;
import model.ArticlesManager;

@WebServlet("/Homeservlet")
public class Homeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//今表示されている記事
		HttpSession session = request.getSession();
		List<Article> articles=(List<Article>) session.getAttribute("articles");

		//パラメーター
		String deleteId=request.getParameter("deleteId");
		String search=request.getParameter("searchword");

		ArticlesManager articlesManager=new ArticlesManager();

		if (deleteId!=null) {
			articlesManager.deleteArticles(deleteId);
		}else if (search!=null) {
			articles=articlesManager.searchGetArticles(search);
		}


		//セッションに上書き
		session.setAttribute("articles", articles);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
