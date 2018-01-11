package com.qsqs.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.qsqs.model.Article;
import com.qsqs.model.CommentOfArticle;
import com.qsqs.model.PageBean;
import com.qsqs.model.User;
import com.qsqs.service.ArticleService;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Article article = new Article();

	public Article getModel() {
		return article;
	}
	
	private ArticleService articleService;
	private Integer pageSize = 6;
	private Integer currentPage = 1;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		if(currentPage==null){
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	public ArticleService getarticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	//获取全部article对象
	public String show() {
		//获取博客对象列表
		ArrayList<Article> beanlist = articleService.show();
		//压栈
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("list", beanlist);
		return SUCCESS;
	}
	
	//分页查询
	public String findByPage(){
		DetachedCriteria criteria =  DetachedCriteria.forClass(Article.class);
		PageBean pageBean = articleService.findByPage(pageSize, currentPage,criteria);
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("page", pageBean);
		return SUCCESS;
	}
	
	//根据id查询单个博客文章
	public String findArticleById(){
		article = articleService.findArticleById(article.getId());
		//测试输出文章评论
		Iterator<CommentOfArticle> iterator = article.getComments().iterator();
		while(iterator.hasNext()){
			CommentOfArticle next = iterator.next();
			System.out.println(next.getArticleId());
			System.out.println(next.getUsername());
			System.out.println(next.getDate());
			System.out.println(next.getComment());
		}
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("article", article);
		return "content";
	}
	
	//添加随笔
	public String addBlog(){
		//前台提交author、title、content
		//userId、date由我自行封装、id为主键自增
		//通过author查询userId
		if(article.getAuthor().equals("")){
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.set("msg", "未登录");
			return ERROR;
		}
		Integer id = articleService.findIdByAuthor(article.getAuthor());
		System.out.println("id:"+id);
		if(id==null){
			ValueStack valueStack = ActionContext.getContext().getValueStack();
			valueStack.set("msg", "不存在的author");
			return ERROR;
		}
		article.setUserId(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		article.setDate(simpleDateFormat.format(new Date()));
	    articleService.addBlog(article);
		return "addSuccess";
	}
	
}
