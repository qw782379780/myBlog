package com.qsqs.dao.Impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.qsqs.dao.ArticleDao;
import com.qsqs.model.Article;
import com.qsqs.model.PageBean;
import com.qsqs.model.User;

public class ArticleDaoImpl extends BaseDaoImpl implements ArticleDao {

	@SuppressWarnings("unchecked")
	public ArrayList<Article> show() {
        String sql = "from Article";
		@SuppressWarnings("unused")
		ArrayList<Article> list = (ArrayList<Article>) this.getSessionFactory().openSession().createQuery(sql).list();
		return list;
	}

	public PageBean<Article> findByPage(Integer pageSize,Integer currentPage,DetachedCriteria criteria) {
		PageBean<Article> page = new PageBean<Article>();
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		//查询总数量 select count(*)
		criteria.setProjection(Projections.rowCount());
		String hqlString = "select count(*) from Article";
	    List<Number> list = this.getSessionFactory().openSession().createQuery(hqlString).list(); 
		if(list != null && list.size() > 0){
			int totalCount = list.get(0).intValue();
			page.setTotalCount(totalCount);
			//测试输出
			System.out.println("总页数:"+totalCount+"  "+"页条数:"+pageSize+"  "+"当前页:"+currentPage);
		}
		//分页查询数据，使用limit
		String sql = "from Article";
		ArrayList<Article> beanlist = (ArrayList<Article>) this.getSessionFactory().openSession().createQuery(sql).setFirstResult(pageSize*(currentPage-1)).setMaxResults(pageSize).list();
		page.setBeanlist(beanlist);
		return page;
	}

	public Integer findIdByAuthor(String author) {
		String sql = "from User where username = ?";
		List<User> list = this.getSessionFactory().openSession().createQuery(sql).setString(0, author).list();
		if(list!=null && list.size()>0){
		return list.get(0).getUserId();
		}
		return null;
	}

	public void addBlog(Article article) {
		String sql = "insert into Article (null,?,?,?,?,?)";
		Session session = this.getSessionFactory().openSession();
		session.save(article);
	}

	public Article findArticleById(Integer id) {
		String sql = "from Article where id = ?";
		ArrayList<Article> list = (ArrayList<Article>) this.getSessionFactory().openSession().createQuery(sql).setInteger(0, id).list();
		return list.get(0);
	}
}
