<%@page import="model.ArticlesManager"%>
<%@page import="dao.QiitaDao"%>
<%@page import="javabeans.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Article> articles = (List<Article>) session.getAttribute("articles");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="cssnew/search.css">
<link rel="stylesheet" href="cssnew/sample.css">
<link rel="stylesheet" href="cssnew/reset.css">
<link rel="stylesheet" href="cssnew/modal.css">
<link rel="stylesheet" href="cssnew/select.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="js/register.js"></script>
  <script type="text/javascript" src="js/delete.js"></script>
<title>Miita</title>
</head>
<body>
	<header>
	 <div class="searchbox__left">
        <form method="get" action="./Homeservlet" class="search_container">
            <input type="text" size="25" placeholder="キーワード検索" name="searchword">
            <input type="submit" value="&#xf002">
          </form>
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
	 </div>
	  <form action="./Homeservlet" method="get">
     <div class="cp_ipselect cp_sl01">
        <select name="inorder" onchange="submit(this.form)">
          <option value="">並べ替えメニュー</option>
           <option value="new">登録が新しい順</option>
          <option  value="new_date">投稿日時が新しい順</option>
          <option  value="old_date">投稿日時が古い順</option>
        </select>
    </div>
  </form>
    </header>



	<%
		if (articles == null) {
	%>
	<%
			ArticlesManager articlesManager=new ArticlesManager();
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
						<form action="./Homeservlet" method="get"onsubmit="return checkdelete();">
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
									value="<%=article.getId()%>">
									<input class="item"
									type="submit" value="削除">
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
		}else{
	%>
<%
		for (Article artcles : articles) {
	%>

	<div>
		<ul>
			<li>
				<div class="contens">


					<div class="parent__right">
						<form action="./Homeservlet" method="get"onsubmit="return checkdelete();">
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
									value="<%=artcles.getId()%>">

									<input class="item"
									type="submit" value="削除">
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



	<%} %>

</body>
</html>