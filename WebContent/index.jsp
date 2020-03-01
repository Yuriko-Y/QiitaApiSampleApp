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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="js/register.js"></script>
<title>Insert title here</title>
</head>
<body>
	URL:
	<input type="text" id="quiitaurl" name="input01">
	<button id="submit">送信</button>


	<form method="get" action="./Mainservlet">
		TITLE:<input type="text" id="qiita__title" name="qiitaTitle" size="60"><br>
		NAME:<input type="text" id="qiita__name" name="qiitaUser" size="10"><br>
		URL:<input type="text" id="qiita__url" name="qiitaUrl" size="50"><br>
		DATE:<input type="text" id="qiita__date" name="qiitaDate" size="10"><br>
		TAG:<input type="text" id="qiita__tag" name="qiitaTag" size="30"><br>
		<input type="submit" value="登録" />
	</form>


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
						<p class="date"><%=article.getDate() %></p>
						<p class="title"><%=article.getTitle() %></p>
						<p class="url">【URL】</p>
						<a class="url__href"
							href=<%=article.getUrl() %>><%=article.getUrl() %></a>
						<p class="tag">【tag】<%=article.getTag() %></p>
						<div class="name__view">
							<p class="item">【User name】<%=article.getUser_name() %></p>
							<button class="item">削除</button>
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



	<div>
		<!-- リスト親 -->
		<ul>
			<!-- 各要素 -->
			<li>
				<div class="contens">


					<div class="parent__right">
						<p class="date">2020.02.05</p>
						<p class="title">初めてのチーム制作!!コード管理編～EclipseでGitHubを使いこなそう～</p>
						<p class="url">【URL】</p>
						<a class="url__href"
							href="https://qiita.com/Yuriko-Y/items/c522253ccf095e1b8158">https://qiita.com/Yuriko-Y/items/c522253ccf095e1b8158</a>
						<p class="tag">【tag】Android,Androidアプリ,playstore</p>
						<div class="name__view">
							<p class="item">【User name】山崎友梨子</p>
							<button class="item">削除</button>
						</div>

					</div>
				</div>
			</li>
		</ul>
	</div>

</body>
</html>