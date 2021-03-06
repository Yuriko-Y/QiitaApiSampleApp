package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
	 * @param  articles 現在表示されている記事
	 * @return List<Article>
	 */
	public List<Article> deleteArticles(String deleteId, List<Article> articles) {
		qiitaDao.deleteSql(deleteId);
		for (Iterator<Article> iterator = articles.iterator(); iterator.hasNext();) {
			Article article = (Article) iterator.next();
			int id = Integer.parseInt(deleteId);
			if (article.getId() == id) {
				iterator.remove();
			}
		}

		return articles;
	}

	/**
	 * データベースに記事を登録
	 * @param qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag 登録する情報
	 * @param articles 現在表示されている記事
	 * @return List<Article>
	 */
	public List<Article> registerArticles(String qiitaTitle, String qiitaUser, String qiitaUrl, String qiitaDate,
			String qiitaTag, List<Article> articles) {
		qiitaDao.registerQiita(qiitaTitle, qiitaUser, qiitaUrl, qiitaDate, qiitaTag);
		articles = this.newFiveArticles();
		return articles;

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

		//全角を半角に
		Transliterator transliteratorToSmall = Transliterator.getInstance("Fullwidth-Halfwidth");
		search = transliteratorToSmall.transliterate(search);

		Transliterator transLiterKana = Transliterator.getInstance("Katakana-Hiragana");
		search = transLiterKana.transliterate(search);
		search = search.toLowerCase();
		search = search.replace("*", "");
		search = search.replaceAll(" ", ")(?=.*");

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

			String wordFromDB = stringBuilder.toString().toLowerCase();
			wordFromDB = transLiterKana.transliterate(wordFromDB);

			if (wordFromDB.matches("^(?=.*" + search + ").*$")) {

				resultArticles.add(article);

			}

		}

		return resultArticles;

	}

	/**
	 * 表示している記事の並べ替え
	 * @param sort 何順(投稿日時新しい順、古い順)
	 * @param articles 在表示されている記事
	 * @return List<Article> 並べ替わった記事の一覧
	 */
	public List<Article> sortArticles(String sort, List<Article> articles) {

		if (sort.equals("new_date")) {
			Collections.sort(articles, (a, b) -> {
				Date date1 = null;
				Date date2 = null;

				String dateString1 = a.getDate();
				String dateString2 = b.getDate();

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date1 = simpleDateFormat.parse(dateString1);
					date2 = simpleDateFormat.parse(dateString2);

				} catch (ParseException e) {
					e.printStackTrace();
				}

				return date2.compareTo(date1);

			});

		} else if (sort.equals("old_date")) {
			Collections.sort(articles, (a, b) -> {
				Date date1 = null;
				Date date2 = null;
				String dateString1 = a.getDate();
				String dateString2 = b.getDate();

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date1 = simpleDateFormat.parse(dateString1);
					date2 = simpleDateFormat.parse(dateString2);

				} catch (ParseException e) {
					e.printStackTrace();
				}

				return date1.compareTo(date2);

			});

		} else {
			Collections.sort(articles, (a, b) -> {
				return b.getId() - a.getId();
			});
		}

		return articles;

	}

}
