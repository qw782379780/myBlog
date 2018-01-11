package com.qsqs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.qsqs.model.Article;
import com.qsqs.model.PageBean;

public interface ArticleDao {

	ArrayList<Article> show();

	PageBean<Article> findByPage(Integer pageSize,Integer currentPage, DetachedCriteria criteria);

	Integer findIdByAuthor(String author);

	void addBlog(Article article);

	Article findArticleById(Integer id);

}
