package com.qsqs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qsqs.model.Article;
import com.qsqs.model.CommentOfArticle;
import com.qsqs.service.CommentOfArticleService;
import com.qsqs.utils.CastStringToDate;

public class CommentOfArticleAction extends ActionSupport implements ModelDriven<CommentOfArticle>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommentOfArticle commentOfArticle = new CommentOfArticle();

	public CommentOfArticle getModel() {
		return commentOfArticle;
	}
	
	private CommentOfArticleService commentOfArticleService;
	
	private Integer pageSize = 6;
	private Integer currentPage = 1;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public CommentOfArticleService getCommentOfArticleService() {
		return commentOfArticleService;
	}

	public void setCommentOfArticleService(
			CommentOfArticleService commentOfArticleService) {
		this.commentOfArticleService = commentOfArticleService;
	}

	public void setCurrentPage(Integer currentPage) {
		if(currentPage==null){
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}
    
	//发表评论，前台用ajax
	public void addComment(){
		//先把评论内容、时间、用户名存入CommentOfArticle
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		System.out.println("addcomment测试输出:"+simpleDateFormat.format(new Date()));
		Integer articleId = (Integer) ServletActionContext.getRequest().getAttribute("articleId");
		commentOfArticle.setDate(simpleDateFormat.format(new Date()));
		//如果未登录，则设定为游客评论
		if("".equals(commentOfArticle.getUsername())){
			commentOfArticle.setUsername("游客");
		}
		commentOfArticleService.addComment(commentOfArticle);
		HttpServletResponse request = ServletActionContext.getResponse();
		try {
			PrintWriter writer = request.getWriter();
			writer.print("ceshi");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
