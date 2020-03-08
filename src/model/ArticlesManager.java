package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.icu.text.Transliterator;

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
	public void registerArticles(String qiitaTitle, String qiitaUser, String qiitaUrl, String qiitaDate,
			String qiitaTag) {
		qiitaDao.registerQiita(qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag);
	}

	/**
	 * 全記事から検索した文字列と関連する記事を取得
	 * @param search 検索したいワード
	 * @return List<Article>
	 */
	public List<Article> searchGetArticles(String search) {
		//DBから全記事を取得
		List<Article> articles = qiitaDao.allArticles();
		//ヒットした記事だけ入れるリスト
		List<Article> resultArticles = new ArrayList<Article>();

		Transliterator transliterator = Transliterator.getInstance("Fullwidth-Halfwidth");
		String resultSearch = transliterator.transliterate(search);

		Iterator<Article> iterator = articles.iterator();
		while (iterator.hasNext()) {
			Article article = (Article) iterator.next();

			String title = article.getTitle();
			String tag = article.getTag();
			String name = article.getUser_name();

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(title);
			stringBuilder.append(tag);
			stringBuilder.append(name);

			String smallStringBuilder = stringBuilder.toString().toLowerCase();
			resultSearch = resultSearch.toLowerCase();

			resultSearch = resultSearch.replace("*", "");

			resultSearch = resultSearch.replace(" ", ")(?=.*");



			if (smallStringBuilder.toString().matches("^(?=.*" + resultSearch + ").*$")) {

				resultArticles.add(article);

			}

		}

		return resultArticles;

	}

}
