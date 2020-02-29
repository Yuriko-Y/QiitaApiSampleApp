package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//[5]
	        out.println("<html><head></head><body>");//[6]
	        out.println("<p>リンクによってセカンドサーブレットが呼び出されました。</p>");//[7]
	        out.println("</body></html>");//[8]
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
