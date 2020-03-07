package model;

import java.util.List;

import dao.QiitaDao;
import javabeans.Article;

public class ArticlesManager {

	QiitaDao qiitaDao = new QiitaDao();
	/**
     * 新着5件の記事を取得する
     * @param  なし
     * @return List<Article>
     */
	public List<Article> newFiveArticles() {
		List<Article> articles = qiitaDao.findAll();
		return articles;

	}
	/**
     * idが一致するものをデータベースから削除
     * @param  deleteId 消したい記事のid
     * @return なし
     */
	public void deleteArticles(String deleteId) {
		qiitaDao.deleteSql(deleteId);
	}
	/**
     * データベースに記事を登録
     * @param qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag 登録する情報
     * @return なし
     */
	public void registerArticles(String qiitaTitle,String qiitaUser,String qiitaUrl,String qiitaDate,String qiitaTag) {
		qiitaDao.registerQiita(qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag);
	}

}
