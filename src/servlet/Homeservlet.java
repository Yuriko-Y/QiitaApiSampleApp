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
		@SuppressWarnings("unchecked")
		List<Article> articles = (List<Article>) session.getAttribute("articles");

		//パラメーター
		String deleteId = request.getParameter("deleteId");
		String searchWord = request.getParameter("search");
		String sortType = request.getParameter("sortType");
		String qiitaTitle = request.getParameter("qiitaTitle");
		String qiitaUser = request.getParameter("qiitaUser");
		String qiitaUrl = request.getParameter("qiitaUrl");
		String qiitaDate = request.getParameter("qiitaDate");
		String qiitaTag = request.getParameter("qiitaTag");

		ArticlesManager articlesManager = new ArticlesManager();

		if (deleteId != null) {
			articles = articlesManager.deleteArticles(deleteId, articles);
		} else if (searchWord != null) {
			articles = articlesManager.searchGetArticles(searchWord);
		} else if (sortType != null) {
			articles = articlesManager.sortArticles(sortType, articles);
		} else {
			articles = articlesManager.registerArticles(qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag, articles);
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
