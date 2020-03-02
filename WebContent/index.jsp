<%@page import="dao.QiitaDao"%>
<%@page import="javabeans.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Article> allArticles = (List<Article>) session.getAttribute("allArticles");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="cssnew/sample.css">
<link rel="stylesheet" href="cssnew/reset.css">
<link rel="stylesheet" href="cssnew/modal.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="js/register.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="content__modal">
		<button class="js-modal-open">登録</button>
		<!-- <a class="js-modal-open" href="">クリックでモーダルを表示</a> -->
	</div>
	<div class="modal js-modal">
		<div class="modal__bg js-modal-close"></div>
		<div class="modal__content">
			<h1 id="modal__title">登録画面</h1>
			URL:<input type="text" id="quiitaurl" name="input01">
			<button id="submit">送信</button>

			<form method="get" action="./Mainservlet">
				TITLE:<input type="text" id="qiita__title" name="qiitaTitle"
					size="60"><br> NAME:<input type="text"
					id="qiita__name" name="qiitaUser" size="10"><br> URL:<input
					type="text" id="qiita__url" name="qiitaUrl" size="50"><br>
				DATE:<input type="text" id="qiita__date" name="qiitaDate" size="10"><br>
				TAG:<input type="text" id="qiita__tag" name="qiitaTag" size="30"><br>
				<button class="js-modal-close">閉じる</button>
				<input type="submit" value="登録" />


			</form>

		</div>
		<!--modal__inner-->
	</div>
	<!--modal-->

	<h3>記事一覧表示</h3>

	<%
		if (allArticles == null) {
	%>
	<%
		QiitaDao qiitaDao = new QiitaDao();
			List<Article> articleList = qiitaDao.findAll();
	%>
	<%
		for (Article article : articleList) {
	%>

	<div>
		<ul>
			<li>
				<div class="contens">


					<div class="parent__right">
						<form action="./Deleteservlet" method="get">
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
									type="submit" value=" 削除 ">
						</form>
					</div>

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