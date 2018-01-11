package com.qsqs.service.Impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.qsqs.dao.ArticleDao;
import com.qsqs.model.Article;
import com.qsqs.model.PageBean;
import com.qsqs.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public ArrayList<Article> show(){
		ArrayList<Article> list = articleDao.show();
		return list;
	}

	public PageBean<Article> findByPage(Integer pageSize, Integer currentPage,DetachedCriteria criteria) {
		return articleDao.findByPage(pageSize,currentPage,criteria);
	}

	public Integer findIdByAuthor(String author) {
		return articleDao.findIdByAuthor(author);
	}

	public void addBlog(Article article) {
		articleDao.addBlog(article);
	}

	public Article findArticleById(Integer id) {
		return articleDao.findArticleById(id);
	}

}
