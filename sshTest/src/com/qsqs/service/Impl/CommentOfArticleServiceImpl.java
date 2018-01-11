package com.qsqs.service.Impl;

import com.qsqs.dao.CommentOfArticleDao;
import com.qsqs.model.CommentOfArticle;
import com.qsqs.service.CommentOfArticleService;

public class CommentOfArticleServiceImpl implements CommentOfArticleService {
	
	private CommentOfArticleDao commentOfArticleDao;

	public CommentOfArticleDao getCommentOfArticleDao() {
		return commentOfArticleDao;
	}

	public void setCommentOfArticleDao(CommentOfArticleDao commentOfArticleDao) {
		this.commentOfArticleDao = commentOfArticleDao;
	}

	
	//发表评论
	public void addComment(CommentOfArticle commentOfArticle) {
		commentOfArticleDao.addComment(commentOfArticle);
	}

}
