<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Miita</title>
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="cssnew/reset.css">
<link rel="stylesheet" href="cssnew/modal.css">
<link rel="stylesheet" href="cssnew/search.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="js/register.js"></script>
</head>
<body>
	 <div class="searchbox__left">
			<form method="get" action="./Homeservlet" class="search_container">
				<input type="text" size="25" placeholder="キーワード検索" name="search">
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

				<form method="get" action="./Homeservlet">
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
</body>
</html>