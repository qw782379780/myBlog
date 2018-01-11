package com.qsqs.dao.Impl;

import java.util.List;

import org.hibernate.classic.Session;

import com.qsqs.dao.CommentOfArticleDao;
import com.qsqs.model.CommentOfArticle;

public class CommentOfArticleDaoImpl extends BaseDaoImpl implements CommentOfArticleDao{

	public void addComment(CommentOfArticle commentOfArticle) {
		Session session = this.getSessionFactory().openSession();
		session.save(commentOfArticle);
		System.out.println("save comment:"+commentOfArticle.getComment());
	}

}
