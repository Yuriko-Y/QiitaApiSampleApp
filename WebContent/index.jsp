<%@page import="model.ArticlesManager"%>
<%@page import="dao.QiitaDao"%>
<%@page import="javabeans.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="register.jsp" %>
<%
	List<Article> articles = (List<Article>) session.getAttribute("articles");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<!-- <link rel="stylesheet" href="cssnew/search.css"> -->
<link rel="stylesheet" href="cssnew/sample.css">
<link rel="stylesheet" href="cssnew/reset.css">
<!-- <link rel="stylesheet" href="cssnew/modal.css"> -->
<link rel="stylesheet" href="cssnew/select.css">
<script type="text/javascript" src="js/delete.js"></script>
 <script src="js/register.js"></script>
<title>Miita</title>
</head>
<body>
	<header>
		<form action="./Homeservlet" method="get">
			<%
				String selectedItem = (String) request.getParameter("sortType");
			%>
			<div class="cp_ipselect cp_sl01">
				<select name="sortType" onchange="submit(this.form)">
					<option value="">並べ替えメニュー</option>
					<option value="new"
						<%="new".equals(selectedItem) ? "selected=\"selected\"" : ""%>>登録が新しい順</option>
					<option value="new_date"
						<%="new_date".equals(selectedItem) ? "selected=\"selected\"" : ""%>>投稿日時が新しい順</option>
					<option value="old_date"
						<%="old_date".equals(selectedItem) ? "selected=\"selected\"" : ""%>>投稿日時が古い順</option>
				</select>
			</div>
		</form>

	</header>


	<%
		if (articles == null) {
	%>
	<%
		ArticlesManager articlesManager = new ArticlesManager();
			List<Article> articleList = articlesManager.newFiveArticles();
			session.setAttribute("articles", articleList);
	%>
	<%
		for (Article article : articleList) {
	%>

	<div>
		<ul>
			<li>
				<div class="contens">


					<div class="parent__right">
						<form action="./Homeservlet" method="get"
							onsubmit="return checkdelete();">
							<p class="date"><%=article.getDate()%></p>
							<p class="title"><%=article.getTitle()%></p>
							<p class="url">【URL】</p>
							<a class="url__href" href=<%=article.getUrl()%>><%=article.getUrl()%></a>
							<p class="tag">
								【tag】<%=article.getTag()%></p>
							<div class="name__view">
								<p class="item">
									【User name】<%=article.getUser_name()%></p>
								<input type="hidden" name="deleteId"
									value="<%=article.getId()%>"> <input class="item"
									type="submit" value="削除">
							</div>
						</form>
					</div>

				</div>
			</li>
		</ul>
	</div>

	<%
		}
	%>
	<%
		} else {
	%>
	<%
		for (Article artcles : articles) {
	%>

	<div>
		<ul>
			<li>
				<div class="contens">


					<div class="parent__right">
						<form action="./Homeservlet" method="get"
							onsubmit="return checkdelete();">
							<p class="date"><%=artcles.getDate()%></p>
							<p class="title"><%=artcles.getTitle()%></p>
							<p class="url">【URL】</p>
							<a class="url__href" href=<%=artcles.getUrl()%>><%=artcles.getUrl()%></a>
							<p class="tag">
								【tag】<%=artcles.getTag()%></p>
							<div class="name__view">
								<p class="item">
									【User name】<%=artcles.getUser_name()%></p>
								<input type="hidden" name="deleteId"
									value="<%=artcles.getId()%>"> <input class="item"
									type="submit" value="削除">
							</div>
						</form>
					</div>

				</div>
			</li>
		</ul>
	</div>

	<%
		}
	%>



	<%
		}
	%>

</body>
</html>