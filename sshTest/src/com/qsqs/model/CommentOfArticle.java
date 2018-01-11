package com.qsqs.model;

public class CommentOfArticle {

	// Fields
	private Integer id;
	private String username;
	private String date;
	private String comment;
    private Integer articleId;

	// constructor
	public CommentOfArticle() {
	}


	public CommentOfArticle(Integer id, String username, String date,
			String comment, Integer articleId) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.comment = comment;
		this.articleId = articleId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

}
