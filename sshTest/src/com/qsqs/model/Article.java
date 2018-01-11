package com.qsqs.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.qsqs.utils.CastStringToDate;



public class Article {
	
	//fields
	private Integer id;
	private Integer userId;
	private String title;
	private String author;
	private String date;
	private String content;
	private Set<CommentOfArticle> comments = new HashSet<CommentOfArticle>();
	

	//constructor
	public Article(){
	}
	
	public Article(Integer id, Integer userId, String title, String author,
			String date, String content) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.author = author;
		this.date = date;
		this.content = content;
	}
	

	//修改为根据date排序的评论集合。使用Comparator
	public List<CommentOfArticle> getComments() {
		         List<CommentOfArticle> ListComment = new ArrayList<CommentOfArticle>();
		         if (comments != null) {
		        	 ListComment.addAll(comments);
		         }
		         Collections.sort(ListComment, new Comparator<CommentOfArticle>() {

					public int compare(CommentOfArticle o1, CommentOfArticle o2) {
						if(o1 != null && o2 != null){
							System.out.println("test"+(CastStringToDate.castStringToDate(o1.getDate()) - CastStringToDate.castStringToDate(o2.getDate())));
							return (int) (CastStringToDate.castStringToDate(o1.getDate()) - CastStringToDate.castStringToDate(o2.getDate()))*(-1);
						}
						return 0;
					}
		           
		         });
		        return ListComment;
		     }
	
	
	public void setComments(Set<CommentOfArticle> comments) {
		this.comments = comments;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
