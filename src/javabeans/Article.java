 package javabeans;

import java.io.Serializable;

public class Article implements Serializable {
	private int id;
	private String url;
	private String title;
	private String user_name;
	private String tag;
	private String date;


	public Article() {
		super();
	}


	public Article(int id, String url, String title, String user_name, String tag, String date) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.user_name = user_name;
		this.tag = tag;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}




}
