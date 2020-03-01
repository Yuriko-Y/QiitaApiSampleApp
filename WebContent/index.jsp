<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sample.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
 <script src="js/register.js"></script>
<title>Insert title here</title>
</head>
<body>
URL:<input type="text" id="quiitaurl" name="input01">
    <button id="submit">送信</button>


    <form method="get" action="./Mainservlet">
    TITLE:<input type="text" id="qiita__title" name="qiitaTitle"size="60"><br>
    NAME:<input type="text" id="qiita__name" name="qiitaUser"size="10"><br>
    URL:<input type="text" id="qiita__url" name="qiitaUrl"size="50"><br>
    DATE:<input type="text" id="qiita__date" name="qiitaDate"size="10"><br>
    TAG:<input type="text" id="qiita__tag" name="qiitaTag"size="30"><br>
    <input type="submit" value="登録" />
    </form>
</body>
</html>