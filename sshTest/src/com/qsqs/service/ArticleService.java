package com.qsqs.service;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;

import com.qsqs.model.Article;
import com.qsqs.model.PageBean;

public interface ArticleService {

	ArrayList<Article> show();

	PageBean<Article> findByPage(Integer pageSize,Integer currentPage, DetachedCriteria criteria);

	Integer findIdByAuthor(String author);

	void addBlog(Article article);

	Article findArticleById(Integer id);

}
